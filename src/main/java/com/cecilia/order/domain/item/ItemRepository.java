package com.cecilia.order.domain.item;

import com.cecilia.order.domain.order.ItemGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemRepository {
    List<Item> itemList=new ArrayList<>();


    public void addItem(Item item){
        itemList.add(item);
    }

    public List<Item> getAllItems() {
        return itemList.stream()
                .filter(item -> item.inStock())
                .collect(Collectors.toList());
        }
    }





