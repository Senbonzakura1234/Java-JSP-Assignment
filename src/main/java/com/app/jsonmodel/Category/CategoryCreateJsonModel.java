package com.app.jsonmodel.Category;

public class CategoryCreateJsonModel {
    private String name;

    public CategoryCreateJsonModel() {
    }

    public CategoryCreateJsonModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
