package com.kh.chap2_ab_In.practice.model.vo;

public abstract class SmartPhone implements CellPhone, TouchDisplay{
	private String maker ;  // ������ ����
	
	public SmartPhone() {
		
	}
	
	public String printInformation() {
		return "";
	}
	
	public void setMaker(String maker) {
		
	}  
	public String getMaker() {
		return "";
	}
	
}
