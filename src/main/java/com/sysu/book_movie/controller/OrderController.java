package com.sysu.book_movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysu.book_movie.bussiness.entity.Reservation;
import com.sysu.book_movie.bussiness.service.ReservationService;
import com.sysu.book_movie.util.MyPersistentTokenBasedRememberMeService;

@Controller
public class OrderController {
	
	@Autowired
	private ReservationService reservationService;

	@ModelAttribute("getOrder")
	public Reservation getOrder() {
		// according to 'user_id' and 'screening_id'
	}

	@RequestMethod(value = "/index", method = RequestMethod.POST)
	public String confirmOrder(Reservation reservation) {
		this.reservationService.addReservation(reservation);
		return "index";
	}

}
