package com.kh.chap1_list.part1.model.vo;

// MVC Model 2 ���� Model�� �ǹ�
/*	��Ʈ�ѷ����� ���޹��� ���뿡 ���� ���¸� �����ϰų�
 * ��û�� ����Ͻ� ������ ó���ϴ� �κ�
 * */

public class Student {
	private String name;
	private int score;
	
	public Student() {
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	
}
