package com.example.capstone;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.os.Handler;
import android.speech.tts.Voice;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import java.util.Set;

public class PythonActivity extends AppCompatActivity {
    int back = 1;
    int PtsNumber;
    long ptsNumbers;
    TextToSpeech tts;

    DBHelper sql;
    int numbers = 1;
    String emaill ,firsts,second,third,fourth,fifth,sixth,seventh;
    public static String PREFS_NAME = "MyPrefsFIle";

    int index,index1,index2,index3,index4,index5,index6 = 0;

    long delay = 50;
    float ani = -320;
    ImageView sir_kurt,sir_kurt2;
    Handler handler;
    TextView first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
        sql = new DBHelper(this);
        LinearLayout linear = findViewById(R.id.Linear1);
        sir_kurt = findViewById(R.id.sir_kurt);
        first = findViewById(R.id.textView2);
        Button skip = findViewById(R.id.skipped);
        LinearLayout textView = findViewById(R.id.Message11);
        firsts = ("Python is the most popular language due to the fact that it’s easier to code and understand it.\n" +
                "Python is an object-oriented programming language and can be used to write functional code too.");
        second = ("It is a suitable language that bridges the gaps between business and developers.\n" +
                "Subsequently, it takes less time to bring a Python program to market compared to other languages such as C#/Java.");
        third = ("Additionally, there are a large number of python machine learning and analytical packages.\n" +
                "A large number of communities and books are available to support Python developers.");
        fourth = ("Nearly all types of applications, ranging from forecasting analytical to UI, can be implemented in Python.\n" +
                "There is no need to declare variable types. Thus it is quicker to implement a Python application.");
        fifth = ("Python is interpreted high-level object-oriented dynamically-typed scripting language.\n" +
                "As a result, run time errors are usually encountered.");
        sixth = ("What is Python?");
        seventh = ("Why python?");
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
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Show();
            }
        });
        /**tts.speak(seventh,TextToSpeech.QUEUE_FLUSH,null);

        Seventh(() -> {

            numbers = 4;
**/
        Button next;
        animate(ani);
        linear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(numbers == 1){
                    tts.speak(sixth,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Sixth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 2;
                    });

                }
                else if(numbers == 2){
                    tts.speak(firsts,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    First(() ->{
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                            numbers = 3;
                        });

                }
                else if(numbers == 3){
                    tts.speak(seventh,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Seventh(() -> {
                        numbers = 4;
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                    });

                }
                else if(numbers == 4){
                    tts.speak(second,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Second(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 5;
                    });
                }
                else if(numbers == 5){
                    tts.speak(third,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Third(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 6;
                    });
                }
                else if(numbers == 6){
                    tts.speak(fourth,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Fourth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 7;
                    });

                }
                else if(numbers == 7){
                    tts.speak(fifth,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Fifth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 8;
                    });
                }
                else if(numbers == 8){
                        Show();

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
                    Sixth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 2;
                    });

                }
                else if(numbers == 2){
                    tts.speak(firsts,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    First(() ->{
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 3;
                    });

                }
                else if(numbers == 3){
                    tts.speak(seventh,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Seventh(() -> {
                        numbers = 4;
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                    });

                }
                else if(numbers == 4){
                    tts.speak(second,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Second(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 5;
                    });
                }
                else if(numbers == 5){
                    tts.speak(third,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Third(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 6;
                    });
                }
                else if(numbers == 6){
                    tts.speak(fourth,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Fourth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 7;
                    });

                }
                else if(numbers == 7){
                    tts.speak(fifth,TextToSpeech.QUEUE_FLUSH,null);
                    linear.setEnabled(false);
                    textView.setEnabled(false);
                    Fifth(() -> {
                        linear.setEnabled(true);
                        textView.setEnabled(true);
                        numbers = 8;
                    });
                }
                else if(numbers == 8){
                    Show();

                }
            }
        });
    }

    private void Show(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("Success");
        String msg = "Lets go and start your journey with Xcite!";
        build.setMessage(msg);
        tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
        build.setPositiveButton("Get Started", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferences sharedPreferences = getSharedPreferences(PythonActivity.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",true);
                editor.apply();
                startActivity(new Intent(PythonActivity.this, HomeActivity.class));
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
    void Seventh(final PythonActivity.Typing type) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index6 <= seventh.length()) {
                    first.setText(seventh.substring(0, index6));
                    index6++;
                    handler.postDelayed(this, delay);
                } else {
                    if (type != null) {
                        type.onAnimationComplete();
                    }
                }
            }
        }, delay);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(PythonActivity.this,"Click again to exit!",Toast.LENGTH_LONG).show();
        if(back == 2){

            super.onBackPressed();
            finish();
            tts.stop();
        }
        else{
            back++;
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Shutdown TTS engine to release resources
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}