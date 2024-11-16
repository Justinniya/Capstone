package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Output extends AppCompatActivity {
    private TextView outputTextView,out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        out = findViewById(R.id.finish);
        outputTextView = findViewById(R.id.outputTextView);

        String output = getIntent().getStringExtra("outputText");
        boolean flask = Boolean.parseBoolean(getIntent().getStringExtra("Flask"));
        outputTextView.setText(output);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/") // Use the actual device IP
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
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}