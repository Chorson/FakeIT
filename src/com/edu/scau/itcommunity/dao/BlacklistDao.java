package com.edu.scau.itcommunity.dao;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Blacklist;

public interface BlacklistDao {
	public void save(Blacklist blacklist);
	public void delete(String user_id);
	public ArrayList<Blacklist> findAll();
	public int getCount();
}
