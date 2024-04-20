package com.example.capstone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    AlertDialog.Builder alert;
    DBHelper sql;
    String lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView logoutCard = findViewById(R.id.logout);
        alert = new AlertDialog.Builder(this);
        sql = new DBHelper(this);
        Display();
        TextView lastnames = findViewById(R.id.lastname);
        lastnames.setText(lastname);
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to go back to HomeActivity
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        logoutCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {//Toast.makeText(ProfileActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME,0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            alert.setTitle("Log out?");
            alert.setMessage("Are you sure you want to Log out?");
            alert.setCancelable(false);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editor.putBoolean("hasLoggedIn",false);
                            editor.commit();
                            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("No",null)
                    .show();


        }
        });
    }
    public void Display(){
        Cursor cur = sql.getAllNotes();

        if(cur != null){
            while(cur.moveToNext()){
                lastname = cur.getString(1);
            }
            cur.close();
        }
    }
}