package com.example.tripsnap;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class BusHolder extends ViewHolder {
    public TextView bus_id,source,destination,depttime,arvtime,fare;
    public CardView cardView;
    public BusHolder(@NonNull View itemView) {
        super(itemView);
        bus_id=itemView.findViewById(R.id.busId);
        source=itemView.findViewById(R.id.source);
        destination=itemView.findViewById(R.id.destination);
        depttime=itemView.findViewById(R.id.busDepartureTime);
        arvtime=itemView.findViewById(R.id.busArrivalTime);
        fare=itemView.findViewById(R.id.busFare);
        cardView=itemView.findViewById(R.id.cardView);
    }

}
