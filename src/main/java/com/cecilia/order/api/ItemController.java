package com.cecilia.order.api;

import com.cecilia.order.domain.item.Item;
import com.cecilia.order.domain.item.ItemDto;
import com.cecilia.order.domain.item.ItemMapper;
import com.cecilia.order.domain.item.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems(){
        List<ItemDto> toBeReturned=new ArrayList<>();
        List<Item> allItems= itemRepository.getAllItems();
        for (Item item:allItems){
            toBeReturned.add(itemMapper.transformItemToDto(item));
        }
        return toBeReturned;
    }
}


