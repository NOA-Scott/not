package com.noa.iot.android.view.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by noalabs on 2017/5/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    void setActionTitle(String title, boolean asup) {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(asup);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }


    public void showAlert(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Not tips");
        builder.setMessage(msg);
        builder.setPositiveButton("I Know", null);
        builder.show();
    }
}
