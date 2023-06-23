package com.cake.service;

import java.util.List;

import com.cake.model.Flavour;

public interface FlavourService {

	public void addFlavour(Flavour flavour); //Create
	
	public List<Flavour> viewFlavours(); //Read
	
	public void updateFlavour(Flavour flavour); //Update
	
	public void deleteFlavour(int id); //Delete
	
	public List<Flavour> searchFlavour(String flavour);
}
