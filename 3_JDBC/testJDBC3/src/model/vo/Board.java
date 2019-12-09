package model.vo;

import java.sql.Date;

public class Board {
	private int bno; // 글번호
	private String title; // 글 제목
	private String content; // 글 내용
	private Date createDate; // 작성일자
	private String writer; // 작성자
	

	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Board(int bno, String title, Date createDate, String writer) {
		this.bno = bno;
		this.title = title;
		this.createDate = createDate;
		this.writer = writer;
	}

	public Board(int bno, String title, String content, Date createDate, String writer) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.writer = writer;
	}

	public Board(int bno, String title, Date createDate, String writer, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.writer = writer;
	}


	public Board(String content) {
	 this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", createDate=" + createDate
				+ ", writer=" + writer + "]";
	}

}
