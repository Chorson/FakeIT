package com.edu.scau.itcommunity.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Message;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.MessageService;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;
import oracle.net.aso.a;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	//增加消息
	@ResponseBody
	@RequestMapping(value="/addMessage",produces="application/json;charset=UTF-8")
	public String addMessage(String content,String getterId
			,String user_id
			){
//		User user=(User)session.getAttribute("user");
		User user=userService.findById(user_id);
		Message message=new Message();
		message.setPoster(user.getUser_id());
		message.setGetter(getterId);
		message.setContent(content);
		message.setPoster_name(user.getUser_name());
		boolean flag=messageService.save(message);
		JSONObject json=new JSONObject();
		json.accumulate("addflag", flag);
		return json.toString();
	}
	
	//删除消息
	@ResponseBody
	@RequestMapping(value="/deleteMessage",produces="application/json;charset=UTF-8")
	public String deleteMessage(String message_id){
		boolean flag=messageService.delete(Integer.valueOf(message_id));
		JSONObject json=new JSONObject();
		json.accumulate("deleteflag", flag);
		return json.toString();
	}
	
	//显示消息以及数量
	@ResponseBody
	@RequestMapping(value="/showMessage",produces="application/json;charset=UTF-8")
	public String showMessage(String user_id){
//		User user=(User)session.getAttribute("user");
		User user=userService.findById(user_id);
		List<Message> list=messageService.findByGetterId(user.getUser_id());
		JSONObject json=new JSONObject();
		json.accumulate("count", list);
		int count=0;
		for(Message m:list){
			if(m.getIsread()==0){
				count++;
			}
		}
		json.accumulate("message", list);
		json.accumulate("num", count);
		return json.toString();
	}
	
	//点击查看消息内容
	@ResponseBody
	@RequestMapping(value="/viewMessage",produces="application/json;charset=UTF-8")
	public String viewMessage(String message_id){
		Message message=messageService.findByMessageId(Integer.valueOf(message_id));
		JSONObject json=new JSONObject();
		json.accumulate("content", message.getContent());
		return json.toString();
	}
	
}
