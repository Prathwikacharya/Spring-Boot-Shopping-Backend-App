package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Order;

@Service
public interface OrderDaoService {
	
	public List<Order> getOrders();
	public void addOrder(Order order);
}
