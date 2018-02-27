package com.example.monthpractice1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.monthpractice1.R;
import com.example.monthpractice1.bean.CatagoryBean;
import com.example.monthpractice1.bean.GroupGoodsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mamiaomiao on 2018/2/27.
 * 图一对应显示图文的适配器
 */

public class MyAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private ArrayList<GroupGoodsBean.DataBean.ListBean> list = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addData(List<GroupGoodsBean.DataBean.ListBean> data){
        this.list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getIcon()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
