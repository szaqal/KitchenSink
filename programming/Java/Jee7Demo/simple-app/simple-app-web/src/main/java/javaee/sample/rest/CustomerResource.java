package javaee.sample.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javaee.sample.model.Customer;
import javaee.sample.service.CustomerService;

/**
 * @author malczyk.pawel@gmail.com
 *
 */
@Path("/customers")
@RequestScoped
public class CustomerResource {
    
    @Inject
    CustomerService customerService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listAllMembers() {
        return customerService.getCustomers();
    }
    
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer lookupMemberById(@PathParam("email") String email) {
    	Customer customer = customerService.getByEmail(email);
        if (customer == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return customer;
    }
}
