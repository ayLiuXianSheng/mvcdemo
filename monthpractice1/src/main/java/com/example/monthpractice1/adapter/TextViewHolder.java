package com.example.monthpractice1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.monthpractice1.R;

/**
 * Created by mamiaomiao on 2018/2/27.
 */

public class TextViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageView img;

    public TextViewHolder(View itemView){
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.mytitle);
        img=(ImageView)itemView.findViewById(R.id.myimg);
    }

}
