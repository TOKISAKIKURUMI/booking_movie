package com.sysu.book_movie.bussiness.service;

import java.sql.Date;
import java.util.List;

import com.sysu.book_movie.bussiness.entity.Screening;

public interface ScreeningService {
	public Screening getScreeningById(Integer id);
	public List<Screening> getScreeningsByTime(Date time);
	public void addScreening(Screening screening);
	public void updateScreening(Screening screening);
	public void deleteScreening(Integer id);
	public List<Screening> getScreeningsByCimema(String cimemaName);
	public List<Screening> getScreeningsByMovie(String movieName);
}
