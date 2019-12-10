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
		// list2.add(new String("bbb"));
		
		// 타입제한 왜 하는가 ?
		// 사용하려는 기능의 목적이 Student 하나로 정해져 있기때문에 타입 제한을 해도 되는 것
		// 타입 제한을 안한 상태에서 Student 객체의 setName() 메소드 호출하기
		if ( list1.get(0) instanceof Student) {
			((Student)list1.get(0)).setName("aaa");
		}
		
		// 타입제한이 된 리스트에서
		// Student 객체의 setName() 메소드 호출하기 
		list2.get(0).setName("aaa");
		
		
	}
	
	// ArrayList 에 학생 객체 추가 메소드
	public void insertStudent(Student std) {
		list.add(std);
	}
	// ArrayList 에 저장되어있는 모든 데이터 출력
	// 기본적으로 10칸의 공간을 가지나, size()는 null을 제외한 요소의 개수만 세는 메소드이기때문에
	// null 값 제외하는 if 필요 없음
	public void printStudent() {
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}


	//	 매개변수로 전달받은 index에 해당하는 요소 삭제	
	public void removeStudent(int index) {
		list.remove(index);
	}
	
	
}
