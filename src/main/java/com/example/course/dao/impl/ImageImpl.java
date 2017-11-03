package com.example.course.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.course.dao.Image;
import com.example.course.entities.Images;

@Repository
public class ImageImpl implements Image {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Images images) {

		Session session = sessionFactory.getCurrentSession();
		session.save(images);
		
	}

	@SuppressWarnings("all")
	public List<Images> selectByPostId(int postid) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Images WHERE post = (FROM Posts WHERE id = :postid)");
		query.setParameter("postid", postid);
		return query.getResultList();
		
	}

}
