package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegActivity extends AppCompatActivity {

    EditText fnametxt, lnametxt, emailtxt, passwordtxt, repasswordtxt, pntxt, datetxt,Agetxt,Sectiontxt,Yeartxt;
    Button register, login;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fnametxt = (EditText) findViewById(R.id.fname);
        lnametxt = (EditText) findViewById(R.id.lname);
        emailtxt = (EditText) findViewById(R.id.email);
        passwordtxt = (EditText) findViewById(R.id.password);
        repasswordtxt = (EditText) findViewById(R.id.repassword);
        pntxt = (EditText) findViewById(R.id.pn);
        datetxt = (EditText) findViewById(R.id.date);
        Agetxt = findViewById(R.id.Age);
        Sectiontxt = findViewById(R.id.Age);
        Yeartxt = findViewById(R.id.Year);
        register = (Button) findViewById(R.id.register);
        dbHelper = new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname,lname,email,password,repass,pn,date,Age,Section,Year;
                fname = fnametxt.getText().toString();
                lname = lnametxt.getText().toString();
                email = emailtxt.getText().toString();
                password = passwordtxt.getText().toString();
                repass = repasswordtxt.getText().toString();
                pn = pntxt.getText().toString();
                date = datetxt.getText().toString();
                Age = Agetxt.getText().toString();
                Section = Sectiontxt.getText().toString();
                Year = Yeartxt.getText().toString();

                if (email.contains("")) {
                    if (fname.equals("") || lname.equals("") || email.equals("") || password.equals("") || repass.equals("") || pn.equals("") || date.equals("")) {
                        Toast.makeText(RegActivity.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
                    } else {
                        if (password.equals(repass)) {
                            if (dbHelper.checkEmail(email)) {
                                Toast.makeText(RegActivity.this,  email+" already Exists", Toast.LENGTH_LONG).show();
                                return;
                            }
                            //Proceed with registration
                            boolean registeredSuccess = dbHelper.insertData(fname, lname, email, password, pn, date,Age,Section,Year);
                            if (registeredSuccess) {
                                Toast.makeText(RegActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                //dbHelper.Level("XciteUser");
                                Intent intent = new Intent(RegActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(RegActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegActivity.this, "Password do not match", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else{
                    Toast.makeText(RegActivity.this,"Use your phinma account",Toast.LENGTH_LONG).show();
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