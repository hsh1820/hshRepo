package com.kh.chap1_poly.practice.view;

import java.util.Scanner;

import com.kh.chap1_poly.practice.controller.LibraryController;
import com.kh.chap1_poly.practice.model.vo.Book;
import com.kh.chap1_poly.practice.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		//public void mainMenu() {
//		// 이름, 나이, 성별을 키보드로 입력 받은 후 Member 객체 생성
//		// LibraryController의 insertMember() 메소드에 전달
//		==== 메뉴 ==== // 무한 반복 실행
//		1. 마이페이지 // LibraryController의 myInfo() 호출하여 출력
//		2. 도서 전체 조회 // LibraryMenu의 selectAll() 호출
//		3. 도서 검색 // LibraryMenu의 searchBook() 호출
//		4. 도서 대여하기 // LibraryMenu의 rentBook() 호출
//		9. 프로그램 종료하기
//		메뉴 번호 :
//		}
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("성별  : ");
		char gender = sc.next().charAt(0);
		
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		while(true) {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 전체 조회");
		System.out.println("3. 도서 검색");
		System.out.println("4. 도서 대여하기");
		System.out.println("9. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1 : {
				
				System.out.println(lc.myInfo().toString());
				break;
			}
			case 2: {
				selectAll();
				break;
			}
			case 3:{
				searchBook();
				break;
				
			}
			case 4: {
				// 대여가능한 도서목록 출력
				rentBook();
				break;
			}
			case 9 : {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
				
		}
	}
}
	public void selectAll() {
		
		Book[] bList = lc.selectAll();
		
		for(int i=0;i<bList.length;i++) {
			System.out.println(i+"번 도서 : "+ bList[i]);
//			ex ) 0번도서 : 백종원의 집밥 / 백종원 / tvN / true
		}
	}
	public void searchBook() {
		sc.nextLine();
		System.out.print( "검색할 키워드 : ");
		String keyword = sc.nextLine();
		
		
		Book[] searchList =  lc.searchBook(keyword);
		
		for(int i = 0;i<searchList.length;i++) {
			if(searchList[i] != null)
			System.out.println(searchList[i]);
		}
		
	}
	public void rentBook() {
		for(int i=0;i<lc.selectAll().length;i++) {
			System.out.println(i+"번 도서 : "+ lc.selectAll()[i]);
		}
		
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		int result = lc.rentBook(index);
		
		if(index == 0) {
			System.out.println("성공적으로 대여되었습니다.");
		}else if(index == 1) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		}else if(index == 2) {
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
		}
		
	}
	
}
