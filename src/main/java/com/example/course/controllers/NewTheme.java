package com.example.course.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.course.entities.Posts;
import com.example.course.services.ImagesService;
import com.example.course.services.PostService;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class NewTheme {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ImagesService imagesService;

	@RequestMapping("/newtheme.html")
	public String newtheme() {
		
		return "WEB-INF/pages/newtheme.jsp";
		
	}
	
	@RequestMapping("/addtheme.html")
	public String addTheme(@Valid Posts posts, BindingResult bindingResult,
			@RequestParam("theme") String theme, @RequestParam("post") String post,
			@RequestParam("file") MultipartFile file, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "WEB-INF/pages/newtheme.jsp";
		}
		
		int postid = postService.save(SecurityContextHolder.getContext().getAuthentication().getName(), theme, post);
		
		if (! file.isEmpty()) {
			imagesService.save(postid, file);
		} 	
		
		return "redirect:/index.html";
		
	}
	
}
