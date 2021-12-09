package com.ttsx.entiy;

public class UserInfo {
    private String userId;//用户ID
    private String addressId;//用户收货地址表ID
    private String userName;//用户名称
    private String userPwd;//用户密码
    private String userEmail;//用户邮箱

    public UserInfo() {
    }

    public UserInfo(String userId, String addressId, String userName, String userPwd, String userEmail) {
        this.userId = userId;
        this.addressId = addressId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "userInfo{" +
                "userId='" + userId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
