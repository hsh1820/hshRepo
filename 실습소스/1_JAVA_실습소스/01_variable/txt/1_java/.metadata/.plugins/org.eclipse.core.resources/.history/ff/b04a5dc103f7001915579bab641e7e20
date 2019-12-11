package com.kh.variable;

public class D_Cast {
	
	/* 형변환에는 두 종류가 있음
	 * 1. 자동 형변환
	 * 	- 서로 다른 자료형 연산 시 컴파일러가 
	 *  값의 범위가 작은 자료형을 
	 * 	큰 자료형으로 변환하는 것
	 * 
	 * 2. 강제 형변환
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public void rule1() { // 자동 형변환 테스트
		
		int i = 12;
		double d = 3.3;
		double result = i + d;
		// i(int) --> i(double)으로 자동 형변환 됨
		
		System.out.println("result : " + result);
		//result : 15.3
		
		// int -> long
		int iNum = 2147483647;
		long lNum = 1000000000L;
		long result2 = iNum + lNum;
		
		System.out.println("result2 : " + result2);
		//result2 : 3147483647
		
		// long -> float
		// long 형이 byte는 더 크지만
		// float가 값의 범위가 더 크므로
		// 자동 형변환 가능
		long lNum2 = 1234567890123456789L;
		float fNum = 10000000000000000000f;
		float result3 = lNum2 + fNum;
		
		System.out.println("result3 : "+ result3 );
		//result3 : 1.1234568E19
		
	
		// char -> int 
		// char 는 실제 문자가 아닌 정수가 저장되고 
		// 저장된 수에 매칭되는 문자가 출력되는 것
		// 그러므로 char는 실제로는 정수형이다.
		
		
		char ch = 'A';
		int iNum3 = ch;		
		System.out.println("iNum : " + iNum3);
		
		char ch2 = 65;
		System.out.println("ch2 : " + ch);
		
		
		
	}
}
