package com.example.tripsnap.RetrofitApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseUrl {
    public static String baseurl= "https://bushop-production.up.railway.app/api/";

    public static RetrofitAPI retrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        return retrofitAPI;
    }
}
