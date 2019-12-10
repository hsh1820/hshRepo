package com.kh.chap_set.part1.model.vo;

public class Student {
	private String name;
	private int age;
	private int score;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() { 
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + age;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + score;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		// 객체가 가지고 있는 값이 동일한지 판별하는 메소드
//		
//		if(!(obj instanceof Student)) {
//			// 타입이 같지 않을 경우 
//			return false;
//		}
//		// 같은 타입인 경우 값을 비교할 수 있게
//		// obj를 Student 타입으로 다운캐스팅
//		Student other = (Student)obj;
//		
//		if(!(name.equals(other.getName()))) {
//			// name 값이 같지 않은 경우
//			return false;
//		}
//		if(age!= other.age) {
//			return false;
//		}
//		if(score!= other.score) {
//			return false;
//		}
//		
//		return true;
//	}
//	
//	
//	@Override
//	public int hashCode() {
//		// 같은 필드값을 가지고 있으면
//		// 같은 정수가 나올 수 있도록 오버라이딩
//		
//		// 1) 필드값을 전부 더함
//		// String -> 
//		final int PRIME = 31;
//		// PRIME : 소수
//		// 31 이라는 수가 해시코드로 변환 시
//		// 중복을 가장 최소화 하면서 
//		// 연산속도가 가장 우수한 숫자
//		// 2 * 31 = 62
//		// 2<<5 - 2 = 62 
//		
//		int result = 1;
//		
//		result = PRIME * result + age; 
//		result = PRIME * result + score;
//		result = PRIME * result + (name == null? 0 : name.hashCode());
//		return result ;
//	}

	
	
}
