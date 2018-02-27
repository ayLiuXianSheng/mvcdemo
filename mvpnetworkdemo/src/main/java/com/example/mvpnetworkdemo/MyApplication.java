package com.example.mvpnetworkdemo;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by mamiaomiao on 2018/2/1.
 */

public class MyApplication extends Application {
    private RefWatcher watcher;

    @Override
    public void onCreate() {
        super.onCreate();
        setupLeakCanary();
        watcher = setupLeakCanary();
//        //只检测所有activity
//        if (LeakCanary.isInAnalyzerProcess(this)) {//1
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
    }

    private RefWatcher setupLeakCanary () {
        try {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return RefWatcher.DISABLED;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }catch (Exception e){

        }
        return LeakCanary.install(this);
    }
    public static RefWatcher getRefWatcher(Context context) {
        MyApplication app = (MyApplication) context.getApplicationContext();
        return app.watcher;
    }
}
