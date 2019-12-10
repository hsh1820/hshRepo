package com.kh.chap4_constructor.run;

import com.kh.chap4_constructor.model.vo.Book;

public class BookRun {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book("자바의 정석", 20000, 0.2, "윤상섭");
		
		b1.setTitle("C언어");
		b1.setDiscountRate(0.1);
		b1.setPrice(30000);
		b1.setAuthor("홍길동");
		
		System.out.println("수정된 결과 확인");
		System.out.printf(b1.inform());
		System.out.println("============================");
		
		
		System.out.println("도서명 = " + b1.getTitle());
		System.out.println("할인된 가격 = " + (int)(b1.getPrice() - b1.getDiscountRate()*b1.getPrice())+ "원");
		System.out.println("도서명 = " + b2.getTitle());
		System.out.println("할인된 가격 = " + (int)(b2.getPrice() - b2.getDiscountRate()*b2.getPrice())+ "원");
			
		
		
	}
	
}
