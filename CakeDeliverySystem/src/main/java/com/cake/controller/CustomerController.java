package com.cake.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cake.model.Customer;
import com.cake.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customer")
	public List<Customer> getCustomer() {
		return customerService.viewAllCustomer();
	}
	
	@PostMapping(value = "/addcustomer")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@PutMapping(value = "/updatecustomer")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}
	
	@GetMapping("customer/{email}/{password}")
	public int customerLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		int flag = customerService.loginValidation(email, password);
		if(flag == 0) {
			return 0;
		}
		return flag;
	}
	
	@GetMapping("customerid/{id}")
	public List<Customer> getACustomer(@PathVariable("id") int id) {
		return customerService.viewCustomer(id);
	}
	
	@GetMapping("customerid/{email}/{password}")
	public int customerId(@PathVariable("email") String email, @PathVariable("password") String password) {
		int flag = customerService.Customerid(email, password);
		if(flag == 0) {
			return 0;
		}
		return flag;
	}
	
}
