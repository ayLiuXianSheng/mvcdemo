package com.example.qqlogin;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by mamiaomiao on 2018/2/2.
 */

public class MyApp extends Application {
    {
        Config.DEBUG=true;
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
