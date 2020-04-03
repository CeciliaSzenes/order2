package com.cecilia.order.api;

import com.cecilia.order.domain.item.Item;
import com.cecilia.order.domain.item.ItemDto;
import com.cecilia.order.domain.item.ItemMapper;
import com.cecilia.order.domain.item.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/item")
public class ItemController {
    ItemRepository itemRepository;
    ItemMapper itemMapper;

    public ItemController(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody ItemDto itemDto) {
        Item itemToBeAdded = new Item(itemDto.getName(), itemDto.getDescription(), itemDto.getPrice(), itemDto.inStock());
        return itemMapper.transformItemToDto(itemToBeAdded);
    }

}


