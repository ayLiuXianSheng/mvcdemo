package com.example.mamiaomiao.mvcdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mamiaomiao.mvcdemo.contact.IUserLoginView;
import com.example.mamiaomiao.mvcdemo.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements IUserLoginView{
    private EditText nameEt,pwdEt;
    private LoginModel model;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEt=(EditText)findViewById(R.id.username);
        pwdEt=(EditText)findViewById(R.id.userpwd);
        model=new LoginModel();
        presenter=new LoginPresenter();
        presenter.attachView(this);
        //SharedPreferences实例化，保存用户名密码
        SharedPreferences sp=getSharedPreferences("userinfo",MODE_PRIVATE);
        sp.edit().putString("name","abc").putString("pwd","123123").commit();
        findViewById(R.id.userlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取点击时的用户名密码输入框里的内容
                String name=nameEt.getText().toString().trim();
                String pwd=pwdEt.getText().toString().trim();
                //将用户输入的内容与本地存储的数据做校验。
                presenter.doLogin(MainActivity.this);
                //if(model.login(name,pwd,MainActivity.this)){
//                    Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_SHORT).show();
//                }else
//                    Toast.makeText(MainActivity.this,"login faied",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public String getName() {
        return nameEt.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return pwdEt.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(MainActivity.this,"login success",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginFailed() {
        Toast.makeText(MainActivity.this,"login faied",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
