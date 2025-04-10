package com.example.capstone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Set;

public class Python1Lesson6 extends AppCompatActivity {
    long OldPtsNumber;
    long newptsNumbers;
    TextToSpeech tts;

    DBHelper sql;
    int numbers = 1;
    String emaill ,firsts,second,third,fourth,fifth,sixth,seventh;

    int index,index1,index2,index3,index4,index5,index6 = 0;

    long delay = 50;
    float ani = -320;
    ImageView sir_kurt,sir_kurt2;
    Handler handler;
    TextView first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python1_lesson6);
        sql = new DBHelper(this);
        LinearLayout linear = findViewById(R.id.Linear1);
        sir_kurt = findViewById(R.id.sir_kurt);
        first = findViewById(R.id.textView2);
        LinearLayout textView = findViewById(R.id.Message11);
        firsts = ("Tuples in Python are similar to lists but are immutable, meaning they cannot be changed after creation.");
        second = ("They are created using parentheses and can store different data types together. For example, numbers_tuple = (1, 2, 3, 4, 5) creates a tuple of numbers.");
        third = ("Tuples are accessed using square bracket notation, similar to lists.");
        fourth = ("Tuples are accessed using square bracket notation, similar to lists.");
        handler = new Handler();
        Locale local = new Locale("en","US");
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
        Button skip = findViewById(R.id.skipped);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newptsNumbers==15) {
                    Show();
                }else {
                    startActivity(new Intent(Python1Lesson6.this, Python1Q6.class));
                    finish();
                    tts.stop();
                    tts.shutdown();
                }
            }
        });


        Button next;
        animate(ani);
        linear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(numbers == 1){
                    tts.speak(firsts,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    if(OldPtsNumber==15) {
                        skip.setEnabled(false);
                        skip.setVisibility(View.GONE);
                    }
                    else {
                        skip.setEnabled(true);
                        skip.setVisibility(View.VISIBLE);
                    }

                    First(() -> {
                        textView.setEnabled(true);
                        linear.setEnabled(true);
                        numbers = 2;

                    });

                }
                else if(numbers == 2){
                    tts.speak(second,TextToSpeech.QUEUE_FLUSH,null);
                    textView.setEnabled(false);
                    linear.setEnabled(false);

                    Second(() -> {
                        textView.setEnabled(true);
                        linear.setEnabled(true);
                        numbers = 3;
                    });

                }
                else if(numbers == 3){
                    tts.speak(third,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Third(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 4;
                    });

                }
                else if(numbers == 4) {
                    tts.speak(fourth, TextToSpeech.QUEUE_FLUSH, null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Fourth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 5;
                    });
                }
                else if(numbers == 5){
                    if(newptsNumbers==15) {
                    Show();
                }else{
                    startActivity(new Intent(Python1Lesson6.this, Python1Q6.class));
                    finish();
                    }
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numbers == 1){
                    tts.speak(firsts,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    if(OldPtsNumber==15) {
                        skip.setEnabled(false);
                        skip.setVisibility(View.GONE);
                    }
                    else {
                        skip.setEnabled(true);
                        skip.setVisibility(View.VISIBLE);
                    }

                    First(() -> {
                        textView.setEnabled(true);
                        linear.setEnabled(true);
                        numbers = 2;

                    });

                }
                else if(numbers == 2){
                    tts.speak(second,TextToSpeech.QUEUE_FLUSH,null);
                    textView.setEnabled(false);
                    linear.setEnabled(false);

                    Second(() -> {
                        textView.setEnabled(true);
                        linear.setEnabled(true);
                        numbers = 3;
                    });

                }
                else if(numbers == 3){
                    tts.speak(third,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Third(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 4;
                    });

                }
                else if(numbers == 4) {
                    tts.speak(fourth, TextToSpeech.QUEUE_FLUSH, null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Fourth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 5;
                    });
                }
                else if(numbers == 5){
                    if(newptsNumbers==15) {
                        Show();
                    }else{
                        startActivity(new Intent(Python1Lesson6.this, Python1Q6.class));
                        finish();
                    }
                }
            }
        });
    }
    private void Show(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Success");
        String msg = "I hope you have learn something new today!";
        build.setMessage(msg);
        build.setCancelable(false);
        tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
        build.setPositiveButton("Procced", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Python1Lesson6.this, Python1Q6.class));
                newptsNumbers = 16;
                sql.UpdatePoints((int) newptsNumbers, emaill);
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = build.create();
        dialog.show();
    }
    public void animate(float animates){
        Animation img = new TranslateAnimation(Animation.ABSOLUTE,animates,Animation.ABSOLUTE,Animation.ABSOLUTE);
        img.setDuration(4000);
        img.setFillAfter(true);

        sir_kurt.startAnimation(img);
    }

    interface Typing{
        void onAnimationComplete();
    }
    void First(final PythonActivity.Typing type){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(index <= firsts.length()){
                    first.setText(firsts.substring(0,index));
                    index++;
                    handler.postDelayed(this,delay);
                }
                else {
                    if(type != null){
                        type.onAnimationComplete();
                    }
                }
            }
        },delay);
    }
    void Second(final PythonActivity.Typing type) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index1 <= second.length()) {
                    first.setText(second.substring(0, index1));
                    index1++;
                    handler.postDelayed(this, delay);
                } else {
                    if (type != null) {
                        type.onAnimationComplete();
                    }
                }
            }
        }, delay);
    }
    void Third(final PythonActivity.Typing type) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index2 <= third.length()) {
                    first.setText(third.substring(0, index2));
                    index2++;
                    handler.postDelayed(this, delay);
                } else {
                    if (type != null) {
                        type.onAnimationComplete();
                    }
                }
            }
        }, delay);
    }
    void Fourth(final PythonActivity.Typing type) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index3<= fourth.length()) {
                    first.setText(fourth.substring(0, index3));
                    index3++;
                    handler.postDelayed(this, delay);
                } else {
                    if (type != null) {
                        type.onAnimationComplete();
                    }
                }
            }
        }, delay);

    }
    public void Points(){
        Cursor cur = sql.getAll();

        if(cur != null){
            while(cur.moveToNext()){
                OldPtsNumber = Long.parseLong(cur.getString(2));
            }
            cur.close();
        }

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Python1Lesson6.this,Pactivity1.class));
        finish();
        tts.stop();
        tts.shutdown();
    }
}