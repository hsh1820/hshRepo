package com.kh.chap3_Wrapper.controller;

public class WrapperController {
	
	// Wrapper class 
	/*
	 * - wrapper : 포장지
	 * - 무엇을 포장하는 클래스 ? 
	 * 	-> 기본 자료형을 객체로 포장하는 클래스
	 * 
	 * - 왜 포장하는가?
	 * 1) 기본자료형으로는 수행할 수 없는 기능을 추가하여 
	 * 	사용하기 위해서 
	 * 	ex) 자료형의 최대, 최소값 
	 * 		String 문자열 -> 각 타입에 맞게 변환
	 * 		"123123" -> int 123123
	 * 
	 * 2) 기본 자료형을 객체로 다뤄야만 되는 경우
	 * 	ex) - 매개변수 또는 반환값이 객체를 요구하는 경우
	 * 		- 기본 자료형이 아닌 객체로 값을 저장하는 경우
	 * 		- 객체간의 비교가 필요한 경우 -> 서로 다른 객체를 크기라도 맞줘서 비교
	 * 			
	 * 
	 * */
	
	public void method1() {
		// int 의 Wrapper class -> Integer
		System.out.println("int의 byte 크기 : " + Integer.BYTES);
		System.out.println("int의 bit크기 : " + Integer.SIZE);
		System.out.println("int의 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int의 최소값 : " + Integer.MIN_VALUE);
		System.out.println("Integer의 기본 자료형 : " + Integer.TYPE);
		
		
		// int 의 최소값 ~ 최대값 100씩 증가하는 코드 출력
		
//		for(int i =  Integer.MIN_VALUE ; i< Integer.MAX_VALUE;i+=100) {
//			System.out.println(i);
//		}
		// 입력받은 문자열이 int형 크기를 초과하면 long형으로 변경하는 것 가능
		
		
		
		
		// String 형을 기본자료형으로 변환
		String num1 = "10";
		int num2 = 20;
		
		System.out.println(num1+num2);

		
		System.out.println(Integer.parseInt(num1)+num2);
							// String형 정수를 int형 정수로 변환,  char를 제외한 모든 기본형에 다있음
		
		
		byte bNum = Byte.parseByte("100"); // static 영역에 올라가 있음
		short sNum= Short.parseShort("1000");
		int iNum = Integer.parseInt("123456789");
		long lNum = Long.parseLong("123456789123456789");
		float fNum = Float.parseFloat("3.14");
		double dNum = Double.parseDouble("1.123456789");
		boolean bool = Boolean.parseBoolean("true"); // 문자열 true 
		char ch = "Hello".charAt(0); // String리터럴.메소드 = 리터럴을 String클래스로 사용
		
		
		// 기본자료형을 -> String 변환
		String s1 = Integer.valueOf(123)/**/.toString(); // Intger클래스의 필드로 넣고 문자열로 출력
		String s2 = 123+"";
		
		// Boxing : 기본 자료형을 래퍼클래스 객체로 변경
		// -> 기본 자료형을 객체라는 박스로 포장
		Integer it1 = new Integer(123); 
		
		// Unboxing : 래퍼클래스를 기본 자료형으로 변환
		int i = it1.intValue();// 인티저 객체가 가지고있는 값을 int로 풀어서 내보내는 기능
		int i2 = (int)it1; // Integer 객체 내부에 int 값 반환 // 강제 형변환 가능
		
		
		// AutoBoxing / Unboxing  : 포장과 언박싱을 자동 == 자동 형변환
		Integer it2 = 100; // AutoBoxing
		int i3 = it2; // Unboxing
		
		
		
	}
	
	
}	
	
