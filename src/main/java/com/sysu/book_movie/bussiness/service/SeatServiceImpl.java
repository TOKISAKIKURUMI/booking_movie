package com.sysu.book_movie.bussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.daos.SeatDAO;
import com.sysu.book_movie.bussiness.entity.Seat;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatDAO seatRespository;

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
        seatRespository.addSeat(seat);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateSeat(Seat seat) {
		// TODO Auto-generated method stub
        seatRespository.updateSeat(seat);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public Seat getSeatById(Integer id) {
		// TODO Auto-generated method stub
		return seatRespository.getSeatById(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Seat> getAllSeat() {
		// TODO Auto-generated method stub
		return seatRespository.getAllSeat();
	}

}
