package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.CollectionsDao;
import com.edu.scau.itcommunity.entity.Collections;
import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.service.CollectionsService;

import oracle.net.aso.b;


@Service("collectionsService")
public class CollectionServiceImpl implements CollectionsService {

	@Autowired
	private CollectionsDao collectionsDao;
	@Override
	public boolean save(Collections collection) {
		// TODO Auto-generated method stub
		boolean result;
		try {
			collectionsDao.save(collection);
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
			result=false;
		}
		return result;
	}

	@Override
	public boolean delete(Collections collection) {
		// TODO Auto-generated method stub
		boolean result;
		try {
			collectionsDao.delete(collection);
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
			result=false;
		}
		return result;
	}

	@Override
	public ArrayList<Note> findByUserId(String user_id) {
		// TODO Auto-generated method stub
		return collectionsDao.findByUserId(user_id);
	}

}
