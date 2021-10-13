package com.revature.models;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String personalInformation;
	private Double balance;
	
	public User(String username, String password, String personalInformation, Double balance) {
		this.username = username;
		this.password = password;
		this.personalInformation = personalInformation;
		this.balance = balance;
	}
	
	public User() {
	
	}

	public String getUsername(){
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPersonalInformation(){
		return personalInformation;
	}
	public void setPersonalInformation(String personalInformation) {
		this.personalInformation = personalInformation;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", personalInformation= "+personalInformation+", balance= "+balance+"]";
	}
}
