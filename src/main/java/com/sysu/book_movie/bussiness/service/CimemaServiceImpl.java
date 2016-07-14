package com.sysu.book_movie.bussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.daos.CimeraDAO;
import com.sysu.book_movie.bussiness.entity.Cimema;

@Service
@Transactional
public class CimemaServiceImpl implements CimemaService {

	@Autowired
	private CimeraDAO cimemaRepository;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public Cimema getCimemaById(Integer id) {
		// TODO Auto-generated method stub
		return cimemaRepository.getCimemaById(id);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Cimema> getCimemaByName(String cimemaName) {
		// TODO Auto-generated method stub
		return cimemaRepository.getCimemaByName(cimemaName);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Cimema> getCimemasByCity(String city) {
		// TODO Auto-generated method stub
		return cimemaRepository.getCimemasByCity(city);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<Cimema> getCimemaByRegion(String region) {
		// TODO Auto-generated method stub
		return cimemaRepository.getCimemaByRegion(region);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addCimema(Cimema cimema) {
		// TODO Auto-generated method stub
        cimemaRepository.addCimema(cimema);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateCimema(Cimema cimema) {
		// TODO Auto-generated method stub
        cimemaRepository.updateCimema(cimema);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void deleteCimema(Integer id) {
		// TODO Auto-generated method stub
        cimemaRepository.deleteCimema(id);
	}

}
