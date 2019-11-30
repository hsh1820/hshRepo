package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcRecArea(int x, int height, int width) {
		// 면적 : 너비 * 높이
		
		r.setX(x);
		r.setHeight(height);
		r.setWidth(width);
		return r.toString() + ( r.getWidth() * r.getHeight());
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		// 둘레 : 2 * (너비 + 높이)
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		return r.toString() + (2 * r.getWidth() + r.getHeight());
	}
}
