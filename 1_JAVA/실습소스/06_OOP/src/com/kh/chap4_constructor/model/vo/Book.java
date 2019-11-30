package com.kh.chap4_constructor.model.vo;

public class Book {
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	public Book() {
		System.out.printf("%s\t%d\t%.1f\t%s\n",title, price,discountRate, author);	
	}
	
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
		
		System.out.printf("%s\t%d\t%.1f\t%s\n",title, price,discountRate, author);
		System.out.println("============================");
	}
	
	public void setTitle (String title) {
		this.title = title;		
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public String getAuthor() {
		return author;
	}
	
	
	public String inform() {
		
		return  title + "\t" +price+ "\t" + discountRate + "\t" +author+"\n";
		
	}
}
