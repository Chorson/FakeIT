package com.edu.scau.itcommunity.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.RegisterService;

import net.sf.json.JSONObject;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@ResponseBody
	@RequestMapping(value="/register" ,produces="application/json;charset=UTF-8")
	public String register(User user){
		JSONObject json = new JSONObject();
		try {
			if(registerService.doRegister(user)){
				json.accumulate("message", "成功");
				return json.toString();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			json.accumulate("message", "用户名已存在");
			return json.toString();
		}
			
		json.accumulate("message", "用户已存在");
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/checkEmail" ,produces="application/json;charset=UTF-8")
	public String checkEmail(String user_email){
		int checknum = (int) (1000 * (Math.random() * 9 + 1));
		JSONObject json = new JSONObject();
		json.accumulate("checknum", checknum);
		try {
			registerService.sendEmail(user_email, "验证码："+checknum);
		} catch (Exception e) {
			json.accumulate("message", "error in sendemail");
			return json.toString();
		}
		json.accumulate("message", checknum);
		return json.toString();
	}
}
