package com.sysu.book_movie.bussiness.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.book_movie.bussiness.entity.Seat;

@Repository
public class SeatDAOImpl implements SeatDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
    }
	
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
        getCurrentSession().save(seat);
	}

	public void updateSeat(Seat seat) {
		// TODO Auto-generated method stub
        getCurrentSession().update(seat);
	}

	public Seat getSeatById(Integer id) {
		// TODO Auto-generated method stub
		Seat seat = null;
		seat = (Seat) getCurrentSession().get(Seat.class, id);
		return seat;
	}

	@SuppressWarnings("unchecked")
	public List<Seat> getAllSeat() {
		// TODO Auto-generated method stub
		List<Seat> seats = new ArrayList<Seat>();
		seats = getCurrentSession().createQuery("from Seat").list();
		return seats;
	}

}
