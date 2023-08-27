package com.example.tripsnap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BusBookingActivity extends AppCompatActivity {

    private Button search;
    private ImageView calender;
    final Calendar c = Calendar.getInstance();
    private EditText dateEdit,etEnterSource,etEnterDestination;
    private long pressedTime,lnUserId;
    private String stEnterSource,stEnterDestination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_booking);
        init();


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
                    Toast.makeText(BusBookingActivity.this, "Please enter source", Toast.LENGTH_SHORT).show();
                }else if( stEnterDestination.isEmpty()){
                    Toast.makeText(BusBookingActivity.this, "Please enter destination", Toast.LENGTH_SHORT).show();
                }else if( dateEdit.getText().toString().isEmpty()){
                    Toast.makeText(BusBookingActivity.this, "Please enter date", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(BusBookingActivity.this, BusesListActivity.class);
                    startActivity(i);
                }
            }
        });
    }
    private void init(){
        lnUserId=getIntent().getLongExtra("User Id",0);
        search=findViewById(R.id.btnSearch);
        calender= findViewById(R.id.calender);
        dateEdit=findViewById(R.id.etDate);
        etEnterSource=findViewById(R.id.etEnterSource);
        etEnterDestination=findViewById(R.id.etEnterDestination);
    }
    private void stringConverter(){
        stEnterSource=etEnterSource.getText().toString();
        stEnterDestination=etEnterDestination.getText().toString();
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