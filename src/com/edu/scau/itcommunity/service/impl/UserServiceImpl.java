package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.BlacklistDao;
import com.edu.scau.itcommunity.dao.UserDao;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlacklistDao blacklistDao;
	@Override
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findById(String user_id) {
		// TODO Auto-generated method stub
		return userDao.findById(user_id);
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try {
			userDao.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		try {
			userDao.update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ArrayList<User> searchByUsername(String user_name) {
		// TODO Auto-generated method stub
		return userDao.searchByUsername("%"+user_name+"%");
	}

	@Override
	public ArrayList<User> findWhiteUser() {
		// TODO Auto-generated method stub
		return userDao.findWhiteUser();
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return (userDao.getCount()-blacklistDao.getCount()-1);
	}

}
