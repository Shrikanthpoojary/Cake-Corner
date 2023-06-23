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

import com.cake.model.Cake;
import com.cake.service.CakeService;

@CrossOrigin("*")
@RestController
public class CakeController {

	@Autowired
	private CakeService cakeService;
	
	@GetMapping(value = "/cake")
	public List<Cake> getCake() {
		return cakeService.viewAllCake();
	}
	
	@PostMapping(value = "/addcake")
	public void addCake(@RequestBody Cake cake) {
		cakeService.addCake(cake);
	}
	
	@PutMapping(value = "/updatecake")
	public void updateCake(@RequestBody Cake cake) {
		cakeService.updateCake(cake);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletecake/{id}")
	public void deleteCake(@PathVariable int id) {
		cakeService.deleteCake(id);
	}
	
	@GetMapping(value = "/flavourcake/{id}")
	public List<Cake> getFlavourCake(@PathVariable int id) {
		return cakeService.viewFlavourCake(id);
	}
	
	@GetMapping(value = "/occassioncake/{id}")
	public List<Cake> getOccasionCake(@PathVariable int id) {
		return cakeService.viewOccasionCake(id);
	}
	
	@GetMapping(value="/cakeid/{id}")
	public List<Cake> getCakeById(@PathVariable int id) {
		return cakeService.viewCakeById(id);
	}
}
