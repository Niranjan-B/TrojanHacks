package com.ninja.neighbours;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.ninja.neighbours.networking.DataModels.Building;
import com.ninja.neighbours.networking.DataModels.SearchModel;
import com.ninja.neighbours.networking.SearchApiAdapter;
import com.ninja.neighbours.networking.interfaces.SearchApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.autoCompleteTextView) AutoCompleteTextView mAutoCompleteTextView;
    SearchModel mSearchModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        callApiToLoadBuildings();
    }

    private void callApiToLoadBuildings() {
        final ProgressDialog progressDialog = Utils.startProgressDialog(this);

        SearchApiInterface searchApiInterface = SearchApiAdapter.getSearchAdapter().create(SearchApiInterface.class);
        Observable<SearchModel> searchApiObservable = searchApiInterface.getSearchResults();
        searchApiObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<SearchModel>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchModel searchModel) {
                        initSearchModel(searchModel);
                    }
                });
        Utils.stopLoadingDialog(progressDialog);

    }

    private void initSearchModel(SearchModel searchModel) {
        mSearchModel = searchModel;
        initAutoCompleteTextView(mSearchModel.getBuildings());
    }

    private void initAutoCompleteTextView(List<Building> arrayList) {
        String[] stringBuildings = new String[arrayList.size()];

        for (int i=0; i<arrayList.size(); i++) {
            stringBuildings[i] = arrayList.get(i).getTitle();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, stringBuildings);
        mAutoCompleteTextView.setAdapter(adapter);
        mAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ApartmentJoiningActivity.class);
                intent.putExtra("apartment_name", parent.getItemAtPosition(position) + "");
                startActivity(intent);
            }
        });
    }
}
