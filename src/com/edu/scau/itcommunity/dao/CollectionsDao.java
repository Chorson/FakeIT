package com.edu.scau.itcommunity.dao;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Collections;
import com.edu.scau.itcommunity.entity.Note;

public interface CollectionsDao {//没测试
	public void save(Collections collection);
	public void delete(Collections collection);
	public ArrayList<Note> findByUserId(String user_id);
}
