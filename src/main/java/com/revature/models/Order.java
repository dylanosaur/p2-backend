package com.revature.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private Date submitted;
	private BigDecimal total;

	
	@Column(name="user_id")
	private int user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(int id, Date submitted, BigDecimal total, int user) {
		super();
		this.id = id;
		this.submitted = submitted;
		this.total = total;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getSubmitted() {
		return submitted;
	}


	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public int getUser() {
		return user;
	}


	public void setUser(int user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + user;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (user != other.user)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", submitted=" + submitted + ", total=" + total + ", user=" + user + "]";
	}



	
	

}
