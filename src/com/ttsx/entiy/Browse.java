package com.ttsx.entiy;

public class Browse {
    private String browseId;
    private String goodsId;
    private String browseDate;

    public Browse() {
    }

    public Browse(String browseId, String goodsId, String browseDate) {
        this.browseId = browseId;
        this.goodsId = goodsId;
        this.browseDate = browseDate;
    }

    public String getBrowseId() {
        return browseId;
    }

    public void setBrowseId(String browseId) {
        this.browseId = browseId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBrowseDate() {
        return browseDate;
    }

    public void setBrowseDate(String browseDate) {
        this.browseDate = browseDate;
    }

    @Override
    public String toString() {
        return "Browse{" +
                "browseId='" + browseId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", browseDate='" + browseDate + '\'' +
                '}';
    }
}
