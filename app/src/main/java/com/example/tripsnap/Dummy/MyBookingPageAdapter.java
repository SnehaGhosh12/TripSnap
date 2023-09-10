package com.example.tripsnap.Dummy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tripsnap.Dummy.BusBookingCancelledFragment;
import com.example.tripsnap.Dummy.BusBookingCompletedFragment;

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
