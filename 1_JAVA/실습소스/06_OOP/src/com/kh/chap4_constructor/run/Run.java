package com.kh.chap4_constructor.run;

import com.kh.chap4_constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		
		// �⺻ ������ ���� 
		// User ��ü ����
		//		User user = new User();
		//		
		//		user.setUserId("admin");
		//		user.setUserPwd("1234");
		//		user.setUserName("������");
		//		user.setAge(40);
		//		user.setGender('��');
		//
		//		System.out.println(user.inform());
		
		//
		// �Ű� ���� �ִ� �����ڸ� �̿��Ͽ� User ��ü ����
		User user2 = new User("user02", "pass02", "�����2", 20, '��');
		System.out.println(user2.inform());
		
		User user3 = new User();
	}
}
