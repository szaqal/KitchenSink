package javaee.sample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@XmlRootElement
@Table(name = "tune_orders")
@NamedQueries({ @NamedQuery(name = "ordersAll", query = "SELECT tunorder FROM TuneOrder AS tunorder")})
public class TuneOrder implements Serializable {

	private static final long serialVersionUID = -5323385267389739733L;

	public static final String ALL = "ordersAll";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "tune_id")
	private Tune tune;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Tune getTune() {
		return tune;
	}

	public void setTune(Tune tune) {
		this.tune = tune;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getId()).addValue(getCustomer()).addValue(getTune())
				.omitNullValues().toString();
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getOrderDate(), getCustomer(), getTune());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final TuneOrder other = (TuneOrder) obj;
		return Objects.equal(getId(), other.getId()) && Objects.equal(getCustomer(), other.getCustomer()) && Objects.equal(getOrderDate(), other.getOrderDate())
				&& Objects.equal(getTune(), other.getTune());
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
