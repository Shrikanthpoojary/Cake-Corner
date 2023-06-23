package com.cake.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cake.model.Customer;
import com.cake.service.CustomerService;
import com.cake.utils.DBUtil;

@Service
public class CustomerServiceImpl implements CustomerService {
	static List<Customer> customerList = new ArrayList<Customer>();
	
	Connection connection;
	
	public CustomerServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("Customer Connection----------"+connection);
		
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Inside addcustomer method");
		
//		int custid = customer.getCustid();
		String custname = customer.getCustname();
		long phone = customer.getPhone();
		String email = customer.getEmail();
		String password = customer.getPassword();
		String address = customer.getAddress();
		
		String insertQuery = "INSERT INTO CUSTOMER(custname,phone,email,password,address) VALUES('"+custname+"',"+phone+",'"+email+"','"+password+"','"+address+"')";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Customer info added successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> viewAllCustomer() {
		
		customerList.clear();
		System.out.println("Inside viewAllCustomer Method");
		
		String getCustomerQuery = "SELECT * FROM CUSTOMER";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCustomerQuery);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustid(rs.getInt(1));
				cust.setCustname(rs.getNString(2));
				cust.setPhone(rs.getLong(3));
				cust.setEmail(rs.getString(4));
				cust.setPassword(rs.getString(5));
				cust.setAddress(rs.getString(6));
				
				customerList.add(cust);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		System.out.println("Inside updatecustomer method");
		
		int custid = customer.getCustid();
		String custname = customer.getCustname();
		long phone = customer.getPhone();
		String email = customer.getEmail();
		String password = customer.getPassword();
		String address = customer.getAddress();
		
		String updateQuery = "UPDATE CUSTOMER SET custname = '"+custname+"',phone="+phone+",email='"+email+"',password='"+password+"',address='"+address+"' WHERE custid ="+custid+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Customer info updated successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deletecustomer method");
		
		String DeleteQuery = "DELETE FROM CUSTOMER WHERE custid = '"+id+"';";
		try {
			PreparedStatement stmt = connection.prepareStatement(DeleteQuery);
			stmt.executeUpdate();
			System.out.println("Customer info deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int loginValidation(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("Inside loginValidation method");
		 String loginQuery = "SELECT * FROM CUSTOMER WHERE email = '"+email+"'";
		 int flag = 0;
//		 String id;
//		 int custid=0;
		 try {
			PreparedStatement stmt = connection.prepareStatement(loginQuery);
			ResultSet res = stmt.executeQuery();
			
			while(res.next()) {
				if(res.getString(4).equals(email) && res.getString(5).equals(password)) {
					flag = 1;
//					id = "SELECT custid FROM CUSTOMER WHERE email = '"+email+"' and password = '"+password+"'";
//					try{
//						stmt = connection.prepareStatement(id);
//						res = stmt.executeQuery();
//						custid =Integer.parseInt(id);
//			            System.out.println(custid);
			            System.out.println("Customer login successfully");
//			        }
//			        catch (NumberFormatException ex){
//			            ex.printStackTrace();
//			        }
					
				}
				else {
					System.out.println("Invalid Username or Passowrd");
				}
			}
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}


	@Override
	public int Customerid(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("Inside customer method");
		 String loginQuery = "SELECT * FROM CUSTOMER WHERE email = '"+email+"'";
		 int flag = 0;
		 
		 try {
			PreparedStatement stmt = connection.prepareStatement(loginQuery);
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				if(res.getString(4).equals(email) && res.getString(5).equals(password)) {
					flag = res.getInt(1);
//					
			            System.out.println("Customerid successfully");
				}
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<Customer> viewCustomer(int id) {
		// TODO Auto-generated method stub
		customerList.clear();
		System.out.println("Inside viewCustomer Method");
		
		String getCustomerQuery = "SELECT * FROM CUSTOMER WHERE custid = "+id+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCustomerQuery);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Customer cust = new Customer();
				cust.setCustid(rs.getInt(1));
				cust.setCustname(rs.getNString(2));
				cust.setPhone(rs.getLong(3));
				cust.setEmail(rs.getString(4));
				cust.setPassword(rs.getString(5));
				cust.setAddress(rs.getString(6));
				
				customerList.add(cust);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
