package com.cecilia.order;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderApplicationTests {

	@Test
	void getAllCustomers_shouldGiveBackAllCustomer(){
		//GIVEN
		Customer customer1=new Customer("Cecilia", "Szenes",
				"cecilia@anywhere.com", "Budapest", "3630123456", 1);
		Customer customer2=new Customer("Adél", "Sulyok", "adel@anywhere.com",
				"Bruxelles", "3020123456", 2);
		CustomerRepository customerRepository=new CustomerRepository();
		customerRepository.addCustomer(customer1);
		customerRepository.addCustomer(customer2);
		//WHEN
		List<Customer> listOfCustomers=customerRepository.getAllCustomers();
		//THEN
		Assertions.assertThat(listOfCustomers).containsExactlyInAnyOrder(customer1, customer2);
	}

	@Test
	void getSingleCustomerbyId_shouldReturnCustomer(){
		//GIVEN
		Customer customer1=new Customer("Cecilia", "Szenes",
				"cecilia@anywhere.com", "Budapest", "3630123456", 1);
		Customer customer2=new Customer("Adél", "Sulyok", "adel@anywhere.com",
				"Bruxelles", "3020123456", 2);
		CustomerRepository customerRepository=new CustomerRepository();
		customerRepository.addCustomer(customer1);
		customerRepository.addCustomer(customer2);

		//THEN
		Assertions.assertThat(customerRepository.viewCustomer(1)).isEqualTo(customer2);
	}

}
