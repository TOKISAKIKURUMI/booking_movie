package com.sysu.book_movie.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public class MyPersistentTokenBasedRememberMeService extends
		PersistentTokenBasedRememberMeServices {

	public MyPersistentTokenBasedRememberMeService(String key,
			UserDetailsService userDetailsService,
			PersistentTokenRepository tokenRepository) {
		super(key, userDetailsService, tokenRepository);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String extractRememberMeCookie(HttpServletRequest request) {
		String rememberMeCookie = super.extractRememberMeCookie(request);
		return rememberMeCookie;
	}
	
	@Override
	public void onLoginSuccess(javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            Authentication successfulAuthentication) {
		super.onLoginSuccess(request, response, successfulAuthentication);
		SecurityContextHolder.getContext().setAuthentication(successfulAuthentication);  
		HttpSession session = request.getSession(true);  
		//在session中存放security context,方便同一个session中控制用户的其他操作  
		session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
		//System.out.print(successfulAuthentication);
	}
	
	@Override
	public String getCookieName() {
		return super.getCookieName();
	}

}
