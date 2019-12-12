package model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private char gender;
	private String email;
	private int age;
	private Date enrollDate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Member(String memberName, char gender, String email, int age) {
		super();
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.age = age;
	}
	
	


	public Member(String memberId, String memberName, char gender, String email, int age, Date enrollDate) {
		this(memberName, gender, email, age);
		this.memberId = memberId;
		this.enrollDate = enrollDate;
	}



	public Member(String memberId, String memberPwd, String memberName, char gender, String email, int age) {
		this(memberName, gender, email, age);
		this.memberId = memberId;
		this.memberPwd = memberPwd;

	}



	public Member(String memberId, String memberPwd, String memberName, char gender, String email, int age,
			Date enrollDate) {
		this(memberId, memberPwd, memberName, gender, email, age);
		this.enrollDate = enrollDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", gender=" + gender + ", email=" + email + ", age=" + age + ", enrollDate=" + enrollDate + "]";
	}
	
	
}
