package com.example.capstone;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.capstone.Example.Others;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import PythonExpert.Pactivity3;
import PythonExplorer.Pactivity2;

public class HomeActivity extends AppCompatActivity {
    public boolean Stage [] = {false,false};
    int back = 1;
    private DBHelper sql;
    SQLiteDatabase sqls;
    long ptsNumber;
    String email,stage;
    int level;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sql = new DBHelper(this);
        Display();
        Points();
        Level();
        // Initialize the TextToSpeech engine
        textToSpeech = new TextToSpeech(HomeActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    // Get the list of available voices
                    Set<Voice> voices = textToSpeech.getVoices();

                    // Print information about each voice
                    for (Voice voice : voices) {
                        Log.d("Voice", String.valueOf(voice));
                        Voice voicee = new Voice(voice.getName(), voice.getLocale(), 1, 1, false, null);

                        // Use the male voice
                        textToSpeech.setVoice(voicee);

                        // Example usage
                        //textToSpeech.speak("Hello, I am a male voice.", TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            }
        });

        //CardView profileCard = findViewById(R.id.profileCard);
        ImageView Practice = findViewById(R.id.PracticeLock);
        CardView practiceCard = findViewById(R.id.practiceCard);
        CardView javaCard = findViewById(R.id.javaCard);
        CardView pythonCard = findViewById(R.id.pythonCard);
        CardView OOPCard = findViewById(R.id.OOPcard);
        CardView settingsCard = findViewById(R.id.settingsCard);
        ImageView LockJava = findViewById(R.id.lockProg2);
        ImageView LockOOp = findViewById(R.id.lockOOP);
        TextView points = findViewById(R.id.LearnPts);
        ImageView profileCard = findViewById(R.id.profileID);
        TextView pts = findViewById(R.id.LearnPts);
        CardView other = findViewById(R.id.Others);
        profileCard.setVisibility(View.GONE);

            DBHelper db = new DBHelper(this);
            sqls = db.getReadableDatabase();
        if(ptsNumber > 0 && ptsNumber <= 44){
            Practice.setVisibility(View.GONE);
            LockJava.setVisibility(View.VISIBLE);
            LockOOp.setVisibility(View.VISIBLE);
            stage = "Starter";
            points.setText("Stage : "+stage);
        }
        else if(ptsNumber > 44 && ptsNumber <= 89){
            Practice.setVisibility(View.GONE);
            LockJava.setVisibility(View.GONE);
            stage = "Explorer";
            points.setText("Stage : "+stage);
            Stage[0] = true;
        }
        else if(ptsNumber > 89){
            Practice.setVisibility(View.GONE);
            LockJava.setVisibility(View.GONE);
            LockOOp.setVisibility(View.GONE);
            stage = "Expert";
            points.setText("Stage : "+stage);
        }
        else{
            points.setText("New User");
            Practice.setVisibility(View.VISIBLE);
            LockJava.setVisibility(View.VISIBLE);
            LockOOp.setVisibility(View.VISIBLE);
        }



        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {


                    @Override
                    public void onRefresh() {
                        Points();
                        Level();
                        if(ptsNumber > 0 && ptsNumber <= 44){
                            Practice.setVisibility(View.GONE);
                            LockJava.setVisibility(View.VISIBLE);
                            LockOOp.setVisibility(View.VISIBLE);
                            stage = "Starter";
                            points.setText("Stage : "+stage);
                        }
                        else if(ptsNumber > 44 && ptsNumber <= 89){
                            Practice.setVisibility(View.GONE);
                            LockJava.setVisibility(View.GONE);
                            stage = "Explorer";
                            points.setText("Stage : "+stage);
                            Stage[0] = true;
                        }
                        else if(ptsNumber > 89){
                            Practice.setVisibility(View.GONE);
                            LockJava.setVisibility(View.GONE);
                            LockOOp.setVisibility(View.GONE);
                            stage = "Expert";
                            points.setText("Stage : "+stage);
                        }
                        else{
                            points.setText("New User");
                            Practice.setVisibility(View.VISIBLE);
                            LockJava.setVisibility(View.VISIBLE);
                            LockOOp.setVisibility(View.VISIBLE);
                        }
                        swipeRefreshLayout.setRefreshing(false);

                    }
                }
        );
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this,"Coming soon",Toast.LENGTH_LONG).show();
            }
        });
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                finish();
            }
        });

        practiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
                        progressDialog.setMessage("Please wait...");
                        progressDialog.setCancelable(false); // Prevent user from dismissing dialog
                        progressDialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(HomeActivity.this, PythonPractice.class));
                                finish();
                            }
                        }, 2000);

                }
            //}
        });

        javaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ptsNumber <= 44){
                    Toast.makeText(HomeActivity.this, "Exporer is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
                    progressDialog.setMessage("Please wait...");
                    progressDialog.setCancelable(false); // Prevent user from dismissing dialog
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(HomeActivity.this, Pactivity2.class));
                            finish();

                        }
                    }, 2000);
                }
            }
        });

        pythonCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
                progressDialog.setMessage("Please wait...");
                progressDialog.setCancelable(false); // Prevent user from dismissing dialog
                progressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(HomeActivity.this,Pactivity1.class));
                        finish();
                    }
                }, 2000);
            }
        });



        OOPCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ptsNumber >= 90) {
                    ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
                    progressDialog.setMessage("Please wait...");
                    progressDialog.setCancelable(false); // Prevent user from dismissing dialog
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(HomeActivity.this, Pactivity3.class));
                            finish();
                        }
                    }, 2000);
                }
                else{
                    Toast.makeText(HomeActivity.this, "Master is locked", Toast.LENGTH_LONG).show();
                }
            }
        });

        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click on the Settings card
                ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
                progressDialog.setMessage("Please wait...");
                progressDialog.setCancelable(false); // Prevent user from dismissing dialog
                progressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(HomeActivity.this,Settings.class));
                        finish();
                    }
                }, 2000);
            }
        });
    }
    public void Display(){
        Cursor cur = sql.getAllNotes();

        if(cur != null){
            while(cur.moveToNext()){
                email = cur.getString(0);
            }
            cur.close();
        }
    }

    public void Points(){
        Cursor cur = sql.getAll();

        if(cur != null){
            while(cur.moveToNext()){
                ptsNumber = Long.parseLong(cur.getString(2));
            }
            cur.close();
        }
    }
    public void Level(){
        Cursor cur = sql.getAll();

        if(cur != null){
            while(cur.moveToNext()){
                level = Integer.parseInt(cur.getString(3));
            }
            cur.close();
        }
    }
    public void hulat(int number){
        try{
            Thread.sleep(number);
        }catch (Exception e){

        }
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(HomeActivity.this, "Click again to exit!", Toast.LENGTH_LONG).show();
        if(back == 2){

            onDestroy();
            finish();
        }
        else{
            back++;
        }
    }


}//end of Program
