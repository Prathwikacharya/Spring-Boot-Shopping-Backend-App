package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Product;

@Service
public interface ProductDaoService {
	
	public List<Product> getProduct();//read operation
	public void addProduct(Product product);//create operation
	public void updateProduct(Product product);//update operation
	public void removeProduct(String product);//delete operation
}
