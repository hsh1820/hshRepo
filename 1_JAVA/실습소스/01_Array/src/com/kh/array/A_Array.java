package com.kh.array;

import java.util.Scanner;

public class A_Array {
	Scanner sc =new Scanner(System.in);
	// �迭
	// - ���� �ڷ����� ������ �ϳ��� �������� �ٷ�� ��.
	// - ����� ������ �ε����� �����ȴ�.
	//   (index�� 0���� ����)
	
	public void method1() {
		// �迭�� ������� �ʰ� 
		// int �� ���� 5���� ����� ���� ���� �ʱ�ȭ �ϰ�
		// ����ϱ�
		
		//		int num1 =1;
		//		int num2 =2;
		//		int num3 =3;
		//		int num4 =4;
		//		int num5 =5;
		//		
		//		System.out.println(num1);
		//		System.out.println(num2);
		//		System.out.println(num3);
		//		System.out.println(num4);
		//		System.out.println(num5);
	
		// �迭 ����
		// �ڷ���[] �迭��;
		// �ڷ��� �迭��[];
		
		int[] arr;
		
		// �迭 �Ҵ�
		// - ���� ���� ������ �� �ִ� �迭���� �Ҵ�(== ����)
		// �迭�� = new �ڷ���[�迭ũ��];
		
		
		arr = new int[5];
		
		//		// ����ó�� �� �ε��� ��ҿ� ���� �Ͽ� �� ���� ����.
		//		arr[0] = 1;
		//		arr[1] = 2;
		//		arr[2] = 3;
		//		arr[3] = 4;
		//		arr[4] = 5;
				
		for(int i=0; i<arr.length;i++) {
			arr[i] = i+1;
		}
				// ����ó�� �� �迭��ҿ� �����Ͽ� ��µ� ����
				
		//		System.out.println("=== �迭 ��� ===");
		//		System.out.println(arr[0]);
		//		System.out.println(arr[1]);
		//		System.out.println(arr[2]);
		//		System.out.println(arr[3]);
		//		System.out.println(arr[4]);
		for(int i = 0; i < arr.length;i++) {
			System.out.println(arr[i]);			
		}
		System.out.println(arr);
	}
	
	public void method2() {
		// ����ڰ� ������ ũ�⸸ŭ�� �迭�� �Ҵ��ϰ�
		// �� �迭�� 1���� ������ ũ�⸸ŭ�� ���ڸ� ���� �� ���
		System.out.print("�Ҵ��� ũ�� : ");
		int size = sc.nextInt();
		
		// �Է¹��� ũ�⸸ŭ�� �迭 ���� �� �Ҵ�
		int[] arr = new int[size];
		
		for(int i = 0; i<arr.length;i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
		
	}
	
	public void method3() {

	// ���, �ٳ���, ������, ���ξ���, Ű��
	// �ټ����� ����
	// �ε����� �Է¹޾� �ش� �ε����� ����� ������ ���.
	
		//String �迭 ����� ���ÿ� �ʱ�ȭ
		// �����Ϸ��� �˾Ƽ� �迭�� ũ�⸦ �Ҵ��ϰ�, �� ��ҿ� ���� ����
		
		String[] fruit = {"���", "�ٳ���", "������", "���ξ���", "Ű��"};
		
		System.out.print("�ε��� �Է� : ");
		int index = sc.nextInt();
		
		if(index >= 0 && index < fruit.length ) {
			System.out.println(fruit[index]);
		}
		
	}
	
	public void method4() {
		// ���, �ٳ���, ������, ���ξ���, Ű��
		// �ټ� ���� ������ ����Ǿ��ִ� �迭�� �ִ�.
		// ���ϸ��� �Է¹޾� �ش� ������ ���° �ε����� ����Ǿ� �ִ��� ���
		
		String[] fruit = {"���", "�ٳ���", "������", "���ξ���", "Ű��"};
		
		System.out.print("���ϸ� �Է� : ");
		String str = sc.nextLine();
		
		boolean isTrue= true;		
		for(int i =0; i < fruit.length ; i++) {
				
			if(fruit[i].equals(str)) {
				// ���� ������ �迭 ����� ����
				// �Է��� ���� ���� ���
					System.out.println(i+"��° �ε����� �ֽ��ϴ�.");
					isTrue = false;
					break; 
				}
		}
		if (isTrue) {
			System.out.println("�Է��� ���� ��ġ�ϴ� ������ �����ϴ�.");
		}
		
		
		
		
		
		
	}
	public void method5() {
		// ���ڿ� 3���� ������ �� �ִ� �迭�� ���� �� �Ҵ��ϰ�
		// ���ڿ� 3���� �Է¹޾� �迭�� ������� ���� ��
		// �˻��� ���ڿ��� �Է¹޾� �迭�� ���° �ε����� ����Ǿ� �ִ��� ��� 
		
		boolean isTrue= true;		
		
		String[] arr = new String[3];
		String str ="";
		//�迭�� �����
		for(int i =0; i < arr.length ; i++) {
			System.out.print("�Է� : ");
			str = sc.nextLine();
				arr[i] = str;
		}
		
		System.out.print("�˻� �Է� : ");
		str = sc.nextLine();
		
		//�迭 �˻���
		for(int i =0; i < arr.length ; i++) {
			if(arr[i].equals(str)) {
				// ���� ������ �迭 ����� ����
				// �Է��� ���� ���� ���
					System.out.println(i+"��° �ε����� �ֽ��ϴ�.");
					isTrue = false;
					break; 
				}
		}
		if (isTrue) {
			System.out.println("�Է��� ���� ��ġ�ϴ� ������ �����ϴ�.");
		}
		
	}		
	
	
	public void method6() {
		
		
		double[] arr = new double[5];
		// �Ǽ��� �迭 height 5ĭ ���� �� �Ҵ�
		double tall =0;
		double avg =0;
		
		//�迭�� �����
		for(int i =0; i < arr.length ; i++) {
			System.out.print( i+1 +" ��° Ű �Է� : ");
			tall = sc.nextDouble();
				arr[i] = tall;
				avg += tall;
		}

		avg /= arr.length;
		
		System.out.println("��� Ű : "+avg);
		System.out.print("�迭 �ȿ� �ִ� ��  : ");

		for(int i =0; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");			
		}

		
		}
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
