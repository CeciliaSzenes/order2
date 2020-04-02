package com.cecilia.order.domain.item;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepository {
    List<Item> itemList=new ArrayList<>();

    public void addItem(Item item){
        itemList.add(item);
    }

}
