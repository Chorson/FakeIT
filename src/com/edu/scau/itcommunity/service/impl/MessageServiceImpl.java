package com.edu.scau.itcommunity.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.scau.itcommunity.dao.MessageDao;
import com.edu.scau.itcommunity.entity.Message;
import com.edu.scau.itcommunity.service.MessageService;
import com.edu.scau.itcommunity.util.FileUtil;


@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	
	@Override
	public boolean save(Message msg){
		// TODO Auto-generated method stub
		try{
			messageDao.save(msg);
			return true;
		}catch(Exception e){
			return false;
		}
		 
		 
	}

	@Override
	public boolean delete(int msg_id) {
		// TODO Auto-generated method stub
		
		try{
			messageDao.delete(msg_id);

			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public ArrayList<Message> findByPosterId(String user_id) {
		// TODO Auto-generated method stub
		return messageDao.findByPosterId(user_id);
	}

	@Override
	public ArrayList<Message> findByGetterId(String user_id) {
		// TODO Auto-generated method stub
		return messageDao.findByGetterId(user_id);
	}

	@Override
	public boolean update(int msg_id) {
		// TODO Auto-generated method stub
		try{
			messageDao.update(msg_id);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public Message findByMessageId(int message_id) {
		// TODO Auto-generated method stub
		return messageDao.findByMessageId(message_id);
	}

}
