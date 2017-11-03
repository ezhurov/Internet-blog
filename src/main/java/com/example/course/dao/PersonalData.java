package com.example.course.dao;

import java.util.List;

import com.example.course.entities.Personaldata;

public interface PersonalData {

	public Personaldata loadById(int userid);
	
	public List<Personaldata> getDataByUser(int userid);
	
	public void save(Personaldata personaldata);
	
	public void update(Personaldata personaldata);
	
}
