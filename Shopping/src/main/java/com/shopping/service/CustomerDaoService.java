package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;

@Service
public interface CustomerDaoService {
	
	public List<Customer> getCustomer();//read operation
	public void addCustomer(Customer customer);//create operation
	public boolean customerLoginValidation(String username, String  password);
	public void updateCustomer(Customer customer);//update operation
	public void deleteCustomer(String username);//delete operation
}
