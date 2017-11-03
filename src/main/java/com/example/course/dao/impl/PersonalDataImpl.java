package com.example.course.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.course.dao.PersonalData;
import com.example.course.entities.Personaldata;

@Repository
public class PersonalDataImpl implements PersonalData {

	@Autowired
	private SessionFactory sessionFactory;

	public Personaldata loadById(int userid) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Personaldata) session.get(Personaldata.class, new Integer(userid));
		
	}

	@SuppressWarnings("all")
	public List<Personaldata> getDataByUser(int userid) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Personaldata WHERE user = (FROM Users WHERE id = :id)");
		query.setParameter("id", userid);
		List<Personaldata> resultList = query.getResultList();
		
		return resultList;
		
	}
	
	public void save(Personaldata personaldata) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(personaldata);
		
	}
	
	public void update(Personaldata personaldata) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(personaldata);
		
	}
	
}