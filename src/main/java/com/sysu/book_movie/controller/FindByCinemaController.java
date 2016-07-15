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

import com.sysu.book_movie.bussiness.entity.Cinema;
import com.sysu.book_movie.bussiness.entity.Screening;
import com.sysu.book_movie.bussiness.service.ScreeningService;

@Controller
public class FindByCinemaController {

	@Autowired
	private ScreeningService screeningService;

	@Autowired
	private Cinema cinema;

	@ModelAttribute("allScreening")
	public List<Screening> allScreening() {
		return this.screeningService.getScreeningByCinema(this.cinema.getCinemaName());
	}

	@ModelAttribute("cinemaDesc")
	public String cinemaDesc() {
		return this.cinema.getDescrption();
	}

	@RequestMapping(value = "/ChooseSeat", method = RequestMethod.GET)
	public String chooseSeat(Screening screening) {
		this.screeningService.updateScreening(screening);
		return "ChooseSeat";
	}

}