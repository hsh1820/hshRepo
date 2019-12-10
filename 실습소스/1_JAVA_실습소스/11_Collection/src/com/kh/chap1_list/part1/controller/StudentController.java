package com.kh.chap1_list.part1.controller;

import java.util.ArrayList;

import com.kh.chap1_list.part1.model.vo.Student;

// MVC Model 2 ���� Controller�� �ǹ�
/*	-> View���� ���޹��� ������� ��û�� ��Ȳ�� ����
 * 	�˸��� Model �� �����ϰ�
 * 	�ش� Model���� ó���Ǿ��� �����
 * 	�ٽ� �˸��� View�� �����ϴ� ����
 * 	��������δ� ��û�� ���� ���α׷��� �帧�� �����ϴ� �κ�
 * */
public class StudentController {
	// �÷��� �� ArrayList�� �̿��Ͽ� Student ��ü ����
	
	// �л� ��ü�� ������ ArrayList ����
	ArrayList<Student> list = new ArrayList<Student>();
	// <Student> --> Generics(���׸�)
	// �ش� �÷��ǿ� ������ ��ü�� Ÿ���� ����
	
	public void method() {
		// ���׸� Ÿ�� ���� �׽�Ʈ
		ArrayList list1 = new ArrayList();
		ArrayList<Student> list2 = new ArrayList<Student>();
		
		// Student ��ü �߰�
		list1.add(new Student());
		list2.add(new Student());
		
		// String ��ü �߰�
		list1.add(new String("aaa"));
		list2.add(new String("bbb"));
		
	}
	
	
}
