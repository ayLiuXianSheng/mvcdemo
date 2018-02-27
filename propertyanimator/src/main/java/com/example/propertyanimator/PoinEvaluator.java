package com.example.propertyanimator;

import android.animation.TypeEvaluator;

import com.example.propertyanimator.point.Point;

/**
 * Created by mamiaomiao on 2018/2/25.
 * 值的估值器
 */

public class PoinEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float x = startValue.getX() + fraction * (endValue.getX() - startValue.getX());
        float y = startValue.getY() + fraction * (endValue.getY() - startValue.getY());
        //代表动画执行的进度为fraction时，此时小球的坐标；
        Point point = new Point(x, y);
        return point;
    }
}
