package com.noa.iot.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivityCodeBinding;
import com.noa.iot.android.viewmodel.login.code.CodeViewListener;
import com.noa.iot.android.viewmodel.login.code.CodeViewModel;


public class CodeActivity extends BaseActivity implements CodeViewListener {

    CodeViewModel viewModel = new CodeViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCodeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_code);
        viewModel.binding(binding);
        setActionTitle("Config Code", true);
    }
}