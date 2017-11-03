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

import com.example.course.entities.Users;
import com.example.course.services.UserService;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class ChangePassword {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/changepassword.html")
	public String changepassword(Model model) {
		
		return "WEB-INF/pages/changepassword.jsp";
		
	}
	
	@RequestMapping("/savepassword.html")
	public String savepassword(@Valid Users user, BindingResult bindingResult,
			@RequestParam("oldpassword") String oldPassword, @RequestParam("password") String password, Model model) {
		
		if (bindingResult.hasFieldErrors("password")) {
			model.addAttribute("errorpassword", "Некорректный пароль");
			return "WEB-INF/pages/changepassword.jsp";
		}
		
		String message = userService.changepassword(SecurityContextHolder.getContext().getAuthentication().getName(), oldPassword, password);
		
		if (message.isEmpty()) {
			return "WEB-INF/pages/authorization.jsp";
		} else {
			model.addAttribute("erroroldpassword", message);
			return "WEB-INF/pages/changepassword.jsp";
		}
		
	}
	
}
