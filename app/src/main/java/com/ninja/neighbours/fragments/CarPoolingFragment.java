package com.ninja.neighbours.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninja.neighbours.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarPoolingFragment extends Fragment {

    public static CarPoolingFragment getNewInstance() {
        return new CarPoolingFragment();
    }

    public CarPoolingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_pooling, container, false);
    }

}
