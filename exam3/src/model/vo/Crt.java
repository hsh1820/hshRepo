package model.vo;

public class Crt{
	
	private int crtNo;
	private String crtName;
	private String crtClass;
	private int crtLevel;
	private String crtOwner;
	
	public Crt() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Crt(String crtName, String crtClass) {
		this.crtName = crtName;
		this.crtClass = crtClass;
	}

	
	public Crt(String crtName, String crtClass, int crtLevel, String crtOwner) {
		super();
		this.crtName = crtName;
		this.crtClass = crtClass;
		this.crtLevel = crtLevel;
		this.crtOwner = crtOwner;
	}


	public Crt(int crtNo, String crtName, String crtClass, int crtLevel, String crtOwner) {
		this(crtName, crtClass);
		this.crtNo = crtNo;
		this.crtLevel = crtLevel;
		this.crtOwner = crtOwner;
	}

	public int getCrtNo() {
		return crtNo;
	}

	public void setCrtNo(int crtNo) {
		this.crtNo = crtNo;
	}

	public String getCrtName() {
		return crtName;
	}

	public void setCrtName(String crtName) {
		this.crtName = crtName;
	}

	public String getCrtClass() {
		return crtClass;
	}

	public void setCrtClass(String crtClass) {
		this.crtClass = crtClass;
	}

	public int getCrtLevel() {
		return crtLevel;
	}

	public void setCrtLevel(int crtLevel) {
		this.crtLevel = crtLevel;
	}

	public String getCrtOwner() {
		return crtOwner;
	}

	public void setCrtOwner(String crtOwner) {
		this.crtOwner = crtOwner;
	}

	@Override
	public String toString() {
		return "Crt [crtNo=" + crtNo + ", crtName=" + crtName + ", crtClass=" + crtClass + ", crtLevel="
				+ crtLevel + ", crtOwner=" + crtOwner + "]";
	}
	
	
}
