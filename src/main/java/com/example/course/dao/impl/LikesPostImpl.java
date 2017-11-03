package com.example.course.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.course.dao.LikesPost;
import com.example.course.entities.Likespost;

@Repository
public class LikesPostImpl implements LikesPost {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("all")
	public List<Likespost> getLikesByPost(int postid) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Likespost WHERE post = (FROM Posts WHERE id = :id)");
		query.setParameter("id", postid);
		List<Likespost> resultList = query.getResultList();
		
		return resultList;
		
	}
	
	@SuppressWarnings("all")
	public List<Likespost> getLikesByPostAndUsername(int postid, String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Likespost WHERE (post = (FROM Posts WHERE id = :postid) AND user = (FROM Users WHERE username = :username))");
		query.setParameter("postid", postid);
		query.setParameter("username", username);
		List<Likespost> resultList = query.getResultList();
		
		return resultList;
		
	}
	
	@SuppressWarnings("all")
	public void addLikes(Likespost likespost) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(likespost);
		
	}
	
}