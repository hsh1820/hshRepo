package com.kh.practice.point.model.vo;

public class Rectangle extends Point{
	private int width;
	private int height;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("사각형 객체 생성");
	}

	public Rectangle(int x, int y, int width, int height) {
		super(x,y);
		
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public int getWidth() {
		return width; 
	}
	
	public int getHeight() {
		return height;
	}
	public String toString() {
		return  super.toString()+" "+ width +" "+ height+" / "; 
	}
	
}
