package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Note;

public interface NoteService {
	public boolean save(Note note,String content,String path);
	public boolean delete(int note_id,String path);
	public ArrayList<Note> findAll();
	public ArrayList<Note> findNewAll();
	public ArrayList<Note> findHotAll();
	public ArrayList<Note> findByPosterId(String user_id);
	public ArrayList<Note> findByPosterName(String user_name);
	public ArrayList<Note> findByCategoriesId(int categorites_id);
	public ArrayList<Note> findHotByCategoriesId(int categorites_id);
	public ArrayList<Note> findNewByCategoriesId(int categorites_id);
	public ArrayList<Note> findByType(String type);
	public ArrayList<Note> searchByTitle(String note_title);
	public Note findByNoteId(int note_id);
	public void update(int note_id);
	public ArrayList<Note> findNewShare();
	public ArrayList<Note> findNewQuestion();
	public ArrayList<Note> findHotShare();
	public ArrayList<Note> findHotQuestion();
	public ArrayList<Note> showSubscribeNote(String user_id);
	public int getVisitSum();
	public int getCount();

}
