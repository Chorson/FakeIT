package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Collections;
import com.edu.scau.itcommunity.entity.Note;

public interface CollectionsService {
	public boolean save(Collections collection);
	public boolean delete(Collections collection);
	public ArrayList<Note> findByUserId(String user_id);
}
