
package model.vo;

import java.sql.Date;

public class EMP {
	/*	VO(Value Object) == DTO(Data Transfer Object)
	 * 	== DO(Domain Object) == Entity(DB)(�겢�옒�뒪�쓽 �냽�꽦�뱾)
	 * 	== ROW == Record 
	 * --> DB �뀒�씠釉붿쓽 �븳 �뻾�쓽 �젙蹂닿� 湲곕줉�릺�뒗 ���옣�슜 媛앹껜
	 * 
	 * VO 瑜� 留뚮뱾 �븣 諛섎뱶�떆 �쟻�슜�빐�빞�븷 寃�
	 *   1. 諛섎뱶�떆 罹≪뒓�솕瑜� �쟻�슜 -> 紐⑤뱺 �븘�뱶�뿉 private �젒洹쇱젣�븳�옄瑜� �궗�슜
	 *   2. 湲곕낯 �깮�꽦�옄\t紐⑤뱺 留ㅺ컻蹂��닔媛� �엳�뒗 �깮�꽦�옄 �옉�꽦
	 *   3. 紐⑤뱺 �븘�뱶�뿉 ���븯�뿬 getter / setter �옉�꽦
	 * 
	 * */
	// java�뿉�꽌�뒗 _濡� �떒�뼱援щ텇 �궗�슜 �븯吏� �븡�쓬
	private int empNo; // �궗踰�
	private String eName; // �궗�썝紐�
	private String job; // 吏곸콉
	private int mgr ; // 吏곸냽�긽�궗(manager)
	private Date hireDate; // �엯�궗�씪(java.sql.Date)
	private int sal; // 湲됱뿬
	private int comm; // 而ㅻ�몄뀡 (�씤�꽱�떚釉�)
	private int depNo; // 遺��꽌踰덊샇
	
	// 湲곕낯�깮�꽦�옄
	public EMP() {
		// TODO Auto-generated constructor stub
	}
	
	// 紐⑤뱺 留ㅺ컻蹂��닔 �엳�뒗 �깮�꽦�옄
	public EMP(int empNo, String eName,String job,int mgr,Date hireDate,int sal,int comm,int depNo) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.depNo = depNo;
	}
	// getter / setter 
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDepNo() {
		return depNo;
	}

	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}

	@Override
	public String toString() {
		return  empNo + "\t" + eName + "\t" + job + "\t" + mgr + "\t" + hireDate
				+ "\t" + sal + "\t" + comm + "\t" + depNo ;
	}	
	
}
