package com.cecilia.order.domain.order;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    List<ItemGroup> itemGroupList=new ArrayList<>();
    private int orderId;


    public OrderDto(List itemGroupList, int orderId){
        this.itemGroupList=itemGroupList;
        this.orderId=orderId;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public int getOrderId() {
        return orderId;
    }
}
