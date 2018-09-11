package com.edu.scau.itcommunity.dao;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Comment;

public interface CommentDao {
	public void save(Comment comment);
	public void delete(int comment_id);
	public ArrayList<Comment> findByUserId(String user_id);
	public ArrayList<Comment> findByNoteId(int note_id);
}
