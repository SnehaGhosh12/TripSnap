package com.example.tripsnap;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyBookingPageAdapter extends FragmentStateAdapter {

    public MyBookingPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BusBookingCompletedFragment();
            case 1:
                return new BusBookingCancelledFragment();
            default:
                return new BusBookingCompletedFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
