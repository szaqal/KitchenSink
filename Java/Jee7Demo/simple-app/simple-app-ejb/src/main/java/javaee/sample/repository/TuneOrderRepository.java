package javaee.sample.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javaee.sample.model.TuneOrder;

@ApplicationScoped
public class TuneOrderRepository implements BaseRepository {
	
    
    @Inject
    private EntityManager entityManager;

	public List<TuneOrder> listOrders() {
		return listResults(entityManager, TuneOrder.ALL, TuneOrder.class);
	}

	public void store(TuneOrder order) {
		store(entityManager, order);
	}
}
