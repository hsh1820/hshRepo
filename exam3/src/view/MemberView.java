package view;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import controller.MemberController;
import model.dao.MemberDAO;
import model.vo.Crt;
import model.vo.Member;

/**회원메인메뉴
 * @author Deok
 *
 */
public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 
	 */
	public void mainMenu() {
		
		MemberController mController = new MemberController();
		
		int sel = 0;
		
		do {
			if(MemberController.LoginMember == null) {
				System.out.println(" Welcome ninige");
				System.out.println(" *** 메인 메뉴 *** ");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("0. 프로그램종료");
				
				System.out.print("메뉴 선택 : ");
				sel = sc.nextInt();
				sc.nextLine();
				
				switch(sel) {
				case 1: mController.login(); break;
				case 2: mController.insertMember(); break;
				case 0: System.out.println("바이바이"); break;
				default : System.out.println("잘못 입력. 다시입력해요");
				}
			} else {
				System.out.println("1. 로그아웃");
				System.out.println("2. 계정정보조회");
				System.out.println("3. 계정정보수정");
				System.out.println("4. 캐릭터 생성");
				System.out.println("5. 전체 캐릭터 조회");
				System.out.println("6. 내 캐릭터 조회");
				System.out.println("7. 캐릭터 삭제");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 : ");
				sel = sc.nextInt();
				sc.nextLine();
				
				switch(sel) {
				case 1 : System.out.println("로그아웃되었슴");
				 	MemberController.LoginMember = null; break;
				case 2 : mController.selectMember(); break;
				case 3 : mController.updateMember(); break;
				case 4 : mController.insertCrt(); break;
				case 5 : mController.selectAll(); break;
				case 6 : mController.selectCrt(); break;
				case 7 : mController.deleteCrt(); break;
				case 0 : mController.gameOver(); 
						System.out.println("다음이시간에~");break;
				default : System.out.println("잘못입력 다시입력");
				}
			}
		} while (sel !=0 );
		
	}

	/** 2. 회원가입
	 * @return member : Member
	 */
	public Member insertMember() {
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		Member member = new Member(memberId, memberPwd, memberName, gender, email, age);
		
		return member;
	}

	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : " + msg);
		
	}
	
	public void displayFail(String msg) {
		System.out.println("서비스 요청 실패 : " + msg);
	}
	
	public void displayError(String msg, Exception e) {
		System.out.println("서비스 요청 중 오류 발생 : " + msg);
		e.printStackTrace();
	}

	public Member inputLogin() {
		Member loginMember = new Member();
		System.out.println("--- 로그인 ---");
		System.out.print("계정 : ");
		loginMember.setMemberId(sc.nextLine());
		System.out.print("비밀번호 : ");
		loginMember.setMemberPwd(sc.nextLine());
		
		return loginMember;
	}

	/** 비밀번호 입력
	 * @return String
	 */
	public String inputPw() {
		System.out.println("=== 비밀번호입력 ===");
		System.out.print("비밀번호 : ");
		return sc.nextLine();
	}

	public Member updateMember() {
		System.out.println("=== 수정할 정보 입력 ===");
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		Member member = new Member(memberName, gender, email, age);
		return member;
	}

	/** 회원정보조회
	 * @param member : Member
	 */
	public void selectMember(Member member) {
		System.out.printf("%-10s %-10s %-3s %-15s %-10s %-15s\n",
				"ID", "NAME", "GENDER", "EMAIL", "AGE", "CREATE_DATE");
		System.out.println("------------------------------------------");
		System.out.printf("%-10s %-10s %-3s %-15s %-10d %-15s\n",
					member.getMemberId(), member.getMemberName(), 
					member.getGender(), member.getEmail(),
					member.getAge(), member.getEnrollDate());
	
	}

	public Crt insertCrt() {
		
		System.out.println("---캐릭터 생성 페이지---");
		System.out.print("캐릭터명 : ");
		String crtName = sc.nextLine();
		System.out.print("클래스 (전사/마법사/도적) : ");
		String crtClass = sc.nextLine();
		Crt crt = new Crt(crtName, crtClass);
		return crt;
	}

	public void selectAll(List<Crt> cList) {
		System.out.printf("%-3s %-15s %-10s %-15s\n",
				"NAME", "CLASS", "LEVEL", "MEMBER_ID");
		System.out.println("------------------------------------------");
		for(Crt c : cList) {
			System.out.printf("%-3s %-15s %-10d %-15s\n",
					c.getCrtName(), c.getCrtClass(), c.getCrtLevel(), c.getCrtOwner());
		}

	}

	public String delName() {
		System.out.print("삭제할캐릭터입력 : ");
		return sc.nextLine();
	}
	
	public char delCheck() {
		System.out.print("진짜 지울꺼야? Y/N : ");
		return sc.nextLine().toUpperCase().charAt(0);
	}

}

	

	
	
	
	

