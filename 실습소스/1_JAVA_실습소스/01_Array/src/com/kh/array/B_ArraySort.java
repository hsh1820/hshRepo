package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class B_ArraySort {
	
	Scanner sc = new Scanner(System.in);
	// 5 4 1 2 3 
	// 오름차순 : 1 2 3 4 5
	// 내림차순 : 5 4 3 2 1 
	
	public void method1() {
		// 배열 요소들 위치 바꾸기
		int[] arr = { 2,1,3};

		// 1 2 3
//		
//		int temp = arr[0];
//		arr[0] = arr[1];
//		arr[1] = temp;
//		
		// 3 2 1 (내림차순)
		int temp = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
		
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// 삽입정렬 (Insertion Sort)
	// 정렬 알고리즘 가장 간단하고 기본이되는 알고리즘
	// ex) 카드게임 패 순서대로 정렬
	// 3 4 2 1 5
	
	// 배열의 n번째 인덱스 값을 (n은 1 부터 시작) 
	// 0 ~ n-1 인덱스 까지 비교하여 정렬
		
	public void method2()	{
		int[] arr = {2, 5,4, 1,3};
		int count = 0;
		// 삽입 정렬(오름차순)
		// 1. 비교 주체를 정하는 for문
		
		for(int i=1; i < arr.length; i++) {
			
			// 2. 비교 대상을 정하는 for문
			for(int j =0; j<i; j++) {
				// 비교를 통해서 오름차순 정렬
				// 비교 주체가 비교 대상보다 작을 경우 값 교환
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
	
	
	
	
	// 버블정렬
		
	
	
	
	
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
			// 비교 대상을 정하는 for문 
			for (int j =0; j<i;j++) {
				if(arr[i] > arr[j] ) {
					// 내림차순은 오름차순과 비교연산자 방향만 다르게
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
		// 정수 5개를 입력 받아 배열에 저장 후
		// 내림차순 정렬하여 출력
		int[] arr = new int[5];
		
		for(int i = 0; i <arr.length; i++) {
			System.out.print("입력 : ");
			int input = sc.nextInt();
			arr[i] = input;
			
		}
		
//		System.out.print(arr[i]);
		
		for(int i =1; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
			// 비교 대상을 정하는 for문 
			for (int j =0; j<i;j++) {
				System.out.print(arr[j] + " ");
				if(arr[i] > arr[j] ) {
					// 내림차순은 오름차순과 비교연산자 방향만 다르게
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
	
	// 버블 정렬 (Bubble Sort)
	// 인접한 두 개의 요소를 검사하여 정렬하는 방법
	// 뒤에서 부터 정렬이 되어지는 것이 특징
	
	//  장점 : 구현이 쉽다. 
	//   		 이미정렬된 데이터를 다시 정렬할 때 가장 빠름.
	// 단점 : 다른 정렬에 비해서 정렬 속도가 느리다
	// 			 
	System.out.println();
	
	int[] arr = { 2, 5, 4, 1, 3};
	int count =0; 
	
	for(int i = arr.length-1; i > 0 ; i--) {
		// 1. 한 회차당 내부에 있는 for문이 반복할 회수
		for(int j =0 ; j< i ;j++) {
			// 2. 지정된 회수만큼 반복하며
			// j번째 인덱스 요소와 j+1 번째 요소를 비교하여 정렬
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
