package com.noa.iot.android.viewmodel.login.login;

/**
 * Created by noalabs on 2017/5/26.
 */

public interface LoginViewListener {
    void startJumpActivity(Class<?> c);

    void showAlert(String msg);
}
