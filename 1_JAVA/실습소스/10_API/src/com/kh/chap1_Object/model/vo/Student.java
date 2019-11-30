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
	// 객체가 가지고 있는 값이 동일한 값인지를 판별하는 기능// 주소값 아님
	@Override
	public boolean equals(Object obj) { // 현재 Student 클래스의 최상위 부모는 Object 클래스이기 때문에 Object타입의 객체를 받아와야함
		// 1. Student 객체가 맞는지
		if(!(obj instanceof Student)/* 다르면 false */) {  // 객체 타입비교
			// 전달받은 객체가 Student 타입 객체인지 
			// 또는 Student를 상속받은 객체인지 
			return false;			
		}
		// 2. 다운캐스팅  : 주소만 저장
		Student other = (Student)obj;  //
		// Object클래스의 obj객체가 부모, Student의 클래스 other객체의 값에 접근하기 위해 
		// 부모 클래스형의 obj 객체를 강제 형변환 ==> 주체가 부모클래스인 obj객체이니까     
		
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
	/*	* VO 클래스 작성시 꼭 작성할 내용
		1. 필드
		2. 생성자
		3. getter() / setter ()
		4. toString
	    5. equals()
	*/
	
	
	
}
