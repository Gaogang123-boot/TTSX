package com.ttsx.dao;

import com.ttsx.entiy.Browse;

import java.util.List;

public interface BrowseDao {
    //根据用户名查询商品最近浏览的商品名称，价格，路径
    List<Browse> getBrowseInfo(String userId);
    //根据用户Id查看商品时添加到数据库浏览信息表
    void insBrowseInfo(String goodsPic,String goodsName,double goodsPrice,String userId);
}
