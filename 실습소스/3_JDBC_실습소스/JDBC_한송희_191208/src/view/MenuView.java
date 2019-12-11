package view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.MemberController;
import controller.MenuController;
import model.vo.Member;
import model.vo.Menu;
import model.vo.OrderFood;


public class MenuView {
	
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		MemberController mController = new MemberController();
		MenuController nComtroller = new MenuController();
		
		int sel = 0;
		
		do {
			if(MemberController.loginUser == null) {
				System.out.printf("%60s","============================================================\n");
				System.out.printf("%60s\n","김밥 0 번가");
				System.out.printf("%35s\n","┌ @)))))))))))) ┐");
				System.out.printf("%35s\n","└───────────────┘");
				System.out.printf("%60s","============================================================\n");
				System.out.printf("%15s","1. 로그인");
				System.out.printf("%15s","2. 회원가입");
				System.out.printf("%15s\n","0. 프로그램 종료");
				System.out.print("[ 입력  ] : ");
				sel = sc.nextInt();
				sc.nextLine();
				
				switch(sel) {
				case 1: mController.login(); break;
				case 2: mController.joinUs(sel); break;
				case 0: System.out.println("프로그램을 종료합니다"); break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}

			}else {
				System.out.printf("%40s","\n ┌──────────── 메\t뉴 ────────────┐ \n\n");
				System.out.printf("\t%-20s","  1. 국    / 탕   류    \n");
				System.out.printf("\t%-20s","  2. 분   식   류    \n");
				System.out.printf("\t%-20s","  3. 김   밥   류    \n");
				System.out.printf("%40s","\n └────────────────────────────────────┘ \n");
				System.out.printf(" - 4. 계산하기\n");
				System.out.printf(" - 9. 로그아웃\n");
				System.out.print("[ 입력  ] : ");
				sel = sc.nextInt();
				sc.nextLine();
				
				
				switch(sel){
				case 1 : case 2 : case 3 : nComtroller.selectMenu(sel); break;		
				case 4 : nComtroller.orderList(); return;
				case 9: {
					System.out.println("로그아웃 하겠습니다. ");
					MemberController.loginUser=null;
					break;
				}
				default : System.out.println("잘못 입력하셨습니다. 메뉴를 다시 입력해주세요");
				}
			}
			
		}while(sel != 0);
		
	}
	
	public int displaySubMenu(Map<Integer,Menu> menu, String menuTitle) {
		int i = 1;
		int select = 0;
		
		System.out.println("\n ─────────────────── "+ menuTitle +" ─────────────────── \n");
		
		Iterator<Integer> keys = menu.keySet().iterator();
		while (keys.hasNext()) {
			Integer key = keys.next();
			System.out.println("\t"+i +". " + menu.get(key).getMenuTitle()
					+ "\t가격 : "+ menu.get(key).getMenuPrice()
					+ "\t남은 수량 : " + menu.get(key).getMenuQuantity());
			i++;
		}
		System.out.println("\t0. 뒤로가기");
		System.out.print("\n [ 메뉴 번호 입력 ] : ");
		select = sc.nextInt();
		sc.nextLine();
		
		return select;
	}

	
		
	public Member inputEmailPassword() {
		System.out.println("\n[ 로그인  ]");
		System.out.print("E-MAIL : ");
		String email = sc.nextLine();
		
		System.out.print("PASSWORD : ");
		String password = sc.nextLine();
		
		return new Member(email, password);
	}

	public void displayLoginSuccess() {
		System.out.println("\n" + MemberController.loginUser.getName() + "님, 환영합니다!\n");
	}

	public void displayLoginFail() {
		System.out.println("아이디 또는 비밀번호를 확인해주세요");
	}

	public void displayError(String msg, Exception e) {
		System.out.println("서비스 에러 : " + msg);
		e.printStackTrace();
		
	}

	public Member joinMemberView() {
		System.out.println("\n[ 회원가입 정보 입력 ] ");
		System.out.print("EMAIL : ");
		String email = sc.nextLine();
		
		System.out.print("PASSWORD : ");
		String password = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("KH 학생 입니까?(Y/N) : ");
		char khYN = sc.next().charAt(0);
		sc.nextLine();
		
		return new Member(email, password, name, khYN);
	}

	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : " + msg);
	}
	
	public void displayFail(String msg) {
		System.out.println("서비스 요청 실패 : " + msg);
	}

	public char displayreceipt(List<OrderFood> oList) {
		int hap = 0;
		System.out.println("┌────────────── 영수증  ──────────────┐");
		System.out.println("상품명\t"+"수량\t"+"가격");
		if(!oList.isEmpty()) {
			for(OrderFood or : oList) { 
				System.out.printf("%10s\t%3d\t%10d\n",or.getMenuName(),or.getQuantity(), or.getPrice());
				hap+= or.getPrice();
			}
			System.out.println("────────────────────────────────────");
			System.out.printf("\t\t\t총" + hap + "원\n");
		}else {
			System.out.println("주문하신 메뉴가 없습니다.");
		}
		System.out.print("메인으로 돌아가시겠습니까?(Y/N: 영수증 재출력) : ");
		char yn = sc.nextLine().toUpperCase().charAt(0);
		return yn;
	}

	public int dispalyQuantity(int quantity) {
		System.out.print("주문 수량 : ");
		int quan = sc.nextInt();
		sc.nextLine();
		
		return quan;
	}


}