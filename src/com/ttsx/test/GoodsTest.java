package com.ttsx.test;

import com.ttsx.dao.GoodsDao;
import com.ttsx.daoImpl.GoodsDaoImpl;
import com.ttsx.entiy.Goods;
import org.junit.Test;

import java.util.List;

public class GoodsTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Test
    public void getGoodsAll(){
        List<Goods> goodsAll = goodsDao.getGoodsFruitAll();
        goodsAll.forEach(k->{
            System.out.println(k.toString());
        });
    }
}
