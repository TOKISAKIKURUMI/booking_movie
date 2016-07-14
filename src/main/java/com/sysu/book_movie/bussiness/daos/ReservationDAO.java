package com.sysu.book_movie.bussiness.daos;

import java.util.List;

import com.sysu.book_movie.bussiness.entity.Reservation;

public interface ReservationDAO {
	public Reservation getReservationById(Integer id);
	public List<Reservation> getReservationsByUser(String userName);
	public List<Reservation> getAllReservations();
	public List<Reservation> getReservationsByMovie(String movieName);
	//ֻ�й���Ա��Ȩ��ʹ�ã���ù��ӿ�
	public void updateReservation(Reservation reservation);
	public void addReservation(Reservation reservation);
	public void deleteReservation(Integer id);
}
