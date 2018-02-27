package com.example.getuidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.igexin.sdk.PushManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // DemoPushService 为第三方自定义推送服务
        //初始化推送SDK
        PushManager.getInstance().initialize(this.getApplicationContext(), null);
        //DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);
    }
}
