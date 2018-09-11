package com.edu.scau.itcommunity.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Comment;
import com.edu.scau.itcommunity.entity.Message;
import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.CommentService;
import com.edu.scau.itcommunity.service.NoteService;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	//验证用户登录；管理员返回0、普通用户返回1、密码错误2、用户名不存在3
	@ResponseBody
	@RequestMapping(value="/login",produces="application/json;charset=UTF-8")
	public String login(String id,String password,HttpSession session)throws IOException{
		String result=null;
		User user=userService.findById(id);
		if(user==null){
			result="3";
		}else if(id.equals("admin")&&user.getUser_password().equals(password)){
			result="0";
		}else if(user.getUser_password().equals(password)){
			result="1";
			session.setAttribute("user", user);
		}else{
			result="2";
		}
		JSONObject json=new JSONObject();
		json.accumulate("result", result);
		return json.toString();
	}
	
}
