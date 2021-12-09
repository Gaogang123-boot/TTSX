package com.ttsx.daoImpl;

import com.ttsx.dao.GoodsTypeDao;
import com.ttsx.entiy.GoodsType;
import com.ttsx.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDs());

    /**
     * 查询所有商品类型
     * @return
     */
    @Override
    public List<GoodsType> getGoodsTypeAll() {
        String sql = "SELECT * FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_type.`type_name`='新鲜水果' LIMIT 0,4";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(GoodsType.class));
    }
}
