package com.example.course.dao;

import java.io.Serializable;
import java.util.List;

import com.example.course.entities.Posts;

public interface Post {

	public Serializable insert(Posts posts);

	public List<Posts> select();

	public Posts loadById(int postid);
	
	public void delete(int postid);
	
	public List<Posts> getPostsByTheme(String theme);
	
	public List<Posts> getPostsByAuthor(String username);
	
}
