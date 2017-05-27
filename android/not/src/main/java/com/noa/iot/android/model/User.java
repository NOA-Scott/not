package com.noa.iot.android.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by noalabs on 2017/5/26.
 */

public class User extends BaseObservable {
    private String username;
    private String email;
    private String password;
    private boolean enable;
    private String phone;
    private boolean code;
    private String scode;


    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
        notifyPropertyChanged(BR.enable);
    }

    public void setCode(boolean code) {
        this.code = code;
        notifyPropertyChanged(BR.code);
    }

    public void setScode(String scode) {
        this.scode = scode;
        notifyPropertyChanged(BR.scode);
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public String getPhone() {
        if (phone == null) {
            return "";
        }
        return phone;
    }

    @Bindable
    public String getScode() {
        if (scode == null) {
            return "";
        }
        return scode;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getPassword() {
        if (password == null) {
            return "";
        }
        return password;
    }

    @Bindable
    public String getUsername() {
        if (username == null) {
            return "";
        }
        return username;
    }

    @Bindable
    public boolean isEnable() {
        return enable;
    }

    @Bindable
    public boolean isCode() {
        return code;
    }


}
