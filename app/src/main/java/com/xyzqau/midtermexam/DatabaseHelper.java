package com.xyzqau.midtermexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME ="Data_db";
    private static final String TABLE_NAME="Data_tab";
    private static final String TASKNAME="Task_Name";
    private static final String TASKDETAIL="Task_Detail";
    private static final String TASKDEADLINE="Task_Deadline";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + TASKNAME + " TEXT,"
                    + TASKDETAIL + " TEXT ,"
                    + TASKDEADLINE + " TEXT"
                    + ")";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    public void insert(String task_name, String task_detail, String task_Deadline) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(TASKNAME,task_name);
        cv.put(TASKDETAIL,task_detail);
        cv.put(TASKDEADLINE,task_Deadline);

    }

    public List<Users> UsersData() {
        List<Users> list_User = new ArrayList<>();
         String Task_Name;
         String Task_detail;
         String Task_Deadline;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToNext()) {
            do {

                Task_Name = cursor.getString(cursor.getColumnIndex(TASKNAME));

                Task_detail = cursor.getString(cursor.getColumnIndex(TASKDETAIL));
                Task_Deadline = cursor.getString(cursor.getColumnIndex(TASKDEADLINE));
                list_User.add(new Users(Task_Name,Task_detail,Task_Deadline));
            } while (cursor.moveToNext());
        }
        db.close();
        return list_User;
    }
}
