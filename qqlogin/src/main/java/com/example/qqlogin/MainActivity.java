package com.example.qqlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobclickAgent.setScenarioType(MainActivity.this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        final UMShareAPI api = UMShareAPI.get(this);
       boolean isinstall= api.isInstall(MainActivity.this,SHARE_MEDIA.WEIXIN);
        System.out.println(isinstall+"   装微信");
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(MainActivity.this)
                        .withText("hello")
                        .withMedia(new UMImage(MainActivity.this,"http://a.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=0326d5754e4a20a4314b34c1a062b41a/79f0f736afc379314a650b4eeac4b74543a91143.jpg"))
                        .setPlatform(SHARE_MEDIA.QQ)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {

                            }
                        })
                        .share();
                //获取用户信息
//                api.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
//                    @Override
//                    public void onStart(SHARE_MEDIA share_media) {
//
//                    }
//
//                    @Override
//                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//                        System.out.println(map.get("name")+"    dddddddddd  "+map.get("iconurl"));
//                    }
//
//                    @Override
//                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onCancel(SHARE_MEDIA share_media, int i) {
//
//                    }
//                });
                //授权代码

//                new ShareAction(MainActivity.this)
//                        .withText("hello")
//                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
//                        .setCallback(umShareListener)
//                        .open();

//                new ShareAction(MainActivity.this)
//                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
//                        .withText("hello")//分享内容
//                        .withMedia(new UMImage(MainActivity.this,"http://a.hiphotos.baidu.com/zhidao/wh%3D600%2C800/sign=0326d5754e4a20a4314b34c1a062b41a/79f0f736afc379314a650b4eeac4b74543a91143.jpg"))
//                        .setCallback(new UMShareListener() {
//                            @Override
//                            public void onStart(SHARE_MEDIA share_media) {
//
//                            }
//
//                            @Override
//                            public void onResult(SHARE_MEDIA share_media) {
//
//                            }
//
//                            @Override
//                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
//
//                            }
//
//                            @Override
//                            public void onCancel(SHARE_MEDIA share_media) {
//
//                            }
//                        })//回调监听器
//                        .share();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
