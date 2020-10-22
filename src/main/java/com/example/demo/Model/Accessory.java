package com.example.demo.Model;

public class Accessory {
    int id;
    String accessory;
    double price;

    public Accessory() {}

    public Accessory(int id, String accessory, double price) {
        this.id = id;
        this.accessory = accessory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
