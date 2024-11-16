package PythonExplorer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.capstone.DBHelper;
import com.example.capstone.Example.E1example1;
import com.example.capstone.Example.E1example6;
import com.example.capstone.Example.E1example8;
import com.example.capstone.Example.E2example2;
import com.example.capstone.Example.E2example6;
import com.example.capstone.Example.E2example8;
import com.example.capstone.HomeActivity;
import com.example.capstone.Python1Lesson1;
import com.example.capstone.Python1Lesson15;
import com.example.capstone.Python1Q1;
import com.example.capstone.R;

import java.util.Locale;
import java.util.Set;

import PythonExpert.Prog3Tut15;

public class Prog2Tut8 extends AppCompatActivity {
    int PtsNumber;
    long ptsNumbers;
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
        setContentView(R.layout.activity_prog2_tut8);
        sql = new DBHelper(this);
        LinearLayout linear = findViewById(R.id.Linear1);
        sir_kurt = findViewById(R.id.sir_kurt);
        first = findViewById(R.id.textView2);
        LinearLayout textView = findViewById(R.id.Message11);
        firsts = ("A nested for loop in Python consists of an outer loop containing one or more inner loops.");
        second = ("Each iteration of the outer loop triggers a complete iteration of the inner loop");
        third = ("This is useful for iterating over 2D data structures or performing operations that require multiple levels of iteration.");
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
        skip.setEnabled(true);
        skip.setVisibility(View.VISIBLE);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ptsNumbers==66) {
                    Show();

                }else {

                    startActivity(new Intent(Prog2Tut8.this, E1example8.class));
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
                    skip.setVisibility(View.VISIBLE);

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
                    if(ptsNumbers==66) {
                        Show();
                    }
                    else {
                        startActivity(new Intent(Prog2Tut8.this, E2example8.class));
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
                    skip.setVisibility(View.VISIBLE);

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
                    if(ptsNumbers==66) {
                        Show();

                    }else{

                        startActivity(new Intent(Prog2Tut8.this, E1example8.class));
                        finish();
                    }
                }
            }
        });
    }
    private void Show(){

        startActivity(new Intent(Prog2Tut8.this, E2example8.class));
        finish();
                PtsNumber = 67;
                sql.UpdatePoints(PtsNumber, emaill);
    }
    public void animate(float animates){
        Animation img = new TranslateAnimation(Animation.ABSOLUTE,animates,Animation.ABSOLUTE,Animation.ABSOLUTE);
        img.setDuration( 4000);
        img.setFillAfter(true);

        sir_kurt.startAnimation(img);
    }

    interface Typing{
        void onAnimationComplete();
    }
    void First(final Prog2Tut8.Typing type){
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
    void Second(final Prog2Tut8.Typing type) {
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
    void Third(final Prog2Tut8.Typing type) {
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
    void Fourth(final Prog2Tut8.Typing type) {
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


    @Override
    public void onBackPressed() {
        startActivity(new Intent(Prog2Tut8.this, Pactivity2.class));
        finish();
        tts.stop();
    }
}