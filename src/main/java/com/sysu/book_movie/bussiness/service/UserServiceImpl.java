package com.sysu.book_movie.bussiness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.sysu.book_movie.bussiness.daos.UserDAO;
import com.sysu.book_movie.bussiness.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userRespository;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void addUser(User user) {
		// TODO Auto-generated method stub
        userRespository.addUser(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=15)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
        userRespository.updateUser(user);
	}
    
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRespository.getUserById(id);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<User> getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userRespository.getUserByName(userName);
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, timeout=30)
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
        userRespository.deleteUser(id);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRespository.getAllUsers();
	}

}
