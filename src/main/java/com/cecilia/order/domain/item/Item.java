package com.cecilia.order.domain.item;

public class Item {
    private String name;
    private String description;
    private int price;
    private boolean inStock;

    public Item(String name, String description, int price, boolean inStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock=inStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public boolean inStock() { return inStock; }
}
