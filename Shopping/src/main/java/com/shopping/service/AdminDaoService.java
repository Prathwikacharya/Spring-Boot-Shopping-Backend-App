package com.shopping.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminDaoService {
	
	public boolean adminValidation(String name,String password);
	
}
	
