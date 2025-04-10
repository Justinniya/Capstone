package PythonExpert;

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

import com.example.capstone.DBHelper;
import com.example.capstone.Pactivity1;
import com.example.capstone.Prog1Prob1;
import com.example.capstone.Python1Lesson1;
import com.example.capstone.Python1Q1;
import com.example.capstone.R;

public class Prog3Q4 extends AppCompatActivity {
    int PtsNumber;
    long ptsNumbers;

    DBHelper sql;
    String emaill;
    int attempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog3_q4);
        EditText answer = findViewById(R.id.fill);
        Button submit = findViewById(R.id.Submit);
        sql = new DBHelper(this);
        Points();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Code = answer.getText().toString().toLowerCase();
                if(Code.equals("instance methods")){
                    Toast.makeText(Prog3Q4.this, "Correct",Toast.LENGTH_LONG).show();
                    if(ptsNumbers==100) {
                        startActivity(new Intent(Prog3Q4.this,Prog3Prob4.class));
                        finish();
                        PtsNumber = 101;
                        sql.UpdatePoints(PtsNumber, emaill);

                    }else{
                        startActivity(new Intent(Prog3Q4.this,Prog3Prob4.class));
                        finish();
                    }

                }
                else {
                    attempt -= 1;
                    if(attempt > 0) {
                        Toast.makeText(
                                Prog3Q4.this, "Wrong code please try again, " +
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
                startActivity(new Intent(Prog3Q4.this, Python1Lesson1.class));
                finish();
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
        startActivity(new Intent(Prog3Q4.this, Pactivity3.class));
        finish();
    }
}