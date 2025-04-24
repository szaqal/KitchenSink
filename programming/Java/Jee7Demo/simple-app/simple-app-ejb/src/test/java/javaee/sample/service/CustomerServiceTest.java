package javaee.sample.service;

import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;

import com.google.common.collect.Lists;

import javaee.sample.model.Customer;
import javaee.sample.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerService;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private Logger log;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(customerService);
		Mockito.when(customerRepository.getByEmail("email")).thenReturn(new Customer());
		Mockito.when(customerRepository.getCustomers()).thenReturn(Lists.newArrayList());
	}

	@Test
	public void getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		Assertions.assertThat(customers).hasSize(0);
		 Mockito.verify(customerRepository).getCustomers();
	}

	@Test
	public void getByEmail() {
		 Customer byEmail = customerService.getByEmail("email");
		 Assertions.assertThat(byEmail).isNotNull();
		 Mockito.verify(customerRepository).getByEmail("email");
	}

	@Test
	public void store() {
		Customer newCustomer = new Customer();
		customerService.store(newCustomer);
		Mockito.verify(customerRepository).store(newCustomer);
	}
	
	
	
}
