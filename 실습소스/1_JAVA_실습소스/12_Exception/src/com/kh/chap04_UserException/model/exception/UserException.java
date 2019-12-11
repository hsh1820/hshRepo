package com.kh.chap04_UserException.model.exception;

public class UserException extends Exception{
	// 사용자 정의 예외 클래스 생성 방법
	// -> 기존에 Java가 제공해주는 Exception 클래스 중
	// 		하나를 상속 받으면 됨.
	// 		보통 Exception 또는 RuntimeException 을 상속 받음.
	//		^ checked 나 unchecked 인지에 따라서 결정
	// 		Checked = Exception
	//		Unchecked = RuntimeException
	
	public UserException() {
		super(); // Exception이 부모라 Exception의 생성자 형태를 따라감
	}
	public UserException(String msg) {
		super(msg);
		//Exception 시 메세지 전달
	}
	
	
}
