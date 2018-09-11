package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Subscribe;
import com.edu.scau.itcommunity.entity.User;

public interface SubscribeService {
	public boolean save(Subscribe subscribe);
	public boolean delete(Subscribe subscribe);
	public ArrayList<User> findById(String user_id);
}
