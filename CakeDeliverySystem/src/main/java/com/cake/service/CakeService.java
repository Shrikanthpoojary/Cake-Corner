package com.cake.service;

import java.util.List;

import com.cake.model.Cake;

public interface CakeService {
	public void addCake(Cake cake); //Create
	
	public List<Cake> viewAllCake(); //Read
	
	public void updateCake(Cake cake); //Update
	
	public void deleteCake(int id); //Delete
	
	public List<Cake> viewFlavourCake(int id);
	
	public List<Cake> viewOccasionCake(int id);
	
	public List<Cake> viewCakeById(int id);
	
	

}
