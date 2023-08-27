package com.example.tripsnap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripsnap.Models.User;
import com.example.tripsnap.RetrofitApiInterface.RetrofitAPI;
import com.example.tripsnap.RetrofitApiInterface.BaseUrl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserSignUpActivity extends AppCompatActivity {


    private EditText etMobileNo;
    private EditText etName;
    private   EditText etEmail;
    private EditText etAge;
    private EditText etGender;
    private  EditText etPassword;
    String stMobileNo,stName,stEmail,stAge,stGender,stPassowrd;
    private Button btnSignUp;
    Dialog dialog;
    private long pressedTime;

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        init();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringConeverter();
                if(stMobileNo.isEmpty() || stEmail.isEmpty() || stPassowrd.isEmpty() || stName.isEmpty() || stAge.isEmpty() || stGender.isEmpty()){
                    Toast.makeText(UserSignUpActivity.this, "Please fill all data", Toast.LENGTH_SHORT).show();
                }else{
                    dialog = new Dialog(UserSignUpActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.progressbar);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    setUser();
                    registrationUser(user);
                }

            }
        });



    }


    private void registrationUser(User user){
       RetrofitAPI retrofitAPI=BaseUrl.retrofit();
        Call<User> call = retrofitAPI.createPost(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                User responseFromAPI = response.body();
                Toast.makeText(UserSignUpActivity.this, "Registration Successsfull.", Toast.LENGTH_SHORT).show();
                Intent i =new Intent(UserSignUpActivity.this,RegisterActivity.class);
                dialog.dismiss();
                startActivity(i);
                finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(UserSignUpActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setUser(){
        user=new User();
        user.setUserId(Long.parseLong(stMobileNo));
        user.setUserEmail(stEmail);
        user.setUserName(stName);
        user.setAge(stAge);
        user.setGender(stGender);
        user.setUserPassword(stPassowrd);
    }
    private void stringConeverter(){
        stMobileNo=etMobileNo.getText().toString();
        stName=etName.getText().toString();
        stEmail=etEmail.getText().toString();
        stAge=etAge.getText().toString();
        stGender=etGender.getText().toString();
        stPassowrd=etPassword.getText().toString();

    }
    private void init(){
        etMobileNo=findViewById(R.id.etMobileNo);

        etName=findViewById(R.id.etName);

        etEmail=findViewById(R.id.etEmail);

        etAge=findViewById(R.id.etAge);

        etGender=findViewById(R.id.etGender);

        etPassword=findViewById(R.id.etPassword);

        btnSignUp=findViewById(R.id.btnSignUp);

    }
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}