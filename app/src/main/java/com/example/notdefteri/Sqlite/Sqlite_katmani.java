package com.example.notdefteri.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_katmani extends SQLiteOpenHelper {

    public Sqlite_katmani(Context context){
        super(context,"NotlarTablo",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =" create table NotlarTablo (id integer primary key autoincrement ,notBaslik text,noticerik text,tarih text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Notlar ");
    }
}
