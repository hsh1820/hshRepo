package com.kh.chap2_ab_In.practice.model.vo;

public class V40 extends SmartPhone implements NotePen{
	
	public V40() {
		super.setMaker("LG");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String charge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String takeCall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String picture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String touch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean bluetoothPen() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String printInformation() {
		return charge()+ makeCall() + takeCall() + picture() +touch() +bluetoothPen() ;
		
	}
}
