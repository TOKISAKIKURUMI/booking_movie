package com.sysu.book_movie.bussiness.daos;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Hall;

public interface HallDAO {
	public Hall getHallById(Integer id);
	public List<Hall> getHallsByCimema(String cimemaName);
	public void addHall(Hall hall);
	public void updateHall(Hall hall);
    public void deleteHall(Integer id);
}
