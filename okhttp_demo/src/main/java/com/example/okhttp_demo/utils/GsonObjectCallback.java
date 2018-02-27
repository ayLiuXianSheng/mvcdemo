package com.example.okhttp_demo.utils;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 1. 类的用途 如果要将得到的json直接转化为集合 建议使用该类
 * 该类的onUi() onFailed()方法运行在主线程
 * 2. @author forever
 * 3. @date 2017/9/24 18:47
 */

public abstract class GsonObjectCallback<T> implements Callback {
    private Handler handler = OkHttp3Utils.getInstance().getHandler();

    //主线程处理
    public abstract void onUi(T t);

    //主线程处理
    public abstract void onFailed(Call call, IOException e);

    //请求失败
    @Override
    public void onFailure(final Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailed(call, e);
            }
        });
    }

    //请求json 并直接返回泛型的对象 主线程处理
    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String json = response.body().string();


        Class<T> cls = null;

        Class clz = this.getClass();
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type，然后将其转换ParameterizedType
        ParameterizedType type = (ParameterizedType) clz.getGenericSuperclass();
       // 返回表示此类型实际类型参数的 Type 对象的数组。[0]就是这个数组中第一个了。简而言之就是获得超类的泛型参数的实际类型。
        Type[] types = type.getActualTypeArguments();
        cls = (Class<T>) types[0];

        Gson gson = new Gson();
        final T t = gson.fromJson(json, cls);
        handler.post(new Runnable() {
            @Override
            public void run() {
            onUi(t);
            }
        });
    }
}
