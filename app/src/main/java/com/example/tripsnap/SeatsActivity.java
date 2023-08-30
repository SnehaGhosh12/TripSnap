package com.example.tripsnap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SeatsActivity extends AppCompatActivity implements View.OnClickListener {

    ViewGroup layout;
    LinearLayout color_guide;
    TextView user_id;
//    String seats = "_UUUUUUAAAAARRRR_/"
//            + "_________________/"
//            + "UU__AAAARRRRR__RR/"
//            + "UU__UUUAAAAAA__AA/"
//            + "AA__AAAAAAAAA__AA/"
//            + "AA__AARUUUURR__AA/"
//            + "UU__UUUA_RRRR__AA/"
//            + "AA__AAAA_RRAA__UU/"
//            + "AA__AARR_UUUU__RR/"
//            + "AA__UUAA_UURR__RR/"
//            + "_________________/"
//            + "UU_AAAAAAAUUUU_RR/"
//            + "RR_AAAAAAAAAAA_AA/"
//            + "AA_UUAAAAAUUUU_AA/"
//            + "AA_AAAAAAUUUUU_AA/"
//            + "_________________/";

    StringBuilder seats = new StringBuilder("AA_AAA/"
            + "AA_AAA/"
            + "___AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AAAAAA/");




    List<TextView> seatViewList = new ArrayList<>();

    int seatSize = 140;
    int seatGaping = 5;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int STATUS_RESERVED = 3;
    String selectedIds = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        layout = findViewById(R.id.layoutSeat);
        color_guide=findViewById(R.id.color_guide);
        color_guide.setVisibility(View.GONE);
        user_id=findViewById(R.id.user_id);


        seats = new StringBuilder("/" + seats);

        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);

        LinearLayout layout = null;

        int count = 0;

        for (int index = 0; index < seats.length(); index++) {
            if (seats.charAt(index) == '/') {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
            } else if (seats.charAt(index) == 'U') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_booked);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_BOOKED);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'A') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_book);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                view.setTextColor(Color.BLACK);
                view.setTag(STATUS_AVAILABLE);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'R') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_reserved);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_RESERVED);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == '_') {
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setText("");
                layout.addView(view);
            }
        }
    }

    @Override
    public void onClick(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((int) view.getTag() == STATUS_AVAILABLE){
                    view.setBackgroundResource(R.drawable.ic_seats_selected);
                    AlertDialog.Builder builder = new AlertDialog.Builder(SeatsActivity.this);
                    builder.setMessage("Do you want to book seat "+view.getId()+"?");
                    builder.setTitle("Alert !");
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                        finish();
                    });

                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        view.setBackgroundResource(R.drawable.ic_seats_book);
                        dialog.cancel();
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if ((int) view.getTag() == STATUS_BOOKED) {
                    Toast.makeText(SeatsActivity.this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
                } else if ((int) view.getTag() == STATUS_RESERVED) {
                    Toast.makeText(SeatsActivity.this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
                }
            }

        });
//        if ((int) view.getTag() == STATUS_AVAILABLE) {
//            if (selectedIds.contains(view.getId() + ",")) {
//                selectedIds = selectedIds.replace(+view.getId() + ",", "");
//                view.setBackgroundResource(R.drawable.ic_seats_book);
//            } else {
//                selectedIds = selectedIds + view.getId() + ",";
//                view.setBackgroundResource(R.drawable.ic_seats_selected);
//            }
//        } else if ((int) view.getTag() == STATUS_BOOKED) {
//            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
//        } else if ((int) view.getTag() == STATUS_RESERVED) {
//            Toast.makeText(this, "Seat " + view.getId() + " is Reserved", Toast.LENGTH_SHORT).show();
//        }
    }
}