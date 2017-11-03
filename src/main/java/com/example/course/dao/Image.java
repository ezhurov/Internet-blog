package com.example.course.dao;

import java.util.List;

import com.example.course.entities.Images;

public interface Image {

	public void insert(Images images);
	
	public List<Images> selectByPostId(int postid);
	
}
