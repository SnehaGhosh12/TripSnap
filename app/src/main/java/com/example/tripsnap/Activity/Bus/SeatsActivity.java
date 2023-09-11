package com.example.tripsnap.Activity.Bus;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripsnap.Models.Bus;
import com.example.tripsnap.Models.Reservation;
import com.example.tripsnap.R;
import com.example.tripsnap.RetrofitApiInterface.BaseUrl;
import com.example.tripsnap.RetrofitApiInterface.RetrofitAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import es.dmoral.toasty.Toasty;

public class SeatsActivity extends AppCompatActivity implements View.OnClickListener {


    private StringBuilder seats = new StringBuilder("AA_AAA/"
            + "AA_AAA/"
            + "___AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AA_AAA/"
            + "AAAAAA/");
    private ViewGroup viewGroupLayout;
    private  LinearLayout color_guide;
    private TextView user_id;
    private List<TextView> seatViewList = new ArrayList<>();
    private HashMap<Integer,Integer> map;

    int seatSize = 140;
    int seatGaping=5;
    private Bundle i;
    private int left,top,right,bottom;

    private int width,height;

    private int STATUS_AVAILABLE = 1;
    private int STATUS_BOOKED = 2;
    private int STATUS_RESERVED = 3;
    private  Dialog dialog;

    TextView bck_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        seats = new StringBuilder("/" + seats);
        map=new HashMap<>();
        mapInitializer();
        i=getIntent().getExtras();

        getAllSeatsByBusId(i.getString("bus_id"));


    }

    private void seatLayOutUi(){
        width= this.getResources().getDisplayMetrics().widthPixels;
        height =this.getResources().getDisplayMetrics().heightPixels;
        top=width/27;
        bottom=width/27;
        left=width/22;
        right=width/24;
//        Toast.makeText(this, ""+width, Toast.LENGTH_SHORT).show();

        viewGroupLayout = findViewById(R.id.layoutSeat);
        color_guide = findViewById(R.id.color_guide);
//        color_guide.setVisibility(View.GONE);
        user_id = findViewById(R.id.user_id);
        user_id.setText(BusBookingActivity.userId.toString());

        bck_btn=findViewById(R.id.back_btn);
        bck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });






        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);

        layoutSeat.setPadding(left,top,right,bottom);
        viewGroupLayout.addView(layoutSeat);

        setSeatsUi(layoutSeat);
    }

    private void mapInitializer(){
        map.put(1,1);
        map.put(2,2);
        map.put(3,4);
        map.put(4,5);
        map.put(5,6);

        map.put(6,8);
        map.put(7,9);
        map.put(8,11);
        map.put(9,12);
        map.put(10,13);


        map.put(11,18);
        map.put(12,19);
        map.put(13,20);

        map.put(14,22);
        map.put(15,23);
        map.put(16,25);
        map.put(17,26);
        map.put(18,27);

        map.put(19,29);
        map.put(20,30);
        map.put(21,32);
        map.put(22,33);
        map.put(23,34);

        map.put(24,36);
        map.put(25,37);
        map.put(26,39);
        map.put(27,40);
        map.put(28,41);

        map.put(29,43);
        map.put(30,44);
        map.put(31,46);
        map.put(32,47);
        map.put(33,48);

        map.put(34,50);
        map.put(35,51);
        map.put(36,53);
        map.put(37,54);
        map.put(38,55);

        map.put(39,57);
        map.put(40,58);
        map.put(41,59);
        map.put(42,60);
        map.put(43,61);
        map.put(44,62);

    }
    @SuppressLint("ResourceAsColor")
    private void setSeatsUi(LinearLayout layoutSeat){

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
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
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
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_selected);
                view.setText(count+ "");
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
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
//                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_book);
//                view.setBackgroundColor(R.color.black);
                view.setText(count+ "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_RESERVED);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == '_') {
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
//                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
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

                    AlertDialog.Builder builder = new AlertDialog.Builder(SeatsActivity.this);
                    builder.setMessage("Do you want to book seat "+view.getId()+"?");
                    builder.setTitle("Alert !");
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                        view.setBackgroundResource(R.drawable.ic_seats_book);
                        seats.replace(view.getId(), view.getId(), "R");
                        view.setTag(STATUS_RESERVED);
                        setReservationApi(view);
                    });

                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        view.setBackgroundResource(R.drawable.ic_seats_selected);
                        dialog.cancel();
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if ((int) view.getTag() == STATUS_BOOKED) {
//                    Toast.makeText(SeatsActivity.this, "Seat " + view.getId() + "already is Booked", Toast.LENGTH_SHORT).show();
                    Toasty.warning(SeatsActivity.this,"Seat " + view.getId() + " already is Booked",Toasty.LENGTH_SHORT).show();
                } else if ((int) view.getTag() == STATUS_RESERVED) {
                    Toasty.warning(SeatsActivity.this,"Seat " + view.getId() + " already is Reserverd",Toasty.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void setReservationApi(View view){

        String currDate= new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault()).format(new Date());

        String currTime= new SimpleDateFormat("HH:mm:ss",Locale.getDefault()).format(new Date());

        Reservation reservation=new Reservation();
        Integer ri= (int) Math.random();
        reservation.setReservationID(ri);
        reservation.setBookedSeat(view.getId());

        reservation.setDate(currDate);
        reservation.setTime(currTime);



        reservation.setStatus("Booked");

        reservation.setUserId(BusesListActivity.userId);
        reservation.setBusId(i.getString("bus_id"));
        reservation.setJourneyDate(BusesListActivity.date);
        reservation.setFare(Integer.parseInt(i.getString("fare")));
        reservation.setSource(i.getString("source"));
        reservation.setDestination(i.getString("destination"));

        RetrofitAPI retrofitAPI = BaseUrl.retrofit();
        Call<Reservation> call = retrofitAPI.newReservation(reservation);
        call.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                Toasty.success(SeatsActivity.this,"Successfully Booked",Toasty.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
              Toasty.error(SeatsActivity.this,""+t.getMessage(),Toasty.LENGTH_SHORT).show();
            }

        });
//        Toasty.success(SeatsActivity.this,"Successfully Booked",Toasty.LENGTH_SHORT).show();


    }

    private  void getAllSeatsByBusId(String busId){
        RetrofitAPI retrofitAPI = BaseUrl.retrofit();
        dialog = new Dialog(SeatsActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progressbar);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Call<ArrayList<Reservation>> call = retrofitAPI.findBusByBusIdandDate(busId,BusesListActivity.date);

        call.enqueue(new Callback<ArrayList<Reservation>>() {
            @Override
            public void onResponse(Call<ArrayList<Reservation>> call, Response<ArrayList<Reservation>> response) {
                     ArrayList<Reservation> resultList=response.body();

//                Toast.makeText(SeatsActivity.this, ""+resultList.size(), Toast.LENGTH_SHORT).show();
                if(resultList!=null) {
                    for (int i = 0; i < resultList.size(); i++) {
                        Reservation reservation = resultList.get(i);
                        int no = reservation.getBookedSeat();
                        int indOfSeats = map.get(no);
                        String s=seats.toString();
                        s = s.substring(0, indOfSeats) + 'R'
                                + s.substring(indOfSeats + 1);
                        seats=new StringBuilder(s);
                    }
//                    Toast.makeText(SeatsActivity.this, "" + seats, Toast.LENGTH_SHORT).show();
                }
                seatLayOutUi();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<Reservation>> call, Throwable t) {
                Toast.makeText(SeatsActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}