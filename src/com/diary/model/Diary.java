package com.diary.model;

public class Diary {
	private String diaryId;
	private String title;
	private String content;
	private String typeId;
	private String releaseDate;
	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDiaryId() {
		return diaryId;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getTypeId() {
		return typeId;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setDiaryId(String diaryId) {
		this.diaryId = diaryId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
