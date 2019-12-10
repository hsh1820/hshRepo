package com.kh.chap4_constructor.model.vo;

public class User {
		// 필드 
		private String userId;
		private String userPwd;
		private String userName;
		private int age;
		private char gender;
		
		// 생성자
		/*
		 *  * 생성자를 사용하는 목적
		 * 1. 객체를 생성해주기 위한 목적 
		 * 2. 매개변수로 전달받은 값을 필드에 초기화할 목적 // 객체가 만들어지자마자 값이 있다
		 *  
		 *  * 생성자 사용 시 주의사항
		 *  1. 생성자명은 반드시 클래스 명과 같아야 한다.
		 *  2. 반환형이 존재하지 않는다.
		 *  3.******* 매개변수 있는 생성자 작성 시 *********************
		 *  	*******기본 생성자를 반드시 작성해야한다. ****************   ==> 오버로딩
		 * 		.******* --> JVM이 기본생성자를 자동 생성하지 못 하기 때문.
		 * 
		 * */

		// 기본생성자 // 비어있는 목적으로라도 만들겠다 매개변수X
				public User() {
						System.out.println("User  객체가 생성됨 .");
						
				}
			//  보통 객체를 생성만 할 때 사용
			// --> 값 초기화 없이 틀만 만들어 두는 것 // 메모리 공간만 할당
			
			// 만약 클래스 내부에 아무 생성자도 작성되지 않았다면 
			// JVM이 자동으로 컴파일 코드에 생성해줌
		
		// 매개 변수 있는 생성자   
		// 객체 생성과 동시에 매개변수로 전달된 값들을 
		// 해당 멤버변수에 초기화 하는 목적으로 사용
		
		public User(String userId, String userPwd, String userName) {
			// 매개변수의 개수가 다르므로 오버로딩 성립
			this.userId = userId;
			this.userName = userName;
			this.userPwd = userPwd;
		}
		public User(String userId, String userPwd, String userName, int age, char gender) {
			//			this.userId = userId;
			//			this.userPwd = userPwd;
			//			this.userName = userName;
			
			// this 생성자
			// 반드시 첫 번째 줄에 작성 //Constructor call must be the first statement in a constructor
			this(userId,userPwd, userName);
			
			this.age = age;
			this.gender = gender;
			
			System.out.println("매개 변수 있는 생성자로 객체 생성");
		}
		
			//		public User(String userddName, String userIddd, String usdderPwd) {
			//			//err) Duplicate method User(String, String, String) in type User
			//		}
		
			//		public User(String userId, String userPwd, int age) {
			//			// 매개변수의 개수는 3개로 같지만 
			//			// 마지막 매개변수의 자료형이 다르므로 오버로딩 성립
			//			this.userId = userId;
			//			this.userPwd = userPwd;
			//			this.age = age;
			//		}
			//		
			//		public User(int age, String userId, String userPwd) {
			//			// 매개변수의 개수, 자료형이 모두 같지만
			//			// 순서가 다른 경우 오버로딩 성립
			//		}
			//		
			
		// userId - setter (우클릭 -> source -> generate getter / setter
			public void setUserId(String userId) {
				this.userId = userId;
			}
			public String getUserId() {
				return userId;
			}

			public String getUserPwd() {
				return userPwd;
			}

			public void setUserPwd(String userPwd) {
				this.userPwd = userPwd;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public int getAge() {
				return age;
			}

			public void setAge(int age) {
				this.age = age;
			}

			public char getGender() {
				return gender;
			}

			public void setGender(char gender) {
				this.gender = gender;
			}
			
			
			
		// 현재 객체가 가지고 있는 모든 필드의 정보를 반환하는 메소드	
		public String inform() {
			return userId + ", " + userPwd+ ", " +userName + ", " + age + ", " + gender ; 
		}
		
		
}
