package com.kh.chap03.practice;

import java.util.Scanner;


public class BranchPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1()	{
		
		int input =0;
//		while(true) {
		do {	
		System.out.print("1이상의 숫자를 입력하세요 : ");
		input = sc.nextInt();
			
		if(input < 0) {				
		System.out.print("1 이상의 숫자를 입력해주세요");				
		}
			
		for(int i= 1;i<=input;i++) {				
		System.out.print(i+" ");
			}
		}while(input < 0);
	}
	
	 

	
	//	for(int i =0; i<=input;i++) {
	//		System.out.print(i+" ");
	//		
	//	}
	//	System.out.println();
	//	
	//	break; // while break
	
	
	

	public void practice2()	{
//		
		int input =0;
		while(true) {
		do {	
		System.out.print("1이상의 숫자를 입력하세요 : ");
		input = sc.nextInt();
		System.out.println();
		if(input < 0) {				
		System.out.print("1 이상의 숫자를 입력해주세요 ");				
		}
			
for(int i= input ;i>=1;i--) {				
	System.out.print(i+" ");
			}
		}while(input < 0);
	}
}

	public void practice3() {
	
	System.out.print("첫 번째 숫자 : ");
	int num1 = sc.nextInt();
	System.out.print("두 번째 숫자 : ");
	int num2 = sc.nextInt();
	int swap;
	
	if (num2>num1) {
		swap = num2;
		num2 = num1;
		num1 = swap;		
	}
	for (int i = num2; i <= num1; i++) {
		System.out.print(i+" ");
	}
	
	
	
	}

	public void practice4() {
		int input =0;
//		while(true) {
		do {	
		System.out.print("9 이하의 숫자를 입력하세요 : ");
		input = sc.nextInt();
			
		if(input > 9) {				
		System.out.print("9 이하의 숫자를 입력해주세요");				
		}
			
		for(int i= 2;i<=input;i++) {				
			System.out.println("=====" + i + "단=====");
			for(int j = 1; j<=9;j++) {
				System.out.printf("%2d x %2d = %2d \n",i,j,i*j);
				}
			}
		}while(input < 9);
	}

	public void practice5() {
		
		System.out.print("시작 숫자 : ");
		int start = sc.nextInt();
		System.out.print("공차 : ");
		int cha= sc.nextInt();
		
		int hap =start;
		for(int i = 1; i<=10; i++) {
			hap += cha ;
			System.out.print(hap-cha+" ");
		}
			
		
	}

	public void practice5_1() {
		System.out.print("시작 숫자 : ");
		int start = sc.nextInt();
		System.out.print("공차 : ");
		int num = sc.nextInt();
		
//		int count = 0;
//		for(int i =start ; ; i+=num) {
		for(int i =start, count=0 ;count <= 10 ; i+=num, count++) { // 방법은 있으나 가독성이 떨어짐

			System.out.print(i + " ");
//			count++;

//			if(count == 10 ) {
//				break;
//			}
		}
		
	}
	public void practice6() {
//		연산자(+, -, *, /, %) : /
//		정수1 : 10 
//		정수2 : 4 
//		10 / 4 = 2 
		
//		연산자(+, -, *, /, %) : /
//		정수1 : 10
//		정수2 : 0
//		0으로 나눌 수 없습니다. 다시 입력해주세요.
		
//		연산자(+, -, *, /, %) : ^ 
//		정수1 : 10 
//		정수2 : 4
//		없는 연산자입니다. 다시 입력해주세요
		
//		연산자(+, -, *, /, %) : exit
//		프로그램을 종료합니다.
//		boolean tf = true;
		
		while(true) {
//		sc.nextLine();
		System.out.print("연산자(+,-,*,/,%) : ");
		String opt = sc.nextLine();
		if (opt.equals("exit")) {		
			System.out.printf("프로그램을 종료합니다."); 
//			tf = false;
			break; 
		}
		System.out.print("정수1: ");
		int num1 = sc.nextInt();
		System.out.print("정수2: ");
		int num2 = sc.nextInt();

		sc.nextLine(); // 입력버퍼에 남아있는 개행문자 제거용  \r\n
		
		switch(opt) {
		case "+" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1+num2);break;
		case "-" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1-num2);break;
		case "/" :{
			if (num1== 0 || num2 ==0) {
				System.out.printf("0으로 나눌 수 없습니다. 다시 입력해주세요.\n");
				break;
			}			
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1/num2);break;
		}
		case "*" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1*num2);break;
		case "%" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1%num2);break;
		default : 
			System.out.printf("없는 연산자입니다. 다시 입력해주세요.\n");
//			continue;
		}
	}
		
		
		
		
		
		
		
		
		
		
		
 	}
}
