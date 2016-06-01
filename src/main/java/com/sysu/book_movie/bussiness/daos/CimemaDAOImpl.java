package com.sysu.book_movie.bussiness.daos;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.book_movie.bussiness.entity.Cimema;

@Repository
public class CimemaDAOImpl implements CimeraDAO {

	@Autowired
	private CurrentSession currentSession;
	
	public Cimema getCimemaById(Integer id) {
		// TODO Auto-generated method stub
		return (Cimema) currentSession.getCurrentSession().get(Cimema.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cimema> getCimemaByName(String cimemaName) {
		// TODO Auto-generated method stub
		Query query = currentSession.getCurrentSession().createQuery("from Cimema as cimema where cimema.cimemaName=:name");
		query.setString("name", cimemaName).setCacheable(true);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cimema> getCimemasByCity(String city) {
		// TODO Auto-generated method stub
		Query query = currentSession.getCurrentSession().createQuery("from Cimema as cimema where cimema.city=:city");
		query.setString("city", city).setCacheable(true);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Cimema> getCimemaByRegion(String region) {
		// TODO Auto-generated method stub
		Query query = currentSession.getCurrentSession().createQuery("from Cimema as cimema where cimema.region=:region group by cimema.city");
		query.setString("region", region).setCacheable(true);
		return query.list();
	}

	public void addCimema(Cimema cimema) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().save(cimema);
	}

	public void updateCimema(Cimema cimema) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().update(cimema);
	}

	public void deleteCimema(Integer id) {
		// TODO Auto-generated method stub
		Cimema cimema = getCimemaById(id);
        if (cimema != null) {
        	currentSession.getCurrentSession().delete(cimema);
        }
	}

}
