package com.sysu.book_movie.bussiness.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.book_movie.bussiness.entity.Seat;

@Repository
public class SeatDAOImpl implements SeatDAO {

	@Autowired
	private CurrentSession currentSession;
	
	
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().save(seat);
	}

	public void updateSeat(Seat seat) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().update(seat);
	}

	public Seat getSeatById(Integer id) {
		// TODO Auto-generated method stub
		Seat seat = null;
		seat = (Seat) currentSession.getCurrentSession().get(Seat.class, id);
		return seat;
	}

	@SuppressWarnings("unchecked")
	public List<Seat> getAllSeat() {
		// TODO Auto-generated method stub
		List<Seat> seats = new ArrayList<Seat>();
		seats = currentSession.getCurrentSession().createQuery("from Seat").list();
		return seats;
	}

}
