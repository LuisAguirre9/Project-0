package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.models.User;

public interface UserDataAccessObject {
	
	List<User> getAllUsers();
	
	User getUserByUsername(String username);
	
	void createUser(User u) throws SQLException;
	
	void updateUser(User u);
	
	void deleteUser(User u);
	
	void deposit(User u);

	void withdraw(User u);

	void transfer(User u);
	
}
