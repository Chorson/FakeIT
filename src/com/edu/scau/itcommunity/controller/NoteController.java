package com.edu.scau.itcommunity.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.service.NoteService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/note")
public class NoteController {
	@Autowired
	NoteService noteService;
	
	@ResponseBody
	@RequestMapping(value="/add" ,produces="application/json;charset=UTF-8")
	public String addnote(Note note,String content,HttpServletRequest request){
		System.out.println(content);
		JSONObject json  = new JSONObject();
		if(noteService.save(note,content,request.getServletContext().getRealPath("Note"))){
			json.accumulate("message", "发布成功");
			json.accumulate("note_id", note.getNote_id());
			return json.toString();
		}
		json.accumulate("message", "发布失败");
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/delete" ,produces="application/json;charset=UTF-8")
	public String deletenote(String note_id,HttpServletRequest request){
		JSONObject json = new JSONObject();
		if(noteService.delete(Integer.parseInt(note_id), request.getServletContext().getRealPath("Note"))){
			json.accumulate("message", "删除成功");
			return json.toString();
		}
		json.accumulate("message", "删除失败");
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/all" ,produces="application/json;charset=UTF-8")
	public String findAll() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findAll();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/newall" ,produces="application/json;charset=UTF-8")
	public String findNewAll() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findNewAll();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/hotall" ,produces="application/json;charset=UTF-8")
	public String findHotAll() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findHotAll();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findByPoster" ,produces="application/json;charset=UTF-8")
	public String findByPoster(String user_id) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findByPosterId(user_id);
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findByPosterName" ,produces="application/json;charset=UTF-8")
	public String findByPosterName(String user_name) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findByPosterName(user_name);
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findByCategories" ,produces="application/json;charset=UTF-8")
	public String findByCategories(int categorites_id) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findByCategoriesId(categorites_id);
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findNewByCategories" ,produces="application/json;charset=UTF-8")
	public String findNewByCategories(int categorites_id) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findNewByCategoriesId(categorites_id);
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findHotByCategories" ,produces="application/json;charset=UTF-8")
	public String findHotByCategories(int categorites_id) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findHotByCategoriesId(categorites_id);
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findByType" ,produces="application/json;charset=UTF-8")
	public String findByType(String type) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findByType(type);
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/addVisitNum" ,produces="application/json;charset=UTF-8")
	public void update(int note_id) {
		noteService.update(note_id);
	}
	@ResponseBody
	@RequestMapping(value="/getNewShare" ,produces="application/json;charset=UTF-8")
	public String getNewShare() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findNewShare();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/getNewQuestion" ,produces="application/json;charset=UTF-8")
	public String getNewQuestion() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findNewQuestion();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/getHotShare" ,produces="application/json;charset=UTF-8")
	public String getHotShare() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findHotShare();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/getHotQuestion" ,produces="application/json;charset=UTF-8")
	public String getHotQuestion() {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.findHotQuestion();
		json.accumulate("list", list);
		return json.toString();
	}
	@ResponseBody
	@RequestMapping(value="/findByTitle" ,produces="application/json;charset=UTF-8")
	public String searchByTitle(String note_title) {
		JSONObject json = new JSONObject();
		ArrayList<Note> list = noteService.searchByTitle(note_title);
		json.accumulate("list", list);
		return json.toString();
	}
	//获取所有帖子的总访问量
	@ResponseBody
	@RequestMapping(value="/getVisitSum",produces="application/json;charset=UTF-8")
	public String getVisitSum(){
		int count=noteService.getVisitSum();
		JSONObject json=new JSONObject();
		json.accumulate("visitSum", count);
		return json.toString();
	}
	
	//获取帖子总数
	@ResponseBody
	@RequestMapping(value="/getCount",produces="application/json;charset=UTF-8")
	public String getCount(){
		int count=noteService.getCount();
		JSONObject json=new JSONObject();
		json.accumulate("count", count);
		return json.toString();
	}
}
