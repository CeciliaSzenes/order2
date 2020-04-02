package com.cecilia.order.domain.customer;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerRepository {

    private Map<String, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    public Collection<Customer> getAllCustomers(){
        return customerMap.values();
    }

    public Customer viewCustomer(String id){
        return customerMap.get(id);
    }

}
