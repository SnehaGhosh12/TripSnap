package com.example.tripsnap.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tripsnap.Adapter.BusesAdapter;
import com.example.tripsnap.Models.Bus;
import com.example.tripsnap.R;

import java.util.ArrayList;

public class BusesListActivity extends AppCompatActivity {

    public static String date;
    public  static Long userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_list);

        RecyclerView recyclerView=findViewById(R.id.buslist_rv);

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
        Bundle i=getIntent().getExtras();
        date=getIntent().getStringExtra("date");
        userId=getIntent().getLongExtra("UserId",-1);
//        Toast.makeText(this, ""+userId, Toast.LENGTH_SHORT).show();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BusesAdapter(getApplicationContext(),arrayList));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}