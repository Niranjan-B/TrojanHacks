package com.ninja.neighbours.fragments.carpool_fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ninja.neighbours.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AvailableCarpoolsFragment extends Fragment {

    @BindView(R.id.fab_post_ride) FloatingActionButton mPostRide;

    public static AvailableCarpoolsFragment getInstance() {
        return new AvailableCarpoolsFragment();
    }


    public AvailableCarpoolsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_available_carpools, container, false);
        ButterKnife.bind(this, view);

        mPostRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRidePoolingDialog(inflater);
            }
        });

        return view;
    }

    private void openRidePoolingDialog(LayoutInflater inflater) {

        View view = inflater.inflate(R.layout.carpooling_dialog_layout, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enter you details!");
        builder.setView(view);
        Button button = (Button) view.findViewById(R.id.button_post_ride);
        final AlertDialog dialog  = builder.create();
        dialog.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "posting to the server", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });


    }

}
