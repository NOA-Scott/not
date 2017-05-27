package com.noa.iot.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivityMainBinding;
import com.noa.iot.android.viewmodel.home.MainViewListener;
import com.noa.iot.android.viewmodel.home.MainViewModel;
import android.support.v4.app.FragmentManager;

public class MainActivity extends BaseActivity implements MainViewListener {

    private MainViewModel viewModel = new MainViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        FragmentManager sfManager = getSupportFragmentManager();
        viewModel.binding(binding,sfManager);
    }
}
