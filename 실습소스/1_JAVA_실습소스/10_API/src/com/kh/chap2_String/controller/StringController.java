package com.kh.chap2_String.controller;

import java.util.Scanner;

public class StringController {

	
	// String Class
	// ���ڿ� ���� ���� �Ұ����� �Һ�(immutable) Ŭ����
	// ���ڿ� ���� ���� �� ���ο� ���ڿ��� �Ҵ�Ǿ� 
	// �� �ּҸ� ��ȯ����
	
	public void method1() {
		String str1 = "abc";
		
		
		// str1.hashCode() 
		// Object �� hashCode() �������̵��Ǿ� �ִ� ���̳�, 
		// String�� ���� StringŬ�������� Object�� hashCode()�� �������̵�
		// String.hashCode()�� ���� �ؽ��ڵ�ȭ, �ּҸ� �Ѱ� �ƴ�
		// --> String�� �������̵��ؼ� ���ϴ� �ּҰ��� ������ �ؽ��ڵ� ��� �Ұ�
		
		// system.identifyHashCode(obj)
		// --> ��ü�� ���� �ּҸ� �̿��Ͽ� ���� �ؽ��ڵ� �� ��ȯ
		System.out.println("str1 : "+System.identityHashCode(str1));
		
		str1 += "def"; // str1 == "abcdef"; // �ٸ� �ּ� ��� == ���� �迭 �������   // �Һ�Ȯ�� //
		System.out.println("str1 : "+System.identityHashCode(str1));
		
		
		String str2 = "abcdef"; // str2 == str3 �ּҰ��� ����
		System.out.println("str2 : "+System.identityHashCode(str2));

		
		String str3 = "abcdef";  // String str = ""; String ���ͷ��� ������ ����
		// ���·� ���ڿ� ������ String pool�� ���� �̹� ������� ������ ���ڿ��� ���� 
		System.out.println("str3 : "+System.identityHashCode(str3));

		String s1 = "Hello";  // String pool �� ����
		String s2 = new String("Hello");
		
		System.out.println("s1 �� : "+ s1);
		System.out.println("s2 �� : "+ s2);
		
		System.out.println("s1 hashCode : "+System.identityHashCode(s1));
		System.out.println("s2 hashCode : "+System.identityHashCode(s2));
		
	}
	
	
	public void method2() {
		// StringBuffer �⺻������ ���� �� ����ũ�� : 16
		StringBuffer sb = new StringBuffer();
		System.out.println("sb�� ����ũ�� : " + sb.capacity());
		
		StringBuffer sb2 = new StringBuffer("java api");
		System.out.println("sb2�� ����ũ�� : " + sb2.capacity());
		
		// ����/�Һ� Ȯ��
		System.out.println("sb�� �ؽ��ڵ� : " + sb.hashCode());
		// StringBuffer ��ü�� ���ڿ� �ִ� ���
		sb.append("Hello World");
		System.out.println("sb : " + sb);
		System.out.println("sb�� �ؽ��ڵ� : " + sb.hashCode());
		System.out.println("sb�� ����ũ�� : " + sb.capacity());
		
		sb.append(sb); // sb�� ���� sb���� �ѹ� �� �߰�
		System.out.println("sb : " + sb);
		System.out.println("sb�� �ؽ��ڵ� : " + sb.hashCode());
		System.out.println("sb�� ����ũ�� : " + sb.capacity());
		
		
	}
	
	public void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ���� �Է��ϼ��� : ");
		// 1 + 2 
		// ���⸦ �����ڷ� ���
		String input = sc.nextLine();
		
		String[] arr = input.split(" ");
		// ������ �����ڷ� �Էµ� ������ String�迭�� ��ȯ
		
		// �Էµ� �� �� ���ںκ��� ������ ��ȯ
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[2]);
		
		switch(arr[1]) {
			case "+" : System.out.println(num1+num2);break;
			case "-" : System.out.println(num1-num2);break;
			case "*" : System.out.println(num1*num2);break;
			case "/" : System.out.println(num1/num2);break;
			case "%" : System.out.println(num1%num2);break;
			default : System.out.println("�����ڸ� �߸��Է���.");
			
			
		}
		
		
		
	}
	
}
