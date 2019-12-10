package com.kh.array;

import java.util.Scanner;

public class A_Array {
	Scanner sc =new Scanner(System.in);
	// 배열
	// - 같은 자료형의 변수를 하나의 묶음으로 다루는 것.
	// - 저장된 값마다 인덱스가 지정된다.
	//   (index는 0부터 시작)
	
	public void method1() {
		// 배열을 사용하지 않고 
		// int 형 변수 5개를 만들어 각각 값을 초기화 하고
		// 출력하기
		
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
	
		// 배열 선언
		// 자료형[] 배열명;
		// 자료형 배열명[];
		
		int[] arr;
		
		// 배열 할당
		// - 실제 값을 저장할 수 있는 배열공간 할당(== 생성)
		// 배열명 = new 자료형[배열크기];
		
		
		arr = new int[5];
		
		//		// 변수처럼 각 인덱스 요소에 접근 하여 값 저장 가능.
		//		arr[0] = 1;
		//		arr[1] = 2;
		//		arr[2] = 3;
		//		arr[3] = 4;
		//		arr[4] = 5;
				
		for(int i=0; i<arr.length;i++) {
			arr[i] = i+1;
		}
				// 변수처럼 각 배열요소에 접근하여 출력도 가능
				
		//		System.out.println("=== 배열 출력 ===");
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
		// 사용자가 지정한 크기만큼의 배열을 할당하고
		// 그 배열에 1부터 지정한 크기만큼의 숫자를 저장 및 출력
		System.out.print("할당할 크기 : ");
		int size = sc.nextInt();
		
		// 입력받은 크기만큼의 배열 선언 및 할당
		int[] arr = new int[size];
		
		for(int i = 0; i<arr.length;i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
		
	}
	
	public void method3() {

	// 사과, 바나나, 오렌지, 파인애플, 키위
	// 다섯개의 과일
	// 인덱스를 입력받아 해당 인덱스에 저장된 과일을 출력.
	
		//String 배열 선언과 동시에 초기화
		// 컴파일러가 알아서 배열의 크기를 할당하고, 각 요소에 값을 대입
		
		String[] fruit = {"사과", "바나나", "오렌지", "파인애플", "키위"};
		
		System.out.print("인덱스 입력 : ");
		int index = sc.nextInt();
		
		if(index >= 0 && index < fruit.length ) {
			System.out.println(fruit[index]);
		}
		
	}
	
	public void method4() {
		// 사과, 바나나, 오렌지, 파인애플, 키위
		// 다섯 개의 과일이 저장되어있는 배열이 있다.
		// 과일명을 입력받아 해당 과일이 몇번째 인덱스에 저장되어 있는지 출력
		
		String[] fruit = {"사과", "바나나", "오렌지", "파인애플", "키위"};
		
		System.out.print("과일명 입력 : ");
		String str = sc.nextLine();
		
		boolean isTrue= true;		
		for(int i =0; i < fruit.length ; i++) {
				
			if(fruit[i].equals(str)) {
				// 현재 접근한 배열 요소의 값이
				// 입력한 값과 같을 경우
					System.out.println(i+"번째 인덱스에 있습니다.");
					isTrue = false;
					break; 
				}
		}
		if (isTrue) {
			System.out.println("입력한 값과 일치하는 과일이 없습니다.");
		}
		
		
		
		
		
		
	}
	public void method5() {
		// 문자열 3개를 저장할 수 있는 배열을 선언 및 할당하고
		// 문자열 3개를 입력받아 배열에 순서대로 저장 후
		// 검색할 문자열을 입력받아 배열에 몇번째 인덱스에 저장되어 있는지 출력 
		
		boolean isTrue= true;		
		
		String[] arr = new String[3];
		String str ="";
		//배열에 저장부
		for(int i =0; i < arr.length ; i++) {
			System.out.print("입력 : ");
			str = sc.nextLine();
				arr[i] = str;
		}
		
		System.out.print("검색 입력 : ");
		str = sc.nextLine();
		
		//배열 검색부
		for(int i =0; i < arr.length ; i++) {
			if(arr[i].equals(str)) {
				// 현재 접근한 배열 요소의 값이
				// 입력한 값과 같을 경우
					System.out.println(i+"번째 인덱스에 있습니다.");
					isTrue = false;
					break; 
				}
		}
		if (isTrue) {
			System.out.println("입력한 값과 일치하는 과일이 없습니다.");
		}
		
	}		
	
	
	public void method6() {
		
		
		double[] arr = new double[5];
		// 실수형 배열 height 5칸 선언 및 할당
		double tall =0;
		double avg =0;
		
		//배열에 저장부
		for(int i =0; i < arr.length ; i++) {
			System.out.print( i+1 +" 번째 키 입력 : ");
			tall = sc.nextDouble();
				arr[i] = tall;
				avg += tall;
		}

		avg /= arr.length;
		
		System.out.println("평균 키 : "+avg);
		System.out.print("배열 안에 있는 값  : ");

		for(int i =0; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");			
		}

		
		}
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
