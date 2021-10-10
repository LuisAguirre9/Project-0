package com.revature.models;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private Double accountBalance;
	private String personalInformation;
	
	public User() {
		super();
	}
	
	public User(String username, String password, Double accountBalance, String personalInformation) {
		this.username = username;
		this.password = password;
		this.accountBalance = accountBalance;
		this.personalInformation = personalInformation;
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
	
	public Double getAccountBalance(){
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getPersonalInformation(){
		return personalInformation;
	}
	public void setPersonalInformation(String personalInformation) {
		this.personalInformation = personalInformation;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password +", accountBalance= " +accountBalance+ ", personalInformation= "+personalInformation+"]";
	}
}
