package com.example.okdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.example.okdemo.view.MyDecoration;
import com.igexin.sdk.PushManager;

import org.w3c.dom.Text;

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

public class MainActivity extends AppCompatActivity {
    private Call call;
    private OkHttpClient okHttpClient;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.get);
//        OkHttpClient client = new OkHttpClient();
//        File dir= Environment.getExternalStorageDirectory();///storage/emulated/0
//        File dcim=new File(dir.getPath()+"/DCIM/Camera");
//        File[] files=dcim.listFiles();
//        System.out.println(files[0].getPath());
//        RequestBody filebody = RequestBody.create(MediaType.parse("image/jpg"), files[0]);
//        MultipartBody multipartBody=  new MultipartBody.Builder()
//               .setType(MultipartBody.FORM)
//                .addFormDataPart("file", "IMG_20180222_154327.jpg", filebody)
//                .addFormDataPart("uid", "12218")
//                .addFormDataPart("token", "967E3AD75E8C28809E1908B134AAE1FE")
//                .build();
//        // RequestBody body=new FormBody.Builder().add("mobile","13520273561").add("password","123456").build();
//        RequestBody body = new FormBody.Builder().add("uid", "12218").add("token", "967E3AD75E8C28809E1908B134AAE1FE")
//                .build();
//        Request request = new Request.Builder().url("https://www.zhaoapi.cn/file/upload").post(multipartBody).build();
//        call = client.newCall(request);
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("failure "+e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println(response.body().string());
//            }
//        });
//        RecyclerView view=(RecyclerView)findViewById(R.id.myrecycler);
//       // view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//       // view.setLayoutManager(new GridLayoutManager(MainActivity.this,8));
//        view.setLayoutManager(new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL));
//        //view.addItemDecoration(new DividerItemDecoration(MainActivity.this,OrientationHelper.HORIZONTAL));
//        view.addItemDecoration(new MyDecoration(MainActivity.this,OrientationHelper.HORIZONTAL));
//        view.setItemAnimator(new DefaultItemAnimator());
//        view.setAdapter(new MyAdapter(MainActivity.this));
//        ValueAnimator animator= ValueAnimator.ofFloat(0,1);
//        animator.setDuration(1000);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                System.out.println(animation.getAnimatedValue());
//            }
//        });
//        animator.start();
        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);
    }
}
