package com.kh.chap1_Abstraction.run;

import com.kh.chap1_Abstraction.model.vo.Person;

public class Run {
	public static void main(String[] args) {
		/*
		 * 1. ��ü ���� ���  : ��ü�� �����ϴ� ���ν� ���α׷� ���� �ڵ���� ��ü�� �̷���� �ְ�
		 *  �� ��ü���� ��ȣ�ۿ��� �ϸ鼭 ���α׷��� ������Ű�� �ϴ� ���
		 * 
		 * 2. ��ü(�Ӽ� + ���) 
		 *  - ������ �ǹ� : ���������� �����ϴ� ������ �� �ִ� ��� �� (����, ���� ������ ����)
		 *  - Java������ �ǹ� : Ŭ������ ���ǵ� ������ new �����ڸ� ���� Heap������ ����(�޸� �Ҵ�)�ϴ� ��
		 *   
		 *  3. ��ü ���� ���α׷��� (OOP)
		 *  - ���Ǽ����� ��ü�� ���� ��ȣ�ۿ��� ��ü���� �� ����  ���α׷����Ͽ� ���󼼰迡 �����ϴ� ����
		 *   
		 *   4. Java���� ��ü�� �����ϱ� ���� �ʿ��� ��
		 *   - Class (�߻�ȭ + ĸ��ȭ �ݵ�� ����)
		 *      
		 * */
		
		/*	�߻�ȭ 
		 * ���� �����ϰ��� �ϴ� ���α׷��� "����"�� ����
		 * �������� �κ��� �����س��� 
		 * ���ʿ��� �κ��� ������ ������ ����
		 * 
		 * */
		// ��ü ���� 
		// * Class == ����� ���� �ڷ��� ==> Ŭ�������� �ڷ����̵�
		Person person = new Person();
		// �ڷ���   ������      => Heap �� Person �ڷ��� ���� �Ҵ� == �� �Ӽ��鿡�� �ε��� ���� == .���� �ʵ� ���� ����
		// person���� 
		// �ּҰ� ����(= ����������)
		// => (stack) 
		
		person.pNo = "000101-1234567";
		person.name = "ȫ�浿";
		person.gender = '��';
		person.address = "����� �߱� ���빮��	120 ���Ϻ��� 2��	";
		person.phone = "010-1234-5678";
		person.age=20;
		
		System.out.println("�̸� : " + person.name);
		System.out.println("�ֹε�Ϲ�ȣ : " + person.pNo);
		System.out.println("���� : " + person.gender);
		System.out.println("���� : " + person.age);
		System.out.println("��ȭ��ȣ : " + person.phone);
		System.out.println("�ּ� : " + person.address);
		
		
		
		
		
		
	}
}
