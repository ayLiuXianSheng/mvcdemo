package com.example.propertyanimator.point;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by mamiaomiao on 2018/2/25.
 */

class MyAnimView extends View {

    public static final float RADIUS = 50f;
//当前小球的坐标
    private Point currentPoint;

    private Paint mPaint;
//两个参数的构造方法，做初始化的操作
    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化一个蓝色的画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }
//使用画笔画小球
    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        //画圆，前两个参数，代表此刻圆的横坐标，纵坐标；第三个参数圆的半径；第四个参数是画圆的画笔；
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private void startAnimation() {
        //valueanimator动画
        Point startPoint = new Point(getWidth()/2 - RADIUS, RADIUS);
        Point endPoint = new Point(getWidth()/2 - RADIUS, getHeight() - RADIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(3000);
        //加速下落，越来越快
        //anim.setInterpolator(new AccelerateInterpolator());
        //减速下落，越来越慢
        //anim.setInterpolator(new DecelerateInterpolator());
        //落下弹起再落下弹起，模仿真实的物理效果
        anim.setInterpolator(new BounceInterpolator());
        //objectanimator动画
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        anim2.setDuration(3000);
        //AnimatorSet animSet = new AnimatorSet();
       // animSet.play(anim).with(anim2);
        //animSet.setDuration(5000);
       // animSet.setInterpolator(new BounceInterpolator());
       anim.start();
        //anim2.start();
    }
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }
}
