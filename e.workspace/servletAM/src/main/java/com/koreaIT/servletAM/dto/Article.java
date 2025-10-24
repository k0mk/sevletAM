package com.koreaIT.servletAM.dto;

public class Article {
	private int id;
	private String regDate;
	private int memberId;
	private int boardId;
	private String title;
	private String content;
	private int viewCnt;
	
	public Article(int id, String regDate, int memberId, int boardId, String title, String content, int viewCnt) {
		this.id = id;
		this.regDate = regDate;
		this.memberId = memberId;
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
	}
	public Article() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
}
