package com.hw1.model.vo;   

public class Employee {
	 private int empNo ;     // 사번
	 private String empName ;//사원명
	 private String dept ;//소속부서
	 private String job ;//직급
	 private int age ;     // 나이
	 private char gender ;      // 성별
	 private int salary ;     // 급여
	 private double bonusPoint ;//보너스포인트
	 private String  phone ;//전화번호
	 private String    address ;//주소
	 
	 public Employee() {
		 
	 }
	 public Employee(int empNo, String empName, int age, 
			 char gender, String phone, String address) {
		 this.empNo = empNo;
		 this.empName = empName;
		 this.age = age;
		 this.gender = gender;
		 this.phone = phone;
		 this.address = address;
	 }
	 public Employee( int empNo ,String empName ,String
			 dept , String job , int age ,char gender ,
			 int salary , double bonusPoint ,String phone ,
			 String address ) {
		 this.empNo = empNo;
		 this.empName = empName;
		 this.dept = dept;
		 this.job = job;
		 this.age = age;
		 this.gender = gender;
		 this.salary = salary;
		 this.bonusPoint = bonusPoint;
		 this.phone = phone;
		 this.address = address;
	 }
	 
	 public void setEmpNo (int empNo) {
		 this.empNo = empNo;
	 }
	 public void setEmpName(String empName)	{
		 this.empName = empName;
	 }
	 public void setDep(String dept)	{
		 this.dept = dept;
	 }
	 public void setJob(String job) {
		 this.job = job;
	 }
	 public void setAge(int age)	{
		 this.age = age;
	 }
	 public void setGender(char gender) {
		 this.gender = gender;
	 }
	 public void setSalary(int salary)	{
		 this.salary = salary;
	 }
	 public void setBounusPoint(double bonusPoint)	{
		 this.bonusPoint = bonusPoint;
	 }
	 public void setPhone(String phone)	{
		 this.phone = phone;
	 }
	 public void setAddress(String address)	{
		 this.address = address;
	 }
	 
	 public int getEmpNo() {		 
		 return empNo;
	 }
	 public int getAge() {
		 return age;
	 }
	 public int getSalary() {
		 return salary;
	 }
	 public String getEmpName()	{
		 return empName;
	 }
	 public String getDept() {
		 return dept;
	 }
	 public String getJob()	{
		 return job;
	 }
	 public String getPhone()	{
		 return phone;
	 }
	 public String getAddress() {
		 return address;
	 }
	 public char getGender() 	{
		 return gender;
	 }
	 public double getBonusPoint() {
		 return bonusPoint;
	 }
	 
	 
	 public String information() {
		 return empNo+","+empName+","+dept+","+job+","+age+","+gender+","+salary+","+bonusPoint+","+phone+","+address;
	 }

}
