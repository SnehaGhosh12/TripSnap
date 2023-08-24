package com.example.tripsnap;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class HomeFragment extends Fragment {
//    EditText source;
//    EditText destination;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

//        source= view.findViewById(R.id.etEnterSource);
//        destination=view.findViewById(R.id.etEnterDestination);

        return view;
    }
}