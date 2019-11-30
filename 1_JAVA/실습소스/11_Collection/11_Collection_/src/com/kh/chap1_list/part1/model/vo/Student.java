package com.kh.chap1_list.part1.model.vo;

// MVC Model 2 에서 Model의 의미
/*	컨트롤러에서 전달받은 내용에 따라 상태를 변경하거나
 * 요청된 비즈니스 로직을 처리하는 부분
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
