package com.edu.scau.itcommunity.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.CommentDao;
import com.edu.scau.itcommunity.entity.Comment;
import com.edu.scau.itcommunity.service.CommentService;
import com.edu.scau.itcommunity.util.FileUtil;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	@Override
	public boolean save(Comment comment,String filepath,String content) {
		// TODO Auto-generated method stub
		try{
			commentDao.save(comment);
			String realpath=filepath+"//"+String.valueOf(comment.getComment_id());
			System.out.println(content);
			System.out.println(realpath);
			FileUtil.WriteFile(content, realpath);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean delete(int comment_id,String filepath) {
		// TODO Auto-generated method stub
		try{
			commentDao.delete(comment_id);
			FileUtil.delFile(filepath);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public ArrayList<Comment> findByUserId(String user_id) {
		// TODO Auto-generated method stub
		return commentDao.findByUserId(user_id);
	}

	@Override
	public ArrayList<Comment> findByNoteId(int note_id) {
		// TODO Auto-generated method stub
		return commentDao.findByNoteId(note_id);
	}

}
