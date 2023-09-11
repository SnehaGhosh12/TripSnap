package com.example.tripsnap.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tripsnap.R;

public class HistoryActivity extends AppCompatActivity {

    TextView bus_id,fare,dest,src,time,date,seat_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();


        bus_id.setText(getIntent().getStringExtra("bus_id"));
        fare.setText("₹"+getIntent().getStringExtra("fare")+"/-");
        src.setText(getIntent().getStringExtra("source"));
        dest.setText(getIntent().getStringExtra("destination"));
        time.setText(getIntent().getStringExtra("time"));
        date.setText(getIntent().getStringExtra("journey_date"));
        seat_no.setText(getIntent().getStringExtra("seat_no"));
    }


    private void init(){
        bus_id=findViewById(R.id.TVbus_id);
        fare=findViewById(R.id.fare);
        src=findViewById(R.id.source);
        dest=findViewById(R.id.destination);
        date=findViewById(R.id.date);
        time=findViewById(R.id.time);
        seat_no=findViewById(R.id.seat_no);
    }
}