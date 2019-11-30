package com.kh.chap1_Object.model.vo;

public class Student {
	private String name;
	private String classRoom;
	private int age;
	private int point;
	
	public Student() {
		
		
	}
	public Student(String name, String classRoom, int age, int point) {
		this.name = name;
		this.classRoom = classRoom;
		this.age = age;
		this.point = point;
	}
	
	
	// shift + alt + s -> r 
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setClassRoom (String classRoom){
		this.classRoom = classRoom;
	}
	public String getClassRoom() {
		return classRoom;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", classRoom=" + classRoom + ", age=" + age + ", point=" + point
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	// Object.equals() 
	// ��ü�� ������ �ִ� ���� ������ �������� �Ǻ��ϴ� ���// �ּҰ� �ƴ�
	@Override
	public boolean equals(Object obj) { // ���� Student Ŭ������ �ֻ��� �θ�� Object Ŭ�����̱� ������ ObjectŸ���� ��ü�� �޾ƿ;���
		// 1. Student ��ü�� �´���
		if(!(obj instanceof Student)/* �ٸ��� false */) {  // ��ü Ÿ�Ժ�
			// ���޹��� ��ü�� Student Ÿ�� ��ü���� 
			// �Ǵ� Student�� ��ӹ��� ��ü���� 
			return false;			
		}
		// 2. �ٿ�ĳ����  : �ּҸ� ����
		Student other = (Student)obj;  //
		// ObjectŬ������ obj��ü�� �θ�, Student�� Ŭ���� other��ü�� ���� �����ϱ� ���� 
		// �θ� Ŭ�������� obj ��ü�� ���� ����ȯ ==> ��ü�� �θ�Ŭ������ obj��ü�̴ϱ�     
		
		if(!(name.equals(other.name))) {
			return false;
		}
		if(!(classRoom.equals(other.classRoom))) {
			return false;
		}
		if(age != other.age) {
			return false;
		}
		if(point != other.point) {
			return false;
		}
		
		return true;
		
	}
	/*	* VO Ŭ���� �ۼ��� �� �ۼ��� ����
		1. �ʵ�
		2. ������
		3. getter() / setter ()
		4. toString
	    5. equals()
	*/
	
	
	
}
