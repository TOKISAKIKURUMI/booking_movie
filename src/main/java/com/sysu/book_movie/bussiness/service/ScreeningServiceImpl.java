package com.sysu.book_movie.bussiness.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.daos.ScreeningDAO;
import com.sysu.book_movie.bussiness.entity.Cimema;
import com.sysu.book_movie.bussiness.entity.Movie;
import com.sysu.book_movie.bussiness.entity.Screening;

@Service
@Transactional
public class ScreeningServiceImpl implements ScreeningService {

	@Autowired
	private ScreeningDAO screeningRepository;
	
	@Autowired
	private CimemaService cimemaService;
	
	@Autowired
	private MovieService movieService;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public Screening getScreeningById(Integer id) {
		// TODO Auto-generated method stub
		return screeningRepository.getScreeningById(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Screening> getScreeningsByTime(Date time) {
		// TODO Auto-generated method stub
		return screeningRepository.getScreeningsByTime(time);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addScreening(Screening screening) {
		// TODO Auto-generated method stub
        screeningRepository.addScreening(screening);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateScreening(Screening screening) {
		// TODO Auto-generated method stub
        screeningRepository.updateScreening(screening);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void deleteScreening(Integer id) {
		// TODO Auto-generated method stub
        screeningRepository.deleteScreening(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Screening> getScreeningsByCimema(String cimemaName) {
		// TODO Auto-generated method stub
		List<Screening> screenings = new ArrayList<Screening>();
		List<Cimema> cimemas = cimemaService.getCimemaByName(cimemaName);
		for (Cimema cimema : cimemas) {
			screenings.addAll(cimema.getScreenings());
		}
		return screenings;
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Screening> getScreeningsByMovie(String movieName) {
		// TODO Auto-generated method stub
		List<Screening> screenings = new ArrayList<Screening>();
		List<Movie> movies = movieService.getMovieByName(movieName);
		for (Movie movie : movies) {
			screenings.addAll(movie.getScreening());
		}
		return screenings;
	}

}
