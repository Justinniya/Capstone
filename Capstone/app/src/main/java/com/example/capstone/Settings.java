package com.example.capstone;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Settings extends AppCompatActivity {
    public static String PREFS_NAME = "MyPrefsFIle";
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        db = new DBHelper(this);
        CardView reset = findViewById(R.id.RReset);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder build = new AlertDialog.Builder(Settings.this);
                build.setTitle("Reset");
                String msg = "Are you sure you want to reset?";
                build.setMessage(msg);
                build.setCancelable(false);
                build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sharedPreferences = getSharedPreferences(Settings.PREFS_NAME,0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("hasLoggedIn",false);
                        editor.commit();
                        db.Reset();
                        startActivity(new Intent(Settings.this, SplashScreenActivity.class));
                        finish();

                        dialogInterface.dismiss();
                    }
                })
                        .setNegativeButton("No",null)
                        .show();
                AlertDialog dialog = build.create();
                dialog.show();

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            startActivity(new Intent(Settings.this, HomeActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}