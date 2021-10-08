package com.revature.exceptions;

public class IncorrectUsernamePassword extends Exception{
	private static final long serialVersionUID = 1L;

	public IncorrectUsernamePassword() {
		super("Username or Password is incorrect");
	}
	
}
