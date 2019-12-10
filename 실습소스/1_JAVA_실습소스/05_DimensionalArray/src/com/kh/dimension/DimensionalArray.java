package com.kh.dimension;

public class DimensionalArray {
	
		// 2차원 배열 : 1차원 배열 여러개를 하나로 묶어 취급하는 것
	
	public void method1() {
		// 2차원 배열의 선언 및 할당
		
		// 2차원 선언
		int [][] arr1;
		int arr2[][];
		int [] arr3[];
		// [] == 배열 1차원을 의미
		
		// 할당 = new
		// 2차원 배열 할당
		arr1 = new int [3][5];
		// Heap 영역에 int 형 2차원 배열 3행 5열 할당
		
		// 행의 개수(몇줄 인가?) 확인
		System.out.println("행의 개수 : "+ arr1.length);
		
		// 열의 개수(몇 칸 인가?) 확인
		System.out.println("열의 개수 : "+ arr1[0].length);
		
		//3행 5열의 int 형 2차원 배열에 모든 칸에
		// 정수 1 채우기
		// 2차원 배열 초기화
		for(int i=0;i<arr1.length ;i++) { // 행의 개수 만큼 반복
			for(int j =0;j<arr1[i].length;j++) { // 열의 개수 만큼 반복
				arr1[i][j]=1;
//				System.out.println(arr1[i][j]);
			}
		}
		// 2차원 배열 접근
		// 2차원 배열에 각 요소에 저장된 값 출력하기
		for(int i=0;i<arr1.length ;i++) { // 행의 개수 만큼 반복
			for(int j =0;j<arr1[i].length;j++) { // 열의 개수 만큼 반복
				System.out.print(arr1[i][j] +" ");
			}System.out.println();			
		}
		
	}
	public void method2() {
		// 2차원 배열 선언과 동시에 초기화
		
		int[][] arr = {   {0, 1, 2, 3} , 
						  {4, 5, 6, 7}, 
						  {8 , 9, 10, 11}    };
		
		// 초기화된 2차원 배열 각 요소 출력
		
		for(int i =0; i<arr.length;i++) {
			for(int j =0; j<arr[i].length;j++) {
				//arr[0][0] = 0
				System.out.print("arr [ " + i +" ] " + " [ "+j+" ]  = " + arr[i][j] +" " );
			}System.out.println();
		}
		
		
	}
	
	public void method3() {
		
		// 4행 4열 짜리 int 형 2차원 배열 선언 및 할당하고
		// 각 요소에 1~16까지의 값을 순서대로 저장하고 출력
		
		int[][] arr = new int[4][4];
		int count = 1;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr[i].length;j++) {				
				
				arr[i][j] = count ++; 
				// arr 각 요소에 현재 count 값 저장 후 count 1 증가  
			
				// arr[i][j] 번째 요소 출력
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(); // 줄바꿈
		}
	}
	
	public void method4() {
		// 행의 개수는 정해져 있으나,
		// 각 행에 대한 열의 개수가 정해지지 않은 2차원 배열
		// 가변 배열 선언 및 할당
		int[][] arr = new int[4][];
		
		arr[0] = new int[3];  // 열생성시 new 로 생성 
		arr[1] = new int[4];
		arr[2] = new int[5];
		arr[3] = new int[2];
		
		// 배열의 각요소에 진짜 0 (int 기본값)이 들어있는지 확인
		for(int i=0; i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) { // 열선택
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
		System.out.println();
		
		int value = 1;
		for(int i=0; i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) { // 열선택
				arr[i][j] = value++;
				
				System.out.print(arr[i][j]+" ");
				
			}System.out.println();
		}
	}
	
}
