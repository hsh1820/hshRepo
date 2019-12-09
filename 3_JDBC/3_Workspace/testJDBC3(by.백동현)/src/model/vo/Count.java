package model.vo;

public class Count {
	private int bno;
	private int count;

	public Count() {
		// TODO Auto-generated constructor stub
	}
	
	public Count(int bno, int count) {
		super();
		this.bno = bno;
		this.count = count;
	}

	public Count(int cCount) {
		this.count = cCount;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Count [bno=" + bno + ", count=" + count + "]";
	}

}
