package com.example.capstone;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/")
    Call<ResponseData> getData();
}
