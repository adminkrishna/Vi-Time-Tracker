package com.example.vitimetracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loading {
    Activity activity;
    AlertDialog dialog;

    Loading(Activity myActivity){
        activity = myActivity;
    }

    public void StartAlertDialog() {
        AlertDialog.Builder customBuild = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        customBuild.setView(inflater.inflate(R.layout.custom_loading, null));
        customBuild.setCancelable(false);

        dialog = customBuild.create();
        dialog.show();
    }

    public void StopAlertDialog(){
        if(dialog.isShowing()) dialog.dismiss();
    }
}
