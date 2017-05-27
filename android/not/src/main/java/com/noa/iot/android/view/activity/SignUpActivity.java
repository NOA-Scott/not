package com.noa.iot.android.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivitySignupBinding;
import com.noa.iot.android.viewmodel.login.signup.SignUpViewListener;
import com.noa.iot.android.viewmodel.login.signup.SignUpViewModel;


/**
 * Created by noalabs on 2017/5/26.
 */

public class SignUpActivity extends BaseActivity implements SignUpViewListener{

    SignUpViewModel model = new SignUpViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignupBinding binding =DataBindingUtil.setContentView(this,R.layout.activity_signup);
        model.binding(binding);
        setActionTitle("Sign Up",true);
    }

    @Override
    public void jumpBack() {
        finish();
    }
}
