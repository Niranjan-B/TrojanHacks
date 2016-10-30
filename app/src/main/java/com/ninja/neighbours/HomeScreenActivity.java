package com.ninja.neighbours;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ninja.neighbours.fragments.CarPoolingFragment;
import com.ninja.neighbours.fragments.HomeFragment;
import com.ninja.neighbours.fragments.NeighboursFragment;
import com.ninja.neighbours.fragments.NotificationsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeScreenActivity extends AppCompatActivity {

    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.navigation_drawer) DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar_home_screen) Toolbar mToolbar;

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ButterKnife.bind(this);

        setupToolbar();
        setupNavigationDrawer();
    }

    private void setupToolbar() {
        mToolbar.setTitle("Home");
        mToolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(mToolbar);

        fragmentManager.beginTransaction().replace(R.id.layout_fragment_holder, HomeFragment.getNewInstance())
                .commit();

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_view_headline_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupNavigationDrawer() {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_navigation_item:
                        fragmentManager
                                .beginTransaction().replace(R.id.layout_fragment_holder, HomeFragment.getNewInstance())
                                .commit();

                        mToolbar.setTitle("Home");
                        mToolbar.setTitleTextColor(Color.WHITE);
                        item.setChecked(true);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.neigbhours_navigation_item:
                        fragmentManager.beginTransaction()
                                .replace(R.id.layout_fragment_holder, NeighboursFragment.getNewInstance())
                                .commit();

                        mToolbar.setTitle("Neigbhours");
                        mToolbar.setTitleTextColor(Color.WHITE);
                        item.setChecked(true);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.carpool_navigation_item:
                        fragmentManager.beginTransaction()
                                .replace(R.id.layout_fragment_holder, CarPoolingFragment.getNewInstance())
                                .commit();

                        mToolbar.setTitle("Carpool");
                        mToolbar.setTitleTextColor(Color.WHITE);
                        item.setChecked(true);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.notifications_navigation_item:
                        fragmentManager.beginTransaction()
                                .replace(R.id.layout_fragment_holder, NotificationsFragment.getNewInstance())
                                .commit();

                        mToolbar.setTitle("Notifications");
                        mToolbar.setTitleTextColor(Color.WHITE);
                        item.setChecked(true);
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isNavDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
