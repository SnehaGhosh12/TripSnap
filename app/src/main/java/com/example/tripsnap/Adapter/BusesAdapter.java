package com.example.tripsnap.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripsnap.Activity.Bus.SeatsActivity;
import com.example.tripsnap.Holder.BusHolder;
import com.example.tripsnap.Models.Bus;
import com.example.tripsnap.R;

import java.util.ArrayList;

public class BusesAdapter extends RecyclerView.Adapter<BusHolder> {

    Context context;
    ArrayList<Bus> itembuses;

    public BusesAdapter(Context context, ArrayList<Bus> buses) {
        this.context = context;
        this.itembuses = buses;
    }


    @NonNull
    @Override
    public BusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BusHolder(LayoutInflater.from(context).inflate(R.layout.buses,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BusHolder holder,
                                 @SuppressLint("RecyclerView") int position) {

        Bus item = itembuses.get(position);
        holder.bus_id.setText(item.getBusId());
        holder.source.setText(item.getSource());
        holder.destination.setText(item.getDestination());
        holder.arvtime.setText(item.getArrivalTime());
        holder.depttime.setText(item.getDepartTime());
        holder.fare.setText("₹"+item.getFare()+"/-");

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, SeatsActivity.class);
                i.putExtra("bus_id",itembuses.get(position).getBusId());
                i.putExtra("source",itembuses.get(position).getSource());
                i.putExtra("destination",itembuses.get(position).getDestination());
                i.putExtra("fare",itembuses.get(position).getFare());
                i.putExtra("date",itembuses.get(position).getDepartTime());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        if(itembuses==null) return 0;
        return itembuses.size();
    }
}
