package com.example.demo.repository;

import com.example.demo.exceptions.EtAuthException;
import com.example.demo.model.User;

public interface UserRepository {

	int insertUser(String fn, String ln, String email, String pass)throws EtAuthException;
	
	User findUserByEmailAndPassword(String email, String password)throws EtAuthException;
	
	int countUserByEmail(String email);
	
	User findUserById(int id);
	
}
