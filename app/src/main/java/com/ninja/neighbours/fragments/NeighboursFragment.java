package com.ninja.neighbours.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.ninja.neighbours.R;
import com.ninja.neighbours.adapters.CustomSpinnerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NeighboursFragment extends Fragment {

    @BindView(R.id.spinner_neigbhours_fragment) Spinner mSpinner;
    @BindView(R.id.spinner_neigbhours_fragment_2) Spinner mSpinner2;
    @BindView(R.id.spinner_neigbhours_fragment_3) Spinner mSpinner3;
    @BindView(R.id.spinner_neigbhours_fragment_4) Spinner mSpinner4;
    @BindView(R.id.spinner_neigbhours_fragment_5) Spinner mSpinner5;

    public static NeighboursFragment getNewInstance() {
        return new NeighboursFragment();
    }

    public NeighboursFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbours, container, false);
        ButterKnife.bind(this, view);

        initSpinner();

        return view;
    }

    private void initSpinner() {
        String[] items = new String[] {"Apartment - 1", "Pavan", "Nitin", "Varun", "Alex", "Ninja"};
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getActivity(), R.layout.item_spinner_neigbhours, items);
        mSpinner.setAdapter(adapter);

        String[] items2 = new String[] {"Apartment - 2", "Pavan", "Nitin", "Varun", "Alex", "Ninja"};
        CustomSpinnerAdapter adapter2 = new CustomSpinnerAdapter(getActivity(), R.layout.item_spinner_neigbhours, items2);
        mSpinner2.setAdapter(adapter2);

        String[] items3 = new String[] {"Apartment - 3", "Pavan", "Nitin", "Varun", "Alex", "Ninja"};
        CustomSpinnerAdapter adapter3 = new CustomSpinnerAdapter(getActivity(), R.layout.item_spinner_neigbhours, items3);
        mSpinner3.setAdapter(adapter3);

        String[] items4 = new String[] {"Apartment - 4", "Pavan", "Nitin", "Varun", "Alex", "Ninja"};
        CustomSpinnerAdapter adapter4 = new CustomSpinnerAdapter(getActivity(), R.layout.item_spinner_neigbhours, items4);
        mSpinner4.setAdapter(adapter4);

        String[] items5 = new String[] {"Apartment - 5", "Pavan", "Nitin", "Varun", "Alex", "Ninja"};
        CustomSpinnerAdapter adapter5 = new CustomSpinnerAdapter(getActivity(), R.layout.item_spinner_neigbhours, items5);
        mSpinner5.setAdapter(adapter5);
    }

}
