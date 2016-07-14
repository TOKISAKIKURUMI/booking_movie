package com.sysu.book_movie.bussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.daos.MovieDAO;
import com.sysu.book_movie.bussiness.entity.Movie;
import com.sysu.book_movie.bussiness.entity.MovieType;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDAO movieRepository;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public Movie getMovieById(Integer id) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMovieByName(String movieName) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByName(movieName);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovies();
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Movie> getMovieByType(MovieType type) {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByType(type);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
        movieRepository.addMovie(movie);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
        movieRepository.updateMovie(movie);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void deleteMovie(Integer id) {
		// TODO Auto-generated method stub
        movieRepository.deleteMovie(id);
	}

}
