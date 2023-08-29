package com.example.tripsnap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripsnap.Models.Bus;

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
    public void onBindViewHolder(@NonNull BusHolder holder, int position) {

        holder.bus_id.setText(itembuses.get(position).getBusId());
        holder.source.setText(itembuses.get(position).getSource());
        holder.destination.setText(itembuses.get(position).getDestination());
        holder.arvtime.setText(itembuses.get(position).getArrivalTime());
        holder.depttime.setText(itembuses.get(position).getDepartTime());
        holder.fare.setText("₹"+itembuses.get(position).getFare()+"/-");

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, SeatsActivity.class);
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
