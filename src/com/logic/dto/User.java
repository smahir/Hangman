package com.logic.dto;

public class User {
	private int id;
	private String username;
	private String password;
	

	public User(){
		
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String newPassword) {
		password = newPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String newUsername) {
		username = newUsername;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password="
				+ password + "]"; 
	}
}
