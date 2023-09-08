package com.example.tripsnap.RetrofitApiInterface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseUrl {
    public static String baseurl= "https://bushop.onrender.com/api/";

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public static RetrofitAPI retrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        return retrofitAPI;
    }
}
