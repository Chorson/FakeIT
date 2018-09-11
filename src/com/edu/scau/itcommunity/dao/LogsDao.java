package com.edu.scau.itcommunity.dao;

import java.util.List;

import com.edu.scau.itcommunity.entity.Logs;

public interface LogsDao {
	public void save(String user_id);
	public void delete(int log_id);
	public List<Logs> find(String user_id);
}
