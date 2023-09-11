package com.example.tripsnap.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Toast.makeText(context, ""+reservation.getTime(), Toast.LENGTH_SHORT).show();
        holder.busSrcDstTextView.setText("₹"+reservation.getFare());
    }

    @Override
    public int getItemCount() {

        return historyList.size()>6?6: historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView historyTv,busIdTv,busNameTv,busSrcDstTextView;
        public ViewHolder(View view) {
            super(view);
            busIdTv=view.findViewById(R.id.busIdTextView);
            busNameTv=view.findViewById(R.id.busNameTextView);
            busSrcDstTextView=view.findViewById(R.id.busSrcDstTextView);

        }
    }
}
