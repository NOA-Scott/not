package com.noa.iot.android.view.activity;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivityLoginBinding;
import com.noa.iot.android.viewmodel.login.login.LoginViewListener;
import com.noa.iot.android.viewmodel.login.login.LoginViewModel;

/**
 * Created by noalabs on 2017/5/26.
 */

public class LoginActivity extends BaseActivity implements LoginViewListener {


    private LoginViewModel viewModel = new LoginViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel.binding(binding);
        setActionTitle("Welcome to NOA IOT",false);
    }

    @Override
    public void startJumpActivity(Class<?> c) {
        Intent intent =new Intent(this,c);
        startActivity(intent);
    }
}
