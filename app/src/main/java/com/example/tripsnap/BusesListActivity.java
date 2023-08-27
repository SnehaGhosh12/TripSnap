package com.example.tripsnap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BusesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_list);

        RecyclerView recyclerView=findViewById(R.id.buslist_rv);

        List<ItemBus> itemBuses=new ArrayList<ItemBus>();
        itemBuses.add(new ItemBus("1234","Kol","Del","12.40","8000"));
        itemBuses.add(new ItemBus("2342","Kol","Mum","10.40","1200"));
        itemBuses.add(new ItemBus("5642","Mumbai","Del","12.40","5900"));
        itemBuses.add(new ItemBus("1289","Kol","Pune","12.40","3900"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BusesAdapter(getApplicationContext(),itemBuses));
    }
}