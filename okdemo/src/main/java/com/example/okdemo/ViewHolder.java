package com.example.okdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mamiaomiao on 2018/2/24.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);
        this.textView = (TextView)itemView.findViewById(R.id.text);
    }
}
