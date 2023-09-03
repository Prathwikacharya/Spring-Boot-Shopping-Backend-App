package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.service.AdminDaoService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminDaoService admin;
	
	@GetMapping("/adminlogin/{name}/{password}")
	public boolean adminValidation(@PathVariable String name,@PathVariable String password) {
		return admin.adminValidation(name, password);
		
	}
}
