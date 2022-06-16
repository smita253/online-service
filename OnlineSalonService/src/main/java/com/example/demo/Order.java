package com.example.demo;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Order {
	int orderId;
	double amount;
	LocalDate billingDate;
	Customer customer;
	String paymentMethod;

}
