package com.example.course.dao;

import java.util.List;

import com.example.course.entities.Likespost;

public interface LikesPost {
	
	public List<Likespost> getLikesByPost(int postid);
	
	public List<Likespost> getLikesByPostAndUsername(int postid, String username);
	
	public void addLikes(Likespost likespost);

}
