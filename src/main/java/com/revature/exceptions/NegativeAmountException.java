package com.revature.exceptions;

public class NegativeAmountException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NegativeAmountException() {
		super("You can NOT deposit a negative amount of cash");
	}

}
