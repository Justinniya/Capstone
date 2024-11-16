package com.example.capstone;

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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Set;

public class Python1Lesson1 extends AppCompatActivity {
    long OldPtsNumber;
    long newptsNumbers;
    TextToSpeech tts;

    DBHelper sql;
    int numbers = 1;
    String emaill ,firsts,second,third,fourth,fifth,sixth,seventh;

    int index,index1,index2,index3,index4,index5,index6 = 0;
    Button skip;

    long delay = 50;
    float ani = -320;
    ImageView sir_kurt,sir_kurt2;
    Handler handler;
    TextView first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python1_lesson1);
        sql = new DBHelper(this);
        Points();
        LinearLayout linear = findViewById(R.id.Linear1);
        sir_kurt = findViewById(R.id.sir_kurt);
        first = findViewById(R.id.textView2);
        skip = findViewById(R.id.skipped);
        LinearLayout textView = findViewById(R.id.Message11);
        firsts = (" It consists of a single line of code that prints the string 'Hello World!' to the console.");
        seventh = ("This simple program serves as an introduction to the language's syntax and how to display output.");
        third = ("Once you see Hello, World! printed on the screen, you're ready to start exploring more complex programs and concepts in Python.");
        sixth = ("The 'Hello World!' program is a classic first program used to demonstrate the basic syntax of a programming language");

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
        skip = findViewById(R.id.skipped);
        if(OldPtsNumber==0) {
            skip.setEnabled(false);
            skip.setVisibility(View.GONE);
        }
        else {
            skip.setEnabled(true);
            skip.setVisibility(View.GONE);
        }
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OldPtsNumber==0) {
                    Show();
                    tts.stop();

                }else{
                    startActivity(new Intent(Python1Lesson1.this, Python1Q1.class));
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
                    tts.speak(sixth,TextToSpeech.QUEUE_FLUSH,null);
                linear.setEnabled(false);
                textView.setEnabled(false);
                        skip.setEnabled(true);
                        skip.setVisibility(View.VISIBLE);


                    Sixth(() -> {
                        textView.setEnabled(true);
                        linear.setEnabled(true);
                        numbers = 2;

                    });

                }
                else if(numbers == 2){
                    tts.speak(firsts,TextToSpeech.QUEUE_FLUSH,null);
                    textView.setEnabled(false);
                    linear.setEnabled(false);
                    First(new PythonActivity.Typing() {
                        @Override
                        public void onAnimationComplete()
                        {
                            textView.setEnabled(true);
                            linear.setEnabled(true);
                            numbers = 3;
                        }
                    });

                }
                else if(numbers == 3){
                    tts.speak(seventh,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Seventh(new PythonActivity.Typing() {
                        @Override
                        public void onAnimationComplete() {
                            linear.setEnabled(true);
                            textView.setEnabled(true);
                            numbers = 4;
                        }
                    });

                }
                else if(numbers == 4){
                    tts.speak(third,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Third(new PythonActivity.Typing() {
                        @Override
                        public void onAnimationComplete() {
                            linear.setEnabled(true);
                            textView.setEnabled(true);
                            numbers=5;
                        }
                    });
                }
                else if(numbers == 5){
                    if(OldPtsNumber==0) {
                        Show();
                        tts.stop();

                    }else{
                        startActivity(new Intent(Python1Lesson1.this, Python1Q1.class));
                        finish();
                        tts.stop();
                    }
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numbers == 1){
                    tts.speak(sixth,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                        skip.setEnabled(true);
                        skip.setVisibility(View.VISIBLE);

                    Sixth(() -> {
                        textView.setEnabled(true);
                        linear.setEnabled(true);
                        numbers = 2;

                    });

                }
                else if(numbers == 2){
                    tts.speak(firsts,TextToSpeech.QUEUE_FLUSH,null);
                    textView.setEnabled(false);
                    linear.setEnabled(false);
                    First(new PythonActivity.Typing() {
                        @Override
                        public void onAnimationComplete()
                        {
                            textView.setEnabled(true);
                            linear.setEnabled(true);
                            numbers = 3;
                        }
                    });

                }
                else if(numbers == 3){
                    tts.speak(seventh,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Seventh(new PythonActivity.Typing() {
                        @Override
                        public void onAnimationComplete() {
                            linear.setEnabled(true);
                            textView.setEnabled(true);
                            numbers = 4;
                        }
                    });

                }
                else if(numbers == 4){
                    tts.speak(third,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Third(new PythonActivity.Typing() {
                        @Override
                        public void onAnimationComplete() {
                            linear.setEnabled(true);
                            textView.setEnabled(true);
                            numbers=5;
                        }
                    });
                }
                else if(numbers == 5){
                    if(OldPtsNumber==0) {
                        Show();
                        tts.stop();

                    }else{
                        startActivity(new Intent(Python1Lesson1.this, Python1Q1.class));
                        finish();
                        tts.stop();
                    }
                }
            }
        });
    }
    private void Show(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Success");
        String msg = "I hope you have learn something new today!";
        build.setCancelable(false);
        build.setMessage(msg);
        tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
        build.setPositiveButton("Procced", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Python1Lesson1.this, Python1Q1.class));
                finish();
                tts.stop();
                tts.shutdown();
                newptsNumbers = 1;
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
        tts.speak(second,TextToSpeech.QUEUE_FLUSH,null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index1 <= second.length()) {
                    first.setText(second.substring(0, index1));
                    index1++;
                    handler.postDelayed(this, delay);
                } else {

                        if(type != null) {
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

    void Fifth(final PythonActivity.Typing type) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index4 <= fifth.length()) {
                    first.setText(fifth.substring(0, index4));
                    index4++;
                    handler.postDelayed(this, delay);
                } else {
                    if (type != null) {
                        type.onAnimationComplete();
                    }
                }
            }
        }, delay);
    }
    void Sixth(final PythonActivity.Typing type) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index5 <= sixth.length()) {
                    first.setText(sixth.substring(0, index5));
                    index5++;
                    handler.postDelayed(this, delay);
                } else {
                    if (type != null) {
                        type.onAnimationComplete();
                    }
                }
            }
        }, delay);
    }
    void Seventh(final PythonActivity.Typing type){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(index6 <= seventh.length()){
                    first.setText(seventh.substring(0,index6));
                    index6++;
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
        startActivity(new Intent(Python1Lesson1.this,Pactivity1.class));
        finish();
        tts.stop();
        tts.shutdown();
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
}