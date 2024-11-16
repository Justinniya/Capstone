package com.example.capstone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        db = new DBHelper(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(PythonActivity.PREFS_NAME,0);
                boolean hasloggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);
                if(hasloggedIn == true) {
                    startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
                    finish();
                }
                else{
                    db.Level("XciteUser");
                    db.insertData("1","1","1","1","1","1","1","1","1");
                    startActivity(new Intent(SplashScreenActivity.this,PythonActivity.class));
                    finish();
                }
            }
        },3000);
    }

}