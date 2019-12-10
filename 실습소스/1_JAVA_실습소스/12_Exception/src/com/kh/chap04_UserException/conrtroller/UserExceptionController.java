package com.kh.chap04_UserException.conrtroller;

import java.util.Scanner;

import com.kh.chap04_UserException.model.exception.UserException;

public class UserExceptionController {	
	// ���� 3���� �Է� �޾� ���� ����ϴ� �޼ҵ�
	// ��, 0 �Է� �� �ٷ� ���α׷� ����
	Scanner sc = new Scanner(System.in);
	public void method() {
		int[] num = new int[3];
		int hap = 0;
		try {
		for(int i=1;i<=num.length;i++) {
			System.out.print("�Է� "+i+" : ");
			 num[i] =sc.nextInt();	
			 
			 if(num[i] == 0 ) {
				 System.out.println("���α׷� ���� ����.");
				 return;
			 }else {
				 hap += num[i];
			 	}
			}
			System.out.println("�� : "+hap);
			System.out.println("���α׷� ���� ����");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public void method1() {
		try {
			method2();
			System.out.println("���α׷� ���� ���� ");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void method2() throws UserException{
		int sum = 0;
		int input = 0;
		for (int i=1; i<4;i++) {
			System.out.print("�Է�"+i+ " : ");
			input = sc.nextInt();
			
			if(input == 0) {
				throw new UserException("���α׷� ���� ���� ");
			}else {
				sum += input;
			}
		}
		System.out.println("�� : "+  sum);		
	}
}
