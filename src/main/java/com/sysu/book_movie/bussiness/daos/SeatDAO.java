package com.sysu.book_movie.bussiness.daos;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Seat;

public interface SeatDAO {
	public void addSeat(Seat seat);
	public void updateSeat(Seat seat);
	public Seat getSeatById(Integer id);
	public List<Seat> getAllSeat();
}
