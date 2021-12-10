package com.ttsx.dao;

import com.ttsx.entiy.AddressInfo;
import com.ttsx.entiy.UserInfo;

public interface UserInfoDao {
    UserInfo getUserAddress(String userId);//获取用户信息地址
    AddressInfo getAddress(String userId);
    UserInfo userLogin(String userName,String userPwd);//用户登录
    boolean userReg(String userName,String userPwd,String userEmail);//用户注册
}
