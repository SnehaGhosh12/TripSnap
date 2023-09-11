package com.example.tripsnap.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripsnap.Activity.Bus.HistoryActivity;
import com.example.tripsnap.Activity.Bus.SeatsActivity;
import com.example.tripsnap.Models.Reservation;
import com.example.tripsnap.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    Context context;
    ArrayList<Reservation> historyList;

    public HistoryAdapter(Context context, ArrayList<Reservation> historyList) {
        this.context = context;
        Collections.reverse(historyList);
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.history_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {

        Reservation reservation=historyList.get(position);
//        Toast.makeText(context, ""+reservation.getFare(), Toast.LENGTH_SHORT).show();
        holder.busIdTv.setText(""+reservation.getBusId());
//        Toast.makeText(context, ""+reservation.getTime(), Toast.LENGTH_SHORT).show();
        holder.busSrcDstTextView.setText("₹"+reservation.getFare()+"/-");


        holder.historyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, HistoryActivity.class);
                i.putExtra("journey_date",reservation.getJourneyDate());
                i.putExtra("source",reservation.getSource());
                i.putExtra("destination",reservation.getDestination());
                i.putExtra("time",reservation.getTime());
                i.putExtra("fare",reservation.getFare().toString());
                i.putExtra("bus_id",reservation.getBusId());
                i.putExtra("seat_no",reservation.getBookedSeat().toString());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        return historyList.size()>6?6: historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView historyTv,busIdTv,busNameTv,busSrcDstTextView;
        ConstraintLayout historyItem;

        public ViewHolder(View view) {
            super(view);
            busIdTv=view.findViewById(R.id.busIdTextView);
            busNameTv=view.findViewById(R.id.busNameTextView);
            busSrcDstTextView=view.findViewById(R.id.busSrcDstTextView);
            historyItem=view.findViewById(R.id.historyItem);
        }
    }
}
