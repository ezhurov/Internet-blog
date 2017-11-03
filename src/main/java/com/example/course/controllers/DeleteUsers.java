package com.example.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.course.services.UserService;

@Controller
@Secured("ROLE_ADMIN")
public class DeleteUsers {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/deleteusers.html")
	public String deleteusers(Model model) {
		
		model.addAttribute("users", userService.selectRoleUser());
		
		return "WEB-INF/pages/deleteusers.jsp";
		
	}
	
	@RequestMapping("/deleteuser.html")
	public String deleteuser(@RequestParam("username") String username, Model model) {
		
		userService.delete(username);
		
		return "redirect:/deleteusers.html";
		
	}
	
}
