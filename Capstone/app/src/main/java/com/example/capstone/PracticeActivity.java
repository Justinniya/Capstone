package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        boolean locklock[] = {true, false};
        CardView Python = findViewById(R.id.pythonL2);
        CardView Java = findViewById(R.id.javaL1);

        Python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (locklock[0] == true) {
                    Intent intent = new Intent(PracticeActivity.this, PythonPractice.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(PracticeActivity.this, "Python Practice is locked", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}