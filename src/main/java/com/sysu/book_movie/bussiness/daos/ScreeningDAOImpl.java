package com.sysu.book_movie.bussiness.daos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sysu.book_movie.bussiness.entity.Screening;

@Repository
public class ScreeningDAOImpl implements ScreeningDAO {
	
	@Autowired
	private CurrentSession currentSession;

	public Screening getScreeningById(Integer id) {
		// TODO Auto-generated method stub
		currentSession.getCurrentSession().setCacheMode(CacheMode.NORMAL);
		return (Screening) currentSession.getCurrentSession().get(Screening.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Screening> getScreeningsByTime(Date time) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String targetTime = formatter.format(time);
		currentSession.getCurrentSession().setCacheMode(CacheMode.NORMAL);
	    Query query = currentSession.getCurrentSession().createQuery("from Screening as screening where screening.time=:time");
	    query.setString("time", targetTime);
		query.setCacheable(true);		
		return query.list();
	}

	public void addScreening(Screening screening) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().save(screening);
	}

	public void updateScreening(Screening screening) {
		// TODO Auto-generated method stub
        currentSession.getCurrentSession().update(screening);
	}

	public void deleteScreening(Integer id) {
		// TODO Auto-generated method stub
        Screening screening = getScreeningById(id);
        if (screening != null) {
        	currentSession.getCurrentSession().delete(screening);
        }
	}

}
