package com.cecilia.order.domain.customer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerList;
    }

    public Customer viewCustomer(int id){
        return customerList.get(id);
    }

}
