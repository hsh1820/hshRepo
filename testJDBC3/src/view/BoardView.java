package view;

import java.util.List;
import java.util.Scanner;

import contoller.BoardController;
import model.vo.Board;
import model.vo.Member;

/**
 * @author < (작성자 정보) Han Song Hee 게시판 프로그램 View
 */
public class BoardView {

	private Scanner sc = new Scanner(System.in);

	/**
	 * 게시판 프로그램 메인 메뉴
	 */
	public void mainMenu() {
		BoardController bController = new BoardController();

		int sel = 0;

		do {
			if (BoardController.loginMember == null) {
				// 프로그램 시작 시 로그인 체크
				System.out.println("\n *** 게시판 프로그램 *** \n");

				System.out.println("1. 로그인");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 ==> ");
				sel = sc.nextInt();
				sc.nextLine();

				switch (sel) {
				case 1:
					bController.login();
					break;
				case 0:
					System.out.println("프로그램 종료.");
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력 해주세요.");
				}
			} else {
				System.out.println("1. 로그아웃");
				System.out.println("2. 글 목록 조회");
				System.out.println("3. 게시글 조회(글번호)");
				System.out.println("4. 글 쓰기");
				System.out.println("5. 글 수정");
				System.out.println("6. 글 삭제");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 ==> ");
				sel = sc.nextInt();
				sc.nextLine();

				switch (sel) {
				case 1:
					System.out.println("로그아웃 되었습니다.");
					BoardController.loginMember = null;	break;
				case 2: bController.selectAll(); break;
				case 3:	bController.selectBoard(); break;
				case 4: bController.insertBoard(); break;
				case 5:	bController.updateBoard(); break;
				case 6:	break;
				case 0: System.out.print("프로그램 종료"); break;				
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

				}
			}
		} while (sel != 0);

	}

	public Member inputLogin() {
		Member loginMember = new Member();

		System.out.println("----- 로그인 -----");
		System.out.print("ID : ");
		loginMember.setMemberId(sc.nextLine());

		System.out.print("PW : ");
		loginMember.setMemberPwd(sc.nextLine());

		return loginMember;
	}

	public void displayLoginSuccess() {
		System.out.println(BoardController.loginMember.getMemberName() + "님, 환영합니다.");
	}

	public void displayFail(String msg) {
		System.out.println("서비스 요청 실패  : " + msg);
	}
	
	public void displayError(String msg, Exception e) {
		System.out.println("오류발생 : " + msg);
		e.printStackTrace();
	}

	public void displayLoginFail() {
		System.out.println("로그인 정보를 확인해주세요.");
	}

	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : " + msg);
	}

	public void selectAll(List<Board> bList) {
		System.out.printf("%-3s %-15s %-10s %-15s\n", "BNO", "TITLE", "WRITER", "CREATE_DATE");
		System.out.println("------------------------------------------");
		for (Board b : bList) {
			System.out.printf("%-3d %-15s %-10s %-15s\n", b.getBno(), b.getTitle(), b.getWriter(), b.getCreateDate());
		}
	}
	public int inputBoard() {
		System.out.print("글 번호 선택 : ");
		int selMenu = sc.nextInt();
		return selMenu;
	}

	public void selectBoard(Board board) {
		System.out.println("------------------------------------------");
		System.out.println("제목 : "+ board.getTitle());
		System.out.print("작성자  : " + board.getWriter() + "\t");
		System.out.print("작성일  : " + board.getCreateDate()+"\n");
		System.out.println("------------------------------------------");
		System.out.println(board.getContent());
		System.out.println("------------------------------------------");
	}
	
	public Board insertBoard() {
		
		System.out.println("\n 게시글 작성 \n");
		System.out.print("글 제목 : ");
		String title = sc.nextLine();
		
		// 가변적인 문자열을 받기위해		
		StringBuffer content = new StringBuffer();
		// content = 입력된 모든 내용 저장
		StringBuffer input = new StringBuffer();
		// input = 한번 입력 받은 뒤 내용 지워서 input 재활용
				
		System.out.println("----- 내용 입력 (종료 시 exit 입력) -----");
		while(true) {
			
			input.delete(0, input.capacity());
			// input.capacity() : StringBuffer의 용량
			// delete() : 시작부터 끝미만까지
			
			input.append(sc.nextLine());
					
			if(input.toString().contentEquals("exit")) break;
			
			content.append(input);
			content.append("\n");
		}
		return new Board(title, content.toString());
	}

	public int inputSubUpdate() {
		
		int sel = 0;
		do {
		System.out.println("1. 글 제목 수정");
		System.out.println("2. 글 내용 수정");
		System.out.print("검색 조건 선택 --> ");
		
		sel = sc.nextInt();
		sc.nextLine();
		
		switch(sel) {
		case 1 : case 2 : return sel;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
		}
	}while(true);
		
	}
	
	public String inputTitle() {
		System.out.print("수정할 글 제목 입력 : ");
		return  sc.nextLine(); 
	}
	public Board inputContent() {
		
		StringBuffer content = new StringBuffer();
		StringBuffer input = new StringBuffer();
				
		System.out.println("----- 내용 입력 (종료 시 exit 입력) -----");
		while(true) {
			
			input.delete(0, input.capacity());
			input.append(sc.nextLine());
					
			if(input.toString().contentEquals("exit")) break;
			
			content.append(input);
			content.append("\n");
		}
		return new Board(content.toString());
	}
}
