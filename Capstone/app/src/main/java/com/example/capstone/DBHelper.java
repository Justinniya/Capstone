package com.example.capstone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class
DBHelper extends SQLiteOpenHelper {
    //HomeActivity home = new HomeActivity();
    String email;
    //LoginActivity a = new LoginActivity();
    public static final String DBNAME = "registerss.db";

    public DBHelper( Context context) {
        super(context, "registerss.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users( fname TEXT , lname TEXT, email TEXT primary key, password TEXT, pn TEXT, date TEXT,Age int,Section Text,Year Text)");
        MyDB.execSQL("create Table usersStage(Player_IGN TEXT PRIMARY KEY,email TEXT, pts INTEGER ,Level INTEGER, FOREIGN KEY(email) REFERENCES user(email) )");
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
       values.put("email",email);
       values.put("pts",0);
       values.put("LEVEL",1);
       long result = myDB.insert("usersStage",null,values);
       if (result == -1) return false;
       else {
           return true;
       }

   }

   public int UpdatePoints(long UpdatedPoints,String email){
       SQLiteDatabase myDB = this.getWritableDatabase();
       ContentValues values = new ContentValues();

       //String eemail = a.getEmail();
       values.put("pts",UpdatedPoints); 
       String Where = "email = ? ";
       String[] args = {"XciteUser"};
       int Update = myDB.update("usersStage", values, Where,args);
       myDB.close();

       return  Update;
   }
    public int Updatelevel(int level,String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //String eemail = a.getEmail();
        values.put("Level",level);
        String Where = "email = ? ";
        String[] args = {"XciteUser"};
        int Update = myDB.update("usersStage", values, Where,args);
        myDB.close();

        return  Update;
    }


    public boolean checkEmail(String email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {

            return true;
        }
        else return false;
    }


    public boolean checkEmailuser(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }
        else return false;
    }
    public int Level(int Pointss,String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //String eemail = a.getEmail();
        values.put("Level",Pointss);
        String Where = "email = ? ";
        String[] args = {"1.ui@phinmaed.com"};
        int Update = myDB.update("usersStage", values, Where,args);
        myDB.close();

        return  Update;
    }
    void Reset(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        String argss[] = {"XciteUser"};
        myDB.delete("usersStage","email = ?",argss);
    }

}
