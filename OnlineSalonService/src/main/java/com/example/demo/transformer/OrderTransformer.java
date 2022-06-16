package com.example.demo.transformer;

import com.example.demo.Order;
import com.example.demo.entity.OrderEntity;

public class OrderTransformer
{
public static OrderEntity transformOrder(Order order) {
	if(order != null) {
		OrderEntity entity = new OrderEntity();
		entity.setOrderId(order.getOrderId());
		entity.setAmount(order.getAmount());
		entity.setBillingDate(order.getBillingDate());
		entity.setCustomer(order.getCustomer());
		entity.setPaymentMethod(order.getPaymentMethod());
		
		return entity;
	}
	return null;
}


public static Order transformOrderEntity(OrderEntity entity) {
	if(entity != null) {
		Order order = new Order();
		order.setOrderId(entity.getOrderId());
		order.setAmount(entity.getAmount());
		order.setBillingDate(entity.getBillingDate());
		order.setCustomer(entity.getCustomer());
		order.setPaymentMethod(entity.getPaymentMethod());
		
		return order;
	}
	return null;
}
}

