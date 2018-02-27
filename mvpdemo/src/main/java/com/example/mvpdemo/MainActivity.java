package com.example.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpdemo.contract.ILoginView;
import com.example.mvpdemo.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity   {
    private EditText nameEt, pwdEt;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view初始化
        nameEt = (EditText) findViewById(R.id.username);
        pwdEt = (EditText) findViewById(R.id.userpwd);
        //presenter初始化
        presenter = new LoginPresenter(new ILoginView() {
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
                Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void loginFailed() {
                Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.userlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.doLogin();
            }
        });
    }
}
