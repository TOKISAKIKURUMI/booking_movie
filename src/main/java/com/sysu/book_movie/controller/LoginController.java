package com.sysu.book_movie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysu.book_movie.bussiness.entity.User;
import com.sysu.book_movie.bussiness.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PersistentTokenBasedRememberMeServices PersistentTokenBasedRememberMeServices;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		if (isRememberMeAuthenticated()) {
			return "redirect:/index";
		}
		return "login";
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getPage(User user) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Register(@Valid User user) {
		user.setUserRole(0);
		userService.addUser(user);
		return "redirect:/login";
	}
	
	private boolean isRememberMeAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication != null ? authentication.getName() : "0");
		System.out.println(RememberMeAuthenticationToken.class);
		System.out.println(authentication.getClass());
		if (authentication == null) {
			return false;
		}
		return false;
	}
	
}
