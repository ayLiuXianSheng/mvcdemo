package com.example.monthpractice1.contract;

import com.example.monthpractice1.bean.CatagoryBean;
import com.example.monthpractice1.bean.GroupGoodsBean;
import com.example.monthpractice1.utils.GsonObjectCallback;

/**
 * Created by mamiaomiao on 2018/2/27.
 */

public interface IShowCardModel {
    void getRightData(String url, GsonObjectCallback<GroupGoodsBean> callback);
    void getGoodsCard(String url, GsonObjectCallback<CatagoryBean> callback);
}
