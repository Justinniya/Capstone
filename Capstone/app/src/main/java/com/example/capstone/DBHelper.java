package com.example.capstone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class
DBHelper extends SQLiteOpenHelper {

    String email;

    public static final String DBNAME = "registerss.db";

    public DBHelper( Context context) {
        super(context, "registerss.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users( fname TEXT , lname TEXT, email TEXT primary key, password TEXT, pn TEXT, date TEXT,Age int,Section Text,Year Text)");
        MyDB.execSQL("create Table usersStage(id INTEGER PRIMARY KEY,email TEXT, pts INTEGER ,Level INTEGER )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists usersStage");
        MyDB.execSQL("drop table if exists usersww");
    }
    public Cursor getAllNotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("users",null,null,null,null,null,null);
    }
    public Cursor getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("usersStage",null,null,null,null,null,null);

    }

    public boolean insertData(String fname, String lname, String email, String password, String pn, String date,String  Age,String Section,String Year){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname", fname);
        contentValues.put("lname", lname);
        contentValues.put("email", "XciteUser");
        contentValues.put("password", password);
        contentValues.put("pn", pn);
        contentValues.put("date", date);
        contentValues.put("Age",Age);
        contentValues.put("Section",Section);
        contentValues.put("Year", Year);
        long result = myDB.insert("users",null,contentValues);
        if (result == -1) return false;
        else {
            return true;
        }
    }
   public boolean Level(String email){

       SQLiteDatabase myDB = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put("id",999);
       values.put("email",email);
       values.put("pts",0);
       values.put("LEVEL",1);
       long result = myDB.insert("usersStage",null,values);
       if (result == -1) return false;
       else {
           return true;
       }

   }

   public int UpdatePoints(long points,String email){
       try (SQLiteDatabase myDB = this.getWritableDatabase()) {
           ContentValues values = new ContentValues();
           values.put("pts", points);
           String Where = "email = ?";
           String[] args = {"XciteUser"};
           return myDB.update("usersStage", values, Where, args);
       }
   }
    public int Updatelevel(int level,String email){
        try (SQLiteDatabase myDB = this.getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put("Level", level);
            String Where = "email = ?";
            String[] args = {email};
            return myDB.update("usersStage", values, Where, args);
        }
    }
    void Reset(){
        try (SQLiteDatabase myDB = this.getWritableDatabase()) {
            String[] args = {"XciteUser"};
            myDB.delete("usersStage", "email = ?", args);
        }
    }

}
