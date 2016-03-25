package weiminsir.jiujiulianxi.jiujie.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;


import weiminsir.jiujiulianxi.R;
public class SQLActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        SQLiteDatabase db = openOrCreateDatabase("wick.db", MODE_PRIVATE, null);
    }

    public void newUpdate(SQLiteDatabase db) {
        String table = null;
        ContentValues values = null;
        String whereClause = null;
        String[] whereArgs = null;
        db.update(table, values, whereClause, whereArgs);
        db.close();
    }

    public void newDelete(SQLiteDatabase db) {
        String table = "students";
        String whereClause = "name=?";
        String[] whereArgs = {""};
        db.delete(table, whereClause, whereArgs);
        db.close();
    }

    public void newInsert(SQLiteDatabase db) {
        String table = "students";
        String nullColumnHack = "id";
        ContentValues values = new ContentValues();
        values.put("name", "Mike");
        values.put("age", 22);
        values.put("gender", 1);
        long id = db.insert(table, nullColumnHack, values);
        Log.d("tedu", "id=" + id);
        db.close();
    }

    public void insert(SQLiteDatabase db) {
        String sql = "insert into students" +
                "(name,age,gander)" +
                "values" +
                "('Lily',18,0)";
        db.execSQL(sql);
        sql = "insert into students " +
                "(name, age, gender) " +
                "values " +
                "('Rose', 19, 0)";
        db.execSQL(sql);

        sql = "insert into students " +
                "(name, age, gender) " +
                "values " +
                "('Billy', '三十', '男')";
        db.execSQL(sql);
        db.close();
    }

    public void createTable(SQLiteDatabase db) {
        String sql = "create table students (" +
                "age integer," +
                "gender integer" +
                ");";
        db.execSQL(sql);
        db.close();
    }

    public void delete(SQLiteDatabase db) {
        String sql = "delete from students " + "where id=4";
        db.execSQL(sql);
        db.close();
    }

    public void newQuery(SQLiteDatabase db) {
        String table = "students";
        String[] colums = {"age", "gender", "id", "name"};
        String selection = null;
        String[] selectionArgs = null;
        String having = null;
        String groupBy = null;
        String orderBy = null;
        Cursor cursor = db.query(table, colums, selection,
                selectionArgs, having, groupBy, orderBy);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.
                    getColumnIndex("name"));
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
    }
}
