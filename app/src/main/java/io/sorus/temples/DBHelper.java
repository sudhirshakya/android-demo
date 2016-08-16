package io.sorus.temples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sudhir on 8/14/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    private static final String DB_NAME = "demo.db";

    public DBHelper(Context ctx) {
        super (ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStmt =
                "CREATE TABLE temples (" +
                        "name varchar(25) primary key," +
                        "address varchar(100)," +
                        "summary varchar (200))";
        db.execSQL(createStmt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insert (Temple temple) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", temple.name);
        values.put("address", temple.address);
        values.put("summary", temple.summary);

        long rowid = db.insert ("temples", null, values);

        return (rowid > -1);
    }

    public Cursor listAll () {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery ("select rowid _id, * from temples", null);
    }
}









