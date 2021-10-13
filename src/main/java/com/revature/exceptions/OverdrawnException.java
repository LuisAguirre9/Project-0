package com.revature.exceptions;

public class OverdrawnException extends Exception{
	private static final long serialVersionUID = 1L;

	public OverdrawnException() {
		super("You can NOT withdraw more money than what is in your account");
	}
}
