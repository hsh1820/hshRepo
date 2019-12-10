package com.kh.chap2_encapsulation.run;

import com.kh.chap1_Abstraction.model.vo.Account;
import com.kh.chap3_field.model.vo.Korean;

public class AccountRun {
	public static void main(String[] args) {
		
		// 캡슐화 
		/*
		 * 추상화를 통해 정의된 속성, 기능을 하나로 묶어 관리하는 기법
		 * 이 때 클래스의 내부의 데이터(필드, 멤버변수)에 직접 접근을
		 * 제한하는 것이 원칙이므로 private 접근 제한자를 사용 
		 * 
		 * 직접 접근을 대신하여 내부 데이터의 접근을 위한 
		 * 간접 접근 방법(기능) 을 클래스 내부에 작성
		 * == getter / setter 메소드
		 * 
		 * */
		
		Account acc = new Account(); // 생성자
		// 생성자 : 객체 생성 시 초기 필드값과 
		//  		  생성되자마자 수행할 기능을 작성하는 부분
		
		//acc.name = "홍길동";
		//The field Account.name is not visible 
		// Account 객체 내부의 name 필드가 private 이므로
		// 외부 직접 접근 불가 --> 간접 접근 방법 사용
		
		acc.setName("홍길동");
		acc.setPassword("password");
		acc.setAccountNumber("01012345678");
		acc.setBalance(100000000);
		acc.setBankCode(0111); // 0 은 8진수, 0x 16진수
		
		System.out.println(Korean.nCode);
		
		
		System.out.println("계좌 정보");
		System.out.println(acc.getName());
		System.out.println(acc.getAccountNumber());
		System.out.println(acc.getBalance());
		System.out.println(acc.getBankCode());
		System.out.println(acc.getPassword());
		
		acc.deposit(1000000000);
		
		System.out.println(acc.getBalance());
		
		
	}
}
