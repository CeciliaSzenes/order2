package com.cecilia.order.api;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerDto;
import com.cecilia.order.domain.item.Item;
import com.cecilia.order.domain.item.ItemDto;
import com.cecilia.order.domain.item.ItemMapper;
import com.cecilia.order.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/item")
public class ItemController {
    ItemRepository itemRepository;
    ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        Item itemToBeAdded= new Item(itemDto.getName(),itemDto.getDescription(), itemDto.getPrice(), itemDto.getAmount());
        return itemMapper.transformItemToDto(itemToBeAdded);
    }
}
