package com.example.mvpnetworkdemo;

/**
 * Created by mamiaomiao on 2018/1/31.
 */

public class DataBean {
   private String data;
   private int code;//code==1008带表搜索成功；code==1007代表搜索失败

    public DataBean(String data, int code) {
        this.data = data;
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
