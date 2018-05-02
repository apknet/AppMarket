package com.example.as.appmarket_test;

public class AppHor {
    private String name;
    private String imageUrl;
    private String size;

    public AppHor(String name, String imageUrl, String size) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSize() {
        return size;
    }
}
