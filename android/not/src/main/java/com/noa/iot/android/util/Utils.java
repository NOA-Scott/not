package com.noa.iot.android.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by noalabs on 2017/5/26.
 */

public class Utils {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public static boolean isEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }
}
