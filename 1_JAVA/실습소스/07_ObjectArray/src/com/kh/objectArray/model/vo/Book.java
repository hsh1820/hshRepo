package com.kh.objectArray.model.vo;

public class Book {
	// �ʵ�
	private String title; // ����
	private String author; // ����
	private String publisher; // ���ǻ�
	private int price; // ����
	
	// ������
	public Book() { // �⺻������
		
	}
	// �Ű����� ������
	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;				
	}
	
	// �޼ҵ�
	// getter /setter
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String inform() {
		return title + ", " + author  + ", " + publisher  + ", " +price;
	}
	
	
	
	
	
	
}
