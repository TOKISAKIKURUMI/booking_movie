package com.sysu.book_movie.bussiness.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCurrentSession implements CurrentSession {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getCurrentSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}

}
