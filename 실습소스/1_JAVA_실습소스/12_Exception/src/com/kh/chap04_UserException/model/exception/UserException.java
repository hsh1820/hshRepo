package com.kh.chap04_UserException.model.exception;

public class UserException extends Exception{
	// ����� ���� ���� Ŭ���� ���� ���
	// -> ������ Java�� �������ִ� Exception Ŭ���� ��
	// 		�ϳ��� ��� ������ ��.
	// 		���� Exception �Ǵ� RuntimeException �� ��� ����.
	//		^ checked �� unchecked ������ ���� ����
	// 		Checked = Exception
	//		Unchecked = RuntimeException
	
	public UserException() {
		super(); // Exception�� �θ�� Exception�� ������ ���¸� ����
	}
	public UserException(String msg) {
		super(msg);
		//Exception �� �޼��� ����
	}
	
	
}
