package com.kh.chap1.practice;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1: {
			System.out.print("�Է� �޴� �Դϴ�.");
			break;
		}
		case 2: {
			System.out.print("���� �޴� �Դϴ�.");
			break;
		}
		case 3: {
			System.out.print("��ȸ �޴� �Դϴ�.");
			break;
		}
		case 4: {
			System.out.print("��ȸ �޴� �Դϴ�.");
			break;
		}
		default : System.out.print("���α׷��� ����˴ϴ�."); 
	}
}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �� �� �Է��ϼ��� : ");
		int input = sc.nextInt();
		
		if(input>0 && input%2 == 0) {
			System.out.println("¦����");
		}else if(input > 0 && input%2 != 0) {
			System.out.println("Ȧ����");
		}else if(input <= 0) {
			System.out.println("����� �Է����ּ���.");
		}
	}
		
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� :  ");
		int kor = sc.nextInt();
		System.out.println("�������� :  ");
		int math = sc.nextInt();
		System.out.println("�������� :  ");
		int eng = sc.nextInt();
		
		int hap = kor + math + eng;
		double avg = hap /3;
		
		if (kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.println("���� : " + kor);
			System.out.println("���� : " + math);
			System.out.println("���� : " + eng);
			System.out.println("�հ� : " + hap);
			System.out.println("��� : " + avg);
			System.out.println("�����մϴ�, �հ��Դϴ�!");		
		}else System.out.println("���հ� �Դϴ�.");
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~12 ������ ���� �Է� : ");
		int month = sc.nextInt();
		
		String season;
		
		switch(month) {
		case 3:
		case 4: 
		case 5: {
			season = "��";
			System.out.println(month +"���� "+ season +"�Դϴ�."); 

			break;
		}
		case 6:
		case 7:
		case 8: {
			season = "����";
			System.out.println(month +"���� "+ season +"�Դϴ�.");
			break;
		}
		case 9:
		case 10:
		case 11: {
			season = "����";
			System.out.println(month +"���� "+ season +"�Դϴ�.");
			break;
		}
		case 12:
		case 1:
		case 2: {
			season = "�ܿ�";
			System.out.println(month +"���� "+ season +"�Դϴ�.");
			break;
		}
		default : {
			System.out.println(month +"���� �߸� �Էµ� ���Դϴ�."); 
		}
	}
}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� : ");
		String id = sc.nextLine();
		System.out.println("��й�ȣ : ");
		String pw = sc.nextLine();
		
		String id_d = "myId";
		String pw_d = "myPassword12";
		
		if (id.equals(id_d) && pw.equals(pw_d)) {
			System.out.print("�α��� ����");			
		}else if (!id.equals(id_d)) {
			System.out.print("���̵� Ʋ�Ƚ��ϴ�.");
		}else if (!pw.equals(pw_d)) {
			System.out.print("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ");
		
		String grade = sc.nextLine();			
		String result=""; 
		
		switch(grade) {
		case "������" :{
			result = "ȸ������, �Խñ� ���� ";
			System.out.print(result);
		}
		case "ȸ��" :{
			result = "�Խñ� �ۼ�,  ��� �ۼ� ";
			System.out.print(result);
		}
		case "��ȸ��" : {
			result = "�Խñ� ��ȸ";
			System.out.print(result);
		}
		
		}
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ű (m)�� �Է��� �ּ��� : ");				
		double height = sc.nextDouble();			
		System.out.println("������(kg)�� �Է��� �ּ��� : ");				
		double weight = sc.nextDouble();
		
		double bmi = weight/(height*height);
		
		if(bmi < 18.5) {
			System.out.println("BMI ���� : "+ bmi + "\n��ü��");
		}else if(bmi < 23 ) {
		System.out.println("BMI ���� : "+ bmi + "\n����ü��");
		}else if(bmi < 25 ) {
				System.out.println("BMI ���� : "+ bmi + "\n��ü��");
		}else if(bmi < 30 ) {
			System.out.println("BMI ���� : "+ bmi + "\n��");
		}else if(bmi >= 30 ) {
			System.out.println("BMI ���� : "+ bmi + "\n�� ��");
		}
		
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ǿ����� 1 �Է� : ");				
		int input1 = sc.nextInt();
		System.out.print("�ǿ����� 2 �Է� : ");				
		int input2 = sc.nextInt();
		System.out.print("�����ڸ� �Է�(+, -, *, /, %) : ");				
		char operator = sc.next().charAt(0);
		
		double result;
		
		if(input1 > 0 && input2 > 0) {
			switch(operator) {
			case '+': {
				result = input1 + input2;
				System.out.print(""+input1 + operator + input2 +"="+ (int)result);
				break;
			}
			case '-': {
				result = input1 - input2;
				System.out.print(""+input1 + operator + input2 +"="+ (int)result);
				break;
				}
			case '*': {
				result = input1 * input2;
				System.out.print(""+input1 + operator + input2 +"="+(int)result);
				break;
			}
			case '/': {
				result = (double)input1 / (double)input2;
				System.out.printf("%d %c %d = %.6f",input1,operator,input2,result);
				break;
				}
			case '%': {
				result = (double)input1 % (double)input2;
				System.out.printf("%d %c %d = %.6f",input1,operator,input2,result);
				break;
			}
		}
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		}
		
		
		
		
		
		
		
		
		
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�߰� ��� ���� : ");				
		double mid = sc.nextInt();
		System.out.print("�⸻ ��� ���� : ");				
		double fin = sc.nextInt();
		System.out.print("���� ���� : ");				
		double task = sc.nextInt();
		System.out.print("�⼮ Ƚ�� : ");				
		double attend = sc.nextInt();
		
		double mid_score = mid*0.2;
		double fin_score = fin*0.3;
		
		
		
		double task_score = task * 0.3;
		
		double total= mid_score + fin_score + attend + task_score;
		
		String pf="";
		
	//		if(total >= 70) {
	//			pf="Pass";
	//		}else if(total < 70) {
	//			pf="Fail [ ���� �̴� ] ";
	//		}else if(attend < 6 ) {
	//			pf="Fail [ �⼮ Ƚ�� ���� ("+ attend +"/20) ]" ;
	//		} 
	//		
		if(attend >= 20 * 0.7) {
			
			System.out.println("=========== ��� ===========");
			System.out.println("�߰� ��� ����(20) : "+ mid_score);
			System.out.println("�⸻ ��� ����(30) : "+ fin_score);
			System.out.println("���� ����       (30) :  "+task_score);
			System.out.println("�⼮ ����       (20) :  "+attend);
			System.out.println("���� : "+total); 
			
			if(total >= 70) {
				       
				System.out.println("PASS");
			}else {
				        
				System.out.println("Fail [���� �̴�]");
			}
		}else {
			System.out.println("FAIL [�⼮ ȸ�� ����] ("+ attend + "/20)]");
		}
		
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		System.out.print("���� : ");
		
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			practice1();
			break;
		case 2:
			practice2();
			break;
		case 3:
			practice3();
			break;
		case 4:
			practice4();
			break;
		case 5:
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}