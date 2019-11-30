package com.kh.chap01_Exception.run;

import com.kh.chap01_Exception.controller.ExceptionController;

public class Run {
	public static void main(String[] args) {
		ExceptionController ec = new ExceptionController();
		// ec 라는  ExceptionController를 참조할 참조 변수를 stack영역에 생성
		// ec 참조변수가 참조할 ExceptionController() 객체를 heap영역에 생성
		// 생성된 ExceptionController() 객체의 주소를 ec 참조변수에 대입
		// ec.method1();
		ec.method2();
		
	}
	
}
