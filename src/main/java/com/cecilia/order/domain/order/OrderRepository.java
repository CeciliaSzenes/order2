package com.cecilia.order.domain.order;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderRepository {
    List<Order> orderRepo=new ArrayList<>();

    public void addNewOrder(Order order){
        orderRepo.add(order);
    }

}
