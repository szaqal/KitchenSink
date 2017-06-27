package javaee.sample.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import javaee.sample.model.Customer;
import javaee.sample.repository.CustomerRepository;

/**
 * Pointless not required but added to satisfy all layers
 */
@Stateless
public class CustomerService {
	
    @Inject
    private Logger log;
    
    @Inject
    private CustomerRepository customerRepository;

	public List<Customer> getCustomers() {
		log.debug("Get all customers");
		return customerRepository.getCustomers();
	}

	public Customer getByEmail(String email) {
		log.debug("Get customer {}", email);
		Preconditions.checkNotNull(!Strings.isNullOrEmpty(email), "Email value is required for data retrieval");
		return customerRepository.getByEmail(email);
	}

	public void store(Customer newCustomer) {
		log.debug("Get customer {}", newCustomer);
		Preconditions.checkNotNull(newCustomer, "Customer object is required for save");
		 customerRepository.store(newCustomer);
	}

}
