package com.cake.model;

public class Cake {
	private int cakeid;
	private String cakename;
	private float amount;
	private String desc;
	private String imgeUrl;
	private float weight;
	private int quantity;
	private int typeid;
	private int flavourid;
	
	@Override
	public String toString() {
		return "Cake [cakeid=" + cakeid + ", cakename=" + cakename + ", amount=" + amount + ", desc=" + desc
				+ ", imgeUrl=" + imgeUrl + ", weight=" + weight + ", quantity=" + quantity + ", typeid=" + typeid
				+ ", flavourid=" + flavourid + "]";
	}

	public Cake() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cake(int cakeid, String cakename, float amount, String desc, String imgeUrl, float weight, int quantity,
			int typeid, int flavourid) {
		super();
		this.cakeid = cakeid;
		this.cakename = cakename;
		this.amount = amount;
		this.desc = desc;
		this.imgeUrl = imgeUrl;
		this.weight = weight;
		this.quantity = quantity;
		this.typeid = typeid;
		this.flavourid = flavourid;
	}

	public int getCakeid() {
		return cakeid;
	}

	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}

	public String getCakename() {
		return cakename;
	}

	public void setCakename(String cakename) {
		this.cakename = cakename;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImgeUrl() {
		return imgeUrl;
	}

	public void setImgeUrl(String imgeUrl) {
		this.imgeUrl = imgeUrl;
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

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public int getFlavourid() {
		return flavourid;
	}

	public void setFlavourid(int flavourid) {
		this.flavourid = flavourid;
	}
	
	
}
