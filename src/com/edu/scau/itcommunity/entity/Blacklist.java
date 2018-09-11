package com.edu.scau.itcommunity.entity;

public class Blacklist {
	private String user_id;
	private String user_name;
	private String solution;
	private String create_time;
	private int howlong;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getHowlong() {
		return howlong;
	}
	public void setHowlong(int howlong) {
		this.howlong = howlong;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
