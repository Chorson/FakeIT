package com.edu.scau.itcommunity.dao;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Subscribe;
import com.edu.scau.itcommunity.entity.User;

public interface SubscribeDao {
	public void save(Subscribe subscribe);
	public void delete(Subscribe subscribe);
	public ArrayList<User> findById(String user_id);
}
