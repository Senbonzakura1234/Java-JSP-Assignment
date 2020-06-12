package com.app.jsonmodel.Shop;

public class ShopCreateJsonModel {
    private String name;

    public ShopCreateJsonModel() {
    }

    public ShopCreateJsonModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
