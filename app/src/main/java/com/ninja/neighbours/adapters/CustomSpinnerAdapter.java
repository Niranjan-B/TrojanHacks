package com.ninja.neighbours.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ninja.neighbours.R;

/**
 * Created by niranjanb on 30/10/16.
 */

public class CustomSpinnerAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mRoomates;

    public CustomSpinnerAdapter(Context context, int textViewResourceId,
                     String[] objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        mRoomates = objects;
    }
    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        View layout = inflater.inflate(R.layout.item_spinner_neigbhours, parent, false);

        TextView tvLanguage = (TextView) layout.findViewById(R.id.textview_roomate_name);
        tvLanguage.setText(mRoomates[position]);

        if (position == 0) {
            tvLanguage.setTextSize(20f);
            tvLanguage.setTextColor(Color.BLACK);
        }

        return layout;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
