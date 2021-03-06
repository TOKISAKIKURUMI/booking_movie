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

import com.sysu.book_movie.bussiness.entity.User;
import com.sysu.book_movie.bussiness.entity.Movie;
import com.sysu.book_movie.bussiness.entity.Cinema;
import com.sysu.book_movie.bussiness.service.MovieService;
import com.sysu.book_movie.bussiness.service.CinemaService;
import com.sysu.book_movie.util.MyPersistentTokenBasedRememberMeService;

@Controller
public class MainController {
	
	@Autowired
	MyPersistentTokenBasedRememberMeService persistentTokenBasedRememberMeServices;

	@Autowired
	private MovieService movieService;

	@ModelAttribute("allMovies")
	public List<Movie> allMovies() {
		return this.movieService.getAllMovies();
	}

	// if movie is in movieList, then invoke this function
	// else, skip
	@RequestMapping(value = "/FindByFile", method = RequestMethod.GET)
	public String findByFile(Movie movie) {
		return "FindByFile"
	}

	// if cinema is in cinemaList, then invoke this function
	// else, skip
	@RequestMapping(value = "/FindByCinema", method = RequestMethod.GET)
	public String findByCinema(Cinema cinema) {
		return "FindByCinema"
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String IndexPage(User user, HttpServletRequest req) {
		String value = "78";
		isRememberMeAuthenticated();
		return "index";
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
