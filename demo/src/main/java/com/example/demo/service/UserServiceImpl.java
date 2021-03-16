package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.EtAuthException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User validateUser(String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		return userRepo.findUserByEmailAndPassword(email, password);
	}

	@Override
	public User registerUser(String fname, String lname, String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		int countEmail = userRepo.countUserByEmail(email);
		if(countEmail > 0) throw new EtAuthException("Votre email existe deja");
		int idUser = userRepo.insertUser(fname, lname, email, password);
		return userRepo.findUserById(idUser);
	}

}
