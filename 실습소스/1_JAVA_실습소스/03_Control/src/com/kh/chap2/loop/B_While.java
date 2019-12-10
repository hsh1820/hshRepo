package com.kh.chap2.loop;

import java.util.Scanner;

public class B_While {
	Scanner sc = new Scanner(System.in);
	
	// 1. 단독 while문
	public void method1() {
		int i = 1; // 초기식
		
		while(i <= 10) { // 조건식
			// while문은 조건식이 true인 경우 반복을 진행함
			System.out.println(i+" 출력");
			
			i++; // 증감식
		}//System.out.println();
		
		// for문
		for(int j = 1; j<=10;j++) {
			System.out.println(j+" 출력");
		}
	}
	
	public void method2() {
		// 10 ~ 1 까지 역순 출력
		int i = 10;
		
		while(i>0) { // i>=1
			System.out.println(i + " 출력");
			i--;
		}
		
		for(int j =10 ; j>0 ; j-- )
			System.out.println(j + " 출력");
		
		
		
	}

	public void method3() {
		// 정수 0이 입력될 때 까지
		// 입력받은 모든 값을 더하여 결과 출력
		
		int input = -1; // 입력받은 정수를 저장할 변수
		int sum = 0; // 정수의 합을 저장할 변수
		
		while(input != 0) {
			
			System.out.print("입력 : ");
			input = sc.nextInt();
			sum += input;
		}
		System.out.println("총합 : " + sum);
	}
	
	public void method4() {
		// 정수 0이 입력될 때 까지
		// 입력받은 모든 값을 더하여 결과 출력

		int input = 0; // 입력받은 정수를 저장할 변수
		int sum = 0; // 정수의 합을 저장할 변수
		boolean check = true; // 반복문의 반복 여부를 지정할 논리형 변수
		
		while(check) { /* 조건식의 경우 결과가 true/false */
			System.out.print("입력 : ");
			input = sc.nextInt();
			
			if(input == 0) { // 입력값이 0이면
				check = false;
				// 반복문 종료를 위해 check 값을 false로 변경
				
			}else {
				sum += input;
			}
		}
		System.out.println("총합 : " + sum);
	}
	
	
	// 중첩 while 문
	// 주의사항!
	// - while문 하나만으로도 무한루프의 가능성이 다분함
	// - while문을 중첩해서 사용하는 경우
	//   무한루프의 위험성이 늘어남
	// --> while문을 무한으로 쓰는 경우는 종료조건이 확실히 나타날 수 있는 경우에만 사용
	
	public void method5() {
		
		// method3() do ~ while 구문으로 변경
		
		int input = -1;
		int sum = 0;
		
		do {
			System.out.print("입력 : ");
			input = sc.nextInt();
			sum += input;
			
		}while(input != 0);
		// do ~ while 문은 while이 끝나는 시점에 세미콜론 (;) 
		// 반드시 추가 
		
		System.out.println("총합 : " + sum);
	}
	
	
	public void method6() {
		// 키보드로 입력한 문자열을 모두 한 문장으로 만들어 출력
		// 단, exit 입력 시 종료.
		
		String str =""; // 입력
		// 참조값은 있되 실질적인 데이터는 없음
		//		String str =null; // 공간이 비어있다. == 참조하는 것이 없다. 
		//		String str;    	  // str 쓰레기 값 들어가있음. 
		
		String sen = ""; // 입력받은 문자열 문장으로 합치는 변수

		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			if (!str.equals("exit")) {
				sen += (str+" ");
			}
			
		}while(!str.equals("exit")); // exit
		
		System.out.println(sen);
	}
	
	public void method7() {
		// do ~ while 을 이용하여 메뉴화면 구성하기
		int input = 0;
		
		do {
				System.out.println("1. 메소드 1 실행");
				System.out.println("2. 메소드 2 실행");
				System.out.println("3. 메소드 3 실행");
				System.out.println("4. 메소드 4 실행");
				System.out.println("5. 메소드 5 실행");
				System.out.println("6. 메소드 6 실행");
				System.out.println("0. 종료");
				System.out.print("메뉴 선택 ==> ");
				input = sc.nextInt();
				
				switch(input) {
				case 1 : method1(); break;
				case 2 : method2(); break;
				case 3 : method3(); break;
				case 4 : method4(); break;
				case 5 : method5(); break;
				case 6 : method6(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("잘못 입력하셨습니다.");
				}
				
		} while(input!=0);
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
