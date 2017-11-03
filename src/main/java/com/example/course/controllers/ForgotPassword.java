package com.example.course.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.course.entities.Users;
import com.example.course.services.SendEmail;

@Controller
public class ForgotPassword {
	
	@Autowired
	private SendEmail sendEmail;
	
	@Value("#{contextParameters.from}")
	private String from;
	
	@Value("#{contextParameters.passwordFrom}")
	private String passwordFrom;

	@RequestMapping("/forgotpassword.html")
	public String forgotpassword(Model model) {
		
		return "WEB-INF/pages/forgotpassword.jsp";
		
	}
	
	@RequestMapping("/remindOrValidate.html")
	public String remindOrValidate(@Valid Users user, BindingResult bindingResult, @RequestParam("email") String email, 
			Model model, Locale locale) {
		
		if (bindingResult.hasFieldErrors("email")) {
			model.addAttribute("erroremail", (locale.getLanguage().equals("en") ? "Invalid email" : "Некорректный email"));
			return "WEB-INF/pages/forgotpassword.jsp";
		}
		
		if (from.isEmpty() || passwordFrom.isEmpty()) {
			model.addAttribute("error", (locale.getLanguage().equals("en") ? "Specify the sender in the file web.xml" : "Укажите отправителя в файле web.xml"));
			return "WEB-INF/pages/forgotpassword.jsp";
		}
		
		sendEmail.sendEmail(email, from, passwordFrom);
		
		return "redirect:/authorization.html";
		
	}
	
}
