package com.sysu.book_movie.bussiness.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import com.sysu.book_movie.bussiness.entity.Reservation;
import com.sysu.book_movie.bussiness.entity.User;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
    private CurrentSession currentSession;
	
	public Reservation getReservationById(Integer id) {
		// TODO Auto-generated method stub
		currentSession.getCurrentSession().setCacheMode(CacheMode.NORMAL);
		return (Reservation) currentSession.getCurrentSession().get(Reservation.class, id);
	}

	public List<Reservation> getReservationsByUser(String userName) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		List<Reservation> reservations = new ArrayList<Reservation>();
		reservations = currentSession.getCurrentSession().createQuery("from Reservation")
				.setCacheable(true).list();
		return reservations;
	}

	public List<Reservation> getReservationsByMovie(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().update(reservation);
	}

	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().save(reservation);
	}

	public void deleteReservation(Integer id) {
		// TODO Auto-generated method stub
		Reservation reservation = getReservationById(id);
		if (reservation != null) {
			currentSession.getCurrentSession().delete(reservation);
		}
	}

}
