package javaee.sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javaee.sample.data.annotation.RequiredTextOnly;

/**
 * Represents Customer model.
 */
@Entity
@XmlRootElement
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({
	@NamedQuery(name=Customer.ALL, query="SELECT cust FROM Customer AS cust"),
	@NamedQuery(name=Customer.BY_EMAIL, query="SELECT cust FROM Customer AS cust WHERE cust.email=:email")
})
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 6405099671698319923L;
	
	public static final String ALL ="usersAll";
	public static final String BY_EMAIL = "userByEmail";
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @RequiredTextOnly
    @Column(name="first_name")
	private String firstName;
	

    @RequiredTextOnly
    @Column(name="last_name")
	private String lastName;
	
    @NotNull
    @NotEmpty
    @Email
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).addValue(getId()).addValue(getFirstName()).addValue(getLastName()).addValue(getEmail())
				.omitNullValues().toString();
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getFirstName(), getLastName(), getEmail());
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Customer other = (Customer) obj;
		return Objects.equal(getId(), other.getId()) && Objects.equal(getFirstName(), other.getFirstName())
				&& Objects.equal(getLastName(), other.getLastName()) && Objects.equal(getEmail(), other.getEmail());
	}
	
}
