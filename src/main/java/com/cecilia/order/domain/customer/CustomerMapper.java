package com.cecilia.order.domain.customer;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto transformIntoDto(Customer customer){
        CustomerDto customerDto=new CustomerDto(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getAddress(),customer.getPhoneNumber(), customer.getIdentifier());
        return customerDto;
    }
    public Customer transformDtoIntoClass(CustomerDto customerDto){
        Customer customer=new Customer(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getPhoneNumber(), customerDto.getIdentifier());
        return customer;
    }
}
