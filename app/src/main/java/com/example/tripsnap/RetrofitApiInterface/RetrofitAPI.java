package com.example.tripsnap.RetrofitApiInterface;

import com.example.tripsnap.Models.PasswordModel;
import com.example.tripsnap.Models.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {


    @POST("user/registration")
    Call<User> createPost(@Body User user);

    @GET("user/{id}")
    Call<Map<String,String>> getPassword(@Path("id")Long id);
}
