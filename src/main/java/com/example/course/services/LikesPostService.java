package com.example.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.course.dao.impl.LikesPostImpl;
import com.example.course.dao.impl.PostImpl;
import com.example.course.dao.impl.UserImpl;
import com.example.course.entities.Likespost;

@Service
@Transactional
public class LikesPostService {

	@Autowired
	private LikesPostImpl likesPostImpl;
	
	@Autowired
	private PostImpl postImpl;

	@Autowired
	private UserImpl userImpl;
	
	@Autowired
	private Likespost likespost;
	
	public int addLikes(String postid, String username) {
		
		List<Likespost> likesByPostAndUsername = likesPostImpl.getLikesByPostAndUsername(Integer.parseInt(postid), username);
		List<Likespost> likesByPost = likesPostImpl.getLikesByPost(Integer.parseInt(postid));
		
		if (! likesByPost.isEmpty()) {
			if (! likesByPostAndUsername.isEmpty()) {
				return likesByPost.size();
			} else {
				likespost.setLikes(1);
				likespost.setPost(postImpl.loadById(Integer.parseInt(postid)));
				likespost.setUser(userImpl.getUserByUsername(username));
				
				likesPostImpl.addLikes(likespost);

				return likesByPost.size() + 1;
			}
		} else {
			likespost.setLikes(1);
			likespost.setPost(postImpl.loadById(Integer.parseInt(postid)));
			likespost.setUser(userImpl.getUserByUsername(username));
			
			likesPostImpl.addLikes(likespost);
			
			return 1;
		}
		
	}
	
	public int getLikes(String postid) {
		
		List<Likespost> likesByPost = likesPostImpl.getLikesByPost(Integer.parseInt(postid));
		
		if (likesByPost.isEmpty()) {
			return 0;
		} else {
			return likesByPost.size();
		}
		
	}
	
}
