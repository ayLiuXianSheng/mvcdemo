package com.example.okhttp_demo;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by mamiaomiao on 2018/2/27.
 */

public class BasicInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
