package com.example.mvpnetworkdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvpnetworkdemo.MyApplication;
import com.example.mvpnetworkdemo.R;
import com.example.mvpnetworkdemo.contract.ISearchView;
import com.example.mvpnetworkdemo.presenter.SearchPresenter;
import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity implements ISearchView {
    private EditText input;
    private Button search;
    private TextView show;
    private SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        search = (Button) findViewById(R.id.search_btn);
        show = (TextView) findViewById(R.id.show);
        //presenter初始化
        presenter = new SearchPresenter();
        presenter.attachView(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发起搜索请求
                presenter.doSearch();
            }
        });
        LeakThread thread = new LeakThread();
        thread.start();
    }

    @Override
    public String getText() {
        return input.getText().toString().trim();
    }

    @Override
    public void setShow(String data) {
        show.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        RefWatcher watcher = MyApplication.getRefWatcher(MainActivity.this);
        watcher.watch(this);
    }


    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
