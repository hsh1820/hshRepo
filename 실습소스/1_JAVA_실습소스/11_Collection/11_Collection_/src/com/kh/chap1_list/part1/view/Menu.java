package com.kh.chap1_list.part1.view;

import java.util.Scanner;

import com.kh.chap1_list.part1.controller.StudentController;
import com.kh.chap1_list.part1.model.vo.Student;

// MVC model 2 에서 view의 의미 :
/*	-> 사용자(클라이언트)로 부터 요청을 받고 응답을 보여주는 
 * 	직접적으로 사용자와 마주하는 부분 
 * */
// CharacterUI == TerminalUI == CommandLI

public class Menu {
	private Scanner sc = new Scanner(System.in);
//	private ObjectArrayController Con = new ObjectArrayController();
	private StudentController Con = new StudentController();
	
	public void display() {
		int sel = 0; // 입력받은 메뉴 번호를 저장할 변수 선언
		
		do {
			System.out.println("=== 학생 관리 프로그램 ===");
			System.out.println("1. 학생 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 학생 삭제");
			System.out.println("0. 프로그램 종료");			
			System.out.print("메뉴 선택 --> ");
			sel = sc.nextInt();
			sc.nextLine(); // 버퍼에 남아 있는 줄바꿈 문자 제거
			
			switch(sel) {
			case 1 : {
				insertStudent();
				break;
			}
			case 2 : {
				printStudent();
				break;
			}
			case 3 : {
				removeStudent();
				break;
			}
			case 0 : {
				System.out.println("프로그램 종료 ");
				break;
			}
			default : {
				System.out.println("잘못입력하셨습니다.");
			}
			}
			
		}while(sel != 0);
		
	}
	private void insertStudent()	{
		System.out.println("[학생 추가]");
		System.out.print(" 이름 : ");
		String name = sc.nextLine();
		System.out.print("점수 : ");
		int score = sc.nextInt();
		sc.nextLine();
		
		// 학생 객체를 생성하자마자 해당 객체의 주소를
		// ObjectArrayController 의 insertArray()로 전달
		Con.insertStudent(new Student(name,score));
		
	}
	
	private void printStudent()	{
		System.out.println("[전체 학생 정보 출력]");
		Con.printStudent();
	}
	
	// 학생 삭제 메소드 
	// 입력받은 인덱스에 해당하는 학생 객체를 삭제
	private void removeStudent()	{
		System.out.println("[학생삭제]");
		System.out.print("인덱스 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		Con.removeStudent(index);
	}
	
	
}
