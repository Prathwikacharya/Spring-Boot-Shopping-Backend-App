package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Order;
import com.shopping.service.OrderDaoService;

@RestController
public class OrderController {
	
	@Autowired
	OrderDaoService orders;
	
	@GetMapping("/orders")
	public List<Order> getAllOrder(){
		return orders.getOrders();
	}
	
	@PostMapping("/addorder")
	public void addOrder(@RequestBody Order order) {
		orders.addOrder(order);
	}
}
