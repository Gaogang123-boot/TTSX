package com.ttsx.daoImpl;

import com.ttsx.dao.UserInfoDao;
import com.ttsx.entiy.AddressInfo;
import com.ttsx.entiy.UserInfo;
import com.ttsx.util.JdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserInfoDaoImpl implements UserInfoDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDs());
    @Override
    public UserInfo getUserAddress(String userId) {
        String sql = "SELECT * FROM user_info WHERE user_id = ? ";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(UserInfo.class),userId);
    }

    @Override
    public AddressInfo getAddress(String userId) {
        String sql = "SELECT address_phone,address_detail FROM address_info WHERE user_id = ? ";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(AddressInfo.class),userId);
    }

    /***
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    @Override
    public UserInfo userLogin(String userName, String userPwd) {
        String sql = "SELECT * FROM user_info WHERE user_name = ? AND user_pwd=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(UserInfo.class),userName,userPwd);
    }
}
