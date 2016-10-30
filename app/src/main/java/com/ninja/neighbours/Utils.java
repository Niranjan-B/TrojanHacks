package com.ninja.neighbours;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by niranjanb on 30/10/16.
 */

public class Utils {

    public static ProgressDialog startProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading Awesomeness!!");
        progressDialog.show();
        return progressDialog;
    }

    public static void stopLoadingDialog(ProgressDialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
