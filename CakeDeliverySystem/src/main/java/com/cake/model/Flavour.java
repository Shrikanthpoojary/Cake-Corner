package com.cake.model;

public class Flavour {
	private int flavourid;
	private String flavourname;
	private String imageUrl;
	
	@Override
	public String toString() {
		return "Flavour [flavourid=" + flavourid + ", flavourname=" + flavourname + ", imageUrl=" + imageUrl + "]";
	}

	public Flavour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flavour(int flavourid, String flavourname, String imageUrl) {
		super();
		this.flavourid = flavourid;
		this.flavourname = flavourname;
		this.imageUrl = imageUrl;
	}

	public int getFlavourid() {
		return flavourid;
	}

	public void setFlavourid(int flavourid) {
		this.flavourid = flavourid;
	}

	public String getFlavourname() {
		return flavourname;
	}

	public void setFlavourname(String flavourname) {
		this.flavourname = flavourname;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
