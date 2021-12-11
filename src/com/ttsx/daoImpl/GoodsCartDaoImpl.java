package com.ttsx.daoImpl;

import com.ttsx.dao.GoodsCartDao;
import com.ttsx.entiy.Goods;
import com.ttsx.entiy.GoodsCart;
import com.ttsx.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GoodsCartDaoImpl implements GoodsCartDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtil.getDs());
    @Override
    public void addGoods(Goods goods,String userId) {//添加商品到购物车
        String sql="INSERT INTO goods_cart VALUES(UUID(),?,?,?,?,1,?)";
        jdbcTemplate.update(sql,userId,goods.getGoodsId(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsPic());
    }

    @Override
    public List<GoodsCart> getGoodsList(String userId) {//通过用户ID查询购物车信息
        String sql = "select * from goods_cart where user_id =?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GoodsCart.class), userId);
    }

    @Override
    public Goods getGoods(String goodsId) {
        String sql = "select * from goods where goods_id =?";//通过商品ID查询商品
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Goods.class),goodsId);
    }

    @Override
    public boolean checkExist(String userId, String goodsId) {//通过商品和用户ID查询购物车是否已经有添加商品
        String sql="select count(*) from goods_cart where user_id=? and goods_id=?";
        Boolean flag = jdbcTemplate.queryForObject(sql, Boolean.class, userId, goodsId);
        return flag;
    }

    @Override
    public void updateGoods(String userId, String goodsId) {//修改购物车车商品数量并在此基础上加1
        String sql="update goods_cart set goods_num=goods_num+1 where user_id=? and goods_id=?";
        jdbcTemplate.update(sql,userId,goodsId);
    }

    @Override
    public void decGoods(String userId, String goodsId) {//修改购物车车商品数量并在此基础上减1
        String sql="update goods_cart set goods_num=goods_num-1 where user_id=? and goods_id=?";
        jdbcTemplate.update(sql,userId,goodsId);
    }
}
