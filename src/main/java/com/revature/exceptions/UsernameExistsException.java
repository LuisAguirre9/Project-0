package com.revature.exceptions;

public class UsernameExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsernameExistsException(){
		super("Username Already Exists");
	}
}
