package com.kh.chap4_constructor.run;

import com.kh.chap4_constructor.model.vo.Book;

public class BookRun {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book("�ڹ��� ����", 20000, 0.2, "����");
		
		b1.setTitle("C���");
		b1.setDiscountRate(0.1);
		b1.setPrice(30000);
		b1.setAuthor("ȫ�浿");
		
		System.out.println("������ ��� Ȯ��");
		System.out.printf(b1.inform());
		System.out.println("============================");
		
		
		System.out.println("������ = " + b1.getTitle());
		System.out.println("���ε� ���� = " + (int)(b1.getPrice() - b1.getDiscountRate()*b1.getPrice())+ "��");
		System.out.println("������ = " + b2.getTitle());
		System.out.println("���ε� ���� = " + (int)(b2.getPrice() - b2.getDiscountRate()*b2.getPrice())+ "��");
			
		
		
	}
	
}
