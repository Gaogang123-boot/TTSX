package com.ttsx.entiy;

public class Browse {
    private String browseId;
    private String browseGoodsPic;
    private String browseGoodsName;
    private double browseGoodsPrice;
    private String browseDate;
    private String userId;

    public Browse() {
    }

    public Browse(String browseId, String browseGoodsPic, String browseGoodsName, double browseGoodsPrice, String browseDate, String userId) {
        this.browseId = browseId;
        this.browseGoodsPic = browseGoodsPic;
        this.browseGoodsName = browseGoodsName;
        this.browseGoodsPrice = browseGoodsPrice;
        this.browseDate = browseDate;
        this.userId = userId;
    }

    public String getBrowseId() {
        return browseId;
    }

    public void setBrowseId(String browseId) {
        this.browseId = browseId;
    }

    public String getBrowseGoodsPic() {
        return browseGoodsPic;
    }

    public void setBrowseGoodsPic(String browseGoodsPic) {
        this.browseGoodsPic = browseGoodsPic;
    }

    public String getBrowseGoodsName() {
        return browseGoodsName;
    }

    public void setBrowseGoodsName(String browseGoodsName) {
        this.browseGoodsName = browseGoodsName;
    }

    public double getBrowseGoodsPrice() {
        return browseGoodsPrice;
    }

    public void setBrowseGoodsPrice(double browseGoodsPrice) {
        this.browseGoodsPrice = browseGoodsPrice;
    }

    public String getBrowseDate() {
        return browseDate;
    }

    public void setBrowseDate(String browseDate) {
        this.browseDate = browseDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Browse{" +
                "browseId='" + browseId + '\'' +
                ", browseGoodsPic='" + browseGoodsPic + '\'' +
                ", browseGoodsName='" + browseGoodsName + '\'' +
                ", browseGoodsPrice=" + browseGoodsPrice +
                ", browseDate='" + browseDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
