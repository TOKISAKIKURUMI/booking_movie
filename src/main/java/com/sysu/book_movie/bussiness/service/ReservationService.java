package com.sysu.book_movie.bussiness.service;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Reservation;

public interface ReservationService {
	public Reservation getReservationById(Integer id);
	public List<Reservation> getAllReservations();
	//ֻ�й���Ա��Ȩ��ʹ�ã���ù��ӿ�
	public void updateReservation(Reservation reservation);
	public void addReservation(Reservation reservation);
	public void deleteReservation(Integer id);
}
