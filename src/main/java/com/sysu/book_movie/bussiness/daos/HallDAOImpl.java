package com.sysu.book_movie.bussiness.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.book_movie.bussiness.entity.Hall;

@Repository
public class HallDAOImpl implements HallDAO {

	@Autowired
	private CurrentSession currentSession;
	
	public Hall getHallById(Integer id) {
		// TODO Auto-generated method stub
		return (Hall) currentSession.getCurrentSession().get(Hall.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Hall> getHallsByCimema(String cimemaName) {
		// TODO Auto-generated method stub
		Query query = currentSession.getCurrentSession().createQuery("select hall from Hall as hall inner join hall.cimema as c where c.cimemaName=:cimemaName");
		query.setString("cimemaName", cimemaName).setCacheable(true);
		return query.list();
	}

	public void addHall(Hall hall) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().save(hall);
	}

	public void updateHall(Hall hall) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().update(hall);
	}

	public void deleteHall(Integer id) {
		// TODO Auto-generated method stub
        Hall hall = getHallById(id);
        if (hall != null) {
        	currentSession.getCurrentSession().delete(hall);
        }
	}

}
