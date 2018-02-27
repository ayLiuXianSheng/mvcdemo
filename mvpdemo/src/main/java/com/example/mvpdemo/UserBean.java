package com.example.mvpdemo;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public class UserBean {
    private String name;
    private String pwd;

    public UserBean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
