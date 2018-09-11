package com.edu.scau.itcommunity.service;

import java.util.List;

import com.edu.scau.itcommunity.entity.Logs;

public interface LogsService {
	public boolean save(String user_id);
	public boolean delete(int log_id);
	public List<Logs> find(String user_id);
}
