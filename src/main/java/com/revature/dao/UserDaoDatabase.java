package com.revature.dao;

import java.sql.Connection;
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
			userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5)));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(User u) throws SQLException {
		// TODO Auto-generated method stub
		
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
