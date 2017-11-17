package com.diary.model;

public class User {

	private int userId;
	private String userName;
	private String password;
	private String nickName;
	private String imageName;
	private String mood;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String passsword) {
		super();
		this.userName = userName;
		this.password = passsword;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getNickName() {
		return nickName;
	}
	public String getImageName() {
		return imageName;
	}
	public String getMood() {
		return mood;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String passsword) {
		this.password = passsword;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
}
