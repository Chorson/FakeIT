package com.edu.scau.itcommunity.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.BlacklistService;
import com.edu.scau.itcommunity.service.NoteService;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class ManageController {

	@Autowired
	private UserService userService;
	@Autowired
	private NoteService noteService;
	@Autowired
	private BlacklistService blacklistService;
	//查询所有用户
	@ResponseBody
	@RequestMapping(value="/allUser",produces="application/json;charset=UTF-8")
	public String allUser(){
		ArrayList<User> list=userService.findAll();
		JSONObject json=new JSONObject();
		json.accumulate("userlist", list);
		return json.toString();
	}
	
	//查询所有未被拉黑的用户
	@ResponseBody
	@RequestMapping(value="/findWhiteUser",produces="application/json;charset=UTF-8")
	public String findWhiteUser(){
		ArrayList<User> list=userService.findWhiteUser();
		JSONObject json=new JSONObject();
		json.accumulate("whitelist", list);
		return json.toString();
	}
	
	 
		@ResponseBody
		@RequestMapping(value="/getCount",produces="application/json;charset=UTF-8")
		public String getCount(){
			JSONObject json=new JSONObject();
			//获取所有帖子的总访问量
			json.accumulate("visitCount", noteService.getVisitSum());
			//获取帖子总数
			json.accumulate("noteCount", noteService.getCount());
			//用户总数
			json.accumulate("userCount", userService.getUserCount());
			//黑名单总数
			json.accumulate("blackCount", blacklistService.getCount());
			return json.toString();
		}
		
		
	
}
