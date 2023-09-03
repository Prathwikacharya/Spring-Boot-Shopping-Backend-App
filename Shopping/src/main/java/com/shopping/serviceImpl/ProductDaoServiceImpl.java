package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Product;
import com.shopping.service.ProductDaoService;
import com.shopping.util.DButil;

@Service
public class ProductDaoServiceImpl implements ProductDaoService{
	
	ArrayList<Product> productList = new ArrayList<Product>();
	
	private Connection connection = null;
	
	public ProductDaoServiceImpl() {
		try {
			connection = DButil.getConnection();
			System.out.println("connection : "+connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getProduct() {
		productList.clear();
		String getProdcutQuery = "SELECT * FROM products";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(getProdcutQuery);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setProductId(rs.getInt(1));
				prod.setProductCatId(rs.getInt(2));
				prod.setProductName(rs.getString(3));
				prod.setProductDesc(rs.getString(4));
				prod.setProductPrice(rs.getDouble(5));
				prod.setProductImg(rs.getString(6));
				productList.add(prod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public void addProduct(Product product) {
		int prodId = product.getProductId();
		int prodCatId = product.getProductCatId();
		String prodName = product.getProductName();
		String prodDesc = product.getProductDesc();
		double prodPrice = product.getProductPrice();
		String prodImg = product.getProductImg();
		
		String addProductQuery = "INSERT INTO products VALUES("
								+prodId+","+prodCatId+",'"+prodName
								+"','"+prodDesc+"',"+prodPrice+",'"
								+prodImg+"')";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(addProductQuery);
			stmt.executeUpdate();
			System.out.println("Product Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		int prodId = product.getProductId();
		int prodCatId = product.getProductCatId();
		String prodName = product.getProductName();
		String prodDesc = product.getProductDesc();
		double prodPrice = product.getProductPrice();
		String prodImg = product.getProductImg();
		
		String updateproductQuery = "UPDATE products SET productcatid = "+prodCatId
									+",productname = '"+prodName
									+"',productdesc = '"+prodDesc
									+"',productprice = "+prodPrice
									+",productimg = '"+prodImg
									+"' WHERE productid = "+prodId+";";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(updateproductQuery);
			stmt.executeUpdate();
			System.out.println("Product updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeProduct(String productName) {
		
		String deleteProductQuery = "DELETE FROM products WHERE productname = '"+productName+"'";
		
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(deleteProductQuery);
			stmt.executeUpdate();
			System.out.println("Product Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
