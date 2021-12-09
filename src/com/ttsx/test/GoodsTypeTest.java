package com.ttsx.test;

import com.ttsx.dao.GoodsTypeDao;
import com.ttsx.daoImpl.GoodsTypeDaoImpl;
import com.ttsx.entiy.GoodsType;
import org.junit.Test;

import java.util.List;

public class GoodsTypeTest {
    private GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    @Test
    public void getGoodsTypeAll(){
        List<GoodsType> goodsTypeAll = goodsTypeDao.getGoodsTypeAll();
        goodsTypeAll.forEach(k->{
            System.out.println(k.toString());
        });
    }
}
