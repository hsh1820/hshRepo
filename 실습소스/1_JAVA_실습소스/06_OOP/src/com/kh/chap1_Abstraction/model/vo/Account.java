package com.kh.chap1_Abstraction.model.vo;

public class Account {
	// Ŭ���� ���� 
	/*
	 * Ŭ���� ����� {
	 * 
	 * 		// �ʵ� ( == ��� ����)
	 * 	
	 * 		// ������ 
	 * 
	 * 		// �޼ҵ�
	 * 
	 * }
	 * 
	 * 
	 * */
	
	 // �ʵ�
	 private  String name; // ������
	 private String accountNumber ; //���¹�ȣ
	 private String password;  // ��й�ȣ
	 private int bankCode;  // �����ڵ�
	 private int balance; // �ܾ�
	 
	// ������
	 public Account() {
		 // �ʵ��� �ʱⰪ�̳� �������� ���� �ٷ� ������ ��ɵ�
		 
	 }
	 
	 // �޼ҵ� set/get + ������ + ()
	 
	 // getter / setter
	 // name �� ���� getter / setter
	 // 
	 public void setName (String name) {
		 this.name = name;
		 // �ʵ� name = ���޹��� name		 
	 }
	 
	public String getName() {
		return name;
	}
	//accountNumber�� getter / setter
	/*
	 * setter �ۼ� ���
	 * public void set�ʵ�� (�ʵ��� �ڷ��� ������(==�ʵ��))
	 * this.�ʵ�� = ������;
	 * 
	 * */
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;		
	}
	 
	/*
	 * getter �ۼ� ���
	 * public ��ȯ��(��ȯ�� �ڷ��� ����) get�ʵ��() {
	 * 		return �ʵ��;
	 *	 }
	 * 
	 * */

	public String getAccountNumber() {
		return accountNumber;
	}
	 
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;		
	}
	public int getBankCode() {
		return bankCode;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	
	
	
	 // �Ա� ���
	 public void deposit(int money) {
		 							// �Ա��ϰ��� �ϴ� �ݾ� ���޵Ǿ� �Ѿ��
		 balance += money;
		 System.out.println(name + "���� ���¿� " + money + "���� �Աݵ�.");
	 }
	  
	 
}
