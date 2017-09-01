package com.example.prakriti.ecommercedemo;

/**
 * Created by Prakriti on 8/30/2017.
 */

class MyData {
        private Integer id;
    private String name, description, image, price;

    public MyData(Integer id, String name, String description, String image, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    }

