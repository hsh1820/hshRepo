package com.kh.chap1_inherit.model.vo;

public class Product {
	private String brand;
	private String name;
	private String pCode;
	private int price ;
	
	public Product() {
		super();
		// 현재 클래스가 객체로 생성될 때
		// 객체 내부에 부모의 기본적인 형태의 객체를 생성하라는 구문		
	}
	
	public Product(String brand, String name, String pCode, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.pCode = pCode;
		this.price = price;
	}
	// get/ setter 빨리 만들기
	// art + shift + s -> r
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String inform() 	{
		return brand + ", "+ name + ", "+ pCode + ", "+ price;
	}
	// final 키워드 확인용 메소드
	public void print() {
		System.out.println("오버라이딩 해봐라.");
	}
	
	
}
