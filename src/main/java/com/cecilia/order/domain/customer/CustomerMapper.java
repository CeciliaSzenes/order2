package com.cecilia.order.domain.customer;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto transformIntoDto(Customer customer){
        CustomerDto customerDto=new CustomerDto(customer.getId(),customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getAddress(),customer.getPhoneNumber());
        return customerDto;
    }
    public Customer transformDtoIntoClass(CustomerDto customerDto){
        Customer customer=new Customer(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getPhoneNumber());
        return customer;
    }
}
