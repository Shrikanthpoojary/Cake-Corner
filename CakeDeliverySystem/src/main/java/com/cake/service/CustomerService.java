package com.cake.service;

import java.util.List;

import com.cake.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer); // Create
	
	public List<Customer> viewAllCustomer();  //Read
	
	public List<Customer> viewCustomer(int id);
	
	public void updateCustomer(Customer customer); //Update
	
	public void deleteCustomer(int id); //Delete
	
	public int loginValidation(String email, String password);
	
	public int Customerid(String email, String password);
	
}
