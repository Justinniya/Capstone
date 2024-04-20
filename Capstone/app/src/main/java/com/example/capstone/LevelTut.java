package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LevelTut extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_tut);
        Button next;
        WebView JavaView;

        JavaView = findViewById(R.id.JavaWebView);
        JavaView.loadUrl("https://www.facebook.com/");
        JavaView.getSettings().setJavaScriptEnabled(true);
        JavaView.setWebViewClient(new WebViewClient());

        next = findViewById(R.id.Next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LevelTut.this, Python1Q1.class));
            }
        });
    }
}