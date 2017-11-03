package com.example.course.dao;

import java.util.List;

import com.example.course.entities.Users;

public interface User {

	public void insert(Users users);
	
	public void update(Users users);
	
	public Users getUserByUsername(String username);
	
	public List<Users> selectRoleUser();
	
}
