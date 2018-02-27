package com.example.mamiaomiao.mvcdemo.presenter;

import android.content.Context;

import com.example.mamiaomiao.mvcdemo.contact.IUserLoginView;
import com.example.mamiaomiao.mvcdemo.model.UserLoginModel;

import java.lang.ref.WeakReference;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public class LoginPresenter {
    private UserLoginModel model;
    private WeakReference<IUserLoginView> reference;

    public void attachView(IUserLoginView view) {
        reference = new WeakReference<IUserLoginView>(view);
    }

    public void detachView() {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }
    public IUserLoginView getView(){
        return reference.get();
    }

    public LoginPresenter() {
        model = new UserLoginModel();
    }

    public void doLogin(Context context) {
        boolean isLogin = model.login(getView().getName(), getView().getPwd(), context);
        if (isLogin) {
            getView().loginSuccess();
        } else
            getView().loginFailed();
    }
}
