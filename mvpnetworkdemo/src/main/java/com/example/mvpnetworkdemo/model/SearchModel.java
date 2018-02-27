package com.example.mvpnetworkdemo.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.mvpnetworkdemo.DataBean;
import com.example.mvpnetworkdemo.contract.DataCallBack;
import com.example.mvpnetworkdemo.contract.ISearchModel;

/**
 * Created by mamiaomiao on 2018/1/31.
 */

public class SearchModel implements ISearchModel {

    private DataCallBack callBack;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            if (data == null || data.equals("")) {
                //获取数据失败；
                callBack.error("网络异常");
            } else {
                //获取数据成功：
                //data是网络请求回来的json串，gson解析为对象
                callBack.success(new DataBean("搜索的结果是：" + data, 1008));
            }

        }
    };

    @Override
    public void search(final String key, DataCallBack callBack) {
        this.callBack = callBack;
        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Handler handler1=new Handler();

                //模拟网络操作
                try {
                    Thread.sleep(3000);
                    Message message = Message.obtain();
                    message.obj = key;
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
