package com.kh.chap1_poly.practice.model.vo;

public class AniBook extends Book{
	private int accessAge;
	
	public AniBook() {
		// TODO Auto-generated constructor stub
	}

	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}
	
	
	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "AniBook " + super.toString() +", accessAge ="+ accessAge +"]";
	}
	
	
}
