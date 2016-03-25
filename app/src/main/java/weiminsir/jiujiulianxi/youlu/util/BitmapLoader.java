package weiminsir.jiujiulianxi.youlu.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.widget.AbsListView;
import android.widget.ImageView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Weimin on 2016/3/14.
 */
public class BitmapLoader {
    private static final int HANDLER_SEND_TASK = 101;

    private List<LoadImageTask> tasks = new ArrayList<>();
    private AbsListView listView;
    private Thread workThread;
    private Context context;
    private boolean isLoop;
    private HashMap<String, SoftReference<Bitmap>> cache = new HashMap<String, SoftReference<Bitmap>>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == HANDLER_SEND_TASK) {

                LoadImageTask task =(LoadImageTask) msg.obj;
                ImageView imageView = (ImageView)listView.findViewWithTag(task.position);
                if (imageView != null) {
                    if (task.bitmap != null) {
                        imageView.setImageBitmap(task.bitmap);

                    }
                }

            }


        }
    };

    public BitmapLoader(AbsListView listView, Context context) {
        super();
        this.listView = listView;
        this.context = context;
        workThread = new Thread() {
            @Override
            public void run() {
                while (!isLoop) {
                    if (tasks != null) {
                        LoadImageTask task = tasks.remove(0);
                        Bitmap bitmap = loadImage(task.photoId);
                        task.bitmap = bitmap;
                        SoftReference<Bitmap> srf =
                                new SoftReference<Bitmap>(bitmap);
                        cache.put(task.photoId + "", srf);
                        Message.obtain(handler, HANDLER_SEND_TASK).sendToTarget();
                    } else {
                        synchronized (workThread) {
                            try {
                                workThread.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                }


            }
        };


    }

    public Bitmap loadImage(int photoId) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = {
                ContactsContract.Data.DATA15};
        Bitmap bitmap = null;
        Cursor cursor = resolver.query(uri, projection, "_id=?",
                new String[]{photoId + ""}, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast();
             cursor.moveToNext()) {
            byte[] bytes = cursor.getBlob(0);
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        cursor.close();
        return bitmap;

    }

    public void display(ImageView imageView, int photoId, int position) {
        imageView.setTag(position);
        SoftReference<Bitmap> srf = cache.get(photoId + "");
        if (srf != null) {
            Bitmap bitmap = srf.get();
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
        LoadImageTask task = new LoadImageTask();
        task.position = position;
        task.photoId = photoId;
        tasks.add(task);
        synchronized (workThread) {
            workThread.notify();
        }
    }

    class LoadImageTask {
        int photoId;
        Bitmap bitmap;
        int position;

    }

}
