package com.example.tripsnap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripsnap.Models.Bus;

import java.util.ArrayList;
import java.util.List;

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

        holder.itemView.setOnClickListener((view -> {
            Intent i= new Intent(view.getContext(),Seats.class);
            view.getContext().startActivity(i);
        }));
    }


    @Override
    public int getItemCount() {
        if(itembuses==null) return 0;
        return itembuses.size();
    }
}
