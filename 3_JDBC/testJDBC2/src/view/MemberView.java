package view;

import java.util.List;
import java.util.Scanner;

import controller.MemberController;
import model.vo.Member;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	
	// 메인 메뉴	
	/**
	 * 이 곳에 어떤 매개변수가 필요하고 
	 * 어떤 기능을 하며
	 * 어떤 값을 반환 한다는 내용을 적는다
	 * 
	 * 단축키 : Alt + Shift + j
	 *  또는 에디터 창에 /** */
	public void mainMenu() {
		
		// MemberController 객체 생성
		MemberController mController = new MemberController();
		
		// 메뉴 선택값 저장용 변수 선언
		int sel = 0;
		
		do {
			System.out.println("\n *** 회원 관리 프로그램 *** \n");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 정보 조회");
			System.out.println("3. 특정 조건 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 >> ");
			sel = sc.nextInt();
			sc.nextLine(); // Scanner 버퍼에 남아있는 개행 문자 제거
			
			switch(sel) {
			case 1 : mController.insertMember(); break;
			case 2 : mController.selectAll(); break;
			case 3 : mController.selectmember(); break;
			case 4 : break;
			case 5 : break;
			case 0 : System.out.println("프로그램 종료");break;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");				
			}
			
		}while(sel != 0);
	}
	
	// 1_2. 회원 정보 입력용 View
	
	/**
	 * 회원 정보 입력용 View
	 * @return member : Member
	 */
	public Member insertMember() {
		System.out.println("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		System.out.println("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.println("성별 (M/F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		
		System.out.println("전화번호(-포함) : ");
		String phone = sc.nextLine();
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); // 개행 문자 제거 
		
		System.out.println("주소 : ");
		String address = sc.nextLine();
		
		Member member = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age);
		
		return member;
	}
	
	// 1_29. DML 성공 메세지 출력용 View
	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : " + msg);
	}
	
	// 1_32. 실패 메세지 출력용 View
	public void displayFail(String msg) {
		System.out.println("서비스 요청 실패 : " + msg);
	}
	
	// 1_35. 에러 메세지 출력용 View
	public void displayError(String msg, Exception e) {
		System.out.println("서비스 요청 중 오류 발생 : " + msg );
		e.printStackTrace();
	}
	
	// 2_21. 회원 정보 출력용 View
	public void displayMember(List<Member> mList) {
		System.out.printf("%-10s %-10s %-5s %-5s %-20s %-15s %-4s %-20s %-15s\n",
				"ID", "PWD", "NAME", "GENDER", "EMAIL", 
				"PHONE", "AGE", "ADDRESS", "EROLLDATE");
		
		for(Member m : mList) {
			System.out.printf("%-10s %-10s %-8s %-5c %-20s %-15s %-4d %-20s %-15s\n",
				m.getMemberId(), m.getMemberPwd(), m.getMemberName(),
				m.getGender(), m.getEmail(), m.getPhone(),
				m.getAge(), m.getAddress(), m.getEnrollDate());
		}
	}
	
	// 3_3. 검색 조건 선택용 View
	public int selectCondition() {
		
		int sel = 0;
		do {
		System.out.println("1. 성별 조회");
		System.out.println("2. 특정 단어가 포함된 아이디 조회");
		System.out.println("3. 특정 지명이 포함된 주소 조회");
		System.out.println("0. 메인 메뉴로 돌아가기");
		System.out.print("검색 조건 선택 --> ");
		
		sel = sc.nextInt();
		sc.nextLine();
		
		switch(sel) {
		case 1 : case 2 : case 3 : case 0: return sel;
		// Controller 로 sel 값 전달한뒤 각 case 에 따른 기능 구현
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
		}
	}while(true);
		
	}
	
	// 3_6_1. 성별 입력용 View 
	public char inputGender() {
		char gender = ' ';
		
		while(true) {
			System.out.print("성별 입력 (M/F) : ");
			gender = sc.nextLine().toUpperCase().charAt(0);
			
			if(gender == 'M' || gender == 'F') break;
			else System.out.println("M 또는 F 만 입력해주세요.");
		}
		return gender;
		
	}
	// 3_6_2. 아이디에 포함된 단어 입력용 View 
	public String inputMemberId() {
		System.out.print("조회 하고자 하는 아이디에 포함된 단어 입력 : ");
		String id = sc.nextLine();
		return id;
	}
	
	// 3_6_3. 주소에 포함된 지명 입력용 View 
	public String inputAddress() {
		System.out.print("조회 하고자 하는 주소에 포함된 지명 입력 : ");
		String addr = sc.nextLine();
		return addr;
		
	}
	
}
