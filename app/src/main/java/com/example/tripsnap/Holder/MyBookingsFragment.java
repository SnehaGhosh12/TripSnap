package com.example.tripsnap.Holder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tripsnap.Dummy.MyBookingPageAdapter;
import com.example.tripsnap.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MyBookingsFragment extends Fragment {

    public MyBookingsFragment() {
        super(R.layout.fragment_my_bookings);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_my_bookings, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapter();
    }
        private void setAdapter() {
        MyBookingPageAdapter pagerAdapter = new MyBookingPageAdapter(requireActivity().getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPagerBookingType = requireView().findViewById(R.id.viewPagerBookingType);
        viewPagerBookingType.setAdapter(pagerAdapter);

        TabLayout tabsMyBooking = requireView().findViewById(R.id.tabsMyBooking);
        TabLayoutMediator.TabConfigurationStrategy tabConfigurationStrategy = new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("COMPLETED");
                        break;
                    case 1:
                        tab.setText("CANCELLED");
                        break;
                }
            }
        };

        new TabLayoutMediator(tabsMyBooking, viewPagerBookingType, tabConfigurationStrategy).attach();
    }

}