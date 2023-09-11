package com.example.tripsnap.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripsnap.Adapter.BusesAdapter;
import com.example.tripsnap.Models.Bus;
import com.example.tripsnap.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

public class BusesListActivity extends AppCompatActivity {

    public static String date,resDate,src,dst;
    public  static Long userId;
    private TextView noBusFound,srcdst,jd;
    private ImageView backimg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_list);

        RecyclerView recyclerView=findViewById(R.id.buslist_rv);
        noBusFound=findViewById(R.id.NoBusFound);
        srcdst=findViewById(R.id.srcdst);
        jd=findViewById(R.id.jd);
        backimg=findViewById(R.id.backimg);
        noBusFound.setVisibility(View.GONE);
        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


//        List<ItemBus> itemBuses=new ArrayList<ItemBus>();
//        itemBuses.add(new ItemBus("WB 29 1234","Kolkata","Delhi","2.00 pm -> 4.14 pm","8000"));
//        itemBuses.add(new ItemBus("WB 29 2342","Kolkata","Mumbai","10.40pm -> 2.00pm","1200"));
//        itemBuses.add(new ItemBus("WB 29 5642","Mumbai","Delhi","12.40pm -> 4.14 pm","5900"));
//        itemBuses.add(new ItemBus("WB 29 1289","Kolkata","Pune","12.40am -> 2.00am","3900"));
//
//        itemBuses.add(new ItemBus("WB 29 1234","Kolkata","Delhi","2.00 pm -> 4.14 pm","8000"));
//        itemBuses.add(new ItemBus("WB 29 2342","Kolkata","Mumbai","10.40pm -> 2.00pm","1200"));
//        itemBuses.add(new ItemBus("WB 29 5642","Mumbai","Delhi","12.40pm -> 4.14 pm","5900"));
//        itemBuses.add(new ItemBus("WB 29 1289","Kolkata","Pune","12.40am -> 2.00am","3900"));
//        itemBuses.add(new ItemBus("WB 29 1234","Kolkata","Delhi","2.00 pm -> 4.14 pm","8000"));
//        itemBuses.add(new ItemBus("WB 29 2342","Kolkata","Mumbai","10.40pm -> 2.00pm","1200"));
//        itemBuses.add(new ItemBus("WB 29 5642","Mumbai","Delhi","12.40pm -> 4.14 pm","5900"));
//        itemBuses.add(new ItemBus("WB 29 1289","Kolkata","Pune","12.40am -> 2.00am","3900"));
//        itemBuses.add(new ItemBus("WB 29 1234","Kolkata","Delhi","2.00 pm -> 4.14 pm","8000"));
//        itemBuses.add(new ItemBus("WB 29 2342","Kolkata","Mumbai","10.40pm -> 2.00pm","1200"));
//        itemBuses.add(new ItemBus("WB 29 5642","Mumbai","Delhi","12.40pm -> 4.14 pm","5900"));
//        itemBuses.add(new ItemBus("WB 29 1289","Kolkata","Pune","12.40am -> 2.00am","3900"));
//        itemBuses.add(new ItemBus("WB 29 1234","Kolkata","Delhi","2.00 pm -> 4.14 pm","8000"));
//        itemBuses.add(new ItemBus("WB 29 2342","Kolkata","Mumbai","10.40pm -> 2.00pm","1200"));
//        itemBuses.add(new ItemBus("WB 29 5642","Mumbai","Delhi","12.40pm -> 4.14 pm","5900"));
//        itemBuses.add(new ItemBus("WB 29 1289","Kolkata","Pune","12.40am -> 2.00am","3900"));

        ArrayList<Bus> arrayList=getIntent().getParcelableArrayListExtra("arraylist");
        String jdate=getIntent().getStringExtra("date");


        try {
            dateAndsrcdstFormat(jdate, getIntent().getStringExtra("src").trim(),getIntent().getStringExtra("dst").trim());
            jd.setText(resDate);
            srcdst.setText(src+" to "+dst);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if(arrayList.size()==0){
            noBusFound.setVisibility(View.VISIBLE);
        }else{
            Bundle i=getIntent().getExtras();
            date=getIntent().getStringExtra("date");
            userId=getIntent().getLongExtra("UserId",-1);
//        Toast.makeText(this, ""+userId, Toast.LENGTH_SHORT).show();

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new BusesAdapter(getApplicationContext(),arrayList));
        }

    }

    private void dateAndsrcdstFormat(String date1, String src, String dst) throws ParseException {
        resDate=date1;

        this.src=src.substring(0, 1).toUpperCase() + src.substring(1);
        this.dst=dst.substring(0, 1).toUpperCase() + dst.substring(1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}