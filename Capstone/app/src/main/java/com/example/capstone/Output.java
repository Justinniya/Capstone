package com.example.capstone;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import androidx.annotation.NonNull;

public class Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView outputTextView,out;
        out = findViewById(R.id.finish);
        outputTextView = findViewById(R.id.outputTextView);

        String output = getIntent().getStringExtra("outputText");
        boolean flask = Boolean.parseBoolean(getIntent().getStringExtra("Flask"));
        outputTextView.setText(output);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:5000/") // Use the actual device IP
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        /*apiService.getData().enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Output.this, "Successs", Toast.LENGTH_SHORT).show();
                    out.setText(response.toString());

                } else {
                    Toast.makeText(Output.this, "Error", Toast.LENGTH_SHORT).show();
                    out.setText(response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Toast.makeText(Output.this, "can't connect"+ t, Toast.LENGTH_LONG).show();
                out.setText(t.getMessage());
            }
        });
            //fetchDataFromFlask();
    }*/
    /*private void fetchDataFromFlask() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:5000/")  // Use 10.0.2.2 for local emulator access
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiService apiService = retrofit.create(ApiService.class);


        // Make the network call
        apiService.getData().enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
                    ResponseData data = response.body();
                    outputTextView.setText(data != null ? data.getMessage() : "No data received");
                } else {
                    outputTextView.setText("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                outputTextView.setText("Failure: " + t.getMessage());
            }
        });
    }*/
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
                Python python = Python.getInstance();
                PyObject module = python.getModule("script");
                PyObject result = module.callAttr("main", "","stop");
//                String output = result.toStToast.makeText(Output.this, output, Toast.LENGTH_SHORT).show();
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}