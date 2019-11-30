package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class B_ArraySort {
	
	Scanner sc = new Scanner(System.in);
	// 5 4 1 2 3 
	// �������� : 1 2 3 4 5
	// �������� : 5 4 3 2 1 
	
	public void method1() {
		// �迭 ��ҵ� ��ġ �ٲٱ�
		int[] arr = { 2,1,3};

		// 1 2 3
//		
//		int temp = arr[0];
//		arr[0] = arr[1];
//		arr[1] = temp;
//		
		// 3 2 1 (��������)
		int temp = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
		
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// �������� (Insertion Sort)
	// ���� �˰��� ���� �����ϰ� �⺻�̵Ǵ� �˰���
	// ex) ī����� �� ������� ����
	// 3 4 2 1 5
	
	// �迭�� n��° �ε��� ���� (n�� 1 ���� ����) 
	// 0 ~ n-1 �ε��� ���� ���Ͽ� ����
		
	public void method2()	{
		int[] arr = {2, 5,4, 1,3};
		int count = 0;
		// ���� ����(��������)
		// 1. �� ��ü�� ���ϴ� for��
		
		for(int i=1; i < arr.length; i++) {
			
			// 2. �� ����� ���ϴ� for��
			for(int j =0; j<i; j++) {
				// �񱳸� ���ؼ� �������� ����
				// �� ��ü�� �� ��󺸴� ���� ��� �� ��ȯ
				if (arr[i] < arr[j] ) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count ++;
				}
				
					
			}
			
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
		
		System.out.print("count :  "+ count );
		
		
		
	}
	
	
	
	
	// ��������
		
	
	
	
	
	public void method3()	{
		int[] arr = { 7,1,5,3,4,2,6};
		
		for(int i = 1; i < arr.length ; i++) {
			
			for (int j =0; j < i ; j++) {
				
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}			
		}
		
		for (int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
			
		}
	}
	
	public void method4() {
		int[] arr = {2,5,4,1,3};
		
		for(int i =1; i<arr.length;i++) {
			// �� ����� ���ϴ� for�� 
			for (int j =0; j<i;j++) {
				if(arr[i] > arr[j] ) {
					// ���������� ���������� �񱳿����� ���⸸ �ٸ���
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
		}
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			
		}
		
		
		
		
		
	}
	
	public void method5() {
		// ���� 5���� �Է� �޾� �迭�� ���� ��
		// �������� �����Ͽ� ���
		int[] arr = new int[5];
		
		for(int i = 0; i <arr.length; i++) {
			System.out.print("�Է� : ");
			int input = sc.nextInt();
			arr[i] = input;
			
		}
		
//		System.out.print(arr[i]);
		
		for(int i =1; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			// �� ����� ���ϴ� for�� 
			for (int j =0; j<i;j++) {
				System.out.print(arr[j] + " ");
				if(arr[i] > arr[j] ) {
					// ���������� ���������� �񱳿����� ���⸸ �ٸ���
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
			System.out.println();
		}
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			
		}
	}
	
	
	
		
		
		
	

public void method6() {
	
	// ���� ���� (Bubble Sort)
	// ������ �� ���� ��Ҹ� �˻��Ͽ� �����ϴ� ���
	// �ڿ��� ���� ������ �Ǿ����� ���� Ư¡
	
	//  ���� : ������ ����. 
	//   		 �̹����ĵ� �����͸� �ٽ� ������ �� ���� ����.
	// ���� : �ٸ� ���Ŀ� ���ؼ� ���� �ӵ��� ������
	// 			 
	System.out.println();
	
	int[] arr = { 2, 5, 4, 1, 3};
	int count =0; 
	
	for(int i = arr.length-1; i > 0 ; i--) {
		// 1. �� ȸ���� ���ο� �ִ� for���� �ݺ��� ȸ��
		for(int j =0 ; j< i ;j++) {
			// 2. ������ ȸ����ŭ �ݺ��ϸ�
			// j��° �ε��� ��ҿ� j+1 ��° ��Ҹ� ���Ͽ� ����
			if(arr[i] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
			count++;
		}
	}
	for(int i = 0; i < arr.length;i++) {
		System.out.print(arr[i] + " ");
		
	}
	System.out.print( "count "+ count );
	
		
	
}

	public void method7() {
		int[] arr = {7,1,5,3,4,2,6};
		
		for(int i = arr.length-1 ; i>0; i--) {
			
			for(int j=0; j<i;j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; 
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	
		public void method8() {
			int[] arr = {7,1,5,3,4,2,6};
			
			for(int i = arr.length-1 ; i>0; i--) {
				
				for(int j=0; j<i;j++) {
					if(arr[i] > arr[j+1]) {
						int temp = arr[i];
						arr[i] = arr[j+1];
						arr[j+1] = temp; 
					}
				}
			}
			System.out.println(Arrays.toString(arr));
			
			for(int i = 0; i < arr.length;i++) {
				System.out.print(arr[i] + " ");
		}
	
	}
		
		
		




}
