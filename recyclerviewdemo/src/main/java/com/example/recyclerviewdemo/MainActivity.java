package com.example.recyclerviewdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewdemo.view.MyItemAnimator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.myrecycler);
        final MyAdapter myAdapter = new MyAdapter(MainActivity.this);
        //设置条目点击
        myAdapter.setOnClickListener(new OnRecyclerClick() {
            @Override
            public void onItemClick(View itemView, int position) {
                myAdapter.deleteItem(position);
                Toast.makeText(MainActivity.this, position + "   dianji", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View itemView, int position) {
                Toast.makeText(MainActivity.this, position + "   长恩", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
        //设置布局管理器，告诉recyclerview每一个item的位置怎么布局；
        //listview效果,LinearLayoutManager第二个参数代表list显示方向（水平或者垂直）；第三个参数代表数据正向显示还是反向显示
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,OrientationHelper.VERTICAL,false));
//gridview效果
        // recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,8));
        //瀑布流效果,spancount代表几条瀑布流；第二个参数代表瀑布流的流向，水平和垂直两种方向。
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, OrientationHelper.VERTICAL));
        //设置默认分割线，第二个参数代表分割的方向，不代表分割线的方向。
        DividerItemDecoration decoration=new DividerItemDecoration(MainActivity.this, OrientationHelper.VERTICAL);
        Drawable drawable=getDrawable(R.mipmap.ic_launcher);
       // decoration.setDrawable(drawable);
        //条目数据增加或者删除的动画,配合notifyItemInserted来显示，单独的notifyDataSetChanged动画不生效
        recyclerView.setItemAnimator(new MyItemAnimator());
        recyclerView.addItemDecoration(decoration);
    }
}
