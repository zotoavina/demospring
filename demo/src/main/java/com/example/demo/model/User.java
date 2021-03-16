package com.example.demo.model;

public class User {
	private int user;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int user, String lastName, String firstName, String email, String password) {
		super();
		this.user = user;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}
	
	public User() {}
	
	
	
	
}
