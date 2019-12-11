package com.kh.chap03_throws.controller;

import java.io.IOException;

public class ThrowsController {
	
	public void method1() {
		System.out.println("method1() 호출");
		try {
			method2();	
		} catch(IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}catch(ArithmeticException e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
	}
	
	public void method2() throws IOException { 
		// arithmeticException은 unchecked 이기때문에 throws또한 선택사항
		System.out.println("method2() 호출");
		method3();		
	}
	
	public void method3() throws IOException, ArithmeticException {
								// checked        unchecked
						// 여러 Exception을 전가 시킬 수도 있음
		// 전가되는 Exception이 checked 인 경우
		// 반드시 호출부에서 예외처리가 필요하지만
		// unchecked 인 경우 호출부에서 예외처리를 선택적으로 하면 됨.
		System.out.println("method3() 호출");
		method4();
		int num = 2/0;
	}
	public void method4() throws IOException {
		System.out.println("method4() 호출");
		
		// throw : 강제로 Exception 발생 시키는 키워드
		// throws : 발생된 Exception을 호출부로 전가하는 키워드 
		// throw new IOException();
	}
	
	
}
