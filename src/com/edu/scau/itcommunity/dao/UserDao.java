package com.edu.scau.itcommunity.dao;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.User;

public interface UserDao {
	public ArrayList<User> findAll();
	public User findById(String user_id);
	public void save(User user);
	public void update(User user);
	public ArrayList<User> searchByUsername(String user_name);
	public ArrayList<User> findWhiteUser();
	public int getCount();
}
