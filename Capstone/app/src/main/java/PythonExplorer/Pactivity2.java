package PythonExplorer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.capstone.DBHelper;
import com.example.capstone.HomeActivity;
import com.example.capstone.Pactivity1;
import com.example.capstone.Python1Lesson1;
import com.example.capstone.Python1Lesson10;
import com.example.capstone.Python1Lesson11;
import com.example.capstone.Python1Lesson12;
import com.example.capstone.Python1Lesson13;
import com.example.capstone.Python1Lesson14;
import com.example.capstone.Python1Lesson15;
import com.example.capstone.Python1Lesson2;
import com.example.capstone.Python1Lesson3;
import com.example.capstone.Python1Lesson4;
import com.example.capstone.Python1Lesson5;
import com.example.capstone.Python1Lesson6;
import com.example.capstone.Python1Lesson7;
import com.example.capstone.Python1Lesson8;
import com.example.capstone.Python1Lesson9;
import com.example.capstone.R;

import PythonExpert.Prog3Tut15;


public class Pactivity2 extends AppCompatActivity {
    public int Pts;
    long PtsNumber;
    DBHelper sql;
    Intent a = getIntent();
    String emaill;


    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pactivity2);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sql = new DBHelper(this);
        handler = new Handler();
        Points();
        CardView Card2 = findViewById(R.id.pythonL1);
        CardView Card1 = findViewById(R.id.pythonL2);
        ImageView L2 = findViewById(R.id.lock2);
        CardView Card3 = findViewById(R.id.pythonL3);
        ImageView L3 = findViewById(R.id.lock3);
        CardView Card4 = findViewById(R.id.pythonL4);
        ImageView L4 = findViewById(R.id.lock4);
        CardView Card5 = findViewById(R.id.pythonL5);
        ImageView L5 = findViewById(R.id.lock5);
        CardView Card6 = findViewById(R.id.pythonL6);
        ImageView L6 = findViewById(R.id.lock6);
        CardView Card7 = findViewById(R.id.pythonL7);
        ImageView L7 = findViewById(R.id.lock7);
        CardView Card8 = findViewById(R.id.pythonL8);
        ImageView L8 = findViewById(R.id.lock8);
        CardView Card9 = findViewById(R.id.pythonL9);
        ImageView L9 = findViewById(R.id.lock9);
        CardView Card10 = findViewById(R.id.pythonL10);
        ImageView L10 = findViewById(R.id.lock10);
        CardView Card11 = findViewById(R.id.pythonL11);
        ImageView L11 = findViewById(R.id.lock11);
        CardView Card12 = findViewById(R.id.pythonL12);
        ImageView L12 = findViewById(R.id.lock12);
        CardView Card13 = findViewById(R.id.pythonL13);
        ImageView L13 = findViewById(R.id.lock13);
        CardView Card14 = findViewById(R.id.pythonL14);
        ImageView L14 = findViewById(R.id.lock14);
        CardView Card15 = findViewById(R.id.pythonL15);
        ImageView L15 = findViewById(R.id.lock15);
        ImageView C1 = findViewById(R.id.Completed1);
        ImageView C2 = findViewById(R.id.Completed2);
        ImageView C3 = findViewById(R.id.Completed3);
        ImageView C4 = findViewById(R.id.Completed4);
        ImageView C5 = findViewById(R.id.Completed5);
        ImageView C6 = findViewById(R.id.Completed6);
        ImageView C7= findViewById(R.id.Completed7);
        ImageView C8 = findViewById(R.id.Completed8);
        ImageView C9 = findViewById(R.id.Completed9);
        ImageView C10 = findViewById(R.id.Completed10);
        ImageView C11= findViewById(R.id.Completed11);
        ImageView C12= findViewById(R.id.Completed12);
        ImageView C13= findViewById(R.id.Completed13);
        ImageView C14= findViewById(R.id.Completed14);
        ImageView C15= findViewById(R.id.Completed15);
        //LoginActivity aa = new LoginActivity();
        //emaill = aa.getEmail();
        Email();
        final boolean level [] = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
        C1.setVisibility(View.GONE);
        C2.setVisibility(View.GONE);
        C3.setVisibility(View.GONE);
        C4.setVisibility(View.GONE);
        C5.setVisibility(View.GONE);
        C6.setVisibility(View.GONE);
        C7.setVisibility(View.GONE);
        C8.setVisibility(View.GONE);
        C9.setVisibility(View.GONE);
        C10.setVisibility(View.GONE);
        C11.setVisibility(View.GONE);
        C12.setVisibility(View.GONE);
        C13.setVisibility(View.GONE);
        C14.setVisibility(View.GONE);
        C15.setVisibility(View.GONE);
        if(PtsNumber ==  48 || PtsNumber ==  49 || PtsNumber ==  50){
            L2.setVisibility(View.GONE);

            C1.setVisibility(View.VISIBLE);
            level[1] = true;
        }
        else if( PtsNumber ==  51 || PtsNumber ==  52 || PtsNumber ==  53){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);

            L3.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
        }
        else if(PtsNumber ==  54 ||
                PtsNumber ==  55 || PtsNumber ==  56){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
        }
        else if(PtsNumber ==  57 ||
                PtsNumber ==  58 || PtsNumber ==  59 ){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
        }
        else if(PtsNumber ==  60 ||
                PtsNumber ==  61 || PtsNumber ==  62){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
        }
        else if( PtsNumber ==  63 ||
                PtsNumber ==  64 || PtsNumber ==  65){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
        }
        else if(PtsNumber ==  66 ||
                PtsNumber ==  67 || PtsNumber ==  68){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
        }
        else if( PtsNumber ==  69 ||
                PtsNumber ==  70 || PtsNumber ==  71){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
        }
        else if(PtsNumber ==  72 ||
                PtsNumber ==  73 || PtsNumber ==  74){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);


            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
        }
        else if(PtsNumber ==  75 ||
                PtsNumber ==  76 || PtsNumber ==  77){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);
            C10.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            L11.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
            level[10] = true;
        }
        else if(PtsNumber ==  78 ||
                PtsNumber ==  79 || PtsNumber ==  80 ){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);
            C10.setVisibility(View.VISIBLE);
            C11.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            L11.setVisibility(View.GONE);
            L12.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
            level[10] = true;
            level[11] = true;
        }
        else if(PtsNumber ==  81 ||
                PtsNumber ==  82 || PtsNumber ==  83){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);
            C10.setVisibility(View.VISIBLE);
            C11.setVisibility(View.VISIBLE);
            C12.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            L11.setVisibility(View.GONE);
            L12.setVisibility(View.GONE);
            L13.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
            level[10] = true;
            level[11] = true;
            level[12] = true;
        }
        else if(PtsNumber ==  84 ||
                PtsNumber ==  85 || PtsNumber ==  86){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);
            C10.setVisibility(View.VISIBLE);
            C11.setVisibility(View.VISIBLE);
            C12.setVisibility(View.VISIBLE);
            C13.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            L11.setVisibility(View.GONE);
            L12.setVisibility(View.GONE);
            L13.setVisibility(View.GONE);
            L14.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
            level[10] = true;
            level[11] = true;
            level[12] = true;
            level[13] = true;
        }
        else if(PtsNumber ==  87 ||
                PtsNumber ==  88 || PtsNumber ==  89){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);
            C10.setVisibility(View.VISIBLE);
            C11.setVisibility(View.VISIBLE);
            C12.setVisibility(View.VISIBLE);
            C13.setVisibility(View.VISIBLE);
            C14.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            L11.setVisibility(View.GONE);
            L12.setVisibility(View.GONE);
            L13.setVisibility(View.GONE);
            L14.setVisibility(View.GONE);
            L15.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
            level[10] = true;
            level[11] = true;
            level[12] = true;
            level[13] = true;
            level[14] = true;
        }
        else if(PtsNumber>=90){
            C1.setVisibility(View.VISIBLE);
            C2.setVisibility(View.VISIBLE);
            C3.setVisibility(View.VISIBLE);
            C4.setVisibility(View.VISIBLE);
            C5.setVisibility(View.VISIBLE);
            C6.setVisibility(View.VISIBLE);
            C7.setVisibility(View.VISIBLE);
            C8.setVisibility(View.VISIBLE);
            C9.setVisibility(View.VISIBLE);
            C10.setVisibility(View.VISIBLE);
            C11.setVisibility(View.VISIBLE);
            C12.setVisibility(View.VISIBLE);
            C13.setVisibility(View.VISIBLE);
            C14.setVisibility(View.VISIBLE);
            C15.setVisibility(View.VISIBLE);

            L4.setVisibility(View.GONE);
            L2.setVisibility(View.GONE);
            L3.setVisibility(View.GONE);
            L5.setVisibility(View.GONE);
            L6.setVisibility(View.GONE);
            L7.setVisibility(View.GONE);
            L8.setVisibility(View.GONE);
            L9.setVisibility(View.GONE);
            L10.setVisibility(View.GONE);
            L11.setVisibility(View.GONE);
            L12.setVisibility(View.GONE);
            L13.setVisibility(View.GONE);
            L14.setVisibility(View.GONE);
            L15.setVisibility(View.GONE);
            level[1] = true;
            level[2] = true;
            level[3] = true;
            level[3] = true;
            level[4] = true;
            level[5] = true;
            level[6] = true;
            level[7] = true;
            level[8] = true;
            level[9] = true;
            level[10] = true;
            level[11] = true;
            level[12] = true;
            level[13] = true;
            level[14] = true;

        }

        autoRefesh();
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        final boolean level [] = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
                        Points();
                        C1.setVisibility(View.GONE);
                        C2.setVisibility(View.GONE);
                        C3.setVisibility(View.GONE);
                        C4.setVisibility(View.GONE);
                        C5.setVisibility(View.GONE);
                        C6.setVisibility(View.GONE);
                        C7.setVisibility(View.GONE);
                        C8.setVisibility(View.GONE);
                        C9.setVisibility(View.GONE);
                        C10.setVisibility(View.GONE);
                        C11.setVisibility(View.GONE);
                        C12.setVisibility(View.GONE);
                        C13.setVisibility(View.GONE);
                        C14.setVisibility(View.GONE);
                        C15.setVisibility(View.GONE);
                        if(PtsNumber ==  48 || PtsNumber ==  49 || PtsNumber ==  50){
                            L2.setVisibility(View.GONE);

                            C1.setVisibility(View.VISIBLE);
                            level[1] = true;
                        }
                        else if( PtsNumber ==  51 || PtsNumber ==  52 || PtsNumber ==  53){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);

                            L3.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                        }
                        else if(PtsNumber ==  54 ||
                                PtsNumber ==  55 || PtsNumber ==  56){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                        }
                        else if(PtsNumber ==  57 ||
                                PtsNumber ==  58 || PtsNumber ==  59 ){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                        }
                        else if(PtsNumber ==  60 ||
                                PtsNumber ==  61 || PtsNumber ==  62){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                        }
                        else if( PtsNumber ==  63 ||
                                PtsNumber ==  64 || PtsNumber ==  65){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                        }
                        else if(PtsNumber ==  66 ||
                                PtsNumber ==  67 || PtsNumber ==  68){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                        }
                        else if( PtsNumber ==  69 ||
                                PtsNumber ==  70 || PtsNumber ==  71){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                        }
                        else if(PtsNumber ==  72 ||
                                PtsNumber ==  73 || PtsNumber ==  74){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);


                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                        }
                        else if(PtsNumber ==  75 ||
                                PtsNumber ==  76 || PtsNumber ==  77){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);
                            C10.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            L11.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                            level[10] = true;
                        }
                        else if(PtsNumber ==  78 ||
                                PtsNumber ==  79 || PtsNumber ==  80 ){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);
                            C10.setVisibility(View.VISIBLE);
                            C11.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            L11.setVisibility(View.GONE);
                            L12.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                            level[10] = true;
                            level[11] = true;
                        }
                        else if(PtsNumber ==  81 ||
                                PtsNumber ==  82 || PtsNumber ==  83){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);
                            C10.setVisibility(View.VISIBLE);
                            C11.setVisibility(View.VISIBLE);
                            C12.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            L11.setVisibility(View.GONE);
                            L12.setVisibility(View.GONE);
                            L13.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                            level[10] = true;
                            level[11] = true;
                            level[12] = true;
                        }
                        else if(PtsNumber ==  84 ||
                                PtsNumber ==  85 || PtsNumber ==  86){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);
                            C10.setVisibility(View.VISIBLE);
                            C11.setVisibility(View.VISIBLE);
                            C12.setVisibility(View.VISIBLE);
                            C13.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            L11.setVisibility(View.GONE);
                            L12.setVisibility(View.GONE);
                            L13.setVisibility(View.GONE);
                            L14.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                            level[10] = true;
                            level[11] = true;
                            level[12] = true;
                            level[13] = true;
                        }
                        else if(PtsNumber ==  87 ||
                                PtsNumber ==  88 || PtsNumber ==  89){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);
                            C10.setVisibility(View.VISIBLE);
                            C11.setVisibility(View.VISIBLE);
                            C12.setVisibility(View.VISIBLE);
                            C13.setVisibility(View.VISIBLE);
                            C14.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            L11.setVisibility(View.GONE);
                            L12.setVisibility(View.GONE);
                            L13.setVisibility(View.GONE);
                            L14.setVisibility(View.GONE);
                            L15.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                            level[10] = true;
                            level[11] = true;
                            level[12] = true;
                            level[13] = true;
                            level[14] = true;
                        }
                        else if(PtsNumber>=90){
                            C1.setVisibility(View.VISIBLE);
                            C2.setVisibility(View.VISIBLE);
                            C3.setVisibility(View.VISIBLE);
                            C4.setVisibility(View.VISIBLE);
                            C5.setVisibility(View.VISIBLE);
                            C6.setVisibility(View.VISIBLE);
                            C7.setVisibility(View.VISIBLE);
                            C8.setVisibility(View.VISIBLE);
                            C9.setVisibility(View.VISIBLE);
                            C10.setVisibility(View.VISIBLE);
                            C11.setVisibility(View.VISIBLE);
                            C12.setVisibility(View.VISIBLE);
                            C13.setVisibility(View.VISIBLE);
                            C14.setVisibility(View.VISIBLE);
                            C15.setVisibility(View.VISIBLE);

                            L4.setVisibility(View.GONE);
                            L2.setVisibility(View.GONE);
                            L3.setVisibility(View.GONE);
                            L5.setVisibility(View.GONE);
                            L6.setVisibility(View.GONE);
                            L7.setVisibility(View.GONE);
                            L8.setVisibility(View.GONE);
                            L9.setVisibility(View.GONE);
                            L10.setVisibility(View.GONE);
                            L11.setVisibility(View.GONE);
                            L12.setVisibility(View.GONE);
                            L13.setVisibility(View.GONE);
                            L14.setVisibility(View.GONE);
                            L15.setVisibility(View.GONE);
                            level[1] = true;
                            level[2] = true;
                            level[3] = true;
                            level[3] = true;
                            level[4] = true;
                            level[5] = true;
                            level[6] = true;
                            level[7] = true;
                            level[8] = true;
                            level[9] = true;
                            level[10] = true;
                            level[11] = true;
                            level[12] = true;
                            level[13] = true;
                            level[14] = true;

                        }


                        swipeRefreshLayout.setRefreshing(false);

                    }
                }
        );
        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //startActivity(new Intent(Pactivity1.this, LevelTut.class));
                startActivity(new Intent(Pactivity2.this, Prog2Tut1.class));
                Toast.makeText(Pactivity2.this, "Welcome to Level 1", Toast.LENGTH_LONG).show();

            }
        });
        Card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[1] == false){
                    Toast.makeText(Pactivity2.this, "Level 2 is locked", Toast.LENGTH_LONG).show();

                }
                else {

                    //startActivity(new Intent(P.this, JavaActivity.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 2", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Pactivity2.this, Prog2Tut2.class));
                }
            }
        });
        Card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[2] == false){
                    Toast.makeText(Pactivity2.this, "Level 3 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut3.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 3", Toast.LENGTH_LONG).show();
                }
            }
        });
        Card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[3] == false){
                    Toast.makeText(Pactivity2.this, "Level 4 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut4.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 4", Toast.LENGTH_LONG).show();
                }
            }
        });
        Card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[4] == false){
                    Toast.makeText(Pactivity2.this, "Level 5 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut5.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 5", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[5] == false){
                    Toast.makeText(Pactivity2.this, "Level 6 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut6.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 6", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[6] == false){
                    Toast.makeText(Pactivity2.this, "Level 7 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut7.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 7", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[7] == false){
                    Toast.makeText(Pactivity2.this, "Level 8 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut8.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 8", Toast.LENGTH_LONG).show();

                }
            }
        });

        Card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[8] == false){
                    Toast.makeText(Pactivity2.this, "Level 9 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut9.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 9", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[9] == false){
                    Toast.makeText(Pactivity2.this, "Level 10 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    //startActivity(new Intent(P.this, JavaActivity.class));
                    startActivity(new Intent(Pactivity2.this, Prog2Tut10.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 10", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[10] == false){
                    Toast.makeText(Pactivity2.this, "Level 11 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(Pactivity2.this, Prog2Tut11.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 11", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[11] == false){
                    Toast.makeText(Pactivity2.this, "Level 12 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(Pactivity2.this, Prog2Tut12.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 12", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[12] == false){
                    Toast.makeText(Pactivity2.this, "Level 13 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(Pactivity2.this, Prog2Tut13.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 13", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[13] == false){
                    Toast.makeText(Pactivity2.this, "Level 14 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(Pactivity2.this, Prog2Tut14.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 14", Toast.LENGTH_LONG).show();

                }
            }
        });
        Card15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level[14] == false){
                    Toast.makeText(Pactivity2.this, "Level 15 is locked", Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(Pactivity2.this, Prog2Tut15.class));
                    Toast.makeText(Pactivity2.this, "Welcome to Level 15", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            startActivity(new Intent(Pactivity2.this,HomeActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public void Points(){
        Cursor cur = sql.getAll();

        if(cur != null){
            while(cur.moveToNext()){
                PtsNumber = Long.parseLong(cur.getString(2));
            }
            cur.close();
        }

    }
    public void autoRefesh(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,100 );
            }
        }, 100);
    }
    public void Email(){
        Cursor cur = sql.getAllNotes();

        if(cur != null){
            while(cur.moveToNext()){
                emaill = cur.getString(2);
            }
            cur.close();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Pactivity2.this, HomeActivity.class));
        finish();
    }
}