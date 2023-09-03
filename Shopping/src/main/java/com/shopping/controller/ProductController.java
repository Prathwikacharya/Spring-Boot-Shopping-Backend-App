package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Product;
import com.shopping.service.ProductDaoService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDaoService products;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return products.getProduct();
	}
	
	@PostMapping("/addproduct")
	public void addProducts(@RequestBody Product product) {
		products.addProduct(product);
	}
	
	@PutMapping("/updateproduct")
	public void updateProduct(@RequestBody Product product) {
		products.updateProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "deleteproduct/{product}")
	public void deleteProduct(@PathVariable String product) {
		products.removeProduct(product);
	}
}
