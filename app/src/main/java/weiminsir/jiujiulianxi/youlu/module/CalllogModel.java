package weiminsir.jiujiulianxi.youlu.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weiminsir.jiujiulianxi.youlu.entity.Calllog;

/**
 * Created by Weimin on 2016/3/14.
 */
public class CalllogModel implements ICalllogModel {


    @Override
    public List<Calllog> findAllCallogs() {
//        private int id;
//        private String name;
//        private String number;
//        private int photoId;
//        private int type;
//        private long date;
        List<Calllog> logs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Calllog calllog = new Calllog();
            calllog.setId(i * i);
            calllog.setPhotoId(i);
            calllog.setName("name" + i);
            calllog.setDate(new Date().getTime());
            if (i % 2 == 0) {
                calllog.setType(0);
            }else {
                calllog.setType(1);
            }
            logs.add(calllog);
        }

//        Context context = MyApplication.getContext();
//        ContentResolver r = context.getContentResolver();
//        Uri uri = CallLog.Calls.CONTENT_URI;
//        String[] columns = {
//                CallLog.Calls._ID,                //0
//                "photo_id",            //1
//                "name",                    //2
//                CallLog.Calls.NUMBER,        //3
//                CallLog.Calls.DATE,            //4
//                CallLog.Calls.TYPE            //5
//        };
//        Cursor c = r.query(uri, columns, null, null, CallLog.Calls.DATE + " desc");
//        List<Calllog> logs = new ArrayList<Calllog>();
//        while (c.moveToNext()) {
//            Calllog log = new Calllog();
//            log.setId(c.getInt(0));
//            log.setPhotoId(c.getInt(1));
//            log.setName(c.getString(2));
//            log.setNumber(c.getString(3));
//            log.setDate(c.getLong(4));
//            log.setType(c.getInt(5));
//            logs.add(log);
//        }
//        c.close();
        return logs;

    }
}