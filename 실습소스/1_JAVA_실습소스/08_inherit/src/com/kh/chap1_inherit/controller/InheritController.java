package com.kh.chap1_inherit.controller;

import com.kh.chap1_inherit.model.vo.Computer;
import com.kh.chap1_inherit.model.vo.Dress;
import com.kh.chap1_inherit.model.vo.Product;
import com.kh.chap1_inherit.model.vo.Snack;

public class InheritController  {
	public void method1() {
		// computer ��ü ����
		//Computer com = new Computer();
		/*
		com.setBrand("�Ｚ");
		com.setName("�Ｚ��ǻ��");
		com.setpCode("s001");
		com.setPrice(2000000);
		com.setCpu("Ryzen 3900X)");
		com.setRam(16);
		com.setHdd(2048);
		*/
		
		// Computer�� �Ű����� �ִ� �����ڸ� �̿��Ͽ� 
		// ��ü ���� �� �ʱ�ȭ 
		Computer com = new Computer(2048, 16, "Ryzen 3900X", "�Ｚ", "�Ｚ��ǻ��", "s001", 2000000);
		
		System.out.println(com.inform());
		
		Snack sn = new Snack();
		sn.setBrand("���");
		
		Dress dr = new Dress();
		dr.setPrice(100000);;
		
		Product pr = new Product();
		//		pr.set
		// �θ� Ŭ������ �ڽ� Ŭ������ ��� ���� �Ұ�
		
		
	}
}
