package com.example.capstone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Python1Q11 extends AppCompatActivity {
    int PtsNumber;
    long ptsNumbers;

    DBHelper sql;
    String emaill;
    int attempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python1_q11);
        EditText answer = findViewById(R.id.fill);
        Button submit = findViewById(R.id.Submit);
        sql = new DBHelper(this);
        Points();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Code = answer.getText().toString();
                if(Code.equals("And")){
                    Toast.makeText(Python1Q11.this, "Correct",Toast.LENGTH_LONG).show();

                    if(ptsNumbers==31) {
                        PtsNumber = 32;
                        sql.UpdatePoints(PtsNumber, emaill);
                        startActivity(new Intent(Python1Q11.this,Prog1Prob11.class));
                        finish();

                    }else{
                        startActivity(new Intent(Python1Q11.this,Prog1Prob1.class));
                        finish();
                    }

                }
                else {
                    attempt -= 1;
                    if(attempt > 0) {
                        Toast.makeText(
                                Python1Q11.this, "Wrong code please try again, " +
                                        "attempt " + attempt + " left", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        attempt = 3;
                        Show();

                    }

                }
            }
        });
    }
    private void Show(){
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("notice");
        build.setMessage("Please review your lesson");
        build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Python1Q11.this, Python1Lesson11.class));
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = build.create();
        dialog.show();
    }
    public void Points(){
        Cursor cur = sql.getAll();

        if(cur != null){
            while(cur.moveToNext()){
                ptsNumbers = Long.parseLong(cur.getString(2));
            }
            cur.close();
        }

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Python1Q11.this, Pactivity1.class));
        finish();
    }
}