package com.edu.scau.itcommunity.service;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Message;

public interface MessageService {
	public boolean save(Message msg);
	public boolean delete(int msg_id);
	public ArrayList<Message> findByPosterId(String user_id);
	public ArrayList<Message> findByGetterId(String user_id);
	public boolean update(int msg_id);
	public Message findByMessageId(int message_id);
}
