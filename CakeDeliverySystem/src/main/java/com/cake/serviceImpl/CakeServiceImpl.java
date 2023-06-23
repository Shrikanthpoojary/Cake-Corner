package com.cake.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cake.model.Cake;
import com.cake.service.CakeService;
import com.cake.utils.DBUtil;

@Service
public class CakeServiceImpl implements CakeService{

	static List<Cake> cakeList = new ArrayList<Cake>();
	
	Connection connection;
	
	public CakeServiceImpl() throws ClassNotFoundException {
		connection = DBUtil.getConnection();
		System.out.println("Cake Connection----------"+connection);
	}

	@Override
	public void addCake(Cake cake) {
		// TODO Auto-generated method stub
		System.out.println("Inside addCake method");
		
		String cakename = cake.getCakename();
		float amount = cake.getAmount();
		String desc = cake.getDesc();
		String imgeUrl = cake.getImgeUrl();
		float weight = cake.getWeight();
		int quantity = cake.getQuantity();
		int typeid = cake.getTypeid();
		int flavourid = cake.getFlavourid();
		
		String insertQuery = "INSERT INTO CAKE(cakename,amount,description,imgeUrl,weight,quantity,typeid,flavourid) VALUES('"+cakename+"',"+amount+",'"+desc+"','"+imgeUrl+"',"+weight+","+quantity+","+typeid+","+flavourid+")";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Cake info added successfully");
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cake> viewAllCake() {
		// TODO Auto-generated method stub
		cakeList.clear();
		System.out.println("Inside viewAllCake Method");
		
		String getCakeQuery = "SELECT * FROM CAKE";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCakeQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cake ck = new Cake();
				ck.setCakeid(rs.getInt(1));
				ck.setCakename(rs.getString(2));
				ck.setAmount(rs.getFloat(3));
				ck.setDesc(rs.getString(4));
				ck.setImgeUrl(rs.getString(5));
				ck.setWeight(rs.getFloat(6));
				ck.setQuantity(rs.getInt(7));
				ck.setTypeid(rs.getInt(8));
				ck.setFlavourid(rs.getInt(9));
				
				cakeList.add(ck);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cakeList;
	}

	@Override
	public void updateCake(Cake cake) {
		// TODO Auto-generated method stub
		System.out.println("Inside updatecake method");
		
		int cakeid = cake.getCakeid();
		String cakename = cake.getCakename();
		float amount = cake.getAmount();
		String desc = cake.getDesc();
		String imgeUrl = cake.getImgeUrl();
		float weight = cake.getWeight();
		int quantity = cake.getQuantity();
		int typeid = cake.getTypeid();
		int flavourid = cake.getFlavourid();
		
		String updateQuery = "UPDATE CAKE SET cakename='"+cakename+"',amount="+amount+",description='"+desc+"',imgeUrl='"+imgeUrl+"',weight="+weight+",quantity="+quantity+",typeid="+typeid+",flavourid="+flavourid+" WHERE cakeid="+cakeid+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Cake info updated successfully");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCake(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteCake method");
		
		String DeleteQuery = "DELETE FROM CAKE WHERE cakeid = '"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(DeleteQuery);
			stmt.executeUpdate();
			System.out.println("cake info deleted successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cake> viewFlavourCake(int id) {
		// TODO Auto-generated method stub
		cakeList.clear();
		System.out.println("Inside viewFlavourCake Method");
		
		String getFlavourCakeQuery = "SELECT * FROM CAKE WHERE flavourid ="+id+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getFlavourCakeQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cake ck = new Cake();
				ck.setCakeid(rs.getInt(1));
				ck.setCakename(rs.getString(2));
				ck.setAmount(rs.getFloat(3));
				ck.setDesc(rs.getString(4));
				ck.setImgeUrl(rs.getString(5));
				ck.setWeight(rs.getFloat(6));
				ck.setQuantity(rs.getInt(7));
				ck.setTypeid(rs.getInt(8));
				ck.setFlavourid(rs.getInt(9));
				
				cakeList.add(ck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cakeList;
	}

	@Override
	public List<Cake> viewOccasionCake(int id) {
		// TODO Auto-generated method stub
		cakeList.clear();
		System.out.println("Inside viewOcassionCake Method");
		
		String getFlavourCakeQuery = "SELECT * FROM CAKE WHERE typeid ="+id+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getFlavourCakeQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cake ck = new Cake();
				ck.setCakeid(rs.getInt(1));
				ck.setCakename(rs.getString(2));
				ck.setAmount(rs.getFloat(3));
				ck.setDesc(rs.getString(4));
				ck.setImgeUrl(rs.getString(5));
				ck.setWeight(rs.getFloat(6));
				ck.setQuantity(rs.getInt(7));
				ck.setTypeid(rs.getInt(8));
				ck.setFlavourid(rs.getInt(9));
				
				cakeList.add(ck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cakeList;
		
	
	}

	@Override
	public List<Cake> viewCakeById(int id) {
		// TODO Auto-generated method stub
		cakeList.clear();
		System.out.println("Inside viewOcassionCake Method");
		
		String getCakeByIdQuery = "SELECT * FROM CAKE WHERE cakeid ="+id+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCakeByIdQuery);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cake ck = new Cake();
				ck.setCakeid(rs.getInt(1));
				ck.setCakename(rs.getString(2));
				ck.setAmount(rs.getFloat(3));
				ck.setDesc(rs.getString(4));
				ck.setImgeUrl(rs.getString(5));
				ck.setWeight(rs.getFloat(6));
				ck.setQuantity(rs.getInt(7));
				ck.setTypeid(rs.getInt(8));
				ck.setFlavourid(rs.getInt(9));
				
				cakeList.add(ck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cakeList;
	}
	
}
