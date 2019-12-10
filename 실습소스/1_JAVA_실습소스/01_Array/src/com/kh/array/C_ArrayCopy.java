package com.kh.array;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayCopy {
	
	Scanner sc = new Scanner(System.in);
	// 배열 복사 
	// - 얕은 복사 : 배열의 주소만을 복사
	// - 깊은 복사 : 복사하려는 배열과 동일한 크기의 
	// 					새로운 배열을 만들어 실제 내부 값을 모두 복사하는 것 
	
	public void method1() {
		int[]  origin = {1,2,3,4,5};
		
		// 얕은 복사
		int[] copyArr = origin;
		
		
		System.out.println("변경 전 ");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// 주소값이 같은지 확인
		System.out.println("origin 의 hashCode :  " +  origin.hashCode());
		System.out.println("copyArr 의 hashCode :  " +  copyArr.hashCode());
		
		System.out.println();
		System.out.println("변경 후 ");
		
		copyArr[0] = 99;// 앝은 복사한 변수를 이용하여 0번 인덱스 값 변경 
		
		// origin(원본) 데이터의 변형이 있는지 확인
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// 주소값이 같은지 확인
		System.out.println("origin 의 hashCode :  " +  origin.hashCode());
		System.out.println("copyArr 의 hashCode :  " +  copyArr.hashCode());
	}
	
	


	public void method2() {
		
		int[] origin = {1,2,3,4,5};
		
		// 깊은 복사
		// --> 깊은 복사를 하기 위해서는 "최소" 원본과 같은 크기의 배열이 필요함
		int[] copyArr = new int[origin.length];
		
//		System.out.println(copyArr.toString());
		
		for(int i =0; i<origin.length;i++) {
			// 원본 배열의 데이터를 깊은 복사한 배열에 복사
			copyArr[i] = origin[i];  
		}
		System.out.println("변경 전 ");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// 주소값이 다른지 확인
		System.out.println("origin 의 hashCode :  " +  origin.hashCode());
		System.out.println("copyArr 의 hashCode :  " +  copyArr.hashCode());
		
		System.out.println();

		System.out.println("변경 후 ");

		copyArr[0] = 99;// 앝은 복사한 변수를 이용하여 0번 인덱스 값 변경 
		
		// origin(원본) 데이터의 변형이 있는지 확인
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// 주소값이 같은지 확인
		System.out.println("origin 의 hashCode :  " +  origin.hashCode());
		System.out.println("copyArr 의 hashCode :  " +  copyArr.hashCode());
		
		
	}
	
	
	public void method3() {
		
		// system 클래스에서 제공하는 arraycopy() 메소드를 사용하여 깊은 복사 하기
		
		int[]	origin = { 9,8,7,6,5};
		
		// 복사할 배열 선언 및 할당
		int[] copyArr = new int[origin.length];
		
		// system.arraycopy(원본배열명, 원본배열의 복사가 시작될 인덱스, 
		// 복사본 배열명, 복사본에 원본데이터의 복사를 시작할 인덱스, 원본에서 복사해올 데이터 길이); 
		
		System.arraycopy(origin, 0, copyArr, 0, origin.length); 
		
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		

		
			
		
	}
	
	// 배열의 크기를 입력받아 해당 크기만큼의 배열을 생성하고,
	// 배열으 크기만큼 정수를 입력받아 순서대로 저장.
	// 마지막까지 값을 저장한 후 추가로 값을 입력받을지 확인('y', 'n')
	// 'y' 선택 시 증가 시킬 크기를 입력받아
	// 원본 배열의 크기를 증가시키고
	//	늘어난 크기만큼 추가로 정수 입력받기.
	//	'n' 선택 시 배열 저장된 모든 값 출력.
	
	public void method4() {
		
		
		
//		System.out.println("정수 입력 : ");
		
		
		System.out.print("배열 크기 입력 : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size]; // 원본 배열 생성
		
		int i = 0; // 초기식
		while (true) {
			System.out.println(i + "번째 인덱스 값 : ");
			arr[i] = sc.nextInt();
			sc.nextLine(); // 버퍼에 남아있는 줄바꿈 문자 제거
			
				if (i == arr.length-1) {
					System.out.print("추가로 값을 입력하시겠습니까? (y/n) : ");
					char yn = sc.next().charAt(0);
					
					if(yn == 'n') {
						break;
					}else { // y 가 입력된 경우
						System.out.println("증가시킬 배열의 크기 : ");
						int addSize = sc.nextInt();
						
						// 배열 크기 증가
						// --> 크기가 증가된 새로운 배열을 만들어
						// 		원본 배열의 데이터를 깊은 복사 후
						// 		원본 배열 참조형 변수가
						// 		새로운 배열을 참조하도록 주소값을 복사
						
						int[] newArr = new int[arr.length+addSize];
						// 원본 배열 크기 + 추가 크기 만큼의 새로운 배열 새로 생성
						System.arraycopy(arr, 0, newArr, 0, arr.length);
					
						arr = newArr; // arr의 배열 값, newArr의 참조변수는 쓰레기댐 =GC
						
					}
					
				}
			
			i++; // 증감식
			
		}
		System.out.println(Arrays.toString(arr));
		
		
		
//		System.out.print("배열 크기 입력 : ");
//		int input = sc.nextInt();
//		
//		for(int i =0 ; i<input;i++) {
//			int[] arr = new int[input]; // origin
			
	//	}
	}
	
	
	
	
}
