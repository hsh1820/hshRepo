package com.kh.chap3.branch;

import java.util.Scanner;

public class B_Continue {
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		// 1 ���� 100 ������ ���� ��
		// 4�� ����� ������ ������ �� ���ϱ�

		int sum = 0;
		
		for(int i = 1; i<=100;i++) {
			
			if(i % 4 ==0) {
				continue;
			}
			sum += i;
		}
		System.out.println("�հ� : " + sum);
	}
	
	public void method2() {
		// 2~9 �� ������ �� Ȧ���ܸ� ����ϱ�
		

		for(int dan =2 ; dan <=9 ; dan++) {
			if(dan % 2 == 0 ) {
				continue;
			}
			System.out.println("=====" + dan + "��=====");
			
			for(int su =1; su <=9; su++) {
				System.out.printf("%2d x %2d = %2d ", dan, su, dan*su);
			}System.out.println();
		}
		
		
		
		
		
		
		
	}
}

