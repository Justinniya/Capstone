package com.example.capstone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.Toast;

public class PythonPractice extends AppCompatActivity {

    private EditText textEditor;
    private TextView lineNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_practice);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lineNumbers = findViewById(R.id.lineNumbers);
        textEditor = findViewById(R.id.textEditor);
        ImageButton Run1 = findViewById(R.id.RunProb1);
        Button tab,Sq,OpenB,CloseB,OpenS,CLoseS,OpenP,CLoseP,Equals,Colon;
        tab = findViewById(R.id.tabMode);
        Sq = findViewById(R.id.Squote);
        OpenB = findViewById(R.id.OpenB);
        CloseB = findViewById(R.id.CloseB);
        OpenS = findViewById(R.id.OpenS);
        CLoseS = findViewById(R.id.CloseSS);
        OpenP= findViewById(R.id.OpenP);
        CLoseP= findViewById(R.id.CLoseP);
        Equals= findViewById(R.id.Equals);
        Colon= findViewById(R.id.Colon);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        lineNumbers.setText("1");

        textEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateLineNumbers();
                highlightSyntax(s);
            }
        });
        tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

                Editable editable = textEditor.getText();

                editable.insert(start, "\t\t\t");

            }
        });
        OpenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

                Editable editable = textEditor.getText();

                editable.insert(start, "{");

            }
        });
        CloseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

                Editable editable = textEditor.getText();

                editable.insert(start, "}");

            }
        });
        Sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();
                Editable editable = textEditor.getText();

                editable.insert(start, "'");

            }
        });
        OpenS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();
                Editable editable = textEditor.getText();
                editable.insert(start, "[");

            }
        });
        CLoseS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

                Editable editable = textEditor.getText();

                editable.insert(start, "]");

            }
        });
        OpenP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

                Editable editable = textEditor.getText();
                editable.insert(start, "(");

            }
        });
        CLoseP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();
                Editable editable = textEditor.getText();
                editable.insert(start, ")");

            }
        });
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();
                Editable editable = textEditor.getText();
                editable.insert(start, "=");

            }
        });
        Colon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();
                Editable editable = textEditor.getText();
                editable.insert(start, ":");

            }
        });




        Run1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ouut;
                String code = textEditor.getText().toString();
                Python python = Python.getInstance();
                PyObject module = python.getModule("script");
                PyObject result = module.callAttr("main",code,"start");
                ouut = result.toString();
                String compile = compileInput(ouut);
                Intent intent = new Intent(PythonPractice.this,Output.class);
                intent.putExtra("outputText", compile);
                intent.putExtra("Flask","true");
                Toast.makeText(PythonPractice.this, ouut, Toast.LENGTH_LONG).show();
                code = null;
                module.clear();
                startActivity(intent);

                    }
        });
}

    private String compileInput(String input) {
        return input;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PythonPractice.this, HomeActivity.class));
        finish();
    }
    private void updateLineNumbers() {
        int lineCount = textEditor.getLineCount();
        StringBuilder numbers = new StringBuilder();
        numbers.append(1).append("\t").append("\n");
        for (int i = 2; i <= lineCount; i++) {

            if(i>9){
                numbers.append(i).append("\t").append("\n");
            }
            else{
                numbers.append(i).append("\t\t").append("\n");
            }
        }
        lineNumbers.setText(numbers.toString());
    }




    private void highlightSyntax(Editable s) {

        Pattern pattern = Pattern.compile("([\"](.*?)|['](.*?))|#(?!TODO )[^\\n]*");
        Pattern patternBlue = Pattern.compile("\\b(as|break|class|continue|def|for|from|global|import|is|lambda|None|nonlocal|pass|True|while|with|yield)\\b");
        Pattern patternGreen = Pattern.compile("([\"](.*?)[\"]|['](.*?)['])|#(?!TODO )[^\\n]*");
        Pattern patternPurple = Pattern.compile("\\b(assert|def|raise|try)\\b");
        Pattern patternOrange = Pattern.compile("\\b(break|del|print|and|elif|else|except|finally|if|in|not|or|return)\\b");
        Matcher matcher = pattern.matcher(s);
        Matcher matcher1 = patternBlue.matcher(s);
        Matcher matcher2 = patternGreen.matcher(s);
        Matcher matcher3 = patternPurple.matcher(s);
        Matcher matcher4 = patternOrange.matcher(s);

        while (matcher4.find()) {
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA500")), matcher4.start(), matcher4.end(), 0);
        }
        while (matcher3.find()) {
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#800080")), matcher3.start(), matcher3.end(), 0);
        }
        while (matcher2.find()) {
            s.setSpan(new ForegroundColorSpan(Color.GREEN), matcher2.start(), matcher2.end(), 0);
        }
        while (matcher1.find()) {
            s.setSpan(new ForegroundColorSpan(Color.BLUE), matcher1.start(), matcher1.end(), 0);
        }
        while (matcher.find()) {
            s.setSpan(new ForegroundColorSpan(Color.WHITE), matcher.start(), matcher.end(), 0);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            startActivity(new Intent(PythonPractice.this, HomeActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}