package com.cake.service;

import java.util.List;

import com.cake.model.Cart;
import com.cake.model.CartItem;

public interface CartService {

	public void addCart(Cart cart); //Create
	
	public List<Cart> viewAllCart(); //Read
	
	public void updateCart(Cart cart); //Update
	
	public void deleteCart(int id); //Delete
	
	public List<CartItem> viewCart(int id);
	
	public void deleteEntireCart(int id); //Delete
	
//	public void updateQuantity(CartItem cartItem);

}
