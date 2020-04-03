package com.cecilia.order.domain.item;

public class ItemDto {
    private String name;
    private String description;
    private int price;
    private boolean inStock;

    public ItemDto(String name, String description, int price, boolean inStock) {
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

    public boolean inStock() {return inStock; }
}
