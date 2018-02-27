package com.example.mvpdemo.presenter;

import com.example.mvpdemo.UserBean;
import com.example.mvpdemo.contract.CallBackListner;
import com.example.mvpdemo.contract.ILoginView;
import com.example.mvpdemo.model.LoginModel;

/**
 * Created by mamiaomiao on 2018/1/30.
 */

public class LoginPresenter {
    private ILoginView view;
    private LoginModel model;
    //presenter构造方法
     public LoginPresenter(ILoginView view){
         this.view=view;
         model=new LoginModel();
     }

     public void doLogin(){
         //从view获取用户名密码
         String name=view.getName();
         String pwd=view.getPwd();
         //交给model层处理
      model.isLogin(name, new CallBackListner() {
           @Override
           public void onSuccess(UserBean data) {
               view.loginSuccess();
           }

           @Override
           public void onError(String error) {
               view.loginFailed();
           }
       });
       //对于数据的处理结果，要在view层有个反馈


     }
}
