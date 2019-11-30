package com.kh.chap1_list.part1.controller;

import java.util.ArrayList;

import com.kh.chap1_list.part1.model.vo.Student;

// MVC Model 2 에서 Controller의 의미
/*	-> View에서 전달받은 사용자의 요청을 상황에 따라
 * 	알맞은 Model 에 전달하고
 * 	해당 Model에서 처리되어진 결과를
 * 	다시 알맞은 View로 전달하는 역할
 * 	결과적으로는 요청에 따른 프로그램의 흐름을 제어하는 부분
 * */
public class StudentController {
	// 컬렉션 중 ArrayList를 이용하여 Student 객체 관리
	
	// 학생 객체를 저장할 ArrayList 생성
	ArrayList<Student> list = new ArrayList<Student>();
	// <Student> --> Generics(제네릭)
	// 해당 컬렉션에 저장할 객체의 타입을 제한
	
	public void method() {
		// 제네릭 타입 제한 테스트
		ArrayList list1 = new ArrayList();
		ArrayList<Student> list2 = new ArrayList<Student>();
		
		// Student 객체 추가
		list1.add(new Student());
		list2.add(new Student());
		
		// String 객체 추가
		list1.add(new String("aaa"));
		list2.add(new String("bbb"));
		
	}
	
	
}
