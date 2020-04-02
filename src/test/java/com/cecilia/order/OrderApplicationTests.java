package com.cecilia.order;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class OrderApplicationTests {

	@Test
	void getAllCustomers_shouldGiveBackAllCustomer(){
		//GIVEN
		Customer customer1=new Customer("1", "Cecilia", "Szenes",
				"cecilia@anywhere.com", "Budapest", "3630123456");
		Customer customer2=new Customer("2",  "Adél", "Sulyok", "adel@anywhere.com",
				"Bruxelles", "3020123456");
		CustomerRepository customerRepository=new CustomerRepository();
		customerRepository.addCustomer(customer1);
		customerRepository.addCustomer(customer2);
		//WHEN
		Collection<Customer> mapOfCustomers=customerRepository.getAllCustomers();
		//THEN
		Assertions.assertThat(mapOfCustomers).containsExactlyInAnyOrder(customer1, customer2);
	}

	@Test
	void getSingleCustomerbyId_shouldReturnCustomer(){
		//GIVEN
		Customer customer1=new Customer("1", "Cecilia", "Szenes",
				"cecilia@anywhere.com", "Budapest", "3630123456");
		Customer customer2=new Customer("2", "Adél", "Sulyok", "adel@anywhere.com",
				"Bruxelles", "3020123456");
		CustomerRepository customerRepository=new CustomerRepository();
		customerRepository.addCustomer(customer1);
		customerRepository.addCustomer(customer2);

		//THEN
		Assertions.assertThat(customerRepository.viewCustomer("2")).isEqualTo(customer2);
	}

}
