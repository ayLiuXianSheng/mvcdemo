package com.example.okhttp_demo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.okhttp_demo.utils.GsonObjectCallback;
import com.example.okhttp_demo.utils.OkHttp3Utils;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.get_1).setOnClickListener(this);
        findViewById(R.id.get_2).setOnClickListener(this);
        findViewById(R.id.post_1).setOnClickListener(this);
        findViewById(R.id.post_img).setOnClickListener(this);
        OkHttpClient client=new OkHttpClient();
        //应用拦截器(发起网络请求之前和获取请求响应之后)
      //  client.interceptors().add()
        //网络拦截器
       // client.networkInterceptors().add()

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get_1:
                OkHttp3Utils.doGet("https://www.zhaoapi.cn/product/addCart?uid=12218&pid=1&source=android", new GsonObjectCallback<String>() {
                    @Override
                    public void onUi(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
                OkHttp3Utils.doGet("https://www.zhaoapi.cn/user/login?mobile=13520273561&password=123456", new GsonObjectCallback<LoginDataBean>() {
                    @Override
                    public void onUi(LoginDataBean dataBean) {
                        System.out.println(Thread.currentThread().getName()+" token="+dataBean.getData().getToken());
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });

                //get 同步请求
//                new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        OkHttpClient client=new OkHttpClient();
//                        //设置超时时间；
//                      OkHttpClient client1=  new OkHttpClient.Builder().connectTimeout(2, TimeUnit.SECONDS).build();
//                        Request request=new Request.Builder().url("http://i.jandan.net/?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields&page=1&custom_fields=thumb_c,views&dev=1").build();
//                        Call call=client.newCall(request);
//                        //call.cancel();取消一个请求
//                        try {
//                            //同步get请求,一定开启子线程，不能再主线程操作。
//                            System.out.println("thread=="+Thread.currentThread().getName());
//                            Response response=call.execute();
//
//                            String result=  response.body().string();
//                            System.out.println(result);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }.start();
                break;
            case R.id.get_2: {
                OkHttp3Utils.doGet("https://www.zhaoapi.cn/product/getCatagory", new GsonObjectCallback<GoodsBean>() {
                    @Override
                    public void onUi(GoodsBean goodsBean) {
                        System.out.println(goodsBean.getMsg());
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
                //{"msg":"登录成功","code":"0","data":{"age":null,"appkey":"6954cf0a92113517","appsecret":"8B4D8218280B5D848297ABD5606671F6","createtime":"2018-02-23T14:46:59","email":null,"fans":null,"follow":null,"gender":null,"icon":"https:\/\/www.zhaoapi.cn\/images\/1519288811963IMG_20180222_154327.jpg","latitude":null,"longitude":null,"mobile":"13520273561","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"967E3AD75E8C28809E1908B134AAE1FE","uid":12218,"userId":null,"username":"13520273561"}}
                //get异步请求
//                OkHttpClient client = new OkHttpClient();
//                // Request request=new Request.Builder().url("http://i.jandan.net/?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields&page=1&custom_fields=thumb_c,views&dev=1").build();
//                 Request request=new Request.Builder().url("https://www.zhaoapi.cn/user/login?mobile=13520273561&password=123456").build();
//                Call call=client.newCall(request);
//                call.enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        //网络请求失败以后的调用。
//                        System.out.println("failure=="+e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                    //  网络请求成功，回调。不能更新UI
//
//                        System.out.println(Thread.currentThread().getId()+"  name="+Thread.currentThread().getName());
//                        System.out.println("异步获取数据：：："+response.body().string());
//                    }
//                });
            }
                break;
            case R.id.post_1:
            {
                //post请求，提交（key-value请求参数）（表单）
                OkHttpClient client=new OkHttpClient();
                RequestBody body=new FormBody.Builder()
                        .add("mobile","13520273561")
                        .add("password","123456").build();
                Request request=new Request.Builder().url("https://www.zhaoapi.cn/user/login").post(body).build();
                Call call=client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        System.out.println("post=="+response.body().string());
                    }
                });
            }
                break;
            case R.id.post_img:
            {
                //token":"967E3AD75E8C28809E1908B134AAE1FE","uid":12218
                String sdpath= Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera";
                File file=new File(sdpath);
                if(file.exists()){
                    File[] files=file.listFiles();
                    if(files!=null&&files.length>0){
                        //相册内的图片文件
                        File imgfile=files[0];
                        OkHttpClient client=new OkHttpClient();
                        //准备requestbody
                        RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpg"),imgfile);

                        RequestBody body=new MultipartBody.Builder()
                                //设置类型
                                .setType(MultipartBody.FORM)
                                //添加文件
                                .addFormDataPart("file","img.jpg",requestBody)
                                //添加其他类型参数
                                .addFormDataPart("token","967E3AD75E8C28809E1908B134AAE1FE")
                                .addFormDataPart("uid","12218")

                                .build();

                        Request request=new Request.Builder().url("https://www.zhaoapi.cn/file/upload").post(body).build();
                        Call call=client.newCall(request);
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                System.out.println("上传图片=="+response.body().string());
                            }
                        });
                    }
                }
            }
                break;
        }
    }
}
