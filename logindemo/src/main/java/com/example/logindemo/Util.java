package com.example.logindemo;

import java.util.regex.Pattern;

/**
 * Created by mamiaomiao on 2018/2/1.
 */

public class Util {
    public final static String PHONE_PATTERN = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    public static boolean isPhone(String phone){
        Pattern pattern=Pattern.compile(PHONE_PATTERN);
        return pattern.matcher(phone).find();
    }

}
