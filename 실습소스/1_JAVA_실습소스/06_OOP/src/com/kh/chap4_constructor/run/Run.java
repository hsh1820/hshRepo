package com.kh.chap4_constructor.run;

import com.kh.chap4_constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		
		// 기본 생성자 실행 
		// User 객체 생성
		//		User user = new User();
		//		
		//		user.setUserId("admin");
		//		user.setUserPwd("1234");
		//		user.setUserName("관리자");
		//		user.setAge(40);
		//		user.setGender('남');
		//
		//		System.out.println(user.inform());
		
		//
		// 매개 변수 있는 생성자를 이용하여 User 객체 생성
		User user2 = new User("user02", "pass02", "사용자2", 20, '여');
		System.out.println(user2.inform());
		
		User user3 = new User();
	}
}
