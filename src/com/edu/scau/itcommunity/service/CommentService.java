package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Comment;

public interface CommentService {
	public boolean save(Comment comment,String filepath,String content);
	public boolean delete(int comment_id,String filepath);
	public ArrayList<Comment> findByUserId(String user_id);
	public ArrayList<Comment> findByNoteId(int note_id);
}
