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
        String sql = "SELECT COUNT(*) FROM address_info WHERE user_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        if (count>0){
            sql = "SELECT address_phone,address_detail FROM address_info WHERE user_id = ? ";
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(AddressInfo.class),userId);
        }else {
            return null;
        }

    }

    /***
     * 用户登录
     * @param userName
     * @param userPwd
     * @return
     */
    @Override
    public UserInfo userLogin(String userName, String userPwd) {
        String sql = "select count(*) from user_info WHERE user_name = ? AND user_pwd=?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userName, userPwd);
        if (count>0){
            sql = "SELECT * FROM user_info WHERE user_name = ? AND user_pwd=?";
            return  jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(UserInfo.class), userName, userPwd);
        }else {
            return null;
        }
    }

    /**
     * 用户注册
     * @param userName
     * @param userPwd
     * @param userEmail
     * @return
     */
    @Override
    public boolean userReg(String userName, String userPwd, String userEmail) {
        String sql = "INSERT INTO user_info VALUES(UUID(),?,?,?)";
        return jdbcTemplate.update(sql,userName,userPwd,userEmail)>0;
    }
}
