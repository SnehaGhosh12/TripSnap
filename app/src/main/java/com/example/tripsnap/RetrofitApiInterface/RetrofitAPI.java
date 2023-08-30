package com.example.tripsnap.RetrofitApiInterface;

import com.example.tripsnap.Models.Bus;
import com.example.tripsnap.Models.Reservation;
import com.example.tripsnap.Models.User;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {


    @POST("user/registration")
    Call<User> createPost(@Body User user);

    @GET("user/{id}")
    Call<Map<String,String>> getPassword(@Path("id")Long id);

    @GET("bus/{id}")
    Call<ArrayList<Bus>> getBus(@Path("id")String id);

    @POST("seat/book")
    Call<Reservation> newReservation(@Body Reservation reservation);

    @GET("seat/check/{id}/{no}")
    Call<ArrayList<Reservation>> checkBookedOrNot(@Path("id")String id,@Path("no")int no);


}
