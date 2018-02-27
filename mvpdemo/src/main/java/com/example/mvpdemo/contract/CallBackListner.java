package com.example.mvpdemo.contract;

import com.example.mvpdemo.UserBean;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public interface CallBackListner {
    void onSuccess(UserBean data);
    void onError(String error);
}
