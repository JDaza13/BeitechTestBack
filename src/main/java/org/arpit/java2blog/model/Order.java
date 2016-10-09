package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="ordenes")
public class Order{
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="customer_id")
	int customerId;	
	
	@Column(name="del_address")
	String address;
	
	@Column(name="order_date")
	String date;

	@Column(name="trm")
	double trm;	
	
	public Order() {
		super();
	}
	public Order(int i, int customerId, String address, String description, int price, String date, double trm) {
		super();
		this.customerId = customerId;
		this.address = address;
		this.date = date;
		this.trm = trm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTrm() {
		return trm;
	}
	public void setTrm(int trm) {
		this.trm = trm;
	}
}