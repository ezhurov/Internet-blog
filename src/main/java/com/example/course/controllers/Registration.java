package com.example.course.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.course.entities.Users;
import com.example.course.services.UserService;

@Controller
public class Registration {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/registration.html")
	public String registration(Model model) {
		
		return "WEB-INF/pages/registration.jsp";
		
	}
	
	@RequestMapping("/saveorvalidate.html")
	public String saveOrValidate(@Valid Users user, BindingResult bindingResult,
			@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, 
			Model model) {
		
		if (bindingResult.hasErrors()) {
			return "WEB-INF/pages/registration.jsp";
		}
		
		userService.save(username, password, email);
		
		return "redirect:/authorization.html";
		
	}
	
}
