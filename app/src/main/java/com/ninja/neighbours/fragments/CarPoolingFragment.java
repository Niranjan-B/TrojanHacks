package com.ninja.neighbours.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninja.neighbours.R;
import com.ninja.neighbours.adapters.FragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarPoolingFragment extends Fragment {

    @BindView(R.id.tablayout_carpooling) TabLayout mTabLayout;
    @BindView(R.id.viewpager_carpooling) ViewPager mViewPager;

    public static CarPoolingFragment getNewInstance() {
        return new CarPoolingFragment();
    }

    public CarPoolingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_pooling, container, false);
        ButterKnife.bind(this, view);

        mViewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }

}
