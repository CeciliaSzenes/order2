package com.cecilia.order;

import com.cecilia.order.domain.customer.Customer;
import com.cecilia.order.domain.customer.CustomerRepository;
import com.cecilia.order.domain.item.Item;
import com.cecilia.order.domain.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
class OrderApplicationTests {

	@Test
	public void addCustomerToRepository(){
		//GIVEN
		CustomerRepository customerRepository=new CustomerRepository();
		Customer customer1=new Customer("1","Cecilia", "Szenes", "cecilia@nowhere.com","Budapest", "+3630123456");

		//WHEN
		Customer actualResult=customerRepository.addCustomer(customer1);
		Customer expectedResult=new Customer("1", "Cecilia", "Szenes", "cecilia@nowhere.com", "Budapest", "+3630123456");

		//THEN
		Assertions.assertThat(actualResult).isEqualTo(expectedResult);
	}

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

	@Test
	public void addItemToRepository(){
		//GIVEN
		Item coffee=new Item("coffee", "Starbucks Latte Macchiato", 4, true);
		Item donut=new Item("donut", "Delicious donut to accompany your coffee", 3, true);
		ItemRepository itemRepository=new ItemRepository();
		itemRepository.addItem(coffee);
		itemRepository.addItem(donut);

		//WHEN
		List<Item> testList=itemRepository.getAllItems();

		//THEN
		Assertions.assertThat(testList).containsExactlyInAnyOrder(coffee, donut);
	}

}
