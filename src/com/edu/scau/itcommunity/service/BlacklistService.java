package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Blacklist;

public interface BlacklistService {
	public void save(Blacklist blacklist);
	public void delete(String blacklsit_id);
	public ArrayList<Blacklist> findAll();
	public int getCount();
}
