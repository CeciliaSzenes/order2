package com.cecilia.order.domain.order;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order turnDtoIntoClass(OrderDto orderDto){
        Order newOrder=new Order(orderDto.getItemGroupList(), orderDto.getOrderId());
        return newOrder;
    }

    public OrderDto turnIntoDto(Order order){
        OrderDto orderDto=new OrderDto(order.getItemGroupList(), order.getOrderId());
        return orderDto;
    }
}
