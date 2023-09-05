package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Order;
import com.shopping.service.OrderDaoService;
import com.shopping.util.DButil;

@Service
public class OrderDaoServiceImpl implements OrderDaoService{

	ArrayList<Order> orderList = new ArrayList<>();
	
	private Connection connection = null;
	
	public OrderDaoServiceImpl() {
		try {
			connection = DButil.getConnection();
			System.out.println("Connection :"+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Order> getOrders() {
		orderList.clear();
		String getOrderQuery = "SELECT * FROM order_details;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(getOrderQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Order ord = new Order();
				ord.setOrderId(rs.getInt(1));
				ord.setCustomerName(rs.getString(2));
				ord.setProductId(rs.getInt(3));
				ord.setQuantity(rs.getInt(4));
				ord.setOrderPrice(rs.getDouble(5));
				orderList.add(ord);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderList;
	}

	@Override
	public void addOrder(Order order) {
		int ordId = order.getOrderId();
		String custName = order.getCustomerName();
		int prodId = order.getProductId();
		int quantity = order.getQuantity();
		double ordPrice = order.getOrderPrice();
		
		String addOrderQuery = "INSERT INTO order_details VAlUES("
								+ordId+",'"+custName
								+"',"+prodId+","
								+quantity+","+ordPrice+");";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(addOrderQuery);
			stmt.executeUpdate();
			System.out.println("Order placed successfully....:)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
