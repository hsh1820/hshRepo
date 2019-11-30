package com.kh.array;

import java.util.Scanner;

public class ArrayPractice {
	Scanner sc =new Scanner(System.in);

	
	public void practice5()	{
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		// 
		// 2. 사용자가 입력한 문자열에서
		// 문자 하나하나를 char 배열에 저장
		
		// 2-1 문자열의 길이만큼의 char 배열 선언 및 할당 
		char[] arr = new char[str.length()]; // .length 기능을 부르는 것
		
		// 2-2 반복문을 통해 str.charAt(i) 값을 arr[i]에 저장
		for(int i = 0; i<arr.length;i++) { // .length 배열의 필드값 가져오는 것  
			arr[i] = str.charAt(i);
		}
		//  3. 검색할 문자가 배열내에 몇개가 들어있는지 검색
				// + 검색된 인덱스 출력
		int count =0;

		// 반복문 실행 전 구문 출력
		System.out.print(str + "에 "+ ch + "가 존재하는 위치(인덱스) : ");
		
		// 반복문을 이용하여 배열의 각 요소에 접근
		for (int i =0 ; i<arr.length;i++) {
			if(arr[i] == ch) { // 해당 인덱스의 요소가 검색될 문자와 같을 경우
				System.out.print( i + " " ); // 현재 인덱스 출력
				count++;
			}
		}
		System.out.println(); // 줄바꿈
		
		// 결과 출력
		System.out.println(ch + "개수 : " + count);
	}
	
	public void practice8()	{
		
		while(true) {
			System.out.print("정수 : ");
			int num = sc.nextInt();
			
			// 입력받은 수가 3이상이면서 홀수인 경우
			if(num > 3 && num %2==1) {
				// 입력받은 크기만큼의 int형 배열 선언 및 할당
				int[] arr = new int[num];

				// 배열 요소에 저장할 값을 만들 변수 생성
				int value = 0;
				// 배열의 중간까지는 value++;
				// 배열 중간이후 부터는 value--;
				for(int i =0; i < arr.length;i++) {
					// 배열의 중간까지
					if (i <= arr.length/2) {
					value ++;
				}else {
					value--;
					} 
					arr[i] = value;
					System.out.print(arr[i] + " ");
				}//for end
				break;
				
			}else {
				System.out.println("다시 입력하세요"); 
				}
		}	
	}
	public void practice15() {
		
		// 1. 사용자에게 문자열 입력받기		
		System.out.print("문자열 : ");
		String str = sc.nextLine(); // nextLine().charat(i) => 문자열 중 i 번째 문자를 받는다
		
		// 입력받은 문자열을 char[] 에 저장
		
		char[] arr = new char[str.length()];
		
		for(int i =0; i<arr.length;i++) {
			arr[i] = str.charAt(i);			
		}
		System.out.print("문자열에 있는 문자 : ");

		// 3. 반복문을 이용하여 char 배열에서 중복값이 존재하는 경우 출력 X
		 int count = 0;
		 
		// 비교 기준 선정
		for(int i =0;i<arr.length;i++) {
			boolean flag = true;
			// 중복 체크용 변수
			
			for(int j = 0; j<i;j++) { // i 이전 까지 비교 대상 선정
				if(arr[i] == arr[j]) { // 기준과 비교대상이 같을 경우 중복발생
					flag = false;
					break;
					
				}
			}
			// 중복이 발생하지 않은 경우 출력 및 count 증가
			if (flag) {
				if(i ==0 ) { //문자열 첫번째라면
					System.out.print(arr[i]);   // a 
				}else {
					System.out.print(", "+arr[i]); // + b
				}
				count++;
			}
			
		}
		System.out.println();
		System.out.println("문자 개수 : " + count );
}
	
	
	
}
// 