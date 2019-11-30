package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private RectangleController rc = new RectangleController();
	private CircleController cc = new CircleController();
	
	public void mainMenu() {		
		// 메뉴 선택 
		while(true) {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("3. 끝내기");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1: {
			this.circleMenu();
			break;
		}
		case 2: {
			this.rectangleMenu();
			break;
		}
		case 3: {
			System.out.println("종료합니다.");
			return;
		}
		
		}
				
		}
			
	}
	public void circleMenu() {
		// 원메뉴
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레 ");
		System.out.println("2. 원 넓이 ");
		System.out.println("9. 메인으로 ");
		System.out.print("메뉴 번호 : ");
		int menu = sc.nextInt();
		switch(menu) {
		case 1:{ // 원 둘레
			this.calcCircum();
			break;
		} 
		case 2:{ // 원 넓이
			this.calcCircleArea();
			break;
		}
		case 9: {
			this.mainMenu();
			
			}
		}
	}
	// cc  , rc
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사격형 둘레 ");
		System.out.println("2. 사각형 넓이 ");
		System.out.println("9. 메인으로 ");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:{
			this.calcPerimeter();
			break;
		} 
		case 2:{
			this.calcRectArea();
			break;
		}
		case 9: {
			this.mainMenu();
			
			}
		}
	}
	
	public void calcCircum() { // 넓이
		
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		
		System.out.println(cc.calcCircum(x, y, radius));
		
	}
	public void calcCircleArea() { // 원 면적
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		System.out.println(cc.calcArea(x, radius));
	}
	public void calcPerimeter() { //원 둘레
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, height, width));
		
	}
	
	public void calcRectArea() { // 사각형 면적
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		
		System.out.println(rc.calcRecArea(x, height, width));
	}
	
	
	
	
	
}	
