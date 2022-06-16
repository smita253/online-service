package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Order;
import com.example.demo.Response;

@Service
public interface IOrderService {
public Response addOrders(Order order);
public Response getOrderId(Integer orderId);
public Response<Boolean> deleteOrder(Integer orderId);
public Response updateOrder(Order order);

}



