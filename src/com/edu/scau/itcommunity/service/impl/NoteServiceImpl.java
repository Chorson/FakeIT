package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.NoteDao;
import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.service.NoteService;
import com.edu.scau.itcommunity.util.FileUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDao noteDao;
	@Override
	public boolean save(Note note,String content,String path) {
		// TODO Auto-generated method stub
		
		try {
			noteDao.save(note);
			FileUtil.WriteFile(content, path+"/"+note.getNote_id());
		} catch (Exception e) {
			// TODO: handle exception
			noteDao.delete(note.getNote_id());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int note_id,String path) {
		// TODO Auto-generated method stub
		try {
			noteDao.delete(note_id);
			FileUtil.delFile(path+"/"+note_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public ArrayList<Note> findAll() {
		// TODO Auto-generated method stub
		return noteDao.findAll();
	}
	
	@Override
	public ArrayList<Note> findNewAll() {
		// TODO Auto-generated method stub
		return noteDao.findNewAll();
	}
	
	@Override
	public ArrayList<Note> findHotAll() {
		// TODO Auto-generated method stub
		return noteDao.findHotAll();
	}

	@Override
	public ArrayList<Note> findByPosterId(String user_id) {
		// TODO Auto-generated method stub
		return noteDao.findByPosterId(user_id);
	}

	@Override
	public ArrayList<Note> findByCategoriesId(int categorites_id) {
		// TODO Auto-generated method stub
		return noteDao.findByCategoriesId(categorites_id);
	}

	@Override
	public ArrayList<Note> findHotByCategoriesId(int categorites_id) {
		// TODO Auto-generated method stub
		return noteDao.findHotByCategoriesId(categorites_id);
	}
	
	@Override
	public ArrayList<Note> findNewByCategoriesId(int categorites_id) {
		// TODO Auto-generated method stub
		return noteDao.findNewByCategoriesId(categorites_id);
	}
	
	@Override
	public ArrayList<Note> findByType(String type) {
		// TODO Auto-generated method stub
		return noteDao.findByType(type);
	}

	@Override
	public void update(int note_id) {
		// TODO Auto-generated method stub
		noteDao.update(note_id);
		
	}

	@Override
	public Note findByNoteId(int note_id) {
		// TODO Auto-generated method stub
		return noteDao.findByNoteId(note_id);
	}

	@Override
	public ArrayList<Note> findNewShare() {
		// TODO Auto-generated method stub
		return noteDao.findNewShare();
	}

	@Override
	public ArrayList<Note> findNewQuestion() {
		// TODO Auto-generated method stub
		return noteDao.findNewQuestion();
	}

	@Override
	public ArrayList<Note> findHotShare() {
		// TODO Auto-generated method stub
		return noteDao.findHotShare();
	}

	@Override
	public ArrayList<Note> findHotQuestion() {
		// TODO Auto-generated method stub
		return noteDao.findHotQuestion();
	}

	@Override
	public ArrayList<Note> searchByTitle(String note_title) {
		// TODO Auto-generated method stub
		return noteDao.searchByTitle("%"+note_title+"%");
	}

	@Override
	public ArrayList<Note> showSubscribeNote(String user_id) {
		// TODO Auto-generated method stub
		return noteDao.showSubscribeNote(user_id);
	}

	@Override
	public int getVisitSum() {
		// TODO Auto-generated method stub
		return noteDao.getVisitSum();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return noteDao.getCount();
	}

	@Override
	public ArrayList<Note> findByPosterName(String user_name) {
		// TODO Auto-generated method stub
		return noteDao.findByPosterName("%"+user_name+"%");
	}

	
	
}
