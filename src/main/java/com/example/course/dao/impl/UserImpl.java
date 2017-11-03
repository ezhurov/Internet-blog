package com.example.course.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.course.dao.User;
import com.example.course.entities.Users;

@Repository
public class UserImpl implements User {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(Users users) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(users);
		
	}

	public void update(Users users) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(users);

	}
	
	@SuppressWarnings("all")
	public Users getUserByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Users WHERE username = :username");
		query.setParameter("username", username);
		List<Users> resultList = query.getResultList();
		
		return resultList.get(0);
		
	}
	
	@SuppressWarnings("all")
	public Users getUserByEmail(String email) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Users WHERE email = :email");
		query.setParameter("email", email);
		List<Users> resultList = query.getResultList();
		
		try {
			return resultList.get(0);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("all")
	public List<Users> selectRoleUser() {

		Session session = sessionFactory.getCurrentSession();
		List<Users> resultList = session.createQuery("FROM Users WHERE role = 'ROLE_USER' AND enabled = 1").getResultList();
		
		return resultList;

	}
	
}