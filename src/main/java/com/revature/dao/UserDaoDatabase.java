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
			userList.add(new User(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4)));
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
				user.setPersonalInformation(rs.getString(3));
				user.setBalance(rs.getDouble(4));
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
		String userdata = "INSERT INTO users(username, password,accountinfo, balance) values"
				+"(?,?,?,?)";
		//Question marks align to my INSERT INTO, acts as a placeholder?
		PreparedStatement ps = c.prepareStatement(userdata);
		
		//This should return the data I send to the DB
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getPersonalInformation());
		ps.setDouble(4, u.getBalance());
		ps.execute();
	}

	@Override
	public void updateUser(User u) {
		try {
			Connection c = cUtil.getConnection();
			String updatedata = "UPDATE users SET username = ?, password = ?,  accountinfo = ?, balance = ?"
			+ "WHERE users.username = ?";
			
			PreparedStatement ps = c.prepareStatement(updatedata);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getPersonalInformation());	
			ps.setDouble(4, u.getBalance());	
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(User u) {
		try {
			Connection c = cUtil.getConnection();
			String deleteuser = "DELETE FROM users WHERE users.username = ?";
			PreparedStatement ps = c.prepareStatement(deleteuser);
			ps.setString(1, u.getUsername());
			ps.execute();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deposit(User u) {
		try {

			Connection c = cUtil.getConnection();
			
			String deposit = "UPDATE users SET balance = balance + ? WHERE username = ?";
			
			PreparedStatement ps = c.prepareStatement(deposit);
			ps.setDouble(1, u.getBalance());
			ps.setString(2, u.getUsername());
			ps.execute();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
		@Override
		public void withdraw(User u) {
			try {

				Connection c = cUtil.getConnection();
				
				String deposit = "UPDATE users SET balance = balance - ? WHERE username = ?";
				
				PreparedStatement ps = c.prepareStatement(deposit);
				ps.setDouble(1, u.getBalance());
				ps.setString(2, u.getUsername());
				ps.execute();
			} 
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
			@Override
			public void transfer(User u) {
				try {

					Connection c = cUtil.getConnection();
					
					String deposit = "UPDATE users SET balance =  ? WHERE username = ?";
					
					PreparedStatement ps = c.prepareStatement(deposit);
					ps.setDouble(1, u.getBalance());
					ps.setString(2, u.getUsername());
					ps.execute();
				} 
				catch(SQLException e) {
					e.printStackTrace();
				}
		
	}
}
