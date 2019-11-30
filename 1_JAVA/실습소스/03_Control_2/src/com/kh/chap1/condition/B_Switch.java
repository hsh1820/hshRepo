package com.kh.chap1.condition;

import java.util.Scanner;

public class B_Switch {
	
	// switch 문은 if - else if  - else 와 비슷한 조건문임.
	// 단, 조건을 범위로 지정할 수 없음.
	// input > 10 (X)
	
	/*
	 * switch 문 표현식
	 * 
	 * switch(조건식) {
	 * case 값1 : 실행코드1; break;
	 * case 값2 : 실행코드2; break;
	 * case 값3 : 실행코드3; break;
	 * ...
	 * default : 실행코드;
	 * }
	 * 
	 * switch 문의 조건식
	 * --> if문 처럼 결과가 true/false가 아닌
	 * 		동등 비교가 되는 식을 작성
	 *
	 * */
	public void method1() {
		// 정수를 입력받아
		// 1이면 "1층 입니다."
		// 2이면 "2층 입니다."
		// 3이면 "3층 입니다."
		// 잘못 입력한 경우 "잘못 입력하셨습니다."
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		switch(input) {
			case 1: {
				System.out.print(input + "층 입니다.");
				//break;
			}
			case 2: {
				System.out.print(input + "층 입니다.");
				break;
			}
			case 3: {
				System.out.print(input + "층 입니다.");
				break;
			}
			default : System.out.print("잘못 입력하셨습니다.");
		}
		
		
		
		
		
		
		
		
		
	}

	public void method2() {
		// switch 문을 이용한 권한 부여
		Scanner sc = new Scanner(System.in);
		System.out.print("등급을 작성해 주세요.: ");
		// 관리자, 매니저, 회원
		
		String grade = sc.nextLine();
		
		switch(grade) {
		case "관리자" : System.out.println("강퇴");
		case "매니저" : System.out.println("등록");
		case "회원" : System.out.println("조회"); break;
		
		default : System.out.println("잘못 입력함");
		
		}
			
		
		}
		
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12월 중 하나를 입력해 주세요 : ");
		int month = sc.nextInt();
		
		String season="";
		
			switch(month) {
			case 3:
			case 4:
			case 5: {
				season = "봄";
				break;
				}
			case 6:
			case 7:
			case 8: {
				season = "여름";
				break;
				}
			case 9:
			case 10:
			case 11: {
				season = "가을";
				break;
				}
			case 12:
			case 1:
			case 2: {
				season = "겨울";
				break;
				}
			default : {
				System.out.print("해당하는 계절이 없습니다.");
			}
			System.out.print(season);
		}		
		
	}
		
	public void method4( ) {
		//1~12월까지 입력받아
		// 해당하는 달의 일수를 출력하세요.(switch문 사용)
		/*
		 * ex)
		 * 달 입력 : 10
		 * 10월은 31일 입니다.
		 * 
		 * 달 입력 : 4
		 * 4월은 30일 입니다.
		 * 
		 * 달 입력 : 15
		 * 잘못 입력하셨습니다.
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
				
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		int day=0;
		
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day =31;
				System.out.println(month + "월은 "+ day + "일 입니다.");
				break;
			case 2:
				day =28;
				System.out.println(month + "월은 "+ day  + "일 또는 "+ (day+1) + "일 입니다.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day =30;
				System.out.println(month + "월은 "+ day + "일 입니다.");
				break;
			default : {
				System.out.print("잘못 입력하셨습니다.");
			}
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
