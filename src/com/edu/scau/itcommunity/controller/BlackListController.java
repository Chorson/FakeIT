package com.edu.scau.itcommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Blacklist;
import com.edu.scau.itcommunity.service.BlacklistService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/blacklist")
public class BlackListController {
	@Autowired
	BlacklistService blacklistService;
	
	@ResponseBody
	@RequestMapping(value="/add",produces="application/json;charset=UTF-8")
	public String add(Blacklist blacklist){
		JSONObject json = new JSONObject();
		try {
			blacklistService.save(blacklist);
		} catch (Exception e) {
			// TODO: handle exception
			json.accumulate("message", "添加失败");
			return json.toString();
		}
		
		json.accumulate("message", "添加成功");
		return json.toString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",produces="application/json;charset=UTF-8")
	public String delete(String user_id){
		JSONObject json = new JSONObject();
		blacklistService.delete(user_id);;
		json.accumulate("message", "删除成功");
		
		return json.toString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/findall",produces="application/json;charset=UTF-8")
	public String findall(){
		JSONObject json = new JSONObject();
		json.accumulate("blacklist", blacklistService.findAll());
		return json.toString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getCount",produces="application/json;charset=UTF-8")
	public String getCount(){
		JSONObject json = new JSONObject();
		json.accumulate("count", blacklistService.getCount());
		return json.toString();
		
	}
}
