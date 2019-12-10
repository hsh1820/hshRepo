package com.kh.chap2_encapsulation.run;

import com.kh.chap1_Abstraction.model.vo.Account;
import com.kh.chap3_field.model.vo.Korean;

public class AccountRun {
	public static void main(String[] args) {
		
		// ĸ��ȭ 
		/*
		 * �߻�ȭ�� ���� ���ǵ� �Ӽ�, ����� �ϳ��� ���� �����ϴ� ���
		 * �� �� Ŭ������ ������ ������(�ʵ�, �������)�� ���� ������
		 * �����ϴ� ���� ��Ģ�̹Ƿ� private ���� �����ڸ� ��� 
		 * 
		 * ���� ������ ����Ͽ� ���� �������� ������ ���� 
		 * ���� ���� ���(���) �� Ŭ���� ���ο� �ۼ�
		 * == getter / setter �޼ҵ�
		 * 
		 * */
		
		Account acc = new Account(); // ������
		// ������ : ��ü ���� �� �ʱ� �ʵ尪�� 
		//  		  �������ڸ��� ������ ����� �ۼ��ϴ� �κ�
		
		//acc.name = "ȫ�浿";
		//The field Account.name is not visible 
		// Account ��ü ������ name �ʵ尡 private �̹Ƿ�
		// �ܺ� ���� ���� �Ұ� --> ���� ���� ��� ���
		
		acc.setName("ȫ�浿");
		acc.setPassword("password");
		acc.setAccountNumber("01012345678");
		acc.setBalance(100000000);
		acc.setBankCode(0111); // 0 �� 8����, 0x 16����
		
		System.out.println(Korean.nCode);
		
		
		System.out.println("���� ����");
		System.out.println(acc.getName());
		System.out.println(acc.getAccountNumber());
		System.out.println(acc.getBalance());
		System.out.println(acc.getBankCode());
		System.out.println(acc.getPassword());
		
		acc.deposit(1000000000);
		
		System.out.println(acc.getBalance());
		
		
	}
}
