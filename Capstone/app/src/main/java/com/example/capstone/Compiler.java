package com.example.capstone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

;

public class Compiler extends AppCompatActivity {

    private Python py;
    private EditText inputText;
    private TextView outputText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        py = Python.getInstance();
        inputText = findViewById(R.id.inputText);
        Button runButton = findViewById(R.id.runButton);
        outputText = findViewById(R.id.outputText);

        runButton.setOnClickListener(v -> runCode());


    }
    private void runCode() {

        PyObject compiler = py.getModule("compiler");
        PyObject compileCodeFunc = compiler.callAttr("run_python_code", inputText.getText().toString());
        String a = compileCodeFunc.toString();
        Toast.makeText(Compiler.this," "+ a,Toast.LENGTH_LONG).show();
    }
    }