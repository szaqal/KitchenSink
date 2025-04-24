package javaee.sample.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.google.common.base.Preconditions;

import javaee.sample.model.Customer;
import javaee.sample.model.Tune;
import javaee.sample.model.TuneOrder;
import javaee.sample.repository.CustomerRepository;
import javaee.sample.repository.TuneOrderRepository;
import javaee.sample.repository.TunesRepository;

@Stateless
public class OrderService {

    @Inject
    private Logger log;
    
    @Inject
    private TuneOrderRepository tuneOrderRepository;
    
    @Inject
    private CustomerRepository customerRepository;
    
    @Inject
    private TunesRepository tunesRepository;

	public List<TuneOrder> listOrders() {
		log.debug("Retrieving orders");
		return tuneOrderRepository.listOrders();
	}

	public void saveOrder(Long customerId, Long tuneId) {
		Preconditions.checkArgument(customerId != null && tuneId != null, "Tune and customer is required");
		Customer customer = customerRepository.get(customerId);
		Tune tune = tunesRepository.get(tuneId);
		
		
		TuneOrder order =new TuneOrder();
		order.setCustomer(customer);
		order.setTune(tune);
		order.setOrderDate(new Date());
		
		tuneOrderRepository.store(order);
	}

}
