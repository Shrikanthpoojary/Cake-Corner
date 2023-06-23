package com.cake.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cake.model.CakeType;
import com.cake.service.CakeTypeService;
import com.cake.utils.DBUtil;

@Service
public class CakeTypeServiceImpl implements CakeTypeService{

	static List<CakeType> typeList = new ArrayList<CakeType>();
	
	Connection connection;
	
	public CakeTypeServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("CakeTypes Connection----------"+connection);
	}

	@Override
	public void addCakeType(CakeType caketype) {
		// TODO Auto-generated method stub
		System.out.println("Inside addcaketype method");
		
		String typename = caketype.getTypename();
		String imgUrl = caketype.getImgUrl();
		
		String insertQuery = "INSERT INTO CAKETYPE(typename,imgUrl) VALUES('"+typename+"','"+imgUrl+"')";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Cake Type added successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CakeType> viewCakeTypes() {
		// TODO Auto-generated method stub
		typeList.clear();
		System.out.println("Inside viewCakeTypes Method");
		
		String getTypeQuery = "SELECT * FROM CAKETYPE";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getTypeQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CakeType cktp = new CakeType();
				cktp.setTypeid(rs.getInt(1));
				cktp.setTypename(rs.getString(2));
				cktp.setImgUrl(rs.getString(3));
				
				typeList.add(cktp);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeList;
	}

	@Override
	public void updateCakeType(CakeType caketype) {
		// TODO Auto-generated method stub
		System.out.println("Inside updatecaketype method");
		
		int typeid = caketype.getTypeid();
		String typename = caketype.getTypename();
		String imgUrl = caketype.getImgUrl();
		
		String updateQuery = "UPDATE CAKETYPE SET typename='"+typename+"',imgUrl='"+imgUrl+"' WHERE typeid ="+typeid+"";
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("cake type updated successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCakeType(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deletecaketype method");
		
		String DeleteQuery = "DELETE FROM CAKETYPE WHERE typeid = '"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(DeleteQuery);
			stmt.executeUpdate();
			System.out.println("cake type deleted successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
