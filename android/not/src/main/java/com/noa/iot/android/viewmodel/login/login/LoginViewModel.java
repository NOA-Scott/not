package com.noa.iot.android.viewmodel.login.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.noa.iot.android.R;
import com.noa.iot.android.databinding.ActivityLoginBinding;
import com.noa.iot.android.model.User;
import com.noa.iot.android.network.AppHelper;
import com.noa.iot.android.util.Utils;
import com.noa.iot.android.view.activity.HomeActivity;
import com.noa.iot.android.view.activity.MainActivity;
import com.noa.iot.android.view.activity.SignUpActivity;

import java.util.Locale;


public class LoginViewModel {

    private final static String TAG = LoginViewModel.class.getName();

    private static User user = new User();
    private Handler handler = new Handler();

    private static LoginViewListener listener;

    public LoginViewModel(LoginViewListener listener) {
        this.listener = listener;
    }

    public void binding(ActivityLoginBinding binding) {
        user.setEmail("1657292627@qq.com");
        user.setPassword("1234567890");
        AppHelper.setUser(user.getEmail());

        binding.setUser(user);
        binding.setHandler(handler);
        binding.email.addTextChangedListener(textEmailWatcher);
        binding.password.addTextChangedListener(textPassWatcher);
    }

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
            if (Utils.isEmail(user.getEmail()) && user.getPassword().length() >= 6) {
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
            if (Utils.isEmail(user.getEmail()) && user.getPassword().length() >= 6) {
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
                    if (listener != null) {
                        listener.startJumpActivity(SignUpActivity.class);
                    }
                    break;
                }
                case R.id.signin: {
                    AppHelper.LoginIn(user.getEmail(), loginHandler);
                    break;
                }
                case R.id.resetpass: {
                    if (listener != null) {
                        listener.startJumpActivity(SignUpActivity.class);
                    }
                    break;
                }
            }
        }
    }

    public static AuthenticationHandler loginHandler = new AuthenticationHandler() {
        @Override
        public void onSuccess(CognitoUserSession userSession, CognitoDevice newDevice) {
            Log.e("AuthenticationHandler", "onSuccess - userSession:" + userSession + "    newDevice:" + newDevice);
            if (listener != null) {
                listener.startJumpActivity(MainActivity.class);
            }
        }

        @Override
        public void getAuthenticationDetails(AuthenticationContinuation continuation, String id) {
            Log.e("AuthenticationHandler", "continuation:" + continuation.toString() + "    id:" + id);
            Locale.setDefault(Locale.US);
            AuthenticationDetails authenticationDetails = new AuthenticationDetails(id, user.getPassword(), null);
            continuation.setAuthenticationDetails(authenticationDetails);
            continuation.continueTask();
        }

        @Override
        public void getMFACode(MultiFactorAuthenticationContinuation continuation) {
            Log.e("AuthenticationHandler", "getMFACode - continuation:" + continuation);
        }

        @Override
        public void authenticationChallenge(ChallengeContinuation continuation) {
            Log.e("AuthenticationHandler", "authenticationChallenge - continuation:" + continuation);
        }

        @Override
        public void onFailure(Exception e) {
            Log.e("AuthenticationHandler", "onFailure - exception:" + e.getMessage() + "  " + e.getLocalizedMessage() + "  " + e.hashCode());

            if (listener != null) {
                listener.showAlert(e.getMessage());
            }
        }
    };
}
