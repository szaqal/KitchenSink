package javaee.samle.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import javaee.sample.model.TuneOrder;
import javaee.sample.service.OrderService;

@Model
public class OrderController {

	private static final String SUCCESS_VIEW = "orders.jsf";

	@Inject
	private FacesContext facesContext;

	@Inject
	private OrderService orderService;

	private Long customerId;

	private Long tuneId;

	@Produces
	@Named
	public List<TuneOrder> getOrders() {
		return orderService.listOrders();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public Long getTuneId() {
		return tuneId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setTuneId(Long tuneId) {
		this.tuneId = tuneId;
	}
	
	public void addOrder() throws Exception {
		try {
			orderService.saveOrder(customerId, tuneId);
			facesContext.getExternalContext().redirect(SUCCESS_VIEW);
		} catch (Exception e) {
			throw e;
		}
	}

}
