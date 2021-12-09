package com.ttsx.dao;

import com.ttsx.entiy.Goods;
import com.ttsx.util.PageUtils;

import java.util.List;

public interface GoodsDao {
    List<Goods> getGoodsFruitAll();//获得水果商品信息
    List<Goods> getGoodsSeafoodAll();//获得海鲜商品信息
    List<Goods> getGoodsFruitAllProduct(PageUtils page);//获得水果不分页的产品
    List<Goods> getGoodsSeafoodAllProduct(PageUtils page);//获得海鲜商品不分页信息
    Goods findGoodsById(String goodsId);//按商品ID查询
    int getGoodsCount(String goodsName);//商品数量
//    int insertBrowse()
}
