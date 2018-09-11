import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.scau.itcommunity.dao.BlacklistDao;
import com.edu.scau.itcommunity.dao.CategoriesDao;
import com.edu.scau.itcommunity.dao.CollectionsDao;
import com.edu.scau.itcommunity.dao.CommentDao;
import com.edu.scau.itcommunity.dao.LogsDao;
import com.edu.scau.itcommunity.dao.NoteDao;
import com.edu.scau.itcommunity.dao.SubscribeDao;
import com.edu.scau.itcommunity.dao.UserDao;
import com.edu.scau.itcommunity.entity.Blacklist;
import com.edu.scau.itcommunity.entity.Categories;
import com.edu.scau.itcommunity.entity.Collections;
import com.edu.scau.itcommunity.entity.Comment;
import com.edu.scau.itcommunity.entity.Note;
import com.edu.scau.itcommunity.entity.Subscribe;
import com.edu.scau.itcommunity.entity.User;
import com.edu.scau.itcommunity.service.RegisterService;

public class testMain {
	static void Usertest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		UserDao u_dao = (UserDao)ac.getBean("userDao");
//		User user = new User();
//		user.setUser_id("111111");
//		user.setUser_name("zz");
//		user.setUser_password("111111");
//		user.setUser_tel("110110");
//		user.setUser_email("1@qq.com");
//		u_dao.save(user);
//		u_dao.findAll();
//		u_dao.findById(user.getUser_id());
//		user.setUser_email("2@qq.com");
//		u_dao.update(user);
		User user=u_dao.findById("111111");
//		System.out.println(user.getuser_like());
	}
	static void Blacklisttest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		BlacklistDao b_dao = (BlacklistDao)ac.getBean("blacklistDao");
		Blacklist blacklist = new Blacklist();
		blacklist.setUser_id("111111");
		blacklist.setSolution("发神经");
		blacklist.setHowlong(10);
		b_dao.save(blacklist);
		b_dao.delete("111111");
		b_dao.findAll();
	}
	static void Categoriestest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		Categories categories = new Categories();
		CategoriesDao dao = (CategoriesDao)ac.getBean("categoriesDao");
		dao.save("java");
		dao.findAll();
		dao.delete(1);
	}
	static void Logstest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		LogsDao dao =(LogsDao)ac.getBean("logsDao");
		dao.save("fafa");
//		dao.findAll();
		dao.delete(1);
	}
	static void Notetest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		NoteDao dao = (NoteDao)ac.getBean("noteDao");
		Note note = new Note();
		note.setNote_title("神经病");
		note.setPoster_id("111111");
		note.setType("share");
		note.setCategories_id(2);
		dao.save(note);
		dao.update(1);
		dao.findAll();
		dao.findByCategoriesId(2);
		dao.findByPosterId("111111");
		dao.findByType("share");
		dao.delete(1);
	}
	static void Commenttest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		CommentDao dao = (CommentDao)ac.getBean("commentDao");
		Comment comment = new Comment();
		comment.setU_id("111111");
		comment.setN_id(2);
		dao.save(comment);
		dao.findByNoteId(2);
		dao.findByUserId("111111");
		dao.delete(1);
	}
	static void Collections(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		CollectionsDao dao = (CollectionsDao)ac.getBean("collectionsDao");
		Collections c = new Collections();
		c.setUserinfo_user_id("111111");
		c.setNoteinfo_note_id(2);
		dao.save(c);
		dao.findByUserId("111111");
		dao.delete(c);
		
	}
	static void Subscribetest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringConf.xml");
		SubscribeDao dao = (SubscribeDao)ac.getBean("subscribeDao");

		
	}
	static void Timetest(){
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		System.out.println(df.format(day));   
	}
	static void Filetest() throws IOException{
		String path="WebRoot/WEB-INF/ojbk.txt";	
		File file=new File(path);
		FileWriter fw=new FileWriter(file);
		String hh=new String("dad好啊d");
		char[] cs=hh.toCharArray();
		if(!file.exists()){
			file.createNewFile();
			
			fw.write(cs);
			fw.flush();
			System.out.println("Yes");
		}
		else{
			fw.write(cs);
			fw.flush();
			System.out.println("存在");
		}
	}
	static void fileExist(){
		File file=new File("WebRoot/WEB-INF/ojbk.txt");
		if(file.exists()){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
	public static void main(String[] args) throws Exception{
		RegisterService r = new RegisterService();
		r.sendEmail("1079157410@qq.com", "what");
		
	}
}
