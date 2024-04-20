package com.example.capstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Problem_Output extends AppCompatActivity {
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_output);
        outputTextView = findViewById(R.id.outputTextView);
        Button button = findViewById(R.id.button);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    String output = getIntent().getStringExtra("outputText");
        String Correcct = getIntent().getStringExtra("Correctt");

        outputTextView.setText(output);

        if(Correcct.equals("Correct")){
            button.setEnabled(true);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder build = new AlertDialog.Builder(Problem_Output.this);
                    build.setTitle("Success");
                    build.setMessage("Congratulations");
                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(Problem_Output.this, Pactivity1.class));
                            finish();
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = build.create();
                    dialog.show();

                }
            });
        }
        else if(Correcct.equals("Wrong")){
            button.setEnabled(false);
            AlertDialog.Builder build = new AlertDialog.Builder(Problem_Output.this);
            build.setTitle("Notice");
            build.setMessage("Incorrect code, please check your code");
            build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog dialog = build.create();
            dialog.show();

        }
        }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Problem_Output.this,Pactivity1.class));
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}