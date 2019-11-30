package com.kh.chap3_field.model.vo;

public class Korean {
	private int age;
	public static int nCode ;
	// static 으로 선언된 필드(변수)는 
	// 접근 제한자를 public으로 하는 것이 관례
	// (static 영역에 누구든 접근 할 수 있기 때문)
		
	// 공유 + 상수  // 메소드 안에 final 생성 불가 
	public static final double PI2 = 3.141592;
	
	// 인스턴스 초기화 블럭
	// 인스턴스 변수를 초기화 시키는 블럭으로 
	// 객체 생성 시 마다 초기화
	
	{
		age = 1;
		
	}
	
	// 스태틱 초기화 블럭
	// 클래스 변수를 초기화 시키는 블럭
	// 프로그램 실행 시 딱 한번 초기화 진행
	static{  // static 초기화 보다 명시적 초기화 보다 더 사용
		nCode = 82;
	}
	
	public Korean() { // 인스턴스 변수 초기화 // 반환형 없음
		
	}
	
	//메소드
	 public void setAge(int age) {
		 this.age = age;
	 }
	 public int getAge() {
		 return age;
	 }

	 
	 
	 
}
