package com.cecilia.order.api;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerDto;
import com.cecilia.order.domain.customer.CustomerMapper;
import com.cecilia.order.domain.customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        Customer customerToBeAdded = new Customer(customerDto.getId(), customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getPhoneNumber());
        customerRepository.addCustomer(customerToBeAdded);
        return customerDto;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {
        Collection<Customer> customerList= customerRepository.getAllCustomers();
        List<CustomerDto> toBeReturned=new ArrayList<CustomerDto>(){};
        for (Customer customers:customerList) {
            toBeReturned.add(customerMapper.transformIntoDto(customers));}
        return toBeReturned;
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto viewCustomer(@PathVariable String id) {
        return customerMapper.transformIntoDto(customerRepository.viewCustomer(id));
    }
}