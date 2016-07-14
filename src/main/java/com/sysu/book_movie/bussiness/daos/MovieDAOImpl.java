package com.sysu.book_movie.bussiness.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.book_movie.bussiness.entity.Movie;
import com.sysu.book_movie.bussiness.entity.MovieType;

@Repository
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	private CurrentSession currentSession;
	
	public Movie getMovieById(Integer id) {
		// TODO Auto-generated method stub
		return (Movie) currentSession.getCurrentSession().get(Movie.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByName(String movieName) {
		// TODO Auto-generated method stub
		Query query = currentSession.getCurrentSession().createQuery("from Movie as movie where movie.movieName=:name");
		query.setString("name", movieName).setCacheable(true);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return currentSession.getCurrentSession().createQuery("from Movie")
				.setCacheable(true).list();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByType(MovieType type) {
		// TODO Auto-generated method stub
		Query query = currentSession.getCurrentSession().createQuery("from Movie as movie where movie.type=:type");
		query.setInteger("type", type.getMovieType()+1).setCacheable(true);
		return query.list();
	}

	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().save(movie);
	}

	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().update(movie);
	}

	public void deleteMovie(Integer id) {
		// TODO Auto-generated method stub
        Movie movie =  getMovieById(id);
        if (movie != null) {
        	currentSession.getCurrentSession().delete(movie);
        }
	}

}
