package com.edu.scau.itcommunity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class SigninController {

	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping(value="/signin",produces="application/json;charset=UTF-8")
	public String signin(String user_id){
//		User user=(User)session.getAttribute("user");
		User user=userService.findById(user_id);
		int experience=user.getExperience()+10;
		user.setExperience(experience);
		boolean flag=userService.update(user);
		JSONObject json=new JSONObject();
		json.accumulate("signflag", flag);
		json.accumulate("experience", experience);
		return json.toString();
	}
}
