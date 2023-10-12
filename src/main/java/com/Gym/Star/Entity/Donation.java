package com.Gym.Star.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String orderId;
	private String amount;
	private String receipt;
	private String status;
	private String payment_id;
	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Donation(long id, String order_id, String amount, String receipt, String status, String payment_id) {
		super();
		this.id = id;
		this.orderId = order_id;
		this.amount = amount;
		this.receipt = receipt;
		this.status = status;
		this.payment_id = payment_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrder_id() {
		return orderId;
	}
	public void setOrder_id(String order_id) {
		this.orderId = order_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	@Override
	public String toString() {
		return "Donation [id=" + id + ", order_id=" +orderId + ", amount=" + amount + ", receipt=" + receipt
				+ ", status=" + status + ", payment_id=" + payment_id + "]";
	}
	
	

}
