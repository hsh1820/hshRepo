package com.kh.chap1.practice;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1: {
			System.out.print("입력 메뉴 입니다.");
			break;
		}
		case 2: {
			System.out.print("수정 메뉴 입니다.");
			break;
		}
		case 3: {
			System.out.print("조회 메뉴 입니다.");
			break;
		}
		case 4: {
			System.out.print("조회 메뉴 입니다.");
			break;
		}
		default : System.out.print("프로그램이 종료됩니다."); 
	}
}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input>0 && input%2 == 0) {
			System.out.println("짝수다");
		}else if(input > 0 && input%2 != 0) {
			System.out.println("홀수다");
		}else if(input <= 0) {
			System.out.println("양수만 입력해주세요.");
		}
	}
		
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수 :  ");
		int kor = sc.nextInt();
		System.out.println("수학점수 :  ");
		int math = sc.nextInt();
		System.out.println("영어점수 :  ");
		int eng = sc.nextInt();
		
		int hap = kor + math + eng;
		double avg = hap /3;
		
		if (kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + hap);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");		
		}else System.out.println("불합격 입니다.");
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String season;
		
		switch(month) {
		case 3:
		case 4: 
		case 5: {
			season = "봄";
			System.out.println(month +"월은 "+ season +"입니다."); 

			break;
		}
		case 6:
		case 7:
		case 8: {
			season = "여름";
			System.out.println(month +"월은 "+ season +"입니다.");
			break;
		}
		case 9:
		case 10:
		case 11: {
			season = "가을";
			System.out.println(month +"월은 "+ season +"입니다.");
			break;
		}
		case 12:
		case 1:
		case 2: {
			season = "겨울";
			System.out.println(month +"월은 "+ season +"입니다.");
			break;
		}
		default : {
			System.out.println(month +"월은 잘못 입력된 달입니다."); 
		}
	}
}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();
		
		String id_d = "myId";
		String pw_d = "myPassword12";
		
		if (id.equals(id_d) && pw.equals(pw_d)) {
			System.out.print("로그인 성공");			
		}else if (!id.equals(id_d)) {
			System.out.print("아이디가 틀렸습니다.");
		}else if (!pw.equals(pw_d)) {
			System.out.print("비밀번호가 틀렸습니다.");
		}
		
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("권한을 확인하고자 하는 회원 등급 : ");
		
		String grade = sc.nextLine();			
		String result=""; 
		
		switch(grade) {
		case "관리자" :{
			result = "회원관리, 게시글 관리 ";
			System.out.print(result);
		}
		case "회원" :{
			result = "게시글 작성,  댓글 작성 ";
			System.out.print(result);
		}
		case "비회원" : {
			result = "게시글 조회";
			System.out.print(result);
		}
		
		}
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키 (m)를 입력해 주세요 : ");				
		double height = sc.nextDouble();			
		System.out.println("몸무게(kg)를 입력해 주세요 : ");				
		double weight = sc.nextDouble();
		
		double bmi = weight/(height*height);
		
		if(bmi < 18.5) {
			System.out.println("BMI 지수 : "+ bmi + "\n저체중");
		}else if(bmi < 23 ) {
		System.out.println("BMI 지수 : "+ bmi + "\n정상체중");
		}else if(bmi < 25 ) {
				System.out.println("BMI 지수 : "+ bmi + "\n과체중");
		}else if(bmi < 30 ) {
			System.out.println("BMI 지수 : "+ bmi + "\n비만");
		}else if(bmi >= 30 ) {
			System.out.println("BMI 지수 : "+ bmi + "\n고도 비만");
		}
		
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("피연산자 1 입력 : ");				
		int input1 = sc.nextInt();
		System.out.print("피연산자 2 입력 : ");				
		int input2 = sc.nextInt();
		System.out.print("연산자를 입력(+, -, *, /, %) : ");				
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
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
		
		
		
		
		
		
		
		
		
	}
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");				
		double mid = sc.nextInt();
		System.out.print("기말 고사 점수 : ");				
		double fin = sc.nextInt();
		System.out.print("과제 점수 : ");				
		double task = sc.nextInt();
		System.out.print("출석 횟수 : ");				
		double attend = sc.nextInt();
		
		double mid_score = mid*0.2;
		double fin_score = fin*0.3;
		
		
		
		double task_score = task * 0.3;
		
		double total= mid_score + fin_score + attend + task_score;
		
		String pf="";
		
	//		if(total >= 70) {
	//			pf="Pass";
	//		}else if(total < 70) {
	//			pf="Fail [ 점수 미달 ] ";
	//		}else if(attend < 6 ) {
	//			pf="Fail [ 출석 횟수 부족 ("+ attend +"/20) ]" ;
	//		} 
	//		
		if(attend >= 20 * 0.7) {
			
			System.out.println("=========== 결과 ===========");
			System.out.println("중간 고사 점수(20) : "+ mid_score);
			System.out.println("기말 고사 점수(30) : "+ fin_score);
			System.out.println("과제 점수       (30) :  "+task_score);
			System.out.println("출석 점수       (20) :  "+attend);
			System.out.println("총점 : "+total); 
			
			if(total >= 70) {
				       
				System.out.println("PASS");
			}else {
				        
				System.out.println("Fail [점수 미달]");
			}
		}else {
			System.out.println("FAIL [출석 회수 부족] ("+ attend + "/20)]");
		}
		
		
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		System.out.print("선택 : ");
		
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
			default : System.out.println("잘못 입력하셨습니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}