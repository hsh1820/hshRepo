package com.kh.chap04_UserException.conrtroller;

import java.util.Scanner;

import com.kh.chap04_UserException.model.exception.UserException;

public class UserExceptionController {	
	// 숫자 3개를 입력 받아 합을 출력하는 메소드
	// 단, 0 입력 시 바로 프로그램 종료
	Scanner sc = new Scanner(System.in);
	public void method() {
		int[] num = new int[3];
		int hap = 0;
		try {
		for(int i=1;i<=num.length;i++) {
			System.out.print("입력 "+i+" : ");
			 num[i] =sc.nextInt();	
			 
			 if(num[i] == 0 ) {
				 System.out.println("프로그램 강제 종료.");
				 return;
			 }else {
				 hap += num[i];
			 	}
			}
			System.out.println("합 : "+hap);
			System.out.println("프로그램 정상 종료");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public void method1() {
		try {
			method2();
			System.out.println("프로그램 정상 종료 ");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void method2() throws UserException{
		int sum = 0;
		int input = 0;
		for (int i=1; i<4;i++) {
			System.out.print("입력"+i+ " : ");
			input = sc.nextInt();
			
			if(input == 0) {
				throw new UserException("프로그램 강제 종료 ");
			}else {
				sum += input;
			}
		}
		System.out.println("합 : "+  sum);		
	}
}
