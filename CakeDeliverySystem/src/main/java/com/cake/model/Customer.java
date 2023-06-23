package com.cake.model;

public class Customer {

	private int custid;
	private String custname;
	private long phone;
	private String email;
	private String address;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", password=" + password + "]";
	}



	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(int custid, String custname, int phone, String email, String address, String password) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
	}



	public int getCustid() {
		return custid;
	}



	public void setCustid(int custid) {
		this.custid = custid;
	}



	public String getCustname() {
		return custname;
	}



	public void setCustname(String custname) {
		this.custname = custname;
	}


	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
