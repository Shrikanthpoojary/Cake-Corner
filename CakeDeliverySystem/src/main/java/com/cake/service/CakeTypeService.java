package com.cake.service;

import java.util.List;

import com.cake.model.CakeType;


public interface CakeTypeService {
	
	public void addCakeType(CakeType caketype); //Create
	
	public List<CakeType> viewCakeTypes(); //Read
	
	public void updateCakeType(CakeType caketype); //Update
	
	public void deleteCakeType(int id); //Delete
	
}
