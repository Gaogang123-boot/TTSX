package com.ttsx.daoImpl;

import com.ttsx.dao.BrowseDao;
import com.ttsx.entiy.Browse;
import com.ttsx.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BrowseDaoImpl implements BrowseDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDs());
    @Override
    public List<Browse> getBrowseInfo(String userId) {
        String sql = "SELECT * FROM browse WHERE browse.`user_id`=? ORDER BY browse.`browse_date` DESC LIMIT 0,5";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Browse.class),userId);
    }

    /**
     * 根据用户点击查看商品添加到浏览信息表
     */
    @Override
    public void insBrowseInfo(String goodsPic,String goodsName,double goodsPrice,String userId) {
        String sql = "INSERT INTO browse  VALUES(UUID(),?,?,?,NOW(),?)";
        jdbcTemplate.update(sql,goodsPic,goodsName,goodsPrice,userId);
    }
}
