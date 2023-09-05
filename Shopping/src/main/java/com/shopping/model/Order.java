package com.shopping.model;

public class Order {

	private int orderId;
	private String customerName;
	private int productId;
	private int quantity;
	private double orderPrice;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public Order(int orderId, String customerName, int productId, int quantity, double orderPrice) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.productId = productId;
		this.quantity = quantity;
		this.orderPrice = orderPrice;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}
