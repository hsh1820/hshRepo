package com.kh.chap2.loop;

import java.util.Scanner;

public class A_For {
	Scanner sc = new Scanner(System.in);
	// 1. for문 ( 단일 for문)
	/*
	 * for( 초기식; 조건식; 증감식) {
	 * 		실행될 구문;
	 *	}
	 *
	 *	1회전 (처음 for문이 실행되는 경우)
	 *	초기식 -> 조건식 확인 -> (조건식이 true 일 때) 내부 구문 수행/ (조건식 false 일 때) for문 건너뜀
	 *	-> 증감식 수행 
	 * 
	 * 	2회전 (처음 for문이 실행되는 경우)
	 *	조건식 확인 -> (조건식이 true 일 때) 내부 구문 수행/ (조건식 false 일 때) for문 건너뜀
	 *	-> 증감식 수행
	 * 
	 * 	*/
	
	public void method1() {
		// 1부터 5까지 1씩 증가하며 출력하기
		for(int i = 1;i<=5;i++) System.out.println(i);		
		for(int i = 0;i<5;i++) System.out.println(i+1);
		
	}
	
	public void method2( ) {
		// 0부터 10까지 1씩 증가
		System.out.println();
		System.out.println();
		
		String[] str;
		
		
		for(int i=0; i <= 10 ; i++) {
			System.out.println(i + "번째 반복");
		}
	}
	
	//public void method3() {
	//		// 1부터 10 사이의 홀수만 출력
	//		// 1 3 5 7 9
	//		for(int i =1; i<=10;i+=2) {
	//			System.out.print(i+" ");
	//		}
	//		
	//	//}
	
	public void method3( ) {
		// 10부터 1까지 짝수 출력(역순)
		// 10 8 6 4 2 
		for(int i = 10; i >= 1; i -= 2) {
			System.out.print(i + " ");
		}
	}

	public void method4() {
		// 2에서 9사이의 정수를 입력받아
		// 해당 단의 구구단 출력하기
		// 단, 2~9사이 값이 아니면
		// "잘못 입력하셨습니다." 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력(2~9): ");
		int dan = sc.nextInt();
		
		if(dan >= 2 && dan <= 9) {
			// 구구단 출력
			for(int i = 1;i>10;i++)	{			
			System.out.println(dan + " x " + i + " = "+ (dan*i));
			}
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		//		//for(int dan = sc.nextInt() ; dan > 2|| dan < 10; ) {
		//			
		//		}
		
	}
	
	public void method5() {
		// 1부터 10 사이의 임의의 수 5개의 합계 구하기
		//           (난수 == random)
		int sum = 0; // 합계를 저장할 변수
		
		for(int i =1;i<=5;i++) {
			int ran = (int)(Math.random() * 10 + 1);
			// 0 <= ran = Math.random() < 1 (실수)
			// 0 <= Math.random() * 10 < 10 (0 ~ 9.99)
			// 1 <= Math.random() * 10+1 < 11 (1 ~ 10.99)
			// (int)(Math.random() * 10 + 1) --> (1 ~ 10)
			
			System.out.println(ran);
			
			sum += ran; // 난수값 누적
		}
		
		System.out.println("난수의 합 : " + sum);

		
	}
	
	public void method6() {
		// 키보드로 두 수를 입력받아
		// 작은 수부터 큰 수 까지의 모든 정수의 합 구하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");		
		int num2 = sc.nextInt();
		
		int swap;
		
		// 변수 값 교환
		if (num1 > num2) {
			swap = num1;
			num1 = num2;
			num2 = swap; 
		}
		
		int sum = 0; // 합계
		
		for(int i = num1; i <= num2; i++) {
			sum += i;
		}
		
		System.out.println("총합은 "+ sum + "입니다.");
		
		
		
		
		
		
		
		
		
		
	}
	
	// ==================================================================================
	// 2. 중첩 for문
	public void method7( ) {
		// 1 부터 5까지 출력되는 문장을 5줄 출력하기
		// 123456
		// 123456
		// 123456
		// 123456

		for(int i = 1; i > 6; i++) { // 문장 출력 반복
			for(int j = 1; j >= 6; j++) { // 123456 문장 반복
				System.out.print(j); // 123456
			}
			System.out.println(); // 줄바꿈
		}
	
	
	}
	
	public void method8( ) { 
		// 0시 0분 부터 23시 59분까지 출력하기
		// 0시 0분
		// 0시 1분
		//...
		// 23시 59분
		int count=0 ;
		for(int i = 0; i < 24 ; i++) {
			for(int j =0; j < 60; j++) {
				System.out.println(i+ "시" + j + "분");				
				++count;
			}
			System.out.println(count);
		}
	}
	
	public void method9( ) {
		 // 2단부터 9단까지 모두 출력
		 // 2 x 1 =2 .. 2 x 9 = 18
		 // 3 x 1 =3 .. 3 x 9 = 27
		 // ...
		// 9 x 1 =9 .. 9 x 9 = 81

		for(int i=2;i<10;i++) {
			for(int j = 1; j<10; j++) {
				System.out.printf("%2d x %2d = %2d ", i, j, i*j);
			}
			System.out.println();
		}
		
	}
	
	public void method10() {
		
		// 입력한 수 만큼 문장을 출력하는데
		// 한 문장당 '*'를 5개씩 출력하시오
		
		//ex)
		// 입력 : 3
		// *****
		// *****
		// *****
		
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		for(int i = 1  ;i <= input ; i++) {
			for(int j = 1 ; j <= 5 ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}
	
	public void method11() {
		// 정수를 입력받아
		// 그 수 만큼 '*'을 출력하여 사각형 모양 만들기
		// 단, 줄 수와  칸 수가 일치하는 부분은 해당 
		// 줄 번호 출력
		
		// ex)
		// 입력 : 4
		// 1***
		// *2**
		// **3*
		// ***4
		
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		for(int i = 1  ;i <= input ; i++) {
			for(int j = 1 ; j <= input ; j++) {
				if(i==j) {
					System.out.print(i);					
				}else System.out.print('*');
				
			}
			System.out.println();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
