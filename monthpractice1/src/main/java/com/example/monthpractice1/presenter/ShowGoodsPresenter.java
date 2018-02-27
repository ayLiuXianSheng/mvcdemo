package com.example.monthpractice1.presenter;

import com.example.monthpractice1.bean.CatagoryBean;
import com.example.monthpractice1.bean.GroupGoodsBean;
import com.example.monthpractice1.contract.IShowCardView;
import com.example.monthpractice1.model.ShowCardModel;
import com.example.monthpractice1.utils.GsonObjectCallback;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

import okhttp3.Call;

/**
 * Created by mamiaomiao on 2018/2/27.
 */

public class ShowGoodsPresenter {
    private WeakReference<IShowCardView> reference;
    private ShowCardModel model;

    public ShowGoodsPresenter() {
        model = new ShowCardModel();
    }

    public void attachView(IShowCardView view) {
        reference = new WeakReference<IShowCardView>(view);
    }

    public void detachView(IShowCardView view) {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }

    public void getGoodsList() {
        //获取图一左侧分类列表
        model.getGoodsCard("https://www.zhaoapi.cn/product/getCatagory", new GsonObjectCallback<CatagoryBean>() {
            @Override
            public void onUi(CatagoryBean o) {
                //图一左侧分类列表加载完成以后，右侧默认显示第一个分类对应的商品子分类列表
                if (o != null && o.getData() != null) {
                    List<CatagoryBean.DataBean> bean = o.getData();
                    if (bean != null) {
                        reference.get().showCardData(bean);
                        if (bean.size() > 0) {
                           getRightData(bean.get(0).getCid());
                        }
                    } else {
                        reference.get().showError("数据为空");
                    }
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                reference.get().showError(e.getMessage());
            }
        });

    }
    //获取图一右侧列表数据
    public void showRightList(int cid){
        getRightData(cid);
    }
    private void getRightData(int cid){
        model.getRightData("https://www.zhaoapi.cn/product/getProductCatagory?cid="
                + cid, new GsonObjectCallback<GroupGoodsBean>() {
            @Override
            public void onUi(GroupGoodsBean groupGoodsBean) {
                if (groupGoodsBean != null && groupGoodsBean.getData() != null) {
                    reference.get().showRightData(groupGoodsBean.getData());
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }


}
