package com.kh.chap3_field.model.vo;

public class Korean {
	private int age;
	public static int nCode ;
	// static ���� ����� �ʵ�(����)�� 
	// ���� �����ڸ� public���� �ϴ� ���� ����
	// (static ������ ������ ���� �� �� �ֱ� ����)
		
	// ���� + ���  // �޼ҵ� �ȿ� final ���� �Ұ� 
	public static final double PI2 = 3.141592;
	
	// �ν��Ͻ� �ʱ�ȭ ��
	// �ν��Ͻ� ������ �ʱ�ȭ ��Ű�� ������ 
	// ��ü ���� �� ���� �ʱ�ȭ
	
	{
		age = 1;
		
	}
	
	// ����ƽ �ʱ�ȭ ��
	// Ŭ���� ������ �ʱ�ȭ ��Ű�� ��
	// ���α׷� ���� �� �� �ѹ� �ʱ�ȭ ����
	static{  // static �ʱ�ȭ ���� ����� �ʱ�ȭ ���� �� ���
		nCode = 82;
	}
	
	public Korean() { // �ν��Ͻ� ���� �ʱ�ȭ // ��ȯ�� ����
		
	}
	
	//�޼ҵ�
	 public void setAge(int age) {
		 this.age = age;
	 }
	 public int getAge() {
		 return age;
	 }

	 
	 
	 
}
