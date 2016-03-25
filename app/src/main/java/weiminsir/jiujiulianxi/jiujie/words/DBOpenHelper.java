package weiminsir.jiujiulianxi.jiujie.words;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Weimin on 2016/3/12.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context) {
        super(context, "dict.db", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table words (" +
                "_id integer primary key autoincrement, " +
                "en varchar(16) not null unique, " +
                "zh varchar(50) not null" +
                ")";
        db.execSQL(sql);

    }
}
