package com.noa.iot.android.network;

import android.content.Context;
import android.util.Log;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.regions.Regions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by noalabs on 2017/5/26.
 */

public class AppHelper {

    private static AppHelper appHelper;
    private static CognitoUserPool userPool;


    private static String user;

    /**
     * Set Your User Pools region.
     * e.g. if your user pools are in US East (N Virginia) then set cognitoRegion = Regions.US_EAST_1.
     */
    private static final Regions cognitoRegion = Regions.US_EAST_1;

    /**
     * App secret associated with your app id - if the App id does not have an associated App secret,
     * set the App secret to null.
     * e.g. clientSecret = null;
     */
    private static final String clientSecret = "1jghfcclrshq835a06suavjplg636mbr4f835ukpbljipvpd8pjn";

    /**
     * Add your pool id here
     */
    private static final String userPoolId = "us-east-1_qUqOOhBLg";

    /**
     * Add you app id
     */
    private static final String clientId = "2t2jpklplpnlebh2e8e671bcsc";

    public static void init(Context context) {
        if (appHelper != null && userPool != null) {
            return;
        }
        if (appHelper == null) {
            appHelper = new AppHelper();
        }

        if (userPool == null) {
            // Create a user pool with default ClientConfiguration
            userPool = new CognitoUserPool(context, userPoolId, clientId, clientSecret, cognitoRegion);
        }
    }

    public static CognitoUserPool getPool() {
        return userPool;
    }

    public static void LoginIn(String email,AuthenticationHandler loginHandler){
        getPool().getUser(email).getSessionInBackground(loginHandler);
    }

    public static void RegisterUser(String nickname,String email,String password,String phone,SignUpHandler signUpHandler){
        CognitoUserAttributes attributes = new CognitoUserAttributes();
        attributes.addAttribute("email",email);
        attributes.addAttribute("phone_number",phone);
        attributes.addAttribute("nickname",nickname);
        Map<String, String> validation = new HashMap<>();
        validation.put("phone_number",phone);
        validation.put("nickname",nickname);
        validation.put("email",email);
        getPool().signUpInBackground(email,password,attributes,validation, signUpHandler);
    }

    public static void ConfirmCode(String email, String code, GenericHandler confHandler){
        getPool().getUser(email).confirmSignUpInBackground(code, true, confHandler);
    }

    public static String getCurrUser() {
        return user;
    }

    public static void setUser(String newUser) {
        user = newUser;
    }
}
