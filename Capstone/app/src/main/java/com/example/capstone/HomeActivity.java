package com.example.capstone;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.capstone.Example.Others;
import java.util.Set;
import PythonExpert.Pactivity3;
import PythonExplorer.Pactivity2;

public class HomeActivity extends AppCompatActivity {
    public boolean[] Stage = {false,false};
    int back = 1;
    private DBHelper sql;
    SQLiteDatabase sqls;
    long ptsNumber;
    String email,stage;
    int level;
    TextToSpeech tts;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sql = new DBHelper(this);
        Display();
        Points();
        Level();

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                Set<Voice> voices = tts.getVoices();

                // Print information about each voice
                for (Voice voice : voices) {
                    Voice voicee = new Voice(voice.getName(), voice.getLocale(), 1, 1, false, null);

                    // Use the male voice
                    tts.setVoice(voicee);
                }
            }

        });



        ImageView Practice = findViewById(R.id.PracticeLock);
        CardView practiceCard = findViewById(R.id.practiceCard);
        CardView javaCard = findViewById(R.id.javaCard);
        CardView pythonCard = findViewById(R.id.pythonCard);
        CardView OOPCard = findViewById(R.id.OOPcard);
        CardView settingsCard = findViewById(R.id.settingsCard);
        ImageView LockJava = findViewById(R.id.lockProg2);
        ImageView LockOOp = findViewById(R.id.lockOOP);
        TextView points = findViewById(R.id.LearnPts);
        TextView pts = findViewById(R.id.points);
        CardView other = findViewById(R.id.Others);
            DBHelper db = new DBHelper(this);
            sqls = db.getReadableDatabase();
        String text = "Welcome Learner";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        if(ptsNumber > 0 && ptsNumber <= 44){
            Practice.setVisibility(View.GONE);
            LockJava.setVisibility(View.VISIBLE);
            LockOOp.setVisibility(View.VISIBLE);
            stage = "Starter";
            points.setText("Stage : "+stage);
            pts.setText("Points : " +ptsNumber);
            sql.Updatelevel(1,"sdad");
        }
        else if(ptsNumber > 44 && ptsNumber <= 89){
            Practice.setVisibility(View.GONE);
            LockJava.setVisibility(View.GONE);
            stage = "Explorer";
            points.setText("Stage : "+stage);
            pts.setText("Points : " +ptsNumber);
            Stage[0] = true;
            sql.Updatelevel(2,"sdad");
        }
        else if(ptsNumber > 89){
            Practice.setVisibility(View.GONE);
            LockJava.setVisibility(View.GONE);
            LockOOp.setVisibility(View.GONE);
            stage = "Expert";
            pts.setText("Points : " +ptsNumber);
            points.setText("Stage : "+stage);
            sql.Updatelevel(3,"sdad");
        }
        else{
            points.setText("New User");
            Practice.setVisibility(View.VISIBLE);
            LockJava.setVisibility(View.VISIBLE);
            LockOOp.setVisibility(View.VISIBLE);
            pts.setText("Points : " +ptsNumber);
        }



        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Points();
                        Level();
                        pts.setText("Points : " +ptsNumber);
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
                startActivity(new Intent(HomeActivity.this, Others.class));
                finish();
            }
        });

        practiceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
                        progressDialog.setMessage("Please wait...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(HomeActivity.this, PythonPractice.class));
                                finish();
                            }
                        }, 2000);

                }
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
                    progressDialog.setCancelable(false);
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
                progressDialog.setCancelable(false);
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
                    progressDialog.setCancelable(false);
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
                progressDialog.setCancelable(false);
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
                email = cur.getString(1);
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

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Toast.makeText(HomeActivity.this, "Click again to exit!", Toast.LENGTH_LONG).show();
        if(back == 2){

            onDestroy();
            finish();
        }
        else{
            back++;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}//end of Program
