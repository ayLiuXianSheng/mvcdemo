package com.example.mvpnetworkdemo.presenter;

import com.example.mvpnetworkdemo.DataBean;
import com.example.mvpnetworkdemo.contract.DataCallBack;
import com.example.mvpnetworkdemo.contract.ISearchView;
import com.example.mvpnetworkdemo.model.SearchModel;

import java.lang.ref.WeakReference;

/**
 * Created by mamiaomiao on 2018/1/31.
 * 为了防止内存泄漏，将view的对象放入引用；
 */

public class SearchPresenter {
    //内存不足时自动回收；
    private WeakReference<ISearchView> reference;
    // private ISearchView view;
    private SearchModel model;

    public SearchPresenter() {
        model = new SearchModel();
    }

    //初始化view
    public void attachView(ISearchView view) {
        reference = new WeakReference<ISearchView>(view);
    }

    //回收view
    public void detachView() {
        if (reference != null) {
            //清空虚引用；
            reference.clear();
            reference = null;
        }
    }

    //从弱引用中获取view；
    private ISearchView getView() {
        return reference.get();
    }

    public void doSearch() {
        //获取搜索框内的搜索关键字
        String key = getView().getText();
        model.search(key, new DataCallBack() {
            @Override
            public void success(DataBean bean) {
                getView().setShow(bean.getData());
            }

            @Override
            public void error(String error) {
                getView().setShow(error);
            }
        });
    }
}
