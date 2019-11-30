package com.kh.chap1_inherit.model.vo;

public class Product {
	private String brand;
	private String name;
	private String pCode;
	private int price ;
	
	public Product() {
		super();
		// ���� Ŭ������ ��ü�� ������ ��
		// ��ü ���ο� �θ��� �⺻���� ������ ��ü�� �����϶�� ����		
	}
	
	public Product(String brand, String name, String pCode, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.pCode = pCode;
		this.price = price;
	}
	// get/ setter ���� �����
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
	// final Ű���� Ȯ�ο� �޼ҵ�
	public void print() {
		System.out.println("�������̵� �غ���.");
	}
	
	
}
