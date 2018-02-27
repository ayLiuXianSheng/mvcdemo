package com.example.okdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mamiaomiao on 2018/2/24.
 */

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private  List<String> list;
    public MyAdapter(Context context){
        this.context=context;
        list =  new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            list.add("商品记录" + i);}
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,null);
      ViewHolder  holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
String text="";
if(position%3==0){
    text="ddddddddddd";
}
      holder.textView.setText(list.get(position)+text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
