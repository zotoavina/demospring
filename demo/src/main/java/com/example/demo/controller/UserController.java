package com.example.demo.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Constants;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RequestMapping("/api/users")
@RestController
public class UserController {
	@Autowired 
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> map){
		String email = (String) map.get("email");
		String password = (String) map.get("password");
		User user = userService.validateUser(email, password);
		Map<String, String> ma = new HashMap<>();
		ma.put("message", "Login successfull");
		ma.put("token", generateToken(user));
		return new ResponseEntity(ma, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> map) {
		String fn = (String)map.get("firstName");
		String ln = (String)map.get("lastName");
		String email = (String) map.get("email");
		String password = (String) map.get("password");
		User user = userService.registerUser(fn, ln, email, password);
		Map<String, String> ma = new HashMap<>();
		ma.put("message", "User created successfully");
		ma.put("status", ""+200);
		ma.put("token", generateToken(user));
		return new ResponseEntity(ma, HttpStatus.OK);
	}
	
	private String generateToken(User user){
		long timestamp = System.currentTimeMillis();
		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SERCRET_KEY)
				.setIssuedAt(new Date(timestamp))
				.setExpiration(new Date(timestamp + Constants.VALIDITY)) 
				.claim("iduser", user.getUser() )
				.claim("firstNmae", user.getFirstName())
				.claim("lastName", user.getLastName())
				.claim("email", user.getEmail())
				.compact();
		return token;
	}
	
	
}