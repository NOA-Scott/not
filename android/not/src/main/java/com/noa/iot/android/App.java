package com.noa.iot.android;

import android.app.Application;

import com.noa.iot.android.network.AppHelper;

/**
 * Created by noalabs on 2017/5/25.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize application
        AppHelper.init(getApplicationContext());
    }
}
