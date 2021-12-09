package com.ttsx.entiy;

public class AddressInfo {
    private String addressId;//用户收货地址ID
    private String addressDetail;//收货地址详情
    private String addressCode;//收货地址邮编
    private String addressPhone;//收货地址电话
    private String nikeName;//收获地址人
    private String userId;//用户表ID
    private String orderId;//订单ID

    public AddressInfo() {
    }

    public AddressInfo(String addressId, String addressDetail, String addressCode, String addressPhone, String nikeName, String userId, String orderId) {
        this.addressId = addressId;
        this.addressDetail = addressDetail;
        this.addressCode = addressCode;
        this.addressPhone = addressPhone;
        this.nikeName = nikeName;
        this.userId = userId;
        this.orderId = orderId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "addressId='" + addressId + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", addressPhone='" + addressPhone + '\'' +
                ", nikeName='" + nikeName + '\'' +
                ", userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
