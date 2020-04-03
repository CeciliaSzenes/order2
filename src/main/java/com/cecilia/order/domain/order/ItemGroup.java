package com.cecilia.order.domain.order;

import com.cecilia.order.domain.item.Item;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemGroup {
    private Item item;
    private int amountOfItem;
    private LocalDate shippingDate;

    public ItemGroup(Item item, int amountOfItem){
        this.item=item;
        this.amountOfItem=amountOfItem;
        if (item.inStock()){
            LocalDate today=LocalDate.now();
            this.shippingDate=today.plusDays(1);
        }
        else{
            LocalDate today=LocalDate.now();
            this.shippingDate=today.plusDays(7);
        };
    }

    public int calculatePriceOfItemGroup(){
        int priceOfItemGroup=item.getPrice()*amountOfItem;
        return priceOfItemGroup;
    }

}
