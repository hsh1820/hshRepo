package com.kh.chap3_map.practice.view;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.chap3_map.controller.MemberController;
import com.kh.chap3_map.model.vo.Member;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	//	사용자가 직접 메인 메뉴를 선택
	//	할 수 있음. 종료 전까지 반복 실
	//	행. 각 메뉴를 누를 시 해당 메소
	//	드로 이동
	public void mainMenu() {
		while(true) {
		System.out.println("========== KH 사이트 ==========");
		System.out.println("=====***** 메인 메뉴 *****=====\n" + 
				"1. 회원가입\n" + 
				"2. 로그인\n" + 
				"3. 같은 이름 회원 찾기\n" + 
				"9. 종료\n");
		System.out.print("메뉴 번호 입력 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		// 메뉴 화면 반복 실행 처리
		// 잘 못 입력 하였을 경우 "잘못 입력하였습니다. 다시 입력해주세요" 출력 후 반복
		
			switch(menu) {
			case 1 : joinMembership();break;
			case 2 : logIn(); memberMenu(); break;
			case 3 : sameName();break;
			case 9 : System.out.print("프로그램 종료.");return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");continue;
			}
		}
	}
	public void memberMenu() {
		while(true) {
		System.out.println("=====***** 회원 메뉴 *****=====\n" + 
				"1. 비밀번호 바꾸기\n" + 
				"2. 이름 바꾸기\n" + 
				"3. 로그아웃\n");
		
		System.out.print("메뉴 번호 입력 : ");
		int submenu = sc.nextInt();
		sc.nextLine();
		
		switch(submenu) {
		case 1 : changePassword();break;
		case 2 : changeName();break;
		case 3 : System.out.println("로그아웃 되었습니다.");mainMenu();return;
		default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");continue;
			}
		}
	}
	public void joinMembership() {
	//		회원가입하기 위해 아이디, 비밀번호, 이름을 받고 비밀번호와 이름은
	//		Member객체에 담고 id와 객체는 MemberController의 joinMembership()로 보냄.
	//		받은 결과에 따라 true면 “성공적으로 회원가입 완료하였습니다.”,
	//		false면 “중복된 아이디입니다. 다시 입력해주세요.” 출력
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			Member m = new Member(password, name);
			
			boolean result = mc.joinMembership(id, m);
			
			if( result == true) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");return;
			}System.out.println("중복된 아이디입니다. 다시 입력해주세요.");continue;
		}
	}
	public void logIn() {
	//		아이디와 비밀번호를 사용자에게 받아 MemberController의 logIn()메소드로 넘겨 줌.
	//		반환 값 있으면 “OOO님, 환영합니다!” 출력 후 로그인 된 화면으로(memberMenu()),
	//		없으면 “틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			String result = mc.login(id, password);
			
			if(result != null) {
				System.out.println(result +"님, 환영합니다!");
				memberMenu();return;
			}System.out.println("틀린 아이디 또는 비밀번호 입니다. 다시 입력해주세요.");continue;
		}
	}
	public void changePassword() {
	//		아이디와 비밀번호, 변경할 비밀번호를 받아 MemberController의
	//		changePassword()로 보냄.
	//		받은 결과 값이 true면 “비밀번호 변경에 성공했습니다.”,
	//		false면 “비밀번호 변경에 실패했습니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("현재 비밀번호 : ");
			String oldPw = sc.nextLine();
			System.out.print("새로운 비밀번호 : ");
			String newPw = sc.nextLine();
			
			boolean result = mc.changePassword(id, oldPw, newPw);
			
			if(result == true) {
				System.out.println("비밀번호 변경에 성공했습니다.");break;
			}else{
				System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");continue;
			}
		}
	}
	public void changeName() {
	//		아이디와 비밀번호를 받아 MemberController의 logIn()으로 넘겨
	//		현재 저장되어 있는 이름을 받고
	//		사용자에게 현재 저장되어 있는 이름을 출력하여 보여줌.
	//		변경할 이름을 받아 MemberController의 chageName()로 id와 함께 넘기고
	//		“이름 변경에 성공하였습니다.” 출력
	//		만일 logIn()로부터 저장되어 있는 이름을 받지 못 했다면
	//		“이름 변경에 실패했습니다. 다시 입력해주세요” 출력 후 반복
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			String name = mc.login(id, password);
			if(name != null) {
				System.out.println("현재 설정된 이름 : "+ name );
				
				System.out.print("변경할 이름  : ");
				String newName = sc.nextLine();
				
				mc.changeName(id, newName);
				break;
			}else {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
				continue;
			}
		}

	}
	public void sameName() {
	//		검색할 이름을 받고 mc의 sameName()메소드로 넘김.
	//		반환 값을 가지고 entrySet()을 이용하여 ‘이름-아이디’ 형식으로 출력
		
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		
		
		for(Map.Entry<String, String> entry : mc.sameName(name).entrySet()) {
			System.out.println("["+entry.getValue()+" - "+entry.getKey()+"]");
		}

	}
}
