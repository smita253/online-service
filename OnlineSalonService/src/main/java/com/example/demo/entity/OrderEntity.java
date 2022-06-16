package com.example.demo.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.Customer;

import lombok.Data;
import lombok.ToString;
   @Entity
	@Table(name = "order1")
   
	@ToString
	public class OrderEntity {
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name="orderId")
		    private int orderId;

		    @Column(name="amount")
		    private double amount;

		    @Column(name= "billingDate")
		    private LocalDate billingDate;

		    @Column(name="customer")
		    private Customer customer;
  
		    @Column(name="paymentMethod")
		    private String paymentMethod ;

			public int getOrderId() {
				return orderId;
			}

			public void setOrderId(int orderId) {
				this.orderId = orderId;
			}

			public double getAmount() {
				return amount;
			}

			public void setAmount(double amount) {
				this.amount = amount;
			}

			public LocalDate getBillingDate() {
				return billingDate;
			}

			public void setBillingDate(LocalDate billingDate) {
				this.billingDate = billingDate;
			}

			public Customer getCustomer() {
				return customer;
			}

			public void setCustomer(Customer customer) {
				this.customer = customer;
			}

			public String getPaymentMethod() {
				return paymentMethod;
			}

			public void setPaymentMethod(String paymentMethod) {
				this.paymentMethod = paymentMethod;
			}
		    
		   
	}