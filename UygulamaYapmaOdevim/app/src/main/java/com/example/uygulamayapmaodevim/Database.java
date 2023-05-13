package com.example.uygulamayapmaodevim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1="create table users(ad text,email text , sifre text)";
        sqLiteDatabase.execSQL(qry1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void kayit(String ad,String email,String sifre)
    {
        ContentValues cv=new ContentValues();
        cv.put("ad",ad);
        cv.put("email",email);
        cv.put("sifre",sifre);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public int giris(String ad,String sifre)
    {
        int result=0;
        SQLiteDatabase db=getReadableDatabase();
        String str[]=new String[2];
        str[0]=ad;
        str[1]=sifre;
        Cursor cursor=db.rawQuery("select * from users where ad=? and sifre=?",str);
        if(cursor.moveToFirst()){
            result =1;
        }

        return result;

    }
}
