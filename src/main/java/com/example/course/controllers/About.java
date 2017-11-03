package com.example.course.controllers;

import java.util.Locale;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class About {

	@RequestMapping("/about.html")
	public String about(Model model, Locale locale) {
		model.addAttribute("message", (locale.getLanguage().equals("en") ? "Course project, 2017" : "Курсовой проект, 2017"));

		return "WEB-INF/pages/about.jsp";
		
	}
	
}
