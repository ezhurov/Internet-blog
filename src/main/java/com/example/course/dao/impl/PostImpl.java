package com.example.course.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.course.dao.Post;
import com.example.course.entities.Posts;

@Repository
public class PostImpl implements Post {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Serializable insert(Posts posts) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.save(posts);
		
	}

	@SuppressWarnings("all")
	public List<Posts> select() {

		Session session = sessionFactory.getCurrentSession();
		List<Posts> resultList = session.createQuery("SELECT p FROM Posts p").getResultList();

		return resultList;
	
	}

	public Posts loadById(int postid) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Posts) session.get(Posts.class, new Integer(postid));
		
	}

	@SuppressWarnings("all")
	public void delete(int postid) {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("DELETE Likespost WHERE post = (FROM Posts WHERE id = :id)");
		query.setParameter("id", postid);
		query.executeUpdate();
		
		query = session.createQuery("DELETE Comments WHERE posts = (FROM Posts WHERE id = :id)");
		query.setParameter("id", postid);
		query.executeUpdate();
		
		query = session.createQuery("DELETE Images WHERE post = (FROM Posts WHERE id = :id)");
		query.setParameter("id", postid);
		query.executeUpdate();

		query = session.createQuery("DELETE Posts WHERE id = :id");
		query.setParameter("id", postid);
		query.executeUpdate();

	}

	@SuppressWarnings("all")
	public List<Posts> getPostsByTheme(String theme) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Posts WHERE theme = :theme");
		query.setParameter("theme", theme);
		List<Posts> resultList = query.getResultList();
		
		return resultList;

	}

	@SuppressWarnings("all")
	public List<Posts> getPostsByAuthor(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Posts WHERE users = (FROM Users WHERE username = :username)");
		query.setParameter("username", username);
		List<Posts> resultList = query.getResultList();
		
		return resultList;

	}
	
}