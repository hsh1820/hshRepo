package com.kh.chap03.practice;

import java.util.Scanner;


public class BranchPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1()	{
		
		int input =0;
//		while(true) {
		do {	
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		input = sc.nextInt();
			
		if(input < 0) {				
		System.out.print("1 �̻��� ���ڸ� �Է����ּ���");				
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
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		input = sc.nextInt();
		System.out.println();
		if(input < 0) {				
		System.out.print("1 �̻��� ���ڸ� �Է����ּ��� ");				
		}
			
for(int i= input ;i>=1;i--) {				
	System.out.print(i+" ");
			}
		}while(input < 0);
	}
}

	public void practice3() {
	
	System.out.print("ù ��° ���� : ");
	int num1 = sc.nextInt();
	System.out.print("�� ��° ���� : ");
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
		System.out.print("9 ������ ���ڸ� �Է��ϼ��� : ");
		input = sc.nextInt();
			
		if(input > 9) {				
		System.out.print("9 ������ ���ڸ� �Է����ּ���");				
		}
			
		for(int i= 2;i<=input;i++) {				
			System.out.println("=====" + i + "��=====");
			for(int j = 1; j<=9;j++) {
				System.out.printf("%2d x %2d = %2d \n",i,j,i*j);
				}
			}
		}while(input < 9);
	}

	public void practice5() {
		
		System.out.print("���� ���� : ");
		int start = sc.nextInt();
		System.out.print("���� : ");
		int cha= sc.nextInt();
		
		int hap =start;
		for(int i = 1; i<=10; i++) {
			hap += cha ;
			System.out.print(hap-cha+" ");
		}
			
		
	}

	public void practice5_1() {
		System.out.print("���� ���� : ");
		int start = sc.nextInt();
		System.out.print("���� : ");
		int num = sc.nextInt();
		
//		int count = 0;
//		for(int i =start ; ; i+=num) {
		for(int i =start, count=0 ;count <= 10 ; i+=num, count++) { // ����� ������ �������� ������

			System.out.print(i + " ");
//			count++;

//			if(count == 10 ) {
//				break;
//			}
		}
		
	}
	public void practice6() {
//		������(+, -, *, /, %) : /
//		����1 : 10 
//		����2 : 4 
//		10 / 4 = 2 
		
//		������(+, -, *, /, %) : /
//		����1 : 10
//		����2 : 0
//		0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.
		
//		������(+, -, *, /, %) : ^ 
//		����1 : 10 
//		����2 : 4
//		���� �������Դϴ�. �ٽ� �Է����ּ���
		
//		������(+, -, *, /, %) : exit
//		���α׷��� �����մϴ�.
//		boolean tf = true;
		
		while(true) {
//		sc.nextLine();
		System.out.print("������(+,-,*,/,%) : ");
		String opt = sc.nextLine();
		if (opt.equals("exit")) {		
			System.out.printf("���α׷��� �����մϴ�."); 
//			tf = false;
			break; 
		}
		System.out.print("����1: ");
		int num1 = sc.nextInt();
		System.out.print("����2: ");
		int num2 = sc.nextInt();

		sc.nextLine(); // �Է¹��ۿ� �����ִ� ���๮�� ���ſ�  \r\n
		
		switch(opt) {
		case "+" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1+num2);break;
		case "-" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1-num2);break;
		case "/" :{
			if (num1== 0 || num2 ==0) {
				System.out.printf("0���� ���� �� �����ϴ�. �ٽ� �Է����ּ���.\n");
				break;
			}			
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1/num2);break;
		}
		case "*" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1*num2);break;
		case "%" :
			System.out.printf("%2d %s%2d = %2d\n",num1,opt,num2,num1%num2);break;
		default : 
			System.out.printf("���� �������Դϴ�. �ٽ� �Է����ּ���.\n");
//			continue;
		}
	}
		
		
		
		
		
		
		
		
		
		
		
 	}
}
