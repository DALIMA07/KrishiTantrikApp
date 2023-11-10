package com.example.krishitantrik.Class;

public class Item {

    String itemName;
    String itemLocation;
    String date;

    public Item() {

    }

    public Item(String itemName, String itemLocation, String date) {
        this.itemName = itemName;
        this.itemLocation = itemLocation;
        this.date = date;
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
}
