package com.example.tripsnap;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class BusHolder extends ViewHolder {
    public TextView bus_id,destination,source,time,fare;
    public BusHolder(@NonNull View itemView) {
        super(itemView);
        bus_id=itemView.findViewById(R.id.bus_id);
        source=itemView.findViewById(R.id.source);
        destination=itemView.findViewById(R.id.destination);
        time=itemView.findViewById(R.id.time);
        fare=itemView.findViewById(R.id.fare);
    }

}
