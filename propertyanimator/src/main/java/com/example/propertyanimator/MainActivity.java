package com.example.propertyanimator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView=(TextView)findViewById(R.id.mytext);
//        //初始化，设置初始值和结束
//        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0.4f,8.7f,3,5);
//        valueAnimator.ofInt(2,1,3);
//        //动画执行时间，初始值到结束值的过渡时间
//        valueAnimator.setDuration(1000);
//        //启动动画；
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //监听执行过程。
//               // System.out.println(animation.getAnimatedValue());
//            }
//        });
//        valueAnimator.start();
//        //使用objectanimator实现补间动画的效果
//        //第一个参数：target：代表要操作的目标对象，textview；第二个参数：实现的（属性名称）动画名称；后面都是针对此属性值的变化值；
////        ObjectAnimator objectAnimator=ObjectAnimator
////                .ofFloat(textView,"rotation",0f,360f);
////        //设置动画执行时间，重复执行次数，重复执行模式；
////        objectAnimator.setDuration(3000);
////        objectAnimator.setRepeatCount(5);
////        //启动动画
////
////        objectAnimator.start();
////        //TextView的get，set方法对应设置ObjectAnimator的第二个参数
////        textView.getAlpha();
////        textView.setAlpha(1);
//        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0f);
//        ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
//        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.play(rotate).with(fadeInOut).after(moveIn);
//        animSet.setDuration(5000);
//        //添加动画监听器
//        animSet.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                //动画开始
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
////动画结束
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//        //动画监听，不需要重新所有方法
//        animSet.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//            }
//        });
//        animSet.start();
//        ValueAnimator animator= (ValueAnimator)AnimatorInflater.loadAnimator(MainActivity.this, R.animator.num_anim);
//animator.setDuration(3000);
//animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//    @Override
//    public void onAnimationUpdate(ValueAnimator animation) {
//        System.out.println("updata=="+animation.getAnimatedValue());
//    }
//});
//animator.start();
//        //FloatEvaluator
//       // return startFloat + fraction * (endValue.floatValue() - startFloat);
//       // p0-t*p0+t*p1=p0+t*(p1-p0)
    }
}
