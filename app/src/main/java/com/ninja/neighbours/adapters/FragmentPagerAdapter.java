package com.ninja.neighbours.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ninja.neighbours.fragments.carpool_fragments.AvailableCarpoolsFragment;
import com.ninja.neighbours.fragments.carpool_fragments.CarpoolRequestsFragment;
import com.ninja.neighbours.fragments.carpool_fragments.MyCarpoolsFragment;

/**
 * Created by niranjanb on 29/10/16.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String[] pageTitles = {"Available", "My Carpools", "Requests"};

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return AvailableCarpoolsFragment.getInstance();
        } else if (position == 1) {
            return MyCarpoolsFragment.getInstance();
        } else if (position == 2) {
            return CarpoolRequestsFragment.getInstance();
        } else {
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
