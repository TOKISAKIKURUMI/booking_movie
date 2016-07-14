package com.sysu.book_movie.bussiness.daos;

import java.sql.Date;
import java.util.List;

import com.sysu.book_movie.bussiness.entity.Screening;

public interface ScreeningDAO {
	public Screening getScreeningById(Integer id);
	public List<Screening> getScreeningsByTime(Date time);
	public void addScreening(Screening screening);
	public void updateScreening(Screening screening);
	public void deleteScreening(Integer id);
}
