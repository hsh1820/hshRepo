package model.vo;

import java.sql.Date;

public class Comment {
	private int cBno;
	private int bBno;
	private String 	content;
	private Date createDate;
	private String writer;	
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int cBno, int bBno, String content, Date createDate, String writer) {
		super();
		this.cBno = cBno;
		this.bBno = bBno;
		this.content = content;
		this.createDate = createDate;
		this.writer = writer;
	}

	
	
	public Comment(String content, String writer, Date createDate) {
		this.content = content;
		this.writer = writer;
		this.createDate = createDate;
	}

	public Comment(int cBno, String content, String writer, Date createDate) {
		this(content,writer,createDate);
		this.cBno = cBno ;
		
	}

	public int getcBno() {
		return cBno;
	}

	public void setcBno(int cBno) {
		this.cBno = cBno;
	}

	public int getbBno() {
		return bBno;
	}

	public void setbBno(int bBno) {
		this.bBno = bBno;
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
		return "Comment [cBno=" + cBno + ", bBno=" + bBno + ", content=" + content + ", createDate=" + createDate
				+ ", writer=" + writer + "]";
	}
	
	
}
