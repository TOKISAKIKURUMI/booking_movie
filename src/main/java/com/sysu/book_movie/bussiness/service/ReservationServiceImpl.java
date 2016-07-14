package com.sysu.book_movie.bussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.daos.ReservationDAO;
import com.sysu.book_movie.bussiness.entity.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationRepository;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public Reservation getReservationById(Integer id) {
		// TODO Auto-generated method stub
		return reservationRepository.getReservationById(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return reservationRepository.getAllReservations();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
        reservationRepository.updateReservation(reservation);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
        reservationRepository.addReservation(reservation);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void deleteReservation(Integer id) {
		// TODO Auto-generated method stub
        reservationRepository.deleteReservation(id);
	}

}
