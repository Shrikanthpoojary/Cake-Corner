package com.cake.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cake.model.Cart;
import com.cake.model.CartItem;
import com.cake.service.CartService;
import com.cake.utils.DBUtil;

@Service
public class CartServiceImpl implements CartService{
	
	static List<Cart> cartList = new ArrayList<Cart>();
	static List<CartItem> cartItemList = new ArrayList<CartItem>();
	Connection connection;
	
	public CartServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("Cart Connection----------"+connection);
	}

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Inside addCart method");
		
		int cakeid = cart.getCakeid();
		int custid = cart.getCustid();
		float weight = cart.getWeight();
		int quantity = cart.getQuantity();
		
		
		String insertQuery = "INSERT INTO CART(cakeid, custid, weight, quantity) VALUES("+cakeid+","+custid+","+weight+","+quantity+")";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Cart info added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cart> viewAllCart() {
		// TODO Auto-generated method stub
		cartList.clear();
		System.out.println("Inside viewAllCart Method");
		
		String getCartQuery = "SELECT * FROM CART";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCartQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cart crt = new Cart();
				crt.setCartid(rs.getInt(1));
				crt.setCakeid(rs.getInt(2));
				crt.setCustid(rs.getInt(3));
				crt.setWeight(rs.getFloat(4));
				crt.setQuantity(rs.getInt(5));
				
				cartList.add(crt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("Inside updateCart method");
		
		int cartid = cart.getCartid();
		int cakeid = cart.getCakeid();
		int custid = cart.getCustid();
		float weight = cart.getWeight();
		int quantity = cart.getQuantity();
		
		
		String updateQuery = "UPDATE CART SET cakeid="+cakeid+",custid="+custid+", weight="+weight+", quantity="+quantity+" WHERE cartid ="+cartid+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Cart info updated successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deletecart method");
		
		String DeleteQuery = "DELETE FROM CART WHERE cartid = '"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(DeleteQuery);
			stmt.executeUpdate();
			System.out.println("Cart info deleted successfully");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CartItem> viewCart(int id) {
		// TODO Auto-generated method stub
		
		cartItemList.clear();
		System.out.println("Inside viewAllCart Method");
		
		String getCartItemQuery = "SELECT cart.cartid, cart.cakeid, cart.custid, cart.weight, cart.quantity, cake.cakename, cake.imgeUrl, cake.amount FROM cart INNER JOIN cake ON cart.cakeid= cake.cakeid INNER JOIN customer ON cart.custid = customer.custid WHERE customer.custid ="+id+" ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCartItemQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CartItem crtItem = new CartItem();
//				crt.setCartid(rs.getInt(1));
//				crt.setCakeid(rs.getInt(2));
//				crt.setCustid(rs.getInt(3));
//				crt.setWeight(rs.getFloat(4));
//				crt.setQuantity(rs.getInt(5));
//				crt.setCakename(rs.getString(6));
//				 crt.setImgeUrl(rs.getString(7));
//				crt.setAmount(rs.getFloat(8));
				
				crtItem.setCartid(rs.getInt(1));
				crtItem.setCakeid(rs.getInt(2));
				crtItem.setCustid(rs.getInt(3));
				crtItem.setWeight(rs.getFloat(4));
				crtItem.setQuantity(rs.getInt(5));
				crtItem.setCakename(rs.getString(6));
				crtItem.setImgeUrl(rs.getString(7));
				crtItem.setAmount(rs.getFloat(8));
				
				cartItemList.add(crtItem);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cartItemList;
	}

	@Override
	public void deleteEntireCart(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteAllCart method");
		
		String DeleteQuery = "DELETE FROM CART WHERE custid = '"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(DeleteQuery);
			stmt.executeUpdate();
			System.out.println("Cart info deleted successfully");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Override
//	public void updateQuantity(CartItem cartItem) {
//		// TODO Auto-generated method stub
//		System.out.println("Inside updateQuantity method");
//		
//		int cartid = cartItem.getCartid();
//		int cakeid = cartItem.getCakeid();
//		int custid = cartItem.getCustid();
//		int quantity = cartItem.getQuantity();
//		float weight = cartItem.getWeight();
//		String cakename = cartItem.getCakename();
//		String imgeUrl = cartItem.getImgeUrl();
//		float amount = cartItem.getAmount();
//	}

	

}
