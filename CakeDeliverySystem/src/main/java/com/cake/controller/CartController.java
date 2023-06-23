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

import com.cake.model.Cart;
import com.cake.model.CartItem;
import com.cake.service.CartService;

@CrossOrigin("*")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping(value = "/cart")
	public List<Cart> getCart() {
		return cartService.viewAllCart();
	}
	
	
	@PostMapping(value = "/addcart")
	public void addCart(@RequestBody Cart cart) {
		cartService.addCart(cart);
	}
	
	@PutMapping(value = "/updatecart") 
	public void updateCart(@RequestBody Cart cart) {
		cartService.updateCart(cart);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletecart/{id}")
	public void deleteCart(@PathVariable int id) {
		cartService.deleteCart(id);
	}
	
	@GetMapping(value ="cartitem/{id}")
	public List<CartItem> getCartItem(@PathVariable int id) {
		return cartService.viewCart(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteallcart/{id}")
	public void deleteAllCart(@PathVariable int id) {
		cartService.deleteEntireCart(id);
	}
}
