package com.kh.chap2.practice;

import java.util.Scanner;

public class LoopPractice1 {
	Scanner sc = new Scanner(System.in);
	
	
	public void practice1()	{
		
	System.out.print("1이상의 숫자를 입력하세요 : ");
	int input = sc.nextInt();
	
		if (input >= 1) {
			for(int i = 1; i <= input ; i++) {
				System.out.print(i +" ");
			}
		}else System.out.print("1 이상의 숫자를 입력해주세요.");
	}
	
	public void practice2()	{
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
			if (input >= 1) {
				for(int i = input; i > 0 ; i--) {
					System.out.print(i +" ");
				}
			}else System.out.print("1 이상의 숫자를 입력해주세요.");
		}
	
	public void practice3()	{
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int hap=0;
		System.out.print("1");
			for(int i = 1; i <= input ; i++) {
				//System.out.print(i);
				hap += i;
				//if(i != input)System.out.print(" + ");
				if(i>1)System.out.print(" + "+i);
			} System.out.print(" = " + hap);
		}
	
	public void practice4()	{
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		if (input1 < input2 )	{
			int swap = input1;
			input1 = input2;
			input2 = swap;
		}
		if (input1 > 0 && input2 > 0) {
			for (int i = input2; i <= input1 ; i++ ) {
				System.out.print(i + " ");
			}
		
		
		
		
		}else System.out.print("1 이상의 숫자를 입력해주세요.");
		
		
	}
	
	public void practice5()	{
		System.out.print("숫자 : ");
		int num1 = sc.nextInt();
		
		for(int i = num1; i <= num1 ; i++) {
			System.out.printf("===== %d단 =====\n",num1);
			for (int j = 1; j <=9 ; j++)	{
				
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}
		
	
	}
	
	
	
	public void practice6()	{
		System.out.print("숫자 : ");
		int num1 = sc.nextInt();
		
		for(int i = num1; i <= 9 ; i++) {
			System.out.printf("===== %d단 =====\n",i);
			for (int j = 1; j <=9 ; j++)	{
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}
	
	}
	public void practice7()	{
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		
		for(int j = 1; j <= num1; j++) {
			for(int i = 1; i <= j; i++ ) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	public void practice8()	{
		System.out.print("정수 입력 : ");
			int num1 = sc.nextInt();
			
//			for(int j = 1 ; j <= num1 ; j++) {
//				for(int i = num1; i >= j; i--) {
//					System.out.print('*');
//		}System.out.println();
//	}
			
	for(int j = num1 ; j >= 1 ; j--) {
				for(int i = j; i >= 1; i--) {
					System.out.print('*');
		}System.out.println();
	}
			
			
			
	}
	public void practice9()	{
		System.out.print("자연수 하나를 입력하세요  : ");
		int num1 = sc.nextInt();
		int count = 0;
		
		for (int i = 1; i <= num1; i++) {
			//System.out.print(i+" ");
			
			if (i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");				
			}
			if (i % 2 == 0 && i % 3 == 0 ) {
				count +=1;
			}
			
			
		}
		
		System.out.print("\ncount : "+ count);
	
	}
	
	public void practice10()	{
		System.out.print("자연수 하나를 입력하세요  : ");
		int num1 = sc.nextInt();
		
		int i;
		int j;
		int k; 

		 

		for(i=1; i<= num1; i++) { 
		           for(j=num1; j>i; j--) { 
		               System.out.printf(" "); 
		           	} 
		           		for(k=1; k<=i; k++)  { 
		        	   System.out.printf("*"); 
		           		} 
		           System.out.printf("\n"); 
		} 
	
	}
	public void practice11() {
		System.out.print("자연수 하나를 입력하세요  : ");
		int num1 = sc.nextInt();
		
		for(int i = 1; i <=num1; i++) {
			for(int j = 1; j <=i;j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		for(int i = 1; i <=num1; i++) {
			for(int j = num1-1; j >=i;j--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	public void practice12() {
		System.out.print("자연수 하나를 입력하세요  : ");
		int num1 = sc.nextInt();
		
		int i;
		int j;
		int k; 

		 

		for(i=1; i<= num1; i++) { 
		           for(j=num1; j>i; j--) { 
		               System.out.printf(" "); 
		           	} 
		           		for(k=1; k<=i; k++)  { 
		        	   System.out.printf("*"); 
		           		} 
		           		for(k=1; k<i; k++)  { 
				        	   System.out.printf("*"); 
				           		} 
		           System.out.printf("\n"); 
		} 
	
	}
	
	public void practice13() {
	//		System.out.print("정수 입력 : ");
	//		int num1 = sc.nextInt();
		
		for(int i = 1; i<=5;i++) {
			for(int j = 1; j <=5 ; j++) {
				System.out.print('*');				
			}
			for(int j = 1; j <=5 ; j++) {
				System.out.print('5');				
			}
			System.out.println();
		}
	}
			
}
