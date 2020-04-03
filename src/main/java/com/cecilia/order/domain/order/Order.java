package com.cecilia.order.domain.order;

import com.cecilia.order.domain.order.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<ItemGroup> itemGroupList=new ArrayList<>();
    private int orderId;

    public Order(List itemGroupList, int orderId){
        this.itemGroupList=itemGroupList;
        this.orderId=orderId;
    }
    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addItemGroupToOrder(ItemGroup itemGroup) {
        itemGroupList.add(itemGroup);
    }

    public int calculateTotalPriceOfOrder(){
        int totalPrice=0;
        for (ItemGroup itemGroup:itemGroupList)
              {totalPrice=totalPrice+itemGroup.calculatePriceOfItemGroup();
              }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order: " +
                "itemGroupList=" + itemGroupList +
                ", orderId=" + orderId +
                '}';
    }
}
