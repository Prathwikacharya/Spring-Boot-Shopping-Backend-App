package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.shopping.model.Admin;
import com.shopping.service.AdminDaoService;
import com.shopping.util.DButil;

@Service
public class AdminDaoServiceImpl implements AdminDaoService{
	
	Admin curAdmin = new Admin();
	private Connection connection = null;
	
	public AdminDaoServiceImpl() {
		try {
			connection = DButil.getConnection();
			System.out.println("Connection :"+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean adminValidation(String name,String password) {
		System.out.println("Admin name : "+name+" Password :"+password);
		boolean flag = false;
		String adminLoginQuery = "SELECT * FROM Admin;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(adminLoginQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(name) && rs.getString(2).equals(password)) {
					System.out.println("Admin login successful");
					flag = true;
				}else {
					System.out.println("Invalid name or password..!");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("flag :"+ flag);
		return flag;
	}

}
