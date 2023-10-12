package com.example.tripsnap.Activity.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.tripsnap.Activity.Authentication.UserLoginActivity;
import com.example.tripsnap.Activity.Bus.BusBookingActivity;
import com.example.tripsnap.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences= getSharedPreferences("login", Context.MODE_PRIVATE);
                if (sharedPreferences.contains("isUserLogIn") && sharedPreferences.getLong("UserId",-1)!=-1) {
//                    Log.d("user",""+sharedPreferences.getLong("UserId",-1));
                    Intent intent = new Intent(SplashActivity.this, BusBookingActivity.class);
                    Long userId= sharedPreferences.getLong("UserId",-1);
                    intent.putExtra("UserId",userId);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, UserLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2500);
    }
}