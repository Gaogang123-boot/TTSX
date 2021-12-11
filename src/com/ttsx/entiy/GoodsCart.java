package com.ttsx.entiy;

public class GoodsCart {
    private String cartId;//购物车ID
    private String userId;//用户ID
    private String goodsId;//商品ID
    private String goodsName;//商品名称
    private String goodsPrice;//商品单价
    private String goodsNum;//商品数量
    private String goodsPic;//商品图片路径


    public GoodsCart() {
    }

    public GoodsCart(String cartId, String userId, String goodsId, String goodsName, String goodsPrice, String goodsNum, String goodsPic) {
        this.cartId = cartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
        this.goodsPic = goodsPic;
    }

    public GoodsCart(String cartId, String userId, String goodsId, String goodsName, String goodsPrice, String goodsNum) {
        this.cartId = cartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    @Override
    public String toString() {
        return "GoodsCart{" +
                "cartId='" + cartId + '\'' +
                ", userId='" + userId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                '}';
    }
}
