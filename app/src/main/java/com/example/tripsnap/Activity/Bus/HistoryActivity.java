package com.example.tripsnap.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripsnap.R;

public class HistoryActivity extends AppCompatActivity {

    TextView bus_id,fare,dest,src,time,date,seat_no;
    ImageView imageView;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();
        height=getApplicationContext().getResources().getDisplayMetrics().heightPixels;
//        Toast.makeText(this, ""+height, Toast.LENGTH_SHORT).show();
        imageView.setMaxHeight(height/9);
        bus_id.setText(getIntent().getStringExtra("bus_id"));
        fare.setText("₹"+getIntent().getStringExtra("fare")+"/-");
        src.setText(getIntent().getStringExtra("source").substring(0,1).toUpperCase()+getIntent().getStringExtra("source").substring(1).toLowerCase());
        dest.setText(getIntent().getStringExtra("destination").substring(0,1).toUpperCase()+getIntent().getStringExtra("destination").substring(1).toLowerCase());
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
        imageView=findViewById(R.id.image);
    }
}