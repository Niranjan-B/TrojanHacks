package com.ninja.neighbours;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApartmentJoiningActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_apartment_joining) Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar_layout) CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.apartment_image) ImageView mApartmentImage;
    @BindView(R.id.textview_status) TextView mStatusTextView;
    @BindView(R.id.fab_join) FloatingActionButton mRequestFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_joining);

        ButterKnife.bind(this);
        initAppBar();
        initStatusCard();

    }

    private void initAppBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout.setTitle(getIntent().getStringExtra("apartment_name"));

        Picasso.with(this)
                .load("https://photonet.hotpads.com/search/listingPhoto/HotPads/1418852/0001_1528141156_large.jpg")
                .into(mApartmentImage);
    }

    private void initStatusCard() {
        String[] status = getResources().getStringArray(R.array.status_array);

        // get this number from backend
        setStatus(status, 1);
    }

    private void setStatus(String[] status, int i) {
        switch (i) {
            case 0: mStatusTextView.setTextColor(Color.GREEN);
                    mStatusTextView.setText(status[i]);
                    break;

            case 1: mStatusTextView.setTextColor(Color.YELLOW);
                    mStatusTextView.setText(status[i]);
                    break;

            case 2: mStatusTextView.setTextColor(Color.RED);
                    mStatusTextView.setText(status[i]);
                    break;

            default: break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
