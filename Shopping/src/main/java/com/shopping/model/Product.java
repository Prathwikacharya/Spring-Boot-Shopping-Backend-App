package com.shopping.model;

public class Product {

	private int productId;
	private int productCatId;
	private String productName;
	private String productDesc;
	private double productPrice;
	private String productImg;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCatId() {
		return productCatId;
	}
	public void setProductCatId(int productCatId) {
		this.productCatId = productCatId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	
	public Product(int productId, int productCatId, String productName, String productDesc, double productPrice,
			String productImg) {
		super();
		this.productId = productId;
		this.productCatId = productCatId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productImg = productImg;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
