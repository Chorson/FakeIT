package com.edu.scau.itcommunity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.LogsDao;
import com.edu.scau.itcommunity.entity.Logs;
import com.edu.scau.itcommunity.service.LogsService;

@Service("logService")
public class LogsServiceImpl implements LogsService {

	@Autowired
	private LogsDao logsDao;
	@Override
	public List<Logs> find(String user_id) {
		// TODO Auto-generated method stub
		return logsDao.find(user_id);
	}
	@Override
	public boolean save(String user_id) {
		// TODO Auto-generated method stub
		try {
			logsDao.save(user_id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	@Override
	public boolean delete(int log_id) {
		// TODO Auto-generated method stub
		try {
			logsDao.delete(log_id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}



}
