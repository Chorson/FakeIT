package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import javax.swing.table.TableStringConverter;

import com.edu.scau.itcommunity.entity.User;

public interface UserService {
	public ArrayList<User> findAll();
	public User findById(String user_id);
	public boolean save(User user);
	public boolean update(User user);
	public ArrayList<User> searchByUsername(String user_name);
	public ArrayList<User> findWhiteUser();
	public int getUserCount();
}
