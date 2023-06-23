package com.cake.model;

public class Cart {
	private int cartid;
	private int cakeid;
	private int custid;
	private float weight;
	private int quantity;
	

//	@Override
//	public String toString() {
//		return "Cart [cartid=" + cartid + ", cakeid=" + cakeid + ", custid=" + custid + ", weight=" + weight
//				+ ", quantity=" + quantity + "]";
//	}
	
	
	
	
	
	
	

	

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", cakeid=" + cakeid + ", custid=" + custid + ", weight=" + weight
				+ ", quantity=" + quantity + "]";
	}

	public Cart(int cartid, int cakeid, int custid, float weight, int quantity, String cakename, String imageUrl,
			float amount) {
		super();
		this.cartid = cartid;
		this.cakeid = cakeid;
		this.custid = custid;
		this.weight = weight;
		this.quantity = quantity;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	
	
	
	
	

//	public Cart() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

//	public Cart(int cartid, int cakeid, int custid, float weight, int quantity) {
//		super();
//		this.cartid = cartid;
//		this.cakeid = cakeid;
//		this.custid = custid;
//		this.weight = weight;
//		this.quantity = quantity;
//	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getCakeid() {
		return cakeid;
	}

	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}




	
	
}
