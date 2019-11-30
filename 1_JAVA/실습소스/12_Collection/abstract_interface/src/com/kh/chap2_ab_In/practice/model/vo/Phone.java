package com.kh.chap2_ab_In.practice.model.vo;

public interface Phone {
	public char[] NUMBERPAD  = {'1', '2','3', '4', '5', '6', '7', '8', '9', '*', '0', '#' };
	public String makeCall() ;  // 전화 걸기
	public String takeCall() ;  // 전화 받기
}
