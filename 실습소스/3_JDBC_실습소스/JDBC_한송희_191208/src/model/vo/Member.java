package model.vo;

public class Member {
	private int mNo; // 회원 번호
	private String email; // 회원 이메일 겸 아이디
	private String password; // 회원 비밀번호
	private String name; // 회원 이름
	private char khYN; // kh학생 여부
	private char adminYN; // 관리자 여부
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Member(String email, String password, String name) {
		this(email, password) ;
		this.name = name;
	}

	public Member(String email, String password, String name, char khYN) {
		this(email, password, name);
		this.khYN = khYN;
	}

	public Member(int mNo, String email, String password, String name, char khYN, char adminYN) {
		super();
		this.mNo = mNo;
		this.email = email;
		this.password = password;
		this.name = name;
		this.khYN = khYN;
		this.adminYN = adminYN;
	}
	
	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public char getKhYN() {
		return khYN;
	}

	public void setKhYN(char khYN) {
		this.khYN = khYN;
	}

	public char getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(char adminYN) {
		this.adminYN = adminYN;
	}

	@Override
	public String toString() {
		return "MEMBER [mNo=" + mNo + ", email=" + email + ", password=" + password + ", name=" + name + ", khYN="
				+ khYN + ", adminYN=" + adminYN + "]";
	}
	
	
}
