package com.kh.chap1_Abstraction.model.vo;

public class Account {
	// 클래스 구조 
	/*
	 * 클래스 선언부 {
	 * 
	 * 		// 필드 ( == 멤버 변수)
	 * 	
	 * 		// 생성자 
	 * 
	 * 		// 메소드
	 * 
	 * }
	 * 
	 * 
	 * */
	
	 // 필드
	 private  String name; // 에금주
	 private String accountNumber ; //계좌번호
	 private String password;  // 비밀번호
	 private int bankCode;  // 은행코드
	 private int balance; // 잔액
	 
	// 생성자
	 public Account() {
		 // 필드의 초기값이나 생성되자 마자 바로 수행할 기능들
		 
	 }
	 
	 // 메소드 set/get + 변수명 + ()
	 
	 // getter / setter
	 // name 에 대한 getter / setter
	 // 
	 public void setName (String name) {
		 this.name = name;
		 // 필드 name = 전달받은 name		 
	 }
	 
	public String getName() {
		return name;
	}
	//accountNumber의 getter / setter
	/*
	 * setter 작성 방법
	 * public void set필드명 (필드의 자료형 변수명(==필드명))
	 * this.필드명 = 변수명;
	 * 
	 * */
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;		
	}
	 
	/*
	 * getter 작성 방법
	 * public 반환형(반환할 자료의 형태) get필드명() {
	 * 		return 필드명;
	 *	 }
	 * 
	 * */

	public String getAccountNumber() {
		return accountNumber;
	}
	 
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;		
	}
	public int getBankCode() {
		return bankCode;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	
	
	
	 // 입금 기능
	 public void deposit(int money) {
		 							// 입금하고자 하는 금액 전달되어 넘어옴
		 balance += money;
		 System.out.println(name + "님의 계좌에 " + money + "원이 입금됨.");
	 }
	  
	 
}
