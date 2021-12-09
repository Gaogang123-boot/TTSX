package com.ttsx.entiy;

public class Goods {
    private String goodsId;//商品ID
    private String goodsName;//商品名称
    private String goodsShows;//商品说明
    private Integer goodsNum;//商品数量
    private String goodsDetail;//商品详情
    private double goodsPrice;//商品价格
    private String goodsPic;//商品图片路径
    private String typeId;//商品类型表ID

    public Goods() {
    }

    public Goods(String goodsId, String goodsName, String goodsShows, Integer goodsNum, String goodsDetail, double goodsPrice, String goodsPic, String typeId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsShows = goodsShows;
        this.goodsNum = goodsNum;
        this.goodsDetail = goodsDetail;
        this.goodsPrice = goodsPrice;
        this.goodsPic = goodsPic;
        this.typeId = typeId;
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

    public String getGoodsShows() {
        return goodsShows;
    }

    public void setGoodsShows(String goodsShows) {
        this.goodsShows = goodsShows;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsShows='" + goodsShows + '\'' +
                ", goodsNum=" + goodsNum +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsPic='" + goodsPic + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
