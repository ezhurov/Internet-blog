package com.example.course.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.course.services.PostService;

@Controller
public class Index {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping({"/", "/index.html"})
	public String index(Model model) {
		
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			return "redirect:/authorization.html";
		}
		
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		model.addAttribute("visible", (roles.contains("ROLE_ADMIN") ? "visible" : "hidden"));
		model.addAttribute("posts", postService.getPosts());
		
		return "WEB-INF/pages/index.jsp";
		
	}
	
	@RequestMapping("/deletepost.html")
	public String deletepost(@RequestParam("postid") String postid, Model model) {
		
		postService.delete(postid);
		
		return "redirect:/index.html";
		
	}
	
}
