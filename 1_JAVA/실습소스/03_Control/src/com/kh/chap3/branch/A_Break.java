package com.kh.chap3.branch;

import java.util.Scanner;

public class A_Break {
	Scanner sc = new Scanner(System.in);
	//1. break
	// --> 가장 가까운 반복문을 빠져 나오는 구문
	public void method1() {
		// 1부터 입력받은 수 까지의 모든 정수 합 구하기
		int input = sc.nextInt();
		int sum = 0;
		
		for(int i = 1;/* 조건식 생략 */;i++) {
			System.out.print("입력 : ");
			sum += i;
			if(input == i) {
				// 입력값과 i가 같은 경우 반복문 종료
				break;
			}
		}
		System.out.print("총합 : " + sum);
	}
	public void method2() {
		// 문자열을 입력받아
		// 해당 문자열의 글자 개수(길이)를 출력하는 반복 프로그램 구현
		// 단, "exit" 입력 시 종료
		
		String str = "";

		while(true) {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();

			if(str.equals("exit")){
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println(str + "의 글자 개수 : " + str.length());
			
		}			
		
		
		
		
		
		
		
	}
}
