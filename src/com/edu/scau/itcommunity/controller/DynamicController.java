package com.edu.scau.itcommunity.controller;

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
import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.CommentService;
import com.edu.scau.itcommunity.service.NoteService;
import com.edu.scau.itcommunity.service.UserService;
import com.edu.scau.itcommunity.util.FileUtil;

import net.sf.json.JSONObject;

@Controller
public class DynamicController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	//查看发布
	@ResponseBody
	@RequestMapping(value="/showNote",produces="application/json;charset=UTF-8")
	public String showNote(String user_id){
//		User user=(User)(session.getAttribute("user"));
		User user=userService.findById(user_id);
	   List<Note> list=noteService.findByPosterId(user.getUser_id());
	   JSONObject json=new JSONObject();
	   json.accumulate("note",list);
	   return json.toString();
	}
	
	//显示与自己相关的帖子（即自己评论过的帖子）
	@ResponseBody
	@RequestMapping(value="/findNote",produces="application/json;charset=UTF-8")
	public String findNote(String user_id){
//		User user=(User)(session.getAttribute("user"));
		User user=userService.findById(user_id);
		List<Comment> commentlist=commentService.findByUserId(user.getUser_id());
		List<Note> notelist=new ArrayList<Note>();
		for(Comment c:commentlist){
			int noteid=c.getN_id();
			boolean flag=true;
			for(int i=0;i<notelist.size();i++){
				if(noteid==notelist.get(i).getNote_id()){
					flag=false;
					break;
				}
			}
			if(flag){
				notelist.add(noteService.findByNoteId(noteid));
			}
		}
		JSONObject json=new JSONObject();
		json.accumulate("nclist", notelist);
		return json.toString();
	}
	
	
	    //点击查看帖子内容时，显示帖子内容以及评论
		@ResponseBody
		@RequestMapping(value="/viewNote",produces="application/json;charset=UTF-8")
		public String viewNote(String noteId,HttpServletRequest request) throws IOException{
			int id=Integer.valueOf(noteId);
			String path1 = request.getServletContext().getRealPath("Note");
			String path2 = request.getServletContext().getRealPath("Comment");
			String realpath=path1+"/"+noteId;
			System.out.println(realpath);
			String content=FileUtil.ReadFile(realpath);
			List<Comment> commentlist=commentService.findByNoteId(id);
			String str=null;
			Note note=noteService.findByNoteId(Integer.valueOf(noteId));
			noteService.update(note.getNote_id());
			for(Comment c:commentlist){
				str=FileUtil.ReadFile(path2+"//"+String.valueOf(c.getComment_id()));
				c.setContent(str);
			}
			JSONObject json=new JSONObject();
			json.accumulate("note", note);
			json.accumulate("content", content);
			json.accumulate("comment", commentlist);
			return json.toString();
		}
		
		//删除评论
		@ResponseBody
		@RequestMapping(value="/deleteComment",produces="application/json;charset=UTF-8")
		public String deleteComment(String commentId,HttpServletRequest request){
			String path = request.getServletContext().getRealPath("Comment");
			String realpath=path+"//"+commentId;
			int id=Integer.valueOf(commentId);
			boolean flag=commentService.delete(id,realpath);
			JSONObject json=new JSONObject();
			json.accumulate("deleteflag", flag);
			return json.toString();	
		}
		
		//增加评论
		@ResponseBody
		@RequestMapping(value="/addComment",produces="application/json;charset=UTF-8")
		public String addComment(String noteid,String content,HttpServletRequest request
				,String user_id,String user_name
				){
//			User user=(User)session.getAttribute("user");
//			User user=userService.findById("111111");
			Comment comment=new Comment();
			comment.setN_id(Integer.valueOf(noteid));
			comment.setU_id(user_id);
			comment.setU_name(user_name);
			String path = request.getServletContext().getRealPath("Comment");
			boolean flag=commentService.save(comment,path,content);
			JSONObject json=new JSONObject();
			json.accumulate("addflag", flag);
			return json.toString();
		}
		
}
