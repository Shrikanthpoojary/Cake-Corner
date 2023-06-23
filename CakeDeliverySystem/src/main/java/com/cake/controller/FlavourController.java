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

import com.cake.model.Flavour;
import com.cake.service.FlavourService;

@CrossOrigin("*")
@RestController
public class FlavourController {
	
	@Autowired
	private FlavourService flavourService;
	
	@GetMapping(value="/flavour")
	public List<Flavour> getFlavour() {
		return flavourService.viewFlavours();
	}
	
	@PostMapping(value = "/addflavour")
	public void addFlavour(@RequestBody Flavour flavour) {
		flavourService.addFlavour(flavour);
	}
	
	@PutMapping(value = "/updateflavour")
	public void updateCustomer(@RequestBody Flavour flavour) {
		flavourService.updateFlavour(flavour);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteflavour/{id}")
	public void deleteCustomer(@PathVariable int id) {
		flavourService.deleteFlavour(id);
	}
	
	@GetMapping(value="/searchflavour/{flavour}")
	public List<Flavour> getSearchedFlavour(@PathVariable String flavour) {
		return flavourService.searchFlavour(flavour);
	}
	
}
