package com.cake.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cake.model.Flavour;
import com.cake.service.FlavourService;
import com.cake.utils.DBUtil;

@Service
public class FlavourServiceImpl implements FlavourService{

	static List<Flavour> flavourList = new ArrayList<Flavour>();
	
	Connection connection;
	
	public FlavourServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("Flavour Connection----------"+connection);
		
	}
	
	@Override
	public void addFlavour(Flavour flavour) {
		// TODO Auto-generated method stub
		System.out.println("Inside addflavour method");
		
		String flavourname = flavour.getFlavourname();
		String imageUrl = flavour.getImageUrl();
		
		String insertQuery = "INSERT INTO FLAVOURS(flavourname,imageUrl) VALUES('"+flavourname+"','"+imageUrl+"')";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Flavour info added successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Flavour> viewFlavours() {
		// TODO Auto-generated method stub
		flavourList.clear();
		System.out.println("Inside viewFlavour Method");
		
		String getFlavourQuery = "SELECT * FROM FLAVOURS";
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getFlavourQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Flavour flav = new Flavour();
				flav.setFlavourid(rs.getInt(1));
				flav.setFlavourname(rs.getString(2));
				flav.setImageUrl(rs.getString(3));
				
				flavourList.add(flav);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flavourList;
	}

	@Override
	public void updateFlavour(Flavour flavour) {
		// TODO Auto-generated method stub
		System.out.println("Inside updateflavour method");
		
		int flavourid = flavour.getFlavourid();
		String flavourname = flavour.getFlavourname();
		String imageUrl = flavour.getImageUrl();
		
		String updateQuery = "UPDATE FLAVOURS SET flavourname = '"+flavourname+"',imageUrl= '"+imageUrl+"' WHERE flavourid = "+flavourid+" ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Flavour info updated successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteFlavour(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteflavour method");
		
		String DeleteQuery = "DELETE FROM FLAVOURS WHERE flavourid = '"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(DeleteQuery);
			stmt.executeUpdate();
			System.out.println("flavour info deleted successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Flavour> searchFlavour(String flavour) {
		// TODO Auto-generated method stub
		flavourList.clear();
		
		System.out.println("Inside searchFlavour Method");
		
		String searchFlavourQuery = " SELECT * FROM FLAVOURS WHERE flavourname LIKE '%" +flavour+ "%' ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(searchFlavourQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Flavour flav = new Flavour();
				flav.setFlavourid(rs.getInt(1));
				flav.setFlavourname(rs.getString(2));
				flav.setImageUrl(rs.getString(3));
				
				flavourList.add(flav);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flavourList;
	}

}
