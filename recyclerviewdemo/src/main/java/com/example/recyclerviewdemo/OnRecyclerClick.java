package com.example.recyclerviewdemo;

import android.view.View;

/**
 * Created by mamiaomiao on 2018/2/24.
 */

public interface OnRecyclerClick {
    //条目点击方法
    void onItemClick(View itemView,int position);
    //条目长摁点击方法
    void onItemLongClick(View itemView,int position);
}
