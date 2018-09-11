package com.edu.scau.itcommunity.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.mail.internet.NewsAddress;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.quartz.ee.jta.UserTransactionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Collections;
import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.CollectionsService;
import com.edu.scau.itcommunity.service.NoteService;
import com.edu.scau.itcommunity.service.impl.CollectionServiceImpl;
import com.edu.scau.itcommunity.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private CollectionsService collectionService;
	@Autowired 
	private NoteService noteService;
	

	@ResponseBody
	@RequestMapping(value = "/check", produces = "application/json;charset=UTF-8")
	// 查看用户信息
	public String check(String id) throws IOException {

		 //User user = (User) session.getAttribute("user");
	     User user=userService.findById(id);
//		 String userinfo = user.getUser_id() + " " + user.getUser_password() + " " + user.getUser_name() + " "
//				+ user.getUser_tel() + " " + user.getUser_email() + " " + user.getCreate_time() + " "
//				+ user.getExperience() + " " + user.getUser_like();
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("userinfo", user);
		return jsonObject.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/modify", produces = "application/json;charset=UTF-8")
	// 修改用户信息
	public String modify(User user) throws Exception {
		

		 System.out.println(user.toString());
//		 System.out.println(user.getUser_id()+" "+user.getUser_password()+" "
//		 +user.getUser_name()+" "+user.getUser_tel()+" "+
//		 user.getUser_email()+" "+user.getCreate_time()+" "+
//		 user.getExperience()+" "+user.getUser_like()+" "+user.getUser_img());
		
		Boolean result = userService.update(user);
		System.out.println(result);
		JSONObject jsonObject = new JSONObject();
		if (result) {
			jsonObject.accumulate("modifyResult", "修改成功!");
		} else
			jsonObject.accumulate("modifyResult", "修改失败!");
		
		return jsonObject.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/addCollection", produces = "application/json;charset=utf-8")
	// 收藏帖子
	public String addCollection(Collections collection) {
		boolean result;
		result = collectionService.save(collection);
		JSONObject jsonObject = new JSONObject();
		if (result)
			jsonObject.accumulate("addCollection", "添加收藏成功!");
		else
			jsonObject.accumulate("deleteCollection", "添加收藏失败!");
		return jsonObject.toString();
	}

	// 取消收藏帖子
	@ResponseBody
	@RequestMapping(value = "/deleteCollection", produces = "application/json;charset=utf-8")
	public String deleteCollection(Collections collection) {
		boolean result;
		result = collectionService.delete(collection);
		JSONObject jsonObject = new JSONObject();
		if (result)
			jsonObject.accumulate("addCollection", "删除收藏成功!");
		else
			jsonObject.accumulate("deleteCollection", "删除收藏失败!");
		return jsonObject.toString();
	}

	// 查看收藏帖子
	@ResponseBody
	@RequestMapping(value = "/showCollection", produces = "application/json;charset=utf-8")
	public String showCollection(String user_id) {
		
		ArrayList<Note> noteArrayList = new ArrayList<Note>();
		noteArrayList = collectionService.findByUserId(user_id);
//		for (Note note : noteArrayList) {
//			System.out.println(note.getNote_id()+" "+note.getNote_title());
//		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("collectedNote",noteArrayList);
		return jsonObject.toString();
	}
	
	//用户数量
	@ResponseBody
	@RequestMapping(value="/userCount",produces="application/json;charset=utf-8")
    public String count(){
		int count=userService.getUserCount();
		JSONObject json=new JSONObject();
		json.accumulate("userCount", count);
		return json.toString();
	}
	
}
