package com.example.capstone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Button btnlogin;
    EditText  etpassword;
    AutoCompleteTextView etemail;
    String[] auto = {""};
    public static String PREFS_NAME = "MyPrefsFIle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DBHelper(this);
        etemail = findViewById(R.id.txtemail);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,auto);
        etemail.setAdapter(adapter);
        etpassword = findViewById(R.id.txtpass);
        btnlogin = findViewById(R.id.login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                boolean isLoggedid = dbHelper.checkEmailuser(etemail.getText().toString(), etpassword.getText().toString());
                if (isLoggedid){
                    editor.putBoolean("hasLoggedIn",true);
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    Intent a = new Intent(LoginActivity.this, Pactivity1.class);
                    a.putExtra("email",etemail.getText().toString());
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Welcome "+ etemail.getText().toString(),Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
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
    public String getEmail(){
        return etemail.getText().toString();

    }
}