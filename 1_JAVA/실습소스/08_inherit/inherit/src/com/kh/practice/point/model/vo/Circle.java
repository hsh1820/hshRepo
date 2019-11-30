package com.kh.practice.point.model.vo;

public class Circle extends Point{
	private int radius;
	
	public Circle() {
		super();
		System.out.println("¿ø °´Ã¼ »ý¼º");
		
		
	}
	public Circle(int x, int y, int radius) {
		super(x,y);
		this.radius = radius;
	}
	
	
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRadius()	{
		return radius;
	}
	
	@Override	
	public String toString(){
		return super.toString()+" "+radius + " / ";
	}
	
}
