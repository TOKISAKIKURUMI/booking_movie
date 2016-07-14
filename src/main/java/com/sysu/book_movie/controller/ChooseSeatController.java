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

import com.sysu.book_movie.bussiness.entity.Seat;
import com.sysu.book_movie.bussiness.entity.Cinema;
import com.sysu.book_movie.bussiness.service.SeatService;

@Controller
public class ChooseSeatController {

	@Autowired
	private SeatService seatService;

	@Autowired
	private Cinema cinema;

	@ModelAttribute("allSeats")
	public List<Seat> allSeats() {
		return this.seatService.getAllSeat();
	}

	@ModelAttribute("cinemaDesc")
	public String cinemaDesc() {
		return this.cinema.getDescrption();
	}

	@RequestMapping(value = "/ChooseSeat", params = {"bookSeat"})
	public String bookSeat(Seat seat) {
		// idle
		if (seat.getSeatState().getSstatus().getStatus() == "idle")
			seat.getSeatState().setSstatus(new SeatStatus("selled"));

		return "ChooseSeat";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String submitOrder(Seat seat) {
		// if none of seats changed, do nothing
		// or submit
		if (seat.getSeatState().getSstatus().getStatus() == "selled")
			this.seatService.updateSeat(seat);
		return "redirect:/order"
	}
}