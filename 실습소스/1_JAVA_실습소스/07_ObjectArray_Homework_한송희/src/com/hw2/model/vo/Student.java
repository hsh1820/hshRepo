package com.hw2.model.vo;

public class Student {
	private int grade ;  // 학년
	private int classroom ;  // 반
	private String name ;  // 이름
	private int kor ;  // 국어점수
	private int eng ;  // 영어점수
	private int math ;  // 수학점수
	
	public Student() {
		
	}
	public Student(int grade ,int classroom ,String name ,
			int kor ,int eng ,int math ) {
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public void setGrade(int grade) {
		this.grade = grade;		
	}
	public void setClassroom(int classroom)	{
		this.classroom = classroom;
	}
	public void setName(String name)	{
		this.name = name;		
	}
	public void setKor(int kor)	{
		this.kor = kor;
	}
	public void setEng(int eng)	{
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	

	
	
	public int getGrade()	{
		return grade;
	}
	public int getClassroom() 	{
		return classroom;
	}
	public int getKor()	{
		return kor;
	}
	public int getEng()	{
		return eng;
	}
	public int getMath()	{
		return math;
	}
	public String getName()	{
		return name;
	}
	
	
	
	public String information()	{
		return grade + "\t" + classroom + "\t" +  name + "\t" + kor+ "\t" + eng+ "\t" + math;
	}
}
