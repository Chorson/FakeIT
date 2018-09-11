package com.edu.scau.itcommunity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.entity.Subscribe;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.NoteService;
import com.edu.scau.itcommunity.service.SubscribeService;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class SubscribeController {

	@Autowired
	private SubscribeService subscribeService;
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private UserService userService;
	//查询用户
	@ResponseBody
	@RequestMapping(value="/searchUser",produces="application/json;charset=UTF-8")
	public String searchUser(String username){
		List<User> list=userService.searchByUsername(username);
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("userlist", list);
		return jsonObject.toString();
	}
	//显示已关注用户
	@ResponseBody
	@RequestMapping(value="/showSubscribe",produces="application/json;charset=UTF-8")
	public String showSubcribe(String user_id){
//		User user=(User)session.getAttribute("user");
		User user=userService.findById(user_id);
		List<User> list=subscribeService.findById(user.getUser_id());
		JSONObject json=new JSONObject();
		json.accumulate("userlist", list);
		return json.toString();
		
		
	}
	
	//取消关注
	@ResponseBody
	@RequestMapping(value="/deleteSubscribe",produces="application/json;charset=UTF-8")
	public String deleteSubcribe(Subscribe sub ){
		boolean flag=subscribeService.delete(sub);
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("deleteflag", flag);
		return jsonObject.toString();
	}
	//关注用户
	@ResponseBody
	@RequestMapping(value="/subscribeUser",produces="application/json;charset=UTF-8")
	public String subcribeUser(Subscribe sub){
		boolean flag=subscribeService.save(sub);
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("subscribeflag", flag);
		return jsonObject.toString();
	}
	
	//显示所关注用户的最新动态
	@ResponseBody
	@RequestMapping(value="/showSubscribenote",produces="application/json;charset=UTF-8")
	public String showSubscribenote(String user_id){
		ArrayList<Note> list=noteService.showSubscribeNote(user_id);
	    JSONObject json=new JSONObject();
	    json.accumulate("notelist", list);
	    return json.toString();
	}
	
}
