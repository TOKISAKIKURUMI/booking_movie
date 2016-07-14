package com.sysu.book_movie.controller;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysu.book_movie.bussiness.entity.Movie;
import com.sysu.book_movie.bussiness.entity.Screening;
import com.sysu.book_movie.bussiness.service.ScreeningService;

@Controller
public class FindByFile {

	@Autowired
	private ScreeningService screeningService;

	@Autowired
	private Movie movie;

	@ModelAttribute("allScreening")
	public List<Screening> allScreening() {
		return this.screeningService.getScreeningByMovie(this.movie.getMovieName());
	}

	@ModelAttribute("movieDesc")
	public String movieDesc() {
		return this.movie.getDescrition();
	}

	@RequestMapping(value = "/ChooseSeat", method = RequestMethod.GET)
	public String chooseSeat(Screening screening) {
		this.screeningService.updateScreening(screening);
		return "ChooseSeat";
	}

}