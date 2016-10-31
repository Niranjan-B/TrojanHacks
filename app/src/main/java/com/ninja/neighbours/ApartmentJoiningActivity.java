package com.ninja.neighbours;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ninja.neighbours.networking.DataModels.BuildingQueryModel;
import com.ninja.neighbours.networking.DataModels.JoinRequestResponseModel;
import com.ninja.neighbours.networking.RetrofitAdapter;
import com.ninja.neighbours.networking.interfaces.BuildingQueryInterface;
import com.ninja.neighbours.networking.interfaces.JoinRequestInterface;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApartmentJoiningActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_apartment_joining) Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar_layout) CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.apartment_image) ImageView mApartmentImage;
    @BindView(R.id.textview_status) TextView mStatusTextView;
    @BindView(R.id.fab_join) FloatingActionButton mRequestFab;
    private String apartmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_joining);

        ButterKnife.bind(this);
        initAppBar();
        initStatusCard(100);

        mRequestFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendJoinRequestToServer();
            }
        });

    }

    private void sendJoinRequestToServer() {
        JoinRequestInterface joinRequestInterface = RetrofitAdapter.getSearchAdapter().create(JoinRequestInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("user", "1995");
        map.put("building", apartmentId);
        map.put("status", "pending");

        final ProgressDialog dialog = Utils.startProgressDialog(this);

        Observable<JoinRequestResponseModel> responseModelObservable = joinRequestInterface.postJoinRequestToServer(map);
        responseModelObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JoinRequestResponseModel>() {
                    @Override
                    public void onCompleted() {
                        Utils.stopLoadingDialog(dialog);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.stopLoadingDialog(dialog);
                    }

                    @Override
                    public void onNext(JoinRequestResponseModel joinRequestResponseModel) {
                        Toast.makeText(ApartmentJoiningActivity.this, "" + joinRequestResponseModel.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        initStatusCard(1);

    }

    private void initAppBar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String apartmentName = getIntent().getStringExtra("apartment_name");

        mCollapsingToolbarLayout.setTitle(apartmentName);

        BuildingQueryInterface buildingQueryInterface = RetrofitAdapter
                .getSearchAdapter()
                .create(BuildingQueryInterface.class);
        Observable<BuildingQueryModel> observable = buildingQueryInterface.getParticularBuilding(apartmentName);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BuildingQueryModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(BuildingQueryModel buildingQueryModel) {
                        loadImageForBuilding(buildingQueryModel);
                        apartmentId = buildingQueryModel.getResults().get(0).getId();
                    }
                });
    }

    private void loadImageForBuilding(BuildingQueryModel buildingQueryModel) {
        Picasso.with(this)
                .load(buildingQueryModel.getResults().get(0).getImg())
                .into(mApartmentImage);
    }

    private void initStatusCard(int statusNumber) {
        String[] status = getResources().getStringArray(R.array.status_array);

        // get this number from backend
        setStatus(status, statusNumber);
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

            default: mStatusTextView.setTextColor(Color.BLACK);
                     mStatusTextView.setText("UNKNOWN");
                break;
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
