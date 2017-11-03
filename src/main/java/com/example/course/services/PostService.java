package com.example.course.services;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.course.beans.PostsBean;
import com.example.course.dao.impl.PostImpl;
import com.example.course.dao.impl.UserImpl;
import com.example.course.entities.Posts;

@Service
@Transactional
public class PostService {

	@Autowired
	private Posts posts;
	
	@Autowired
	private PostImpl postImpl;
	
	@Autowired
	private UserImpl userImpl;
	
	@Autowired
	private Mapper dozer;
	
	@Value("#{contextParameters.countOfPosts}")
	private String countOfPosts;
	
	public int save(String username, String theme, String post) {
		
		posts.setTheme(theme);
		posts.setPost(post);
		posts.setDatatime(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
		posts.setUsers(userImpl.getUserByUsername(username));
		
		Serializable postid = postImpl.insert(posts);
		
		return Integer.parseInt(postid.toString());
		
	}

	public List<PostsBean> getPosts() {

		ArrayList<Posts> filterList = new ArrayList<Posts>();
		List<Posts> listPosts = postImpl.select();
		if (! listPosts.isEmpty()) {
			int min = (listPosts.size() < Integer.parseInt(countOfPosts)) ? listPosts.size() : Integer.parseInt(countOfPosts);

			for (int i = 0; i < min; i++) {
				filterList.add(listPosts.get(i));
			}
		}

		List<PostsBean> resultList = new ArrayList<>();
		for (Posts post : filterList) {
			resultList.add(dozer.map(post, PostsBean.class));
		}
		
		return resultList;
		
	}

	public PostsBean getPostById(int postid) {
		
		Posts postById = postImpl.loadById(postid);
		
		return dozer.map(postById, PostsBean.class);
		
	}
	
	public void delete(String postid) {
		
		postImpl.delete(Integer.parseInt(postid));
		
	}
	
	public List<PostsBean> getPostsByTheme(String theme) {
		
		List<Posts> postsByTheme = postImpl.getPostsByTheme(theme);
		List<PostsBean> resultList = new ArrayList<>();
		for (Posts post : postsByTheme) {
			resultList.add(dozer.map(post, PostsBean.class));
		}
		
		return resultList;
		
	}
	
	public List<PostsBean> getPostsByAuthor(String username) {
		
		List<Posts> postsByAuthor = postImpl.getPostsByAuthor(username);
		List<PostsBean> resultList = new ArrayList<>();
		for (Posts post : postsByAuthor) {
			resultList.add(dozer.map(post, PostsBean.class));
		}
		
		return resultList;
		
	}
	
}
