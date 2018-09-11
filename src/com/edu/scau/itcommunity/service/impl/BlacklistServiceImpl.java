package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.BlacklistDao;
import com.edu.scau.itcommunity.entity.Blacklist;
import com.edu.scau.itcommunity.service.BlacklistService;

@Service("blacklistService")
public class BlacklistServiceImpl implements BlacklistService {

	@Autowired
	private BlacklistDao blacklistDao;
	@Override
	public void save(Blacklist blacklist) {
		// TODO Auto-generated method stub
     blacklistDao.save(blacklist);
	}

	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		blacklistDao.delete(user_id);
	}

	@Override
	public ArrayList<Blacklist> findAll() {
		// TODO Auto-generated method stub
		return blacklistDao.findAll();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return blacklistDao.getCount();
	}

}
