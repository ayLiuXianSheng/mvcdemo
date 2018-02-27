package com.example.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mamiaomiao on 2018/2/24.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        //itemview代表布局文件的父view；
        textView=(TextView)itemView.findViewById(R.id.item_text);
    }
}
