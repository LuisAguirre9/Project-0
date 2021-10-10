package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDaoDatabase implements UserDataAccessObject{

	ConnectionUtil cUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public List<User> getAllUsers(){
		
		List<User> userList = new ArrayList<User>();
		
		try {
		//This establishes the connection to the database 
		Connection c = cUtil.getConnection();
		String selectAllSQL = "SELECT * FROM users";
		
		Statement s = c.createStatement();
		
		ResultSet rs = s.executeQuery(selectAllSQL);	
		
		while(rs.next()) {
			userList.add(new User(rs.getString(1), rs.getString(2),rs.getDouble(3), rs.getString(4)));
		}
		return userList;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
User user = new User();
		
		try {
			Connection c = cUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE users.username = '" + username + "'";
			
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setAccountBalance(rs.getDouble(3));
				user.setPersonalInformation(rs.getString(4));
			}
				return user;
			} 
			catch(SQLException e) {
				e.printStackTrace();
			}
				return null;
	}

	@Override
	public void createUser(User u) throws SQLException {
		Connection c = cUtil.getConnection();
		//Error NOTE: I have to start a connection first
		String userdata = "INSERT INTO users(username, password,accountbalance,personalinformation) values"
				+"(?,?,?,?)";
		//Question marks align to my INSERT INTO, acts as a placeholder?
		PreparedStatement ps = c.prepareStatement(userdata);
		
		//This should return the data I send to the DB
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ps.setDouble(3, u.getAccountBalance());
		ps.setString(4, u.getPersonalInformation());
		ps.execute();
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}
}
