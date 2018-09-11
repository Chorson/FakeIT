package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.CategoriesDao;
import com.edu.scau.itcommunity.entity.Categories;
import com.edu.scau.itcommunity.service.CategoriesService;

@Service("categoriesService")
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	@Override
	public void save(String categories) {
		// TODO Auto-generated method stub
		categoriesDao.save(categories);
	}

	@Override
	public void delete(int categories_id) {
		// TODO Auto-generated method stub
		categoriesDao.delete(categories_id);
	}

	@Override
	public ArrayList<Categories> findAll() {
		// TODO Auto-generated method stub
		return categoriesDao.findAll();
	}

	@Override
	public Categories findByName(String categories_name) {
		// TODO Auto-generated method stub
		return categoriesDao.findByName(categories_name);
	}

}
