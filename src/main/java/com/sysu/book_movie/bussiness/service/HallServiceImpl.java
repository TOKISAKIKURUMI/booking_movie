package com.sysu.book_movie.bussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.daos.HallDAO;
import com.sysu.book_movie.bussiness.entity.Hall;

@Service
@Transactional
public class HallServiceImpl implements HallService {

	@Autowired
	private HallDAO hallRepository;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public Hall getHallById(Integer id) {
		// TODO Auto-generated method stub
		return hallRepository.getHallById(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Hall> getHallsByCimema(String cimemaName) {
		// TODO Auto-generated method stub
		return hallRepository.getHallsByCimema(cimemaName);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addHall(Hall hall) {
		// TODO Auto-generated method stub
        hallRepository.addHall(hall);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateHall(Hall hall) {
		// TODO Auto-generated method stub
        hallRepository.updateHall(hall);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void deleteHall(Integer id) {
		// TODO Auto-generated method stub
        hallRepository.deleteHall(id);
	}

}
