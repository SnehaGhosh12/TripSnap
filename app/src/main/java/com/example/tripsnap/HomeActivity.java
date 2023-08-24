package com.example.tripsnap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tripsnap.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding =ActivityHomeBinding.inflate(getLayoutInflater());

            setContentView(binding.getRoot());
            replaceFragment(new HomeFragment());

            binding.menuBottom.setOnItemSelectedListener(item -> {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.menu_account:
                        replaceFragment(new MyAccountFragment());
                        break;
                    case R.id.menu_bookings:
                        replaceFragment(new MyBookingsFragment());
                        break;
                    case R.id.menu_help:
                        replaceFragment(new HelpFragment());
                }


                return true;
            });
        }
        private void replaceFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment,fragment);
            fragmentTransaction.commit();
        }
}