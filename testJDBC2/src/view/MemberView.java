package view;

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
			case 1 : break;
			case 2 : break;
			case 3 : break;
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
}
