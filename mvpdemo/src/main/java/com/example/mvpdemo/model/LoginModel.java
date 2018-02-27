package com.example.mvpdemo.model;

import android.os.Handler;
import android.os.Message;

import com.example.mvpdemo.UserBean;
import com.example.mvpdemo.contract.CallBackListner;


/**
 * Created by mamiaomiao on 2018/1/30.
 * model层处理数据
 */

public class LoginModel {
    private CallBackListner callBackListner;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            if (data != null && !data.equals("")) {
                callBackListner.onSuccess(new UserBean(data,data));
            }else{
                callBackListner.onError("获取数据失败");
            }
        }
    };

    public void isLogin(String name, CallBackListner callBack) {
        this.callBackListner = callBack;
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    Message msg = Message.obtain();
                    msg.obj = "ddddd";
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
