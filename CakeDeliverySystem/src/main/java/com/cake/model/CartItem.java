package com.cake.model;

public class CartItem {
	private int cartid;
	private int cakeid;
	private int custid;
	private float weight;
	private int quantity;
	private String cakename;
	private String imgeUrl;
	private float amount;
	@Override
	public String toString() {
		return "CartItem [cartid=" + cartid + ", cakeid=" + cakeid + ", custid=" + custid + ", weight=" + weight
				+ ", quantity=" + quantity + ", cakename=" + cakename + ", imgeUrl=" + imgeUrl + ", amount=" + amount
				+ "]";
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(int cartid, int cakeid, int custid, float weight, int quantity, String cakename, String imgeUrl,
			float amount) {
		super();
		this.cartid = cartid;
		this.cakeid = cakeid;
		this.custid = custid;
		this.weight = weight;
		this.quantity = quantity;
		this.cakename = cakename;
		this.imgeUrl = imgeUrl;
		this.amount = amount;
	}
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
	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	public String getImgeUrl() {
		return imgeUrl;
	}
	public void setImgeUrl(String imgeUrl) {
		this.imgeUrl = imgeUrl;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
	
}
