package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private RectangleController rc = new RectangleController();
	private CircleController cc = new CircleController();
	
	public void mainMenu() {		
		// �޴� ���� 
		while(true) {
		System.out.println("===== �޴� =====");
		System.out.println("1. ��");
		System.out.println("2. �簢��");
		System.out.println("3. ������");
		System.out.print("�޴� ��ȣ : ");
		
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
			System.out.println("�����մϴ�.");
			return;
		}
		
		}
				
		}
			
	}
	public void circleMenu() {
		// ���޴�
		System.out.println("===== �� �޴� =====");
		System.out.println("1. �� �ѷ� ");
		System.out.println("2. �� ���� ");
		System.out.println("9. �������� ");
		System.out.print("�޴� ��ȣ : ");
		int menu = sc.nextInt();
		switch(menu) {
		case 1:{ // �� �ѷ�
			this.calcCircum();
			break;
		} 
		case 2:{ // �� ����
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
		System.out.println("===== �簢�� �޴� =====");
		System.out.println("1. ����� �ѷ� ");
		System.out.println("2. �簢�� ���� ");
		System.out.println("9. �������� ");
		System.out.print("�޴� ��ȣ : ");
		
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
	
	public void calcCircum() { // ����
		
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int radius = sc.nextInt();
		
		System.out.println(cc.calcCircum(x, y, radius));
		
	}
	public void calcCircleArea() { // �� ����
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("������ : ");
		int radius = sc.nextInt();
		System.out.println(cc.calcArea(x, radius));
	}
	public void calcPerimeter() { //�� �ѷ�
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int height = sc.nextInt();
		System.out.print("�ʺ� : ");
		int width = sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, height, width));
		
	}
	
	public void calcRectArea() { // �簢�� ����
		System.out.print("x ��ǥ : ");
		int x = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int y = sc.nextInt();
		System.out.print("���� : ");
		int height = sc.nextInt();
		System.out.print("�ʺ� : ");
		int width = sc.nextInt();
		
		System.out.println(rc.calcRecArea(x, height, width));
	}
	
	
	
	
	
}	
