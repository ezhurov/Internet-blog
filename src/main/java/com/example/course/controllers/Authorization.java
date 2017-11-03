package com.example.course.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Authorization {

	@RequestMapping("/authorization.html")
	public String authorization(@RequestParam(value="error", required=false) String error, Model model, Locale locale) {

		if (error != null) {
			model.addAttribute("error", (locale.getLanguage().equals("en") ? "Invalid username or password" : "Некорректный логин или пароль"));
		}
		
		return "WEB-INF/pages/authorization.jsp";
		
	}
	
}
