package com.example.course.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.course.beans.CommentsBean;
import com.example.course.dao.impl.CommentImpl;
import com.example.course.dao.impl.PostImpl;
import com.example.course.dao.impl.UserImpl;
import com.example.course.entities.Comments;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	private Comments comments;
	
	@Autowired
	private CommentImpl commentImpl;
	
	@Autowired
	private UserImpl userImpl;

	@Autowired
	private PostImpl postImpl;
	
	@Autowired
	private Mapper dozer; 
	
	public List<CommentsBean> getComments(String postid) {

		List<Comments> commentsByPostId = commentImpl.selectByPostId(Integer.parseInt(postid));
		List<CommentsBean> resultList  = new ArrayList<>();
		
		for (Comments comment : commentsByPostId) {
			resultList.add(dozer.map(comment, CommentsBean.class));
		}
		
		return resultList;
		
	} 
	
	public void save(String username, String newcomment, String postid) {
		
		comments.setComment(newcomment);
		comments.setDatatime(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
		comments.setUsers(userImpl.getUserByUsername(username));
		comments.setPosts(postImpl.loadById(Integer.parseInt(postid)));
		
		commentImpl.insert(comments);
		
	}
	
	public void delete(String commentid) {
		
		commentImpl.delete(Integer.parseInt(commentid));
		
	}
	
}
