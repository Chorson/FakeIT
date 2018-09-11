package com.edu.scau.itcommunity.dao;

import java.util.ArrayList;

import com.edu.scau.itcommunity.entity.Message;

public interface MessageDao {
	public void save(Message msg);
	public void delete(int msg_id);
	public ArrayList<Message> findByPosterId(String user_id);
	public ArrayList<Message> findByGetterId(String user_id);
	public void update(int msg_id);
	public Message findByMessageId(int message_id);
}
