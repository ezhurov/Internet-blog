package com.example.course.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.course.services.PostService;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class Search {
	
	@Autowired
	private PostService postService;

	@RequestMapping("/search.html")
	public String search(Model model) {
		
		return "WEB-INF/pages/search.jsp";
		
	}
	
	@RequestMapping("/searchresult.html")
	public String searchresult(@RequestParam("subject") String subject, @RequestParam("searchfor") String searchFor, Model model, Locale locale) {
		
		if (searchFor.isEmpty()) {
			model.addAttribute("error", (locale.getLanguage().equals("en") ? "fill this line" : "заполните эту строку"));
			return "WEB-INF/pages/search.jsp";
		}
		
		model.addAttribute("posts", subject.equals("theme") ? postService.getPostsByTheme(searchFor) : postService.getPostsByAuthor(searchFor));
		
		return "WEB-INF/pages/search.jsp";
		
	}
	
}
