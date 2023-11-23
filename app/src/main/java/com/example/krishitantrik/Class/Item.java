package com.example.krishitantrik.Class;

public class Item {

    String itemName;
    String itemLocation;
    String date;
    String price;

    public Item() {

    }

    public Item(String itemName, String itemLocation, String date, String price) {
        this.itemName = itemName;
        this.itemLocation = itemLocation;
        this.date = date;
        this.price = price;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
