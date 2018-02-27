package com.example.mvpdemo.contract;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public interface ILoginView {
    //获取view层，edittext的内容，获取用户输入的用户名和密码
    String getName();
    String getPwd();
    //针对按钮点击以后，校验用户名密码的结果，对用户提醒；
    void loginSuccess();
    void loginFailed();
}
