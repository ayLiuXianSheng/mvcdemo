package com.example.mamiaomiao.mvcdemo.contact;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public interface IUserLoginView {
    String getName();
    String getPwd();
    void loginSuccess();
    void loginFailed();
}
