package com.example.tripsnap.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripsnap.Adapter.BusesAdapter;
import com.example.tripsnap.Adapter.HistoryAdapter;
import com.example.tripsnap.Models.Bus;
import com.example.tripsnap.Models.Reservation;
import com.example.tripsnap.R;
import com.example.tripsnap.RetrofitApiInterface.BaseUrl;
import com.example.tripsnap.RetrofitApiInterface.RetrofitAPI;

import java.util.ArrayList;
import java.util.Calendar;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusBookingActivity extends AppCompatActivity {

    private Button search;
    private ImageView calender;
    final Calendar c = Calendar.getInstance();
    private EditText dateEdit,etEnterSource,etEnterDestination;
    private long pressedTime;
//    public static  Long lnUserId;
    public static Long userId;
    private Dialog dialog;
    private String stEnterSource,stEnterDestination;
    private RecyclerView historyRecyclerView;
    private TextView historyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_booking);
        init();

        historyApi();


        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        BusBookingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                dateEdit.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000l);

                datePickerDialog.show();
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        BusBookingActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                dateEdit.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        year, month, day);
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000l);
                datePickerDialog.show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringConverter();
                if(stEnterSource.isEmpty()){
                    Toasty.error(BusBookingActivity.this,"Please enter source",Toasty.LENGTH_SHORT).show();
                }else if( stEnterDestination.isEmpty()){
                    Toasty.error(BusBookingActivity.this,"Please enter destination",Toasty.LENGTH_SHORT).show();
//                    Toast.makeText(BusBookingActivity.this, "Please enter destination", Toast.LENGTH_SHORT).show();
                }else if( dateEdit.getText().toString().isEmpty()){
                    Toasty.error(BusBookingActivity.this,"Please enter date",Toasty.LENGTH_SHORT).show();
//                    Toast.makeText(BusBookingActivity.this, "Please enter date", Toast.LENGTH_SHORT).show();
                }else {
                    dialog = new Dialog(BusBookingActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.progressbar);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                    getBusByApi();

                }
            }
        });
    }

    private void historyApi() {
        RetrofitAPI retrofitAPI=BaseUrl.retrofit();
        dialog = new Dialog(BusBookingActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progressbar);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Call<ArrayList<Reservation>> historyList=retrofitAPI.getAllHistory(userId);
        historyList.enqueue(new Callback<ArrayList<Reservation>>() {
            @Override
            public void onResponse(Call<ArrayList<Reservation>> call, Response<ArrayList<Reservation>> response) {
                ArrayList<Reservation> arrayList=response.body();
//                Toast.makeText(BusBookingActivity.this, ""+arrayList.size(), Toast.LENGTH_SHORT).show();
                if(arrayList.size()==0){
                    historyTextView.setVisibility(View.GONE);
                    dialog.dismiss();
                }else {
                    dialog.dismiss();
                    historyRecyclerView.setLayoutManager(new LinearLayoutManager(BusBookingActivity.this));
                    historyRecyclerView.setAdapter(new HistoryAdapter(getApplicationContext(), arrayList));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Reservation>> call, Throwable t) {
                     dialog.dismiss();
                     Toasty.error(BusBookingActivity.this,t.getMessage(),Toasty.LENGTH_SHORT).show();

            }
        });


    }

    public void getBusByApi(){
        RetrofitAPI retrofitAPI = BaseUrl.retrofit();
        String srcdst= stEnterSource.trim()+stEnterDestination.trim();
        Call<ArrayList<Bus>> call = retrofitAPI.findAllBusBySrcdstAndDate(srcdst,dateEdit.getText().toString());

        call.enqueue(new Callback<ArrayList<Bus>>() {
            @Override
            public void onResponse(Call<ArrayList<Bus>> call, Response<ArrayList<Bus>> response) {
                ArrayList<Bus> list=response.body();
//                Toast.makeText(BusBookingActivity.this, ""+list.size(), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(BusBookingActivity.this, BusesListActivity.class);

                Bundle bundle=new Bundle();
                bundle.putParcelableArrayList("arraylist",list);
                i.putExtras(bundle);
                i.putExtra("src",stEnterSource);
                i.putExtra("dst",stEnterDestination);
                i.putExtra("date",dateEdit.getText().toString());
                i.putExtra("UserId",userId);

                dialog.dismiss();
                startActivity(i);
            }

            @Override
            public void onFailure(Call<ArrayList<Bus>> call, Throwable t) {
                Toast.makeText(BusBookingActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }



        });

    }
    private void init(){
//        lnUserId=getIntent().getLongExtra("User Id",0);
        SharedPreferences sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        userId=sharedPreferences.getLong("UserId",-1);
//        Toast.makeText(BusBookingActivity.this, ""+userId, Toast.LENGTH_SHORT).show();
        search=findViewById(R.id.btnSearch);
        calender= findViewById(R.id.calender);
        dateEdit=findViewById(R.id.etDate);
        historyTextView=findViewById(R.id.historyTextView);
        historyRecyclerView=findViewById(R.id.historyRecyclerView);
        etEnterSource=findViewById(R.id.etEnterSource);
        etEnterDestination=findViewById(R.id.etEnterDestination);
    }
    private void stringConverter(){
        stEnterSource=etEnterSource.getText().toString().toLowerCase();
        stEnterDestination=etEnterDestination.getText().toString().toLowerCase();
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