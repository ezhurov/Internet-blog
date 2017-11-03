package com.example.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.course.dao.impl.UserImpl;
import com.example.course.entities.Users;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private Users users;
	
	@Autowired
	private UserImpl userImpl;
	
	public void save(String username, String password, String email) {
		
		users.setUsername(username);
		users.setPassword(password);
		users.setEmail(email);
		users.setEnabled(1);
		users.setRole("ROLE_USER");
		
		userImpl.insert(users);
		
	}
	
	public void delete(String username) {
		
		Users user = userImpl.getUserByUsername(username);
		
		user.setEnabled(0);

		userImpl.update(user);
			
	}
	
	public String changepassword(String username, String oldPassword, String password) {
		
		Users user = userImpl.getUserByUsername(username);
		
		if (oldPassword.trim().equals(user.getPassword())) {
			
			user.setPassword(password);
		
			userImpl.update(user);
				
			return "";
				
		} else {
				
			return "Некорректный пароль";
				
		}
		
	}
	
	public List<Users> selectRoleUser() {
		
		return userImpl.selectRoleUser();
		
	}
		
}
