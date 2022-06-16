package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Order;
import com.example.demo.Response;
import com.example.demo.service.IOrderService;

import io.swagger.annotations.Api;
@Api
@RestController
@RequestMapping("/order")
public class MainController {

	@Autowired
	private IOrderService orderService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Order> addOrders(@RequestBody Order order) {
		return orderService.addOrders(order);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Order> updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}

	@GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Order> getOrderId(@PathVariable("orderId") Integer orderId) {
		return orderService.getOrderId(orderId);
	}

	@DeleteMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> deleteOrder(@PathVariable("orderId") Integer orderId) {
		return orderService.deleteOrder(orderId);
	}

}
