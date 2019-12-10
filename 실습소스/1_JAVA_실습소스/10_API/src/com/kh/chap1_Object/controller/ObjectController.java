package com.kh.chap1_Object.controller;

import com.kh.chap1_Object.model.vo.Student;

public class ObjectController {
	
	// API : Application Programming Interface
	// 응용 프로그램을 만들 때 프로그래밍 언어가 제공하는 
	// 기능들을 제어할 수 있는 인터페이스를 제공하는 것
	
	// Object class
	/*
	 *  - 필드가 존재하지 않고, 11개의 메소드만 존재(모든 클래스들이 기본적으로 가지고 있어야하는 기능들) 
	 *  - 모든 클래스의 최상위 부모이기 때문에 
	 *  	어떤 클래스에서든 상속이 되어 바로 사용 가능하다
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public void method1() {
		Student std1 = new Student("홍길동", "A강의장", 20, 80);
		System.out.println(std1);
		
		Student std2 = new Student("홍길동", "A강의장", 20, 80);
		System.out.println(std2);
		
		// 동등 객체(hashCode()) / 동일 객체(equals()==object에서 제공)
		// 동일 객체 : 두 객체가 서로 같은 '값'을 가지고 있을 때 성립
		// 동등 객체 : 두 객체가 하나다. 완전히 같은 객체(같은 주소값)
		// 두가지를 비교하는 방법이 Object클래스 안에 있음
		
		// equals() 가 @override 안되있는 상태 
		System.out.println("둘의 값이 같은가?"+ std1.equals(std2));
		
		
		
		
		
	}
}
