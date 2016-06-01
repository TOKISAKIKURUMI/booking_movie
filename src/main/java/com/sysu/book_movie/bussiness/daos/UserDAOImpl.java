package com.sysu.book_movie.bussiness.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sysu.book_movie.bussiness.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
    }
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
        getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
        getCurrentSession().update(user);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = null;
        getCurrentSession().setCacheMode(CacheMode.NORMAL);
        //这里不需要使用lazyload,user的数据都比较重要，可以直接从数据库中得到实体
        user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserByName(String userName) {
		// TODO Auto-generated method stub
		List<User> user = new ArrayList<User>();
	    getCurrentSession().setCacheMode(CacheMode.NORMAL);
	    Query query = getCurrentSession().createQuery("from User as user where user.userName=:name");
		query.setString("name", userName);
		query.setCacheable(true);
		user = query.list();
		return user;
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		getCurrentSession().setCacheMode(CacheMode.NORMAL);
		User user = getUserById(id);
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		getCurrentSession().setCacheMode(CacheMode.GET);
		users = getCurrentSession().createQuery("from User").list();
		return users;
	}

}
