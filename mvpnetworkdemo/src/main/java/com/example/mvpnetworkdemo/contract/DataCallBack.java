package com.example.mvpnetworkdemo.contract;

import com.example.mvpnetworkdemo.DataBean;

/**
 * Created by mamiaomiao on 2018/1/31.
 */

public interface DataCallBack {
    void success(DataBean bean);
    void error(String error);
}
