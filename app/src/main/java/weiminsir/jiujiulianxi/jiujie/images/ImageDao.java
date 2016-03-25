package weiminsir.jiujiulianxi.jiujie.images;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weimin on 2016/3/12.
 */
public class ImageDao implements IimgDao<Image> {

    private Context context;
    public ImageDao(Context context) {
        super();
        if(context == null) {
            throw new IllegalArgumentException("参数Context不可以为null！！！");
        }
        this.context = context;
    }


    @Override
    public List<Image> query() {
        List<Image> images = new ArrayList<Image>();
        ContentResolver resolver = context.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] colums = {
                "_id", // 0
                "_data", // 1
                "_size", // 2
                "_display_name", // 3
                "width", // 4
                "height" // 5
        };
        Cursor c = resolver.query(uri, colums, null, null, null);
        if (c != null) {
            if(c.moveToFirst()) {
                for(; !c.isAfterLast(); c.moveToNext()) {
                    Image image = new Image();
                    image.setId(c.getLong(0));
                    image.setPath(c.getString(1));
                    image.setSize(c.getInt(2));
                    image.setDisplayName(c.getString(3));
                    image.setWidth(c.getInt(4));
                    image.setHeight(c.getInt(5));
                    images.add(image);
                }
            }
        }

        if(!c.isClosed()) {
            c.close();
        }

        // 返回
        return images;
    }
}
