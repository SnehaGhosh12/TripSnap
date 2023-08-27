package com.example.tripsnap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BusesAdapter extends RecyclerView.Adapter<BusHolder> {

    Context context;
    List<ItemBus> itembuses;

    public BusesAdapter(Context context, List<ItemBus> buses) {
        this.context = context;
        this.itembuses = itembuses;
    }


    @NonNull
    @Override
    public BusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BusHolder(LayoutInflater.from(context).inflate(R.layout.buses,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BusHolder holder, int position) {

        holder.bus_id.setText(itembuses.get(position).getBus_id());
        holder.source.setText(itembuses.get(position).getSource());
        holder.destination.setText(itembuses.get(position).getDestination());
        holder.time.setText(itembuses.get(position).getTime());
        holder.fare.setText(itembuses.get(position).getFare());
    }

    @Override
    public int getItemCount() {
        if(itembuses==null) return 0;
        return itembuses.size();
    }
}
