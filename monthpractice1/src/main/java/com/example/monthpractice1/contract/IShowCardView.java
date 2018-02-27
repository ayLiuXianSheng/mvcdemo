package com.example.monthpractice1.contract;

import com.example.monthpractice1.bean.CatagoryBean;
import com.example.monthpractice1.bean.GroupGoodsBean;

import java.util.List;

/**
 * Created by mamiaomiao on 2018/2/27.
 */

public interface IShowCardView {
    void showRightData(List<GroupGoodsBean.DataBean> data);
    void showCardData(List<CatagoryBean.DataBean> data);

    void showError(String error);
}
