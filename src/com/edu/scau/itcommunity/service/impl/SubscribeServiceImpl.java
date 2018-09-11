package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.SubscribeDao;
import com.edu.scau.itcommunity.entity.Subscribe;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.SubscribeService;

@Service("subscribeService")
public class SubscribeServiceImpl implements SubscribeService {

	@Autowired
	private SubscribeDao subscribeDao;
	@Override
	public boolean save(Subscribe subscribe) {
		// TODO Auto-generated method stub
		try{
			subscribeDao.save(subscribe);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean delete(Subscribe subscribe) {
		// TODO Auto-generated method stub
		try {
			subscribeDao.delete(subscribe);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ArrayList<User> findById(String user_id) {
		// TODO Auto-generated method stub
		return subscribeDao.findById(user_id);
	}

}
