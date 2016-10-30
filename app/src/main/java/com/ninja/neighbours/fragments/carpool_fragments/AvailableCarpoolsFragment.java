package com.ninja.neighbours.fragments.carpool_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninja.neighbours.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvailableCarpoolsFragment extends Fragment {

    public static AvailableCarpoolsFragment getInstance() {
        return new AvailableCarpoolsFragment();
    }


    public AvailableCarpoolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_available_carpools, container, false);
    }

}
