package com.example.capstone.Example;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.capstone.Python1Q13;
import com.example.capstone.R;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.Locale;
import java.util.Set;

import PythonExpert.Prog3Q13;
import PythonExplorer.Prog2Q1;
import PythonExplorer.Prog2Q13;

public class E1example13 extends AppCompatActivity {
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e1example13);
        Button next = findViewById(R.id.Next);
        PhotoView photoView = findViewById(R.id.imageView4);
        photoView.setMaximumScale(10f); // Set maximum zoom scale
        photoView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        Locale local = new Locale("en","US");
        AlertDialog.Builder build = new AlertDialog.Builder(this);
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                build.setTitle("Success");
                String msg = "I hope you have learn something new today!   ";
                build.setMessage(msg);
                tts.speak(msg, TextToSpeech.QUEUE_FLUSH,null);
                build.setPositiveButton("Procced", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(E1example13.this, Prog3Q13.class));
                        finish();
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = build.create();
                dialog.show();
            }
        });
    }
}