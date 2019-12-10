package com.kh.chap4_constructor.model.vo;

public class User {
		// �ʵ� 
		private String userId;
		private String userPwd;
		private String userName;
		private int age;
		private char gender;
		
		// ������
		/*
		 *  * �����ڸ� ����ϴ� ����
		 * 1. ��ü�� �������ֱ� ���� ���� 
		 * 2. �Ű������� ���޹��� ���� �ʵ忡 �ʱ�ȭ�� ���� // ��ü�� ��������ڸ��� ���� �ִ�
		 *  
		 *  * ������ ��� �� ���ǻ���
		 *  1. �����ڸ��� �ݵ�� Ŭ���� ��� ���ƾ� �Ѵ�.
		 *  2. ��ȯ���� �������� �ʴ´�.
		 *  3.******* �Ű����� �ִ� ������ �ۼ� �� *********************
		 *  	*******�⺻ �����ڸ� �ݵ�� �ۼ��ؾ��Ѵ�. ****************   ==> �����ε�
		 * 		.******* --> JVM�� �⺻�����ڸ� �ڵ� �������� �� �ϱ� ����.
		 * 
		 * */

		// �⺻������ // ����ִ� �������ζ� ����ڴ� �Ű�����X
				public User() {
						System.out.println("User  ��ü�� ������ .");
						
				}
			//  ���� ��ü�� ������ �� �� ���
			// --> �� �ʱ�ȭ ���� Ʋ�� ����� �δ� �� // �޸� ������ �Ҵ�
			
			// ���� Ŭ���� ���ο� �ƹ� �����ڵ� �ۼ����� �ʾҴٸ� 
			// JVM�� �ڵ����� ������ �ڵ忡 ��������
		
		// �Ű� ���� �ִ� ������   
		// ��ü ������ ���ÿ� �Ű������� ���޵� ������ 
		// �ش� ��������� �ʱ�ȭ �ϴ� �������� ���
		
		public User(String userId, String userPwd, String userName) {
			// �Ű������� ������ �ٸ��Ƿ� �����ε� ����
			this.userId = userId;
			this.userName = userName;
			this.userPwd = userPwd;
		}
		public User(String userId, String userPwd, String userName, int age, char gender) {
			//			this.userId = userId;
			//			this.userPwd = userPwd;
			//			this.userName = userName;
			
			// this ������
			// �ݵ�� ù ��° �ٿ� �ۼ� //Constructor call must be the first statement in a constructor
			this(userId,userPwd, userName);
			
			this.age = age;
			this.gender = gender;
			
			System.out.println("�Ű� ���� �ִ� �����ڷ� ��ü ����");
		}
		
			//		public User(String userddName, String userIddd, String usdderPwd) {
			//			//err) Duplicate method User(String, String, String) in type User
			//		}
		
			//		public User(String userId, String userPwd, int age) {
			//			// �Ű������� ������ 3���� ������ 
			//			// ������ �Ű������� �ڷ����� �ٸ��Ƿ� �����ε� ����
			//			this.userId = userId;
			//			this.userPwd = userPwd;
			//			this.age = age;
			//		}
			//		
			//		public User(int age, String userId, String userPwd) {
			//			// �Ű������� ����, �ڷ����� ��� ������
			//			// ������ �ٸ� ��� �����ε� ����
			//		}
			//		
			
		// userId - setter (��Ŭ�� -> source -> generate getter / setter
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
			
			
			
		// ���� ��ü�� ������ �ִ� ��� �ʵ��� ������ ��ȯ�ϴ� �޼ҵ�	
		public String inform() {
			return userId + ", " + userPwd+ ", " +userName + ", " + age + ", " + gender ; 
		}
		
		
}
