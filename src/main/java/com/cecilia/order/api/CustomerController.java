package com.cecilia.order.api;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerDto;
import com.cecilia.order.domain.customer.CustomerMapper;
import com.cecilia.order.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {

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
        Customer customerToBeAdded = new Customer(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmail(), customerDto.getAddress(), customerDto.getPhoneNumber(), customerDto.getIdentifier());
        return customerMapper.transformIntoDto(customerToBeAdded);
    }

    @GetMapping(produces = "application/json", path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getListOfCustomers() {
        List<Customer> listOfAllCustomers = customerRepository.getAllCustomers();
        List<CustomerDto> listToBeReturned = new ArrayList<>();
        for (Customer customer : listOfAllCustomers) {
            listToBeReturned.add(customerMapper.transformIntoDto(customer));
        }
        return listToBeReturned;
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto viewSingleCustomer(@PathVariable int id) {
        Customer toBeViewed = customerRepository.viewCustomer(id);
        return customerMapper.transformIntoDto(toBeViewed);


    }
}