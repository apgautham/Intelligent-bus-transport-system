package com.example.sabarishnandha.intelligentcheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="dbname.db";
    public static final String TABLE_NAME="passengers";
    public static final String COL_1="mobilenumber";
    public static final String COL_2="name";
    public static final String COL_3="source";
    public static final String COL_4="destination";
    public static final String COL_5="noofseats";
    public static final String COL_6="seats";
    public static final String COL_7="totalcost";
    public static final String COL_8="transid";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (mobilenumber TEXT PRIMARY KEY ,name TEXT," +
                "source TEXT,destination TEXT,noofseats TEXT,seats TEXT,totalcost TEXT,transid TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       // db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String mobilenumber,String name,String source,String destination,String noofseats,String seats,String totalcost,String transid)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_1,mobilenumber);
        cv.put(COL_2,name);
        cv.put(COL_3,source);
        cv.put(COL_4,destination);
        cv.put(COL_5,noofseats);
        cv.put(COL_6,seats);
        cv.put(COL_7,totalcost);
        cv.put(COL_8,transid);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1)
            return false;
        else
            return true;


    }
}
