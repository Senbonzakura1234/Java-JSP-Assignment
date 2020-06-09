package com.app.jsonmodel;

public class AttributeCreateJsonModel {
    private String name;

    public AttributeCreateJsonModel() {
    }

    public AttributeCreateJsonModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
