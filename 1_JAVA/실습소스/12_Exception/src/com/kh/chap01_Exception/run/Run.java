package com.kh.chap01_Exception.run;

import com.kh.chap01_Exception.controller.ExceptionController;

public class Run {
	public static void main(String[] args) {
		ExceptionController ec = new ExceptionController();
		// ec ���  ExceptionController�� ������ ���� ������ stack������ ����
		// ec ���������� ������ ExceptionController() ��ü�� heap������ ����
		// ������ ExceptionController() ��ü�� �ּҸ� ec ���������� ����
		// ec.method1();
		ec.method2();
		
	}
	
}
