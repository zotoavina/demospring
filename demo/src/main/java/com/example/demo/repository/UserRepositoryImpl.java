package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.exceptions.EtAuthException;
import com.example.demo.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private static final String INSERT_USER = "insert into users(firstName , lastName, email,password)"
			+ " values (?, ?, ?, ?)";
	private static final String SQL_COUNT_BY_EMAIL = "select count(*) from users where email = ?";
	private static final String SQL_FIND_BY_ID = "select * from users where idUser = ?";
	private static final String SQL_FIND_BY_EMAIL= "select * from users where email = ?";
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int insertUser(String fn, String ln, String email, String pass) throws EtAuthException {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update( connection -> {
				PreparedStatement ps =  connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, fn);
				ps.setString(2, ln);
				ps.setString(3, email);
				ps.setString(4, pass);
				System.out.println(ps.toString());
				return ps;
			}, keyHolder);
			return (int) keyHolder.getKeys().get("idUser");
		}catch(Exception e) {
			throw new EtAuthException("Invalid details. Failed to create user");
		}
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) throws EtAuthException {
		try {
			User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[] {email}, userRowMapper);
			if(user.getPassword().compareTo(password) != 0)
				throw new EtAuthException("Invalid password");
			return user;
		}catch(EmptyResultDataAccessException e) {
			throw new EtAuthException("Invalid email or password");
		}
	}
	

	@Override
	public int countUserByEmail(String email) {
		return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[] {email}, Integer.class);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public User findUserById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[] {id}, userRowMapper);
	}
	
	private RowMapper<User> userRowMapper = ((rs, rowNum)->{
		return new User( rs.getInt("idUser"),
				rs.getString("firstName"),
				rs.getString("lastName"),
				rs.getString("email"),
				rs.getString("password"));	
	});
	
	
}
