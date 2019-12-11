package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	public static final double PI = 3.141592;
	
	private  Circle c = new  Circle();
	
	
	
	
	
	public String calcCircum(int x, int y, int radius) {
		// 둘레 : PI * 반지름 * 2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c.toString()  + ( PI *  c.getRadius() * 2);
	}
	
	public String calcArea(int x,int radius) {
		// 면적 : PI * 반지름 * 반지름
		c.setRadius(radius);
		c.setX(x);
		return c.toString()  + (PI * radius * radius);
	}
	

	
}
