package com.cecilia.order.api;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerDto;
import com.cecilia.order.domain.item.Item;
import com.cecilia.order.domain.item.ItemDto;
import com.cecilia.order.domain.item.ItemMapper;
import com.cecilia.order.domain.item.ItemRepository;
import com.cecilia.order.domain.order.Order;
import com.cecilia.order.domain.order.OrderDto;
import com.cecilia.order.domain.order.OrderMapper;
import com.cecilia.order.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/order")
public class OrderController {
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeAnOrder(@RequestBody OrderDto orderDto){
        Order orderToBeAdded=new Order(orderDto.getItemGroupList(), orderDto.getOrderId());
        orderRepository.addNewOrder(orderToBeAdded);
        return "Thank you for your order!" + orderDto;
    }
}
