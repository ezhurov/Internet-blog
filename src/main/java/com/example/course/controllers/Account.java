package com.example.course.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.course.services.PersonalDataService;
import com.example.course.services.UserService;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class Account {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonalDataService personaldataService;

	@RequestMapping("/account.html")
	public String account(Model model) {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

		model.addAttribute("visible", (roles.contains("ROLE_ADMIN") ? "visible" : "hidden"));
		model.addAttribute("personaldata", personaldataService.getPersonalData(SecurityContextHolder.getContext().getAuthentication().getName()));
		
		return "WEB-INF/pages/account.jsp";
		
	}
	
	@RequestMapping("/deleteaccount.html")
	public String deleteaccount(Model model) {
		
		userService.delete(SecurityContextHolder.getContext().getAuthentication().getName());
		
		return "WEB-INF/pages/authorization.jsp";
		
	}
	
	@RequestMapping("/savepersonaldata.html")
	public String savepersonaldata(@RequestParam("surname") String surname, @RequestParam("name") String name, 
			@RequestParam("patronymic") String patronymic, Model model) {
		
		personaldataService.saveupdate(SecurityContextHolder.getContext().getAuthentication().getName(), surname, name, patronymic);
		
		return "redirect:/account.html";
		
	}
	
}
