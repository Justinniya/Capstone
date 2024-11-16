package com.example.capstone.Example;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.capstone.HomeActivity;
import com.example.capstone.R;

public class Others extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CardView other1 = findViewById(R.id.others1);
        CardView other2 = findViewById(R.id.others2);
        CardView other3 = findViewById(R.id.others3);
        CardView other4 = findViewById(R.id.others4);
        CardView other5 = findViewById(R.id.others5);
        CardView other6 = findViewById(R.id.others6);


        other1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Others.this, "Coming soon!....", Toast.LENGTH_LONG).show();
            }
        });

        other2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Others.this, "Coming soon!....", Toast.LENGTH_LONG).show();
            }
        });

        other3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Others.this, "Coming soon!....", Toast.LENGTH_LONG).show();
            }
        });

        other4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Others.this, "Coming soon!....", Toast.LENGTH_LONG).show();
            }
        });

        other5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Others.this, "Coming soon!....", Toast.LENGTH_LONG).show();
            }
        });

        other6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Others.this, "Coming soon!....", Toast.LENGTH_LONG).show();
            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            startActivity(new Intent(Others.this, HomeActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Others.this, HomeActivity.class));
        finish();
    }
}