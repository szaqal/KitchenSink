package javaee.samle.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import javaee.sample.model.Customer;
import javaee.sample.service.CustomerService;

@Model
public class CustomerController {
	
	private static final String SUCCESS_VIEW = "customers.jsf";
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private FacesContext facesContext;
	
	private Customer newCustomer;
	
	@Produces
	@Named
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@Produces
	@Named
	public Customer newCustomer() {
		return newCustomer;
	}
	
	@PostConstruct
	public void initModel() {
		newCustomer = new Customer();
	}
	
	
	
	public void addCustomer() throws Exception {
		try {
			customerService.store(newCustomer);
			facesContext.getExternalContext().redirect(SUCCESS_VIEW);
		} catch (Exception e) {
			throw e;
		}
	}
}
