package com.example.mamiaomiao.mvcdemo.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mamiaomiao.mvcdemo.contact.IUserLoginModel;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public class UserLoginModel implements IUserLoginModel {
    @Override
    public boolean login(String name, String pwd, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String reginName = sp.getString("name", "");
        String reginPwd = sp.getString("pwd", "");
        //做校验
        if (reginName.equals(name) && reginPwd.equals(pwd)) {
            return true;
        }
        return false;
    }
}
