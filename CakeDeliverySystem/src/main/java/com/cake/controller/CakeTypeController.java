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

import com.cake.model.CakeType;
import com.cake.service.CakeTypeService;

@CrossOrigin("*")
@RestController
public class CakeTypeController {
	
	@Autowired
	private CakeTypeService caketypeService;
	
	@GetMapping(value = "/caketype")
	public List<CakeType> getCakeType() {
		return caketypeService.viewCakeTypes();
	}
	
	@PostMapping(value ="/addcaketype")
	public void addCaketype(@RequestBody CakeType caktype) {
		caketypeService.addCakeType(caktype);
	}
	
	@PutMapping(value = "/updatecaketype")
	public void updateCakeType(@RequestBody CakeType caketype) {
		caketypeService.updateCakeType(caketype);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/deletecaketype/{id}") 
	public void deletecakeType(@PathVariable int id) {
		caketypeService.deleteCakeType(id);
	}
}
