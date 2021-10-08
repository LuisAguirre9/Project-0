package com.revature.services;

import java.sql.SQLException;
import com.revature.models.User;
import com.revature.dao.UserDataAccessObject;
import com.revature.exceptions.IncorrectUsernamePassword;
import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UsernameExistsException;
import com.revature.logging.Logging;

public class UserService {
		
	private UserDataAccessObject uDAO;

	public UserService(UserDataAccessObject u) {
		this.uDAO = u;
	}
		
		public User signUp(String username, String password, String accountInfo, Double accountBalance, String personalInformation) throws UsernameExistsException{
			
			User u = new User(username, password, accountInfo, accountBalance, personalInformation);
			
			try {
				uDAO.createUser(u);
				Logging.logger.info("Account created successfully");
			} 
			catch(SQLException e) {
				Logging.logger.warn("Username already exists");
				throw new UsernameExistsException();
			}
			return(u);
		}
		
		public User signIn(String username, String password) throws UserNotFoundException, IncorrectUsernamePassword{
			
			User u = uDAO.getUserByUsername(username);
			
			if(!u.getUsername().equals(username)) {
				Logging.logger.warn("User tried to log into an account that doesn't exsist");
				throw new UserNotFoundException();
			}
			else if(!u.getPassword().equals(password)) {
				Logging.logger.warn("User tried to log in with an incorrect password/username");
				throw new IncorrectUsernamePassword();
			}
			else {
				Logging.logger.info("User was logged in successfully");
				return u;
			}
		}
}

