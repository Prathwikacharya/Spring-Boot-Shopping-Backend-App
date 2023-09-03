package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;
import com.shopping.service.CustomerDaoService;
import com.shopping.util.DButil;

@Service
public class CustomerDaoServiceImpl implements CustomerDaoService {

	ArrayList<Customer> customerList = new ArrayList<Customer>();

	private Connection connection = null;

	public CustomerDaoServiceImpl() {
		try {
			connection = DButil.getConnection();
			System.out.println("Connection : " + connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getCustomer() {
		customerList.clear();
		String getCustomerQuerry = "SELECT * FROM Customer;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(getCustomerQuerry);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerId(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setGender(rs.getString(3));
				cust.setContactNo(rs.getLong(4));
				cust.setEmail(rs.getString(5));
				cust.setAddress(rs.getString(6));
				cust.setPincode(rs.getInt(7));
				cust.setUsername(rs.getString(8));
				cust.setPassword(rs.getString(9));
				customerList.add(cust);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public void addCustomer(Customer customer) {
		int customerid = customer.getCustomerId();
		String customerName = customer.getCustomerName();
		String gender = customer.getGender();
		long contactNo = customer.getContactNo();
		String email = customer.getEmail();
		String address = customer.getAddress();
		int pincode = customer.getPincode();
		
		String insertQuery = "INSERT INTO CUSTOMER VALUE("+customerid+",'"+customerName+"','"+gender+"',"+contactNo+",'"+email+"','"+address+"',"+pincode+",'null','null');";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Customer Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean customerLoginValidation(String username, String password) {
		System.out.println("username: "+username+" password: "+password);
		boolean flag = false;
		String loginQuery = "SELECT * FROM customer where username = '"+username+"';";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(loginQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if(rs.getString(8).equals(username) && rs.getString(9).equals(password) )
				{
				flag = true;
				System.out.println("Login Successful ");
				Customer currentCustomer = new Customer();
				currentCustomer.setCustomerId(rs.getInt(1));
				currentCustomer.setCustomerName(rs.getString(2));
				currentCustomer.setGender(rs.getString(3));
				currentCustomer.setContactNo(rs.getLong(4));
				currentCustomer.setEmail(rs.getString(5));
				currentCustomer.setAddress(rs.getString(6));
				currentCustomer.setPincode(rs.getInt(7));
				currentCustomer.setUsername(rs.getString(8));
				currentCustomer.setPassword(rs.getString(9));
				}
				else {
					System.out.println("Invalid Customer Data");
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		System.out.println("flag :"+flag);
		return flag;
	}

	@Override
	public void updateCustomer(Customer customer) {
		int customerid = customer.getCustomerId();
		String customerName = customer.getCustomerName();
		String gender = customer.getGender();
		long contactNo = customer.getContactNo();
		String email = customer.getEmail();
		String address = customer.getAddress();
		int pincode = customer.getPincode();
		String username = customer.getUsername();
		String password = customer.getPassword();
		
		String updateQuery = "UPDATE customer SET customerName = '"+customerName+"',"
				+ "Gender = '"+gender+"',"
				+ "contactNo = "+contactNo+","
				+ "email = '"+email+"',"
				+ " address = '"+address+"',"
				+ "pincode = "+pincode+", "
				+ "username = '"+username+"',"
				+ "password = '"+password
				+"' WHERE customerid = '"+customerid+"';";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Customer data updated Successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(String username) {
		
		String deleteQuery = "DELETE FROM CUSTOMER WHERE username = '"+username+"'";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Custemer data deleted successfully");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}
