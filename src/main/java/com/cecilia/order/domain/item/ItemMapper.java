package com.cecilia.order.domain.item;

import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto transformItemToDto(Item item){
        ItemDto itemDtoForTransformation=new ItemDto(item.getName(), item.getDescription(), item.getPrice(), item.getAmount());
        return itemDtoForTransformation;
    }

    public Item tranformDtoToClass(ItemDto itemDto){
        Item itemForTransformation=new Item(itemDto.getName(), itemDto.getDescription(), itemDto.getPrice(), itemDto.getAmount());
        return itemForTransformation;
    }
}
