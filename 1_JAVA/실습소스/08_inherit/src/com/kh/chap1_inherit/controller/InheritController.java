package com.kh.chap1_inherit.controller;

import com.kh.chap1_inherit.model.vo.Computer;
import com.kh.chap1_inherit.model.vo.Dress;
import com.kh.chap1_inherit.model.vo.Product;
import com.kh.chap1_inherit.model.vo.Snack;

public class InheritController  {
	public void method1() {
		// computer 객체 생성
		//Computer com = new Computer();
		/*
		com.setBrand("삼성");
		com.setName("삼성컴퓨터");
		com.setpCode("s001");
		com.setPrice(2000000);
		com.setCpu("Ryzen 3900X)");
		com.setRam(16);
		com.setHdd(2048);
		*/
		
		// Computer의 매개변수 있는 생성자를 이용하여 
		// 객체 생성 및 초기화 
		Computer com = new Computer(2048, 16, "Ryzen 3900X", "삼성", "삼성컴퓨터", "s001", 2000000);
		
		System.out.println(com.inform());
		
		Snack sn = new Snack();
		sn.setBrand("농심");
		
		Dress dr = new Dress();
		dr.setPrice(100000);;
		
		Product pr = new Product();
		//		pr.set
		// 부모 클래스는 자식 클래스의 멤버 접근 불가
		
		
	}
}
