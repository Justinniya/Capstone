package PythonExplorer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.capstone.DBHelper;
import com.example.capstone.Pactivity1;
import com.example.capstone.Problem_Output;
import com.example.capstone.Prog1Prob1;
import com.example.capstone.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prog2Code8 extends AppCompatActivity {
    int PtsNumber;
    long ptsNumbers;

    DBHelper sql;
    String emaill;
    private EditText textEditor;
    private TextView lineNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog2_code8);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sql = new DBHelper(this);
        lineNumbers = findViewById(R.id.lineNumbers);
        textEditor = findViewById(R.id.textEditor);
        Button tab,Sq,OpenB,CloseB,OpenS,CLoseS,OpenP,CLoseP,Equals,Colon;
        ImageButton Run1 = findViewById(R.id.RunProb1);
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
        Points();
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

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "\t\t\t");

            }
        });
        OpenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "{");

            }
        });
        CloseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "}");

            }
        });
        Sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "'");

            }
        });
        OpenS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "[");

            }
        });
        CLoseS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "]");

            }
        });
        OpenP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "(");

            }
        });
        CLoseP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, ")");

            }
        });
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, "=");

            }
        });
        Colon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = textEditor.getSelectionStart();
                int end = textEditor.getSelectionEnd();

// Get the text in the EditText
                Editable editable = textEditor.getText();

// Insert the string at the cursor position
                editable.insert(start, ":");

            }
        });




        Run1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python python = Python.getInstance();
                PyObject Eout = python.getModule("script");
                PyObject call = Eout.callAttr("main","my_list = [1, 2, 3, 4, 5]\n" +
                        "\n" +
                        "# Iterate over the list and print each element\n" +
                        "for element in my_list:\n" +
                        "    print(element)\n" +
                        "\n");
                PyObject module = python.getModule("script");
                PyObject result = module.callAttr("main",textEditor.getText().toString());
                String EOutput = call.toString();
                String Prob1R = result.toString();


                if(Prob1R.equals(EOutput)) {
                    if(ptsNumbers==2) {
                        String compile = compileInput(Prob1R);
                        Intent intent = new Intent(Prog2Code8.this, Problem_Output.class);
                        String Coorect = "Correct";
                        String cor = compileInput(Coorect);
                        PtsNumber = 3;
                        sql.UpdatePoints(PtsNumber, emaill);
                        intent.putExtra("outputText", compile)
                                .putExtra("Correctt",cor);

                        startActivity(intent);
                        finish();

                    }else{
                        String compile = compileInput(Prob1R);
                        Intent intent = new Intent(Prog2Code8.this,Problem_Output.class);
                        String Coorect = "Correct";
                        String cor = compileInput(Coorect);
                        intent.putExtra("outputText", compile)
                                .putExtra("Correctt",cor);
                        startActivity(intent);
                        finish();
                    }

                }
                else{

                    AlertDialog.Builder build = new AlertDialog.Builder(Prog2Code8.this);
                    build.setTitle("Error");
                    String msg = Prob1R;
                    build.setMessage(msg);
                    AlertDialog dialog = build.create();
                    dialog.show();
                }
            }
        });
    }

    private String compileInput(String input) {
        // Your compilation logic here
        // For demonstration, simply return the input
        return input;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Prog2Code8.this, Pactivity1.class));
        finish();
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

        Pattern pattern = Pattern.compile("\\b()\\b");
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

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            startActivity(new Intent(Prog2Code8.this, Pactivity2.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}