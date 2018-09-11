package com.edu.scau.itcommunity.controller;

import java.io.File;
//import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import net.sf.json.JSONObject;


@Controller
public class ImgController {
	
//	@ResponseBody
//	@RequestMapping(value="/test" ,produces="application/json;charset=UTF-8")
//	public String test(String key) throws IOException{//通过key拿json的值，此处参数key名字要与json中的key一致
//		System.out.println("it works!!!");
//		System.out.println(key);
//		JSONObject json = new JSONObject();
//		json.accumulate("message", "你好！");
//		return json.toString();
//	}
	
	@ResponseBody
	@RequestMapping("/userimg")
	public String UploadUserImg(@RequestParam MultipartFile uploadFile, HttpServletRequest request){

		String realpath = request.getServletContext().getRealPath("UserImg");
		String fileName = uploadFile.getOriginalFilename(); 
//		String user_id = (String)session.getAttribute("user");
		long time = new Date().getTime();
		String file_name = "";
		if(fileName.endsWith(".jpg"))
			file_name = time+".jpg";
		else if(fileName.endsWith(".JPG"))
			file_name = time+".jpg";
		else if(fileName.endsWith(".PNG"))
			file_name = time+".png";
		else if(fileName.endsWith(".png"))
			file_name = time+".png";
		File targetFile = new File(realpath, file_name); 
		if(!targetFile.exists()){  
            targetFile.mkdirs();  
        } 
        try {   
        	uploadFile.transferTo(targetFile);
        } catch (Exception e) {  
            return "上传失败";
        }  
        return "/se52/UserImg/"+file_name;
	}
	
	@ResponseBody
	@RequestMapping("/noteimg")
	public String UploadNoteImg(@RequestParam MultipartFile uploadFile, HttpServletRequest request){

		String realpath = request.getServletContext().getRealPath("NoteImg");
		String fileName = uploadFile.getOriginalFilename(); 
		long time = new Date().getTime();
		String file_name = "";
		if(fileName.endsWith(".jpg"))
			file_name = time+".jpg";
		else if(fileName.endsWith(".JPG"))
			file_name = time+".jpg";
		else if(fileName.endsWith(".PNG"))
			file_name = time+".png";
		else if(fileName.endsWith(".png"))
			file_name = time+".png";
		File targetFile = new File(realpath, file_name); 
        try {   
        	uploadFile.transferTo(targetFile);
        } catch (Exception e) {  
            return "上传失败";
        }  
		return "/se52/NoteImg/"+file_name;
	}
}
