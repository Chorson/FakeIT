package com.edu.scau.itcommunity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Categories;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.CategoriesService;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class CategoriesCtroller {

	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private UserService userService;
	//显示关注的话题
	@ResponseBody
	@RequestMapping(value="/showCategories",produces="application/json;charset=UTF-8")
	public String showCategories(String user_id){
//		User user=(User)session.getAttribute("user");
		User user=userService.findById(user_id);
		System.out.println("user:"+user.getUser_name());
		String like=user.getUser_like();
		System.out.println(like);
		String[] topic=like.split("_");
		List<Categories> list=new ArrayList<Categories>();
		for(int i=0;i<topic.length;i++){
			list.add(categoriesService.findByName(topic[i]));
		}
		JSONObject json=new JSONObject();
		json.accumulate("categories", list);
		return json.toString();
	}
	
	//更新话题
	@ResponseBody
	@RequestMapping(value="/updateCategories",produces="application/json;charset=UTF-8")
	public String updateCategories(String likes,String user_id){
//	     User user=(User)session.getAttribute("user");
		 User user=userService.findById(user_id);
         user.setUser_like(likes);
         boolean flag=userService.update(user);
	     JSONObject jsonObject=new JSONObject();
	     jsonObject.accumulate("update", flag);
	     return jsonObject.toString();
	}
	
}
