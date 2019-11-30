package com.kh.chap3_map.practice.model.vo;

public class Member {
	private String password;
	private String name;
	private String address;
	
	public Member() {
		
	}
	public Member(String name, String password, String address) {
		super();
		this.password = password;
		this.name = name;
		this.address = address;
	}
	
	//	public Member(String name, String password) {
	//		super();
	//		this.password = password;
	//		this.name = name;
	//	}
	
	public String getAddress() {
		return address;
	}
	
	public void setGender(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Member [password=" + password + ", name=" + name + ", gender=" + address + "]";
	}
	

	
	
	 
}
