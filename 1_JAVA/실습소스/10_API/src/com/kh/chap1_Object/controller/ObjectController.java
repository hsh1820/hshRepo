package com.kh.chap1_Object.controller;

import com.kh.chap1_Object.model.vo.Student;

public class ObjectController {
	
	// API : Application Programming Interface
	// ���� ���α׷��� ���� �� ���α׷��� �� �����ϴ� 
	// ��ɵ��� ������ �� �ִ� �������̽��� �����ϴ� ��
	
	// Object class
	/*
	 *  - �ʵ尡 �������� �ʰ�, 11���� �޼ҵ常 ����(��� Ŭ�������� �⺻������ ������ �־���ϴ� ��ɵ�) 
	 *  - ��� Ŭ������ �ֻ��� �θ��̱� ������ 
	 *  	� Ŭ���������� ����� �Ǿ� �ٷ� ��� �����ϴ�
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public void method1() {
		Student std1 = new Student("ȫ�浿", "A������", 20, 80);
		System.out.println(std1);
		
		Student std2 = new Student("ȫ�浿", "A������", 20, 80);
		System.out.println(std2);
		
		// ���� ��ü(hashCode()) / ���� ��ü(equals()==object���� ����)
		// ���� ��ü : �� ��ü�� ���� ���� '��'�� ������ ���� �� ����
		// ���� ��ü : �� ��ü�� �ϳ���. ������ ���� ��ü(���� �ּҰ�)
		// �ΰ����� ���ϴ� ����� ObjectŬ���� �ȿ� ����
		
		// equals() �� @override �ȵ��ִ� ���� 
		System.out.println("���� ���� ������?"+ std1.equals(std2));
		
		
		
		
		
	}
}
