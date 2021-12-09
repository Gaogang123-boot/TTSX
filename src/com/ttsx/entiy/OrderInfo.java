package com.ttsx.entiy;

public class OrderInfo {
    private String orderId;
    private Integer orderNum;
    private String cartId;

    public OrderInfo() {
    }

    public OrderInfo(String orderId, Integer orderNum, String cartId) {
        this.orderId = orderId;
        this.orderNum = orderNum;
        this.cartId = cartId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "orderInfo{" +
                "orderId='" + orderId + '\'' +
                ", orderNum=" + orderNum +
                ", cartId='" + cartId + '\'' +
                '}';
    }
}
