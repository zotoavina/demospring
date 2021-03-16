package com.example.demo.service;

import com.example.demo.exceptions.EtAuthException;
import com.example.demo.model.User;

public interface UserService {
	
	User validateUser(String  email, String password) throws EtAuthException;
	
	User registerUser(String fname , String lname, String email, String password) throws EtAuthException;
	
	
}
