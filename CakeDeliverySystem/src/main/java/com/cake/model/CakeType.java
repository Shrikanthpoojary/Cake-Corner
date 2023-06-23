package com.cake.model;

public class CakeType {
	private int typeid;
	private String typename;
	private String imgUrl;
	
	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typename=" + typename + ", imgUrl=" + imgUrl + "]";
	}

	public CakeType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CakeType(int typeid, String typename, String imgUrl) {
		super();
		this.typeid = typeid;
		this.typename = typename;
		this.imgUrl = imgUrl;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}

