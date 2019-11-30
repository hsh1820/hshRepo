package com.kh.chap3_map.practice.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.chap3_map.practice.controller.MemberController;
import com.kh.chap3_map.practice.model.vo.Member;

public class MemberMenu {
	private  Scanner sc = new Scanner(System.in);
	private MemberController mc 	= new MemberController();
	
	public void mainMenu() {
		//		******* 메인 메뉴 *******
		//		1. 회원가입 // joinMembership() 실행
		//		2. 로그인 // logIn() 실행 후 memberMenu() 실행
		//		3. 같은 이름 회원 찾기 // sameName()
		//		9. 종료 // “프로그램 종료.” 출력 후 main()으로 리턴
		//		메뉴 번호 선택 : >> 입력 받음
		//		// 메뉴 화면 반복 실행 처리
		//		// 잘 못 입력 하였을 경우 "잘못 입력하였습니다. 다시 입력해주세요" 출력 후 반복
		while(true) {
		System.out.println("========== KH 사이트 ==========");
		System.out.println("=====***** 메인 메뉴 *****=====\n" + 
				"1. 회원가입\n" + 
				"2. 로그인\n" + 
				"3. 같은 이름 회원 찾기\n" +
				"4. 회원 주소 오름차순 정렬\n"+
				"9. 종료");
		System.out.print("메뉴 번호 입력 : ");
		int menu = sc.nextInt()	;
		
		sc.nextLine();
		
			switch(menu) {
			case 1 : joinMembership();break;
			case 2 : logIn();break;
			case 3 : sameName();break;
			case 4 : ascAddress();break;
			case 9 : System.out.println("프로그램 종료.");return;		
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");			
			
			}
		}
	}
	public void memberMenu() {
		System.out.println("=====***** 회원 메뉴 *****=====\n" + 
				"1. 비밀번호 바꾸기\n" + 
				"2. 이름 바꾸기\n" + 
				"3. 로그아웃");
		System.out.print("메뉴 번호 입력 : ");
		int submenu = sc.nextInt()	;
		sc.nextLine();
		
		while(true) { 
		switch(submenu) {
		case 1 : {
			changePassword();
			break;
		}
		case 2 : {
			changeName();
			break;
		}
		case 3 : {
			System.out.println("로그아웃 되었습니다");			
			break;
		}
		default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");		
			}
		break;
		}
		
	}
	public void joinMembership() {
	//		회원가입하기 위해 아이디, 비밀번호, 이름을 받고 비밀번호와 이름은
	//		Member객체에 담고 id와 객체는 MemberController의 joinMembership()로 보냄.
	//		받은 결과에 따라 true면 “성공적으로 회원가입 완료하였습니다.”,
	//		false면 “중복된 아이디입니다. 다시 입력해주세요.” 출력
		System.out.print("아이디 : " );
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		Member m = new Member(name, pw, address);
		
		
		if(mc.joinMembership(id,m)) {
			System.out.println("성공적으로 회원가입 완료하였습니다."); 
		}else {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
	}
	public void logIn() {
	//		아이디와 비밀번호를 사용자에게 받아 MemberController의 logIn()메소드로 넘겨 줌.
	//		반환 값 있으면 “OOO님, 환영합니다!” 출력 후 로그인 된 화면으로(memberMenu()),
	//		없으면 “틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
		System.out.print("아이디 : " );
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		String name = mc.logIn(id, pw); 
		
		if (name != null) {
			System.out.println( name + "님, 환영합니다!");
			memberMenu();
			break;
		}else {
			System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			break;
		}
		}
	}
	public void changePassword() {
		//		아이디와 비밀번호, 변경할 비밀번호를 받아 MemberController의
		//		changePassword()로 보냄.
		//		받은 결과 값이 true면 “비밀번호 변경에 성공했습니다.”,
		//		false면 “비밀번호 변경에 실패했습니다. 다시 입력해주세요.” 출력 후 반복
		while(true) {
			System.out.print("아이디 : " );
			String id = sc.nextLine();
			System.out.print("현재 비밀번호 : ");
			String oldPw = sc.nextLine();
			System.out.print("새로운 비밀번호 : ");
			String newPw = sc.nextLine();
			
			boolean result = mc.changePassword(id, oldPw, newPw); 
			
			if (result== true) {
				System.out.println( "비밀번호 변경에 성공했습니다.");
				memberMenu();
				break;
			}else {
				System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");				
				break;
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
			System.out.print("아이디 : " );
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			
			String name = mc.logIn(id, pw); 
			
			if (name != null) {
				System.out.println( "현재 설정된 이름 : " + name );
				
				System.out.print( "변경할 이름 : " );
				String chName = sc.nextLine();
				mc.changeName(id, chName);
				
				System.out.println( "이름 변경에 성공했습니다." );
				break;
			}else {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");				
				break;
			}
			}
		
	}
	public void sameName() {
	//		검색할 이름을 받고 mc의 sameName()메소드로 넘김.
	//		반환 값을 가지고 entrySet()을 이용하여 ‘이름-아이디’ 형식으로 출력
		System.out.print("검색할 이름 : " );
		String name = sc.nextLine();
		Map<String, String> result = mc.sameName(name); // 같은 이름 결과 map으로 반환
		
//			Set<String> keySet = result.keySet(); // 키셋묶음
			
//			Set<Entry<String, String>> entryset = result.entrySet(); // 엔트리셋
//			Iterator<Entry<String, String>> it = entryset.iterator(); // 엔트리셋의 이터레이터
	//		
	//		while(it.hasNext()) { // 이터레이터 출력
	//			Entry<String, String> entry = it.next();
	//			System.out.println("[" + entry.getValue()+" - "+entry.getKey()+"]");
	//		}
//		for(String key: keySet ) {  // 향상된 포문 출력
//			System.out.println("["+ result.get(key)+" - " + key + "]");
//		}
	
	}
	public void ascAddress()	{
		// 화면에 회원들 주소 오름차순 정렬하여 바로 보여주기		
		// [ 아이디 - 주소 ]
		// 아이디를 키로 잡고, 주소를 값으로. 이름은 아이디를 기준으로 접근해서 출력?
		List<Map.Entry<String, Integer>> result = mc.ascAddress(); // 아이디랑 주소는 가져옴
		
//		Set<String> keySet = result.keySet();
//		Iterator<String> it = result.iterator();
////		
//		while(it.hasNext()) {
//			String str = it.next();
//			System.out.println("["+ str + " - "+ result.get(it.next()) +"]");
//		}
//		
//		
//		
//		Iterator<String> it = result.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next()); // 주소값이 있는 list를 가리키는 iterator
//		}// 주소 정렬은 되나 아이디값을 못가져옴
		
		// entryset사용
		
		
		
	}
}
