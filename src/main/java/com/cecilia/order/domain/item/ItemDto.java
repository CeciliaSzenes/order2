package com.cecilia.order.domain.item;

public class ItemDto {
    private String name;
    private String description;
    private int price;
    private int amount;

    public ItemDto(String name, String description, int price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }
}
