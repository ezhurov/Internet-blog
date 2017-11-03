package com.example.course.dao;

import java.util.List;

import com.example.course.entities.Comments;

public interface Comment {

	public List<Comments> selectByPostId(int postid);
	
	public void insert(Comments comments);
	
	public void delete(int commentid);
	
}
