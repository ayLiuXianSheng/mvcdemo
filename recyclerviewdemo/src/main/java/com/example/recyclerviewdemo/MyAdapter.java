package com.example.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mamiaomiao on 2018/2/24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private ArrayList<String> data = new ArrayList<String>();

    public MyAdapter(Context context) {
        this.context = context;
        for (int i = 0; i < 20; i++) {
            if (i % 3 == 0) {
                data.add("ss" + i);
            } else {
                data.add("自定义数据 " + i);
            }
        }

    }

    //删除对应位置的条目数据
    public void deleteItem(int position) {
       // data.remove(position);
        //notifyItemRemoved(position);
        data.add(position,"add");
        notifyItemInserted(position);
       // notifyDataSetChanged();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //通过布局文件创建item的父view，返回viewholder
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        final MyViewHolder holder = new MyViewHolder(view);
        //条目点击事件设置
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getLayoutPosition());
            }
        });
        //条目长摁点击事件设置
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClick(v, holder.getLayoutPosition());
                //防止点击冲突，返回值设置为true；
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//给item赋值；
        holder.textView.setText(data.get(position));
        System.out.println(position+"   onbind");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public OnRecyclerClick listener;

    //设置点击事件，在activity使用adaper调用
    public void setOnClickListener(OnRecyclerClick clickListener) {
        this.listener = clickListener;
    }
}
