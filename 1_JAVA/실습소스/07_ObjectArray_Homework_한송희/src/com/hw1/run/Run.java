package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {
public static void main(String[] args) {
	Employee[] emp = new Employee[3];
		
	emp[0] = new Employee();
	emp[1] = new Employee(1,"È«±æµ¿",null,null,19,'m',0,0.0,"01022223333","¼­¿ï Àá½Ç");
	emp[2] = new Employee(2,"°­¸»¼ø", "±³À°ºÎ", "°­»ç", 20, 'F', 1000000, 0.01, "01011112222", "¼­¿ï ¸¶°î");
	
	System.out.println("emp[0] : "+emp[0].information());
	System.out.println("emp[1] : "+emp[1].information());
	System.out.println("emp[2] : "+emp[2].information());
	System.out.println("=================================================================");
	
	emp[0].setEmpNo(0);
	emp[0].setEmpName("±è¸»¶Ë");
	emp[0].setDep("¿µ¾÷ºÎ");
	emp[0].setJob("ÆÀÀå");
	emp[0].setAge(30);
	emp[0].setGender('M');
	emp[0].setSalary(3000000);
	emp[0].setBounusPoint(0.2);
	emp[0].setPhone("01055559999");
	emp[0].setAddress("Àü¶óµµ ±¤ÁÖ");
	
	emp[1].setEmpNo(1);
	emp[1].setEmpName("È«±æµ¿");
	emp[1].setDep("±âÈ¹ºÎ");
	emp[1].setJob("ºÎÀå");
	emp[1].setAge(19);
	emp[1].setGender('M');
	emp[1].setSalary(4000000);
	emp[1].setBounusPoint(0.3);
	emp[1].setPhone("01022223333");
	emp[1].setAddress("¼­¿ï Àá½Ç");
	
	
	System.out.println("emp[0] : "+emp[0].information());
	System.out.println("emp[1] : "+emp[1].information());
	System.out.println("=================================================================");
	
	System.out.println(emp[0].getEmpName()+"ÀÇ ¿¬ºÀ : "+((emp[0].getSalary()+(int)(emp[0].getSalary()*emp[0].getBonusPoint()))*12) +"¿ø");
	System.out.println(emp[1].getEmpName()+"ÀÇ ¿¬ºÀ : "+((emp[1].getSalary()+(int)(emp[1].getSalary()*emp[1].getBonusPoint()))*12) +"¿ø");
	System.out.println(emp[2].getEmpName()+"ÀÇ ¿¬ºÀ : "+((emp[2].getSalary()+(int)(emp[2].getSalary()*emp[2].getBonusPoint()))*12) +"¿ø");
	System.out.println("=================================================================");
	System.out.println("Á÷¿øµéÀÇ ¿¬ºÀÀÇ Æò±Õ : "+(((emp[0].getSalary()+(int)(emp[0].getSalary()*emp[0].getBonusPoint()))*12)+((emp[1].getSalary()+(int)(emp[1].getSalary()*emp[1].getBonusPoint()))*12)+((emp[2].getSalary()+(int)(emp[2].getSalary()*emp[2].getBonusPoint()))*12))/3+"¿ø");
}

}
