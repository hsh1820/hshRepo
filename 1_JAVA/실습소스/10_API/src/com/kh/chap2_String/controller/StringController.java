package com.kh.chap2_String.controller;

import java.util.Scanner;

public class StringController {

	
	// String Class
	// 문자열 값이 수정 불가능한 불변(immutable) 클래스
	// 문자열 내용 수정 시 새로운 문자열이 할당되어 
	// 그 주소를 반환받음
	
	public void method1() {
		String str1 = "abc";
		
		
		// str1.hashCode() 
		// Object 의 hashCode() 오버라이딩되어 있는 것이나, 
		// String의 경우는 String클래스에서 Object의 hashCode()를 오버라이딩
		// String.hashCode()는 값을 해쉬코드화, 주소를 한게 아님
		// --> String이 오버라이딩해서 원하는 주소값이 변형된 해시코드 출력 불가
		
		// system.identifyHashCode(obj)
		// --> 객체의 실제 주소를 이용하여 만든 해시코드 를 반환
		System.out.println("str1 : "+System.identityHashCode(str1));
		
		str1 += "def"; // str1 == "abcdef"; // 다른 주소 출력 == 새로 배열 만들어짐   // 불변확인 //
		System.out.println("str1 : "+System.identityHashCode(str1));
		
		
		String str2 = "abcdef"; // str2 == str3 주소값도 같음
		System.out.println("str2 : "+System.identityHashCode(str2));

		
		String str3 = "abcdef";  // String str = ""; String 리터럴로 생성된 형태
		// 형태로 문자열 생성시 String pool에 의해 이미 만들어진 동일한 문자열을 재사용 
		System.out.println("str3 : "+System.identityHashCode(str3));

		String s1 = "Hello";  // String pool 에 생성
		String s2 = new String("Hello");
		
		System.out.println("s1 값 : "+ s1);
		System.out.println("s2 값 : "+ s2);
		
		System.out.println("s1 hashCode : "+System.identityHashCode(s1));
		System.out.println("s2 hashCode : "+System.identityHashCode(s2));
		
	}
	
	
	public void method2() {
		// StringBuffer 기본생성자 생성 시 버퍼크기 : 16
		StringBuffer sb = new StringBuffer();
		System.out.println("sb의 버퍼크기 : " + sb.capacity());
		
		StringBuffer sb2 = new StringBuffer("java api");
		System.out.println("sb2의 버퍼크기 : " + sb2.capacity());
		
		// 가변/불변 확인
		System.out.println("sb의 해시코드 : " + sb.hashCode());
		// StringBuffer 객체에 문자열 넣는 방법
		sb.append("Hello World");
		System.out.println("sb : " + sb);
		System.out.println("sb의 해시코드 : " + sb.hashCode());
		System.out.println("sb의 버퍼크기 : " + sb.capacity());
		
		sb.append(sb); // sb에 기존 sb값을 한번 더 추가
		System.out.println("sb : " + sb);
		System.out.println("sb의 해시코드 : " + sb.hashCode());
		System.out.println("sb의 버퍼크기 : " + sb.capacity());
		
		
	}
	
	public void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계산할 식을 입력하세요 : ");
		// 1 + 2 
		// 띄어쓰기를 구분자로 사용
		String input = sc.nextLine();
		
		String[] arr = input.split(" ");
		// 공백을 구부자로 입력된 문장을 String배열로 반환
		
		// 입력된 값 중 숫자부분을 정수로 변환
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[2]);
		
		switch(arr[1]) {
			case "+" : System.out.println(num1+num2);break;
			case "-" : System.out.println(num1-num2);break;
			case "*" : System.out.println(num1*num2);break;
			case "/" : System.out.println(num1/num2);break;
			case "%" : System.out.println(num1%num2);break;
			default : System.out.println("연산자를 잘못입력함.");
			
			
		}
		
		
		
	}
	
}
