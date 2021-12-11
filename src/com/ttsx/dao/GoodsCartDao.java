package com.ttsx.dao;

import com.ttsx.entiy.Goods;
import com.ttsx.entiy.GoodsCart;

import java.util.List;

public interface GoodsCartDao {
    void addGoods(Goods goods, String userId);//添加商品到购物车
    List<GoodsCart> getGoodsList(String userId);//通过用户ID查询购物车信息
    Goods getGoods(String goodsId);//通过商品ID查询商品
    boolean checkExist(String userId,String goodsId);//检测是否商品已经存在
    void updateGoods(String userId,String goodsId);//增加购物车同样商品的数量
    void decGoods(String userId,String goodsId);//减少购物车同样商品的数量
}
