package com.example.as.appmarket_test;

public class HeadItem {
    private String name;
    private int imageId;

    public HeadItem(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
