package com.sysu.book_movie.bussiness.service;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Movie;
import com.sysu.book_movie.bussiness.entity.MovieType;

public interface MovieService {
	public Movie getMovieById(Integer id);
	public List<Movie> getMovieByName(String movieName);
    public List<Movie> getAllMovies();
    public List<Movie> getMovieByType(MovieType type);
    public void addMovie(Movie movie);
    public void updateMovie(Movie movie);
    public void deleteMovie(Integer id);
}
