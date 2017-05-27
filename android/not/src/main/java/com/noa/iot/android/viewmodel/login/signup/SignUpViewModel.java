package com.noa.iot.android.viewmodel.login.signup;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivitySignupBinding;
import com.noa.iot.android.model.User;
import com.noa.iot.android.network.AppHelper;
import com.noa.iot.android.util.Utils;

/**
 * Created by noalabs on 2017/5/26.
 */

public class SignUpViewModel {

    private final static String TAG = SignUpViewModel.class.getName();
    public static User user = new User();
    private Handler handler = new Handler();

    private static SignUpViewListener listener;

    public SignUpViewModel(SignUpViewListener listener) {
        this.listener = listener;
    }

    public void binding(ActivitySignupBinding binding) {
        binding.setHandler(handler);
        binding.setUser(user);
        binding.email.addTextChangedListener(textEmailWatcher);
        binding.password.addTextChangedListener(textPassWatcher);
        binding.code.addTextChangedListener(textCodeWatcher);
        binding.phone.addTextChangedListener(textPhoneWatcher);
        binding.username.addTextChangedListener(textNameWatcher);
    }

    TextWatcher textPhoneWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            user.setPhone(s.toString().trim());

            if (user.getPhone().length() > 5 && user.getUsername().length() > 2 && Utils.isEmail(user.getEmail()) && user.getPassword().length() > 2) {
                user.setEnable(true);
            } else {
                user.setEnable(false);
            }
        }
    };

    TextWatcher textNameWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            user.setUsername(s.toString().trim());

            if (user.getPhone().length() > 5 && user.getUsername().length() > 2 && Utils.isEmail(user.getEmail()) && user.getPassword().length() > 2) {
                user.setEnable(true);
            } else {
                user.setEnable(false);
            }
        }
    };

    TextWatcher textCodeWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            user.setScode(s.toString().trim());
        }
    };

    TextWatcher textPassWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            user.setPassword(s.toString().trim());
            if (user.getPhone().length() > 5 && user.getUsername().length() > 2 && Utils.isEmail(user.getEmail()) && user.getPassword().length() > 2) {
                user.setEnable(true);
            } else {
                user.setEnable(false);
            }
        }
    };

    TextWatcher textEmailWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            user.setEmail(s.toString().trim());
            if (user.getPhone().length() > 5 && user.getUsername().length() > 2 && Utils.isEmail(user.getEmail()) && user.getPassword().length() > 2) {
                user.setEnable(true);
            } else {
                user.setEnable(false);
            }
        }
    };

    public class Handler {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.signup: {
                    AppHelper.RegisterUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), signUpHandler);
                    break;
                }
                case R.id.config: {
                    AppHelper.ConfirmCode(user.getEmail(), user.getScode(), confHandler);
                    break;
                }
            }
        }
    }


    GenericHandler confHandler = new GenericHandler() {
        @Override
        public void onSuccess() {
            if (listener != null) {
                listener.jumpBack();
            }
        }

        @Override
        public void onFailure(Exception exception) {

        }
    };

    public static SignUpHandler signUpHandler = new SignUpHandler() {
        @Override
        public void onSuccess(CognitoUser couser, boolean state, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
            if (state) {
                if (listener != null) {
                    listener.jumpBack();
                }
            } else {
                user.setCode(true);
            }
        }

        @Override
        public void onFailure(Exception e) {
            if (listener != null) {
                listener.showAlert(e.getLocalizedMessage());
            }
        }
    };
}
