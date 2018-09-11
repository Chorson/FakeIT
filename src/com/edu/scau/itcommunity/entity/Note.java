package com.edu.scau.itcommunity.entity;

public class Note {
	private int note_id;
	private String note_title;
	private String create_time;
	private String poster_id;
	private int categories_id;
	private String type;
	private int visitor_number;
	private String poster_name;
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getPoster_id() {
		return poster_id;
	}
	public void setPoster_id(String poster_id) {
		this.poster_id = poster_id;
	}
	public int getCategories_id() {
		return categories_id;
	}
	public void setCategories_id(int categories_id) {
		this.categories_id = categories_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster_name() {
		return poster_name;
	}
	public void setPoster_name(String poster_name) {
		this.poster_name = poster_name;
	}
	public int getVisitor_number() {
		return visitor_number;
	}
	public void setVisitor_number(int visitor_number) {
		this.visitor_number = visitor_number;
	}
}
