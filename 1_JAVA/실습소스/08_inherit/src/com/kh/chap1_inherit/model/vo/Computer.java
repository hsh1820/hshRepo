package com.kh.chap1_inherit.model.vo;

		// ��� �Ұ� Ŭ����
public final class Computer extends Product{
											 // -> Ȯ���ϴ� 
	// �θ� Ŭ������ ����� �����ͼ�
	// �ڽ� Ŭ������ ����� ���Խ���
	// �ڽ��� ũ�⸦ Ȯ�� -> ���
	
	private int hdd;
	private int ram;
	private String cpu;
	
	public Computer() {
		super();
	}
	
	// �Ű� ���� �ִ� ������
	// Computer �ڽ��� �ʵ� + ��ӹ��� �ǵ� ��� �ʱ�ȭ
	public Computer(int hdd, int ram, String cpu, String brand, String name, String pCode, int price) {
		super(brand, name, pCode, price);
		this.setBrand(brand);
		super.setBrand(brand);
		
		this.hdd = hdd;
		this.ram = ram;
		this.cpu = cpu;
	}
	
	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	@Override
	public String inform() {
		
		
		return super.inform()+", "+cpu + ", " + hdd + ", " +  ram;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("�������̵� �ߴµ�?");
	}
	
}
