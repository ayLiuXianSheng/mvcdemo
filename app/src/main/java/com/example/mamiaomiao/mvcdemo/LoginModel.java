package com.example.mamiaomiao.mvcdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mamiaomiao on 2018/1/30.
 * 业务层，处理登录业务
 */

public class LoginModel {
    //方法的参数，代表
public boolean login(String name,String pwd,Context context){
    SharedPreferences sp=context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
    String reginName=sp.getString("name","");
    String reginPwd=sp.getString("pwd","");
    //做校验
    if(reginName.equals(name)&&reginPwd.equals(pwd)){
        return  true;
    }
    return  false;
}


}
