package com.sysu.book_movie.bussiness.daos;

import java.util.List;
import com.sysu.book_movie.bussiness.entity.User;


public interface UserDAO {
	public void addUser(User user);
    public void updateUser(User user);
    public User getUserById(int id);
    public List<User> getUserByName(String userName);
    public void deleteUser(int id);
    public List<User> getAllUsers();
}
