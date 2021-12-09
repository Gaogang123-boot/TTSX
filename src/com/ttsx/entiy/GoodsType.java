package com.ttsx.entiy;

public class GoodsType {
    private String typeId;//商品类型Id
    private String typeName;//商品类型名称

    public GoodsType() {
    }

    public GoodsType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "goodsType{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
