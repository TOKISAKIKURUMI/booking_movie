package com.sysu.book_movie.bussiness.service;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Reservation;

public interface ReservationService {
	public Reservation getReservationById(Integer id);
	public List<Reservation> getAllReservations();
	//只有管理员有权限使用，最好诡辩接口
	public void updateReservation(Reservation reservation);
	public void addReservation(Reservation reservation);
	public void deleteReservation(Integer id);
}
