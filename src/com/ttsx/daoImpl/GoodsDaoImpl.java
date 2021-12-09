package com.ttsx.daoImpl;

import com.ttsx.dao.GoodsDao;
import com.ttsx.entiy.Goods;
import com.ttsx.util.JdbcUtil;
import com.ttsx.util.PageUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDs());

    /**
     * 查询4条水果商品信息
     * @return
     */
    @Override
    public List<Goods> getGoodsFruitAll() {
        String sql = "SELECT * FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_type.`type_name`='新鲜水果' LIMIT 0,4";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class));
    }

    /**
     * 获得4条水产商品信息
     * @return
     */
    @Override
    public List<Goods> getGoodsSeafoodAll() {
        String sql = "SELECT * FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_type.`type_name`='海鲜水产' LIMIT 0,4";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class));
    }

    /**
     * 获得所有水果商品信息
     * @return
     */
    @Override
    public List<Goods> getGoodsFruitAllProduct(PageUtils page) {
        int startIndex = (page.getPageNum()-1)*page.getRows();
        String sql = "SELECT * FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_type.`type_name`='新鲜水果' limit ?,?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class),startIndex,page.getRows());
    }

    /**
     * 获得海鲜商品不分页信息
     * @return
     */
    @Override
    public List<Goods> getGoodsSeafoodAllProduct(PageUtils page) {
        String sql = "SELECT * FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_type.`type_name`='海鲜水产' limit ?,?";
        int startIndex = (page.getPageNum()-1)*page.getRows();
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Goods.class),startIndex,page.getRows());
    }
    /**
     * 根据商品ID查询
     * @param goodsId
     * @return
     */
    @Override
    public Goods findGoodsById(String goodsId) {
        String sql = "SELECT * FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Goods.class),goodsId);
    }

    /**
     * 根据商品类型查询商品当前类型商品数量
     * @param goodsName
     * @return
     */
    @Override
    public int getGoodsCount(String goodsName) {
        String sql = "SELECT COUNT(*) FROM goods_type,goods WHERE goods_type.`type_id`=goods.`type_id` AND goods_type.`type_name`=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,goodsName);
    }
}
