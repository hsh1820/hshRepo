package com.kh.chap3.branch;

import java.util.Scanner;

public class A_Break {
	Scanner sc = new Scanner(System.in);
	//1. break
	// --> ���� ����� �ݺ����� ���� ������ ����
	public void method1() {
		// 1���� �Է¹��� �� ������ ��� ���� �� ���ϱ�
		int input = sc.nextInt();
		int sum = 0;
		
		for(int i = 1;/* ���ǽ� ���� */;i++) {
			System.out.print("�Է� : ");
			sum += i;
			if(input == i) {
				// �Է°��� i�� ���� ��� �ݺ��� ����
				break;
			}
		}
		System.out.print("���� : " + sum);
	}
	public void method2() {
		// ���ڿ��� �Է¹޾�
		// �ش� ���ڿ��� ���� ����(����)�� ����ϴ� �ݺ� ���α׷� ����
		// ��, "exit" �Է� �� ����
		
		String str = "";

		while(true) {
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();

			if(str.equals("exit")){
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			System.out.println(str + "�� ���� ���� : " + str.length());
			
		}			
		
		
		
		
		
		
		
	}
}
