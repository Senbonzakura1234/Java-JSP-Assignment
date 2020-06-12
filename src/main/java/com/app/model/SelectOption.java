package com.app.model;

public class SelectOption {
    private int value;
    private String name;
    private boolean selected;

    public SelectOption() {
    }

    public SelectOption(int value, String name, boolean selected) {
        this.value = value;
        this.name = name;
        this.selected = selected;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
