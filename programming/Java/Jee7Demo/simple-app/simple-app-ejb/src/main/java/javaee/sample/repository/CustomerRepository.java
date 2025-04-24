package javaee.sample.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;

import com.google.common.base.Preconditions;

import javaee.sample.model.Customer;

@ApplicationScoped
public class CustomerRepository implements BaseRepository {
	
    @Inject
    private Logger log;
	
	@Inject
	private EntityManager entityManager;

	public List<Customer> getCustomers() {
		log.debug("Retrieving all customers");
		return listResults(entityManager, Customer.ALL, Customer.class);
	}
	
	public Customer getByEmail(String email) {
		Preconditions.checkNotNull(email, "Email value is requried");
		log.debug("Retrieving customers by email {}", email);
		return getResult(Customer.BY_EMAIL, Pair.of("email", email));
	}
	
	public Customer getResult( String query, Pair<String, Object> arg) {
		log.debug("Retrieving customers by args {}", arg);
		return singleResult(entityManager, query, Customer.class, arg);
	}

	public void store(Customer newCustomer) {
		store(entityManager, newCustomer);
	}

	public Customer get(Long customerId) {
		return get(entityManager, customerId, Customer.class);
	}
}
