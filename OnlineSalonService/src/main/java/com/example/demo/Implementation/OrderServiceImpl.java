package com.example.demo.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.AppError;
import com.example.demo.Order;
import com.example.demo.Response;
import com.example.demo.dao.IOrderDAO;
import com.example.demo.entity.OrderEntity;
import com.example.demo.service.IOrderService;
import com.example.service.impl.OrderTransformer;

public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderDAO orderDAO;

	@Override
	public Response addOrders(Order order) {
		Response<Order> response = new Response<>();
		System.out.println("order");
		// try
		{

			if (orderDAO.findById(order.getOrderId()).isPresent()) {
				System.out.println("If block execute");
				AppError error = new AppError();
				error.setCode("ERR_ADD_Oder");
				// Order order;
				error.setMessage("Order already exists " + order.getOrderId());
				// Response response;
				response.setError(error);
			} else {
				System.out.println("Else block execute");
				// order.setOrderId(0);

				// Object order;
				OrderEntity entity = OrderTransformer.transformOrder(order);
				System.out.println(entity);
				orderDAO.save(entity);
				Order newCate = OrderTransformer.transformOrderEntity(entity);
				// Response response;
				response.setData(newCate);
			}
			// }
			/*
			 * catch (Exception e) { AppError error = new AppError();
			 * error.setCode("ERR_ADD_Order"); error.setMessage(e.getMessage());
			 * response.setError(error); }
			 */
		}
		return response;
	}

	@Override
	public Response<Order> getOrderId(Integer orderId) {
		Response<Order> response = new Response<>();
		try {
			Optional<OrderEntity> opEntity = orderDAO.findById(orderId);
			if (opEntity.isPresent()) {
				response.setData(OrderTransformer.transformOrderEntity(opEntity.get()));
			}
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_ORDER");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Boolean> deleteOrder(Integer orderId) {
		Response<Boolean> response = new Response<>();
		try {
			orderDAO.deleteById(orderId);
			response.setData(true);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_ORDER");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Order> updateOrder(Order order) {
		Response<Order> response = new Response<>();
		try {
			OrderEntity entity = OrderTransformer.transformOrder(order);

			orderDAO.save(entity);

			Order newCate = OrderTransformer.transformOrderEntity(entity);
			response.setData(newCate);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_UPDATING_ORDER");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}
}