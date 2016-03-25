package weiminsir.jiujiulianxi.youlu.module;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import weiminsir.jiujiulianxi.youlu.activity.MyApplication;
import weiminsir.jiujiulianxi.youlu.entity.Conversation;
import weiminsir.jiujiulianxi.youlu.entity.Sms;

/**
 * Created by Weimin on 2016/3/15.
 */
public class SmsModel implements ISmsModel {

    @Override
    public List<Conversation> loadAllConversations() {
        Uri uri = Uri.parse("content://mms-sms/conversations/");
        ContentResolver resolver = MyApplication.getContext().getContentResolver();
        String []colums={"thread_id",		//0
                "address", 		//1
                "body",				//2
                "date"				//3
                 };

        Cursor c = resolver.query(uri, colums, null, null, "date  desc");

        List<Conversation> conversations = new ArrayList<Conversation>();
        while (c.moveToNext()) {
            Conversation con = new Conversation();
            con.setId(c.getInt(0));
            con.setNumber(c.getString(1));
            con.setBody(c.getString(2));
            con.setDate(c.getLong(3));
            conversations.add(con);
        }
        c.close();
        return conversations;
    }

    @Override
    public List<Sms> findSmsByThreadId(int threadId) {
        Uri uri = Uri.parse("content://sms/");
        Context context = MyApplication.getContext();
        ContentResolver r = context.getContentResolver();
        String[] columns={
                "_id",			//0
                "body",			//1
                "date",			//2
                "type"			//3
        };
        Cursor c=r.query(uri, columns, "thread_id=?", new String[]{threadId+""}, "date");
        List<Sms> smss = new ArrayList<Sms>();
        while(c.moveToNext()){
            Sms sms = new Sms(
                    c.getInt(0),
                    c.getLong(2),
                    c.getString(1),
                    c.getInt(3));
            smss.add(sms);
        }
        c.close();
        return smss;
    }
}
