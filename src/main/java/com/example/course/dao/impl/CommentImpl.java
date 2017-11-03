package com.example.course.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.course.dao.Comment;
import com.example.course.entities.Comments;

@Repository
public class CommentImpl implements Comment {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("all")
	public List<Comments> selectByPostId(int postid) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Comments WHERE posts = (FROM Posts WHERE id = :postid) ORDER BY id DESC");
		query.setParameter("postid", postid);
		
		return query.getResultList();
	
	}

	public void insert(Comments comments) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(comments);
		
	}
	
	@SuppressWarnings("all")
	public void delete(int commentid) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE Comments WHERE id = :id");
		query.setParameter("id", commentid);
		query.executeUpdate();
		
	}

}