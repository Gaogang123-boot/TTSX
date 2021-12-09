package com.ttsx.entiy;

public class GoodsCart {
    private String cartId;//购物车ID
    private String userId;//用户ID
    private String goodsId;//商品ID
    private Integer cartNum;//购物添加数量

    public GoodsCart() {
    }

    public GoodsCart(String cartId, String userId, String goodsId, Integer cartNum) {
        this.cartId = cartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.cartNum = cartNum;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }

    @Override
    public String toString() {
        return "goodsCart{" +
                "cartId='" + cartId + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", cartNum=" + cartNum +
                '}';
    }
}
