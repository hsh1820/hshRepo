package com.kh.chap3_Wrapper.controller;

public class WrapperController {
	
	// Wrapper class 
	/*
	 * - wrapper : ������
	 * - ������ �����ϴ� Ŭ���� ? 
	 * 	-> �⺻ �ڷ����� ��ü�� �����ϴ� Ŭ����
	 * 
	 * - �� �����ϴ°�?
	 * 1) �⺻�ڷ������δ� ������ �� ���� ����� �߰��Ͽ� 
	 * 	����ϱ� ���ؼ� 
	 * 	ex) �ڷ����� �ִ�, �ּҰ� 
	 * 		String ���ڿ� -> �� Ÿ�Կ� �°� ��ȯ
	 * 		"123123" -> int 123123
	 * 
	 * 2) �⺻ �ڷ����� ��ü�� �ٷ�߸� �Ǵ� ���
	 * 	ex) - �Ű����� �Ǵ� ��ȯ���� ��ü�� �䱸�ϴ� ���
	 * 		- �⺻ �ڷ����� �ƴ� ��ü�� ���� �����ϴ� ���
	 * 		- ��ü���� �񱳰� �ʿ��� ��� -> ���� �ٸ� ��ü�� ũ��� ���༭ ��
	 * 			
	 * 
	 * */
	
	public void method1() {
		// int �� Wrapper class -> Integer
		System.out.println("int�� byte ũ�� : " + Integer.BYTES);
		System.out.println("int�� bitũ�� : " + Integer.SIZE);
		System.out.println("int�� �ִ밪 : " + Integer.MAX_VALUE);
		System.out.println("int�� �ּҰ� : " + Integer.MIN_VALUE);
		System.out.println("Integer�� �⺻ �ڷ��� : " + Integer.TYPE);
		
		
		// int �� �ּҰ� ~ �ִ밪 100�� �����ϴ� �ڵ� ���
		
//		for(int i =  Integer.MIN_VALUE ; i< Integer.MAX_VALUE;i+=100) {
//			System.out.println(i);
//		}
		// �Է¹��� ���ڿ��� int�� ũ�⸦ �ʰ��ϸ� long������ �����ϴ� �� ����
		
		
		
		
		// String ���� �⺻�ڷ������� ��ȯ
		String num1 = "10";
		int num2 = 20;
		
		System.out.println(num1+num2);

		
		System.out.println(Integer.parseInt(num1)+num2);
							// String�� ������ int�� ������ ��ȯ,  char�� ������ ��� �⺻���� ������
		
		
		byte bNum = Byte.parseByte("100"); // static ������ �ö� ����
		short sNum= Short.parseShort("1000");
		int iNum = Integer.parseInt("123456789");
		long lNum = Long.parseLong("123456789123456789");
		float fNum = Float.parseFloat("3.14");
		double dNum = Double.parseDouble("1.123456789");
		boolean bool = Boolean.parseBoolean("true"); // ���ڿ� true 
		char ch = "Hello".charAt(0); // String���ͷ�.�޼ҵ� = ���ͷ��� StringŬ������ ���
		
		
		// �⺻�ڷ����� -> String ��ȯ
		String s1 = Integer.valueOf(123)/**/.toString(); // IntgerŬ������ �ʵ�� �ְ� ���ڿ��� ���
		String s2 = 123+"";
		
		// Boxing : �⺻ �ڷ����� ����Ŭ���� ��ü�� ����
		// -> �⺻ �ڷ����� ��ü��� �ڽ��� ����
		Integer it1 = new Integer(123); 
		
		// Unboxing : ����Ŭ������ �⺻ �ڷ������� ��ȯ
		int i = it1.intValue();// ��Ƽ�� ��ü�� �������ִ� ���� int�� Ǯ� �������� ���
		int i2 = (int)it1; // Integer ��ü ���ο� int �� ��ȯ // ���� ����ȯ ����
		
		
		// AutoBoxing / Unboxing  : ����� ��ڽ��� �ڵ� == �ڵ� ����ȯ
		Integer it2 = 100; // AutoBoxing
		int i3 = it2; // Unboxing
		
		
		
	}
	
	
}	
	
