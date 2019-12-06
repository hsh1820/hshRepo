package view;

import java.util.List;
import java.util.Scanner;

import controller.BoardController;
import model.vo.Board;
import model.vo.Comment;
import model.vo.Member;

public class BoardView {

	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		BoardController bController = new BoardController();
		
		int sel = 0;
		
		do {
			if(BoardController.loginMember == null ) {
				System.out.println("\n *** 게시판 프로그램 *** \n");
				
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 ==> ");
				sel = sc.nextInt();
				sc.nextLine();
				
				switch(sel) {
				case 1: bController.login(); break;
				case 2: bController.join(); break;
				case 0: System.out.println("프로그램 종료."); break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			
			}else {
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
				
				switch(sel) {
				case 1: System.out.println("로그아웃 되었습니다."); 
						BoardController.loginMember = null; break;
				case 2: bController.selectAll(); break;
				case 3: bController.selectBoard(); break;
				case 4: bController.insertBoard(); break;
				case 5: bController.updateBoard(); break;
				case 6: bController.deleteBoard(); break;
				case 0: System.out.println("프로그램 종료"); break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				
			}
			
		}while(sel != 0);
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
		System.out.println(BoardController.loginMember.getMemberName() + "님 환영합니다.");
	}

	public void displayLoginFail() {
		System.out.println("로그인 정보를 확인해주세요.");
	}

	public void displayError(String msg, Exception e) {
		System.out.println("오류 발생 : " + msg);
		e.printStackTrace();
	}
	
	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공 : " + msg);
	}
	
	public void displayFail(String msg) {
		System.out.println("서비스 요청 실패 : " + msg);
	}
	
	public void selectAll(List<Board> bList) {
		System.out.printf("%-3s %-15s %-10s %-15s\n",
							"BNO", "TITLE", "WRITER", "CREATE_DATE");
		System.out.println("------------------------------------------");
		for(Board b : bList) {
			System.out.printf("%-3d %-15s %-10s %-15s\n",
						b.getbNo(), b.getTitle(), b.getWriter(), b.getCreateDate());
		}
	}	
	
	public int inputBNo() {
		System.out.print("글 번호 입력 : ");
		int no = sc.nextInt();
		sc.nextLine();
		return no;
	}

	public void selectBoard(Board board) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("글번호 : " + board.getbNo());
		System.out.println("제목 : " + board.getTitle());
		System.out.printf("작성자 : %-10s 작성일 %-15s\n",board.getWriter(), board.getCreateDate());
		System.out.println("-------------------------------------------------");
		System.out.println(board.getContent());
		System.out.println("-------------------------------------------------");
	}
	
	
	public Board insertBoard() {
		
		System.out.println("\n 게시글 작성 \n");
		System.out.print("글 제목 : ");
		String title = sc.nextLine();
		
		StringBuffer content = new StringBuffer();
		StringBuffer input = new StringBuffer();
		System.out.println("----- 내용 입력(종료 시 exit 입력) -----");
		while(true) {
			
			input.delete(0, input.capacity());
			input.append(sc.nextLine());
			
			if(input.toString().equals("exit")) break;
			
			content.append(input);
			content.append("\n");
		}
		
		return new Board(title, content.toString()); 
		
	}
	
	public int updateMenu() {
		int sel = 0;
		while(true) {
			System.out.println("1. 제목 수정");
			System.out.println("2. 내용 수정");
			System.out.println("0. 메인 메뉴로 이동");
			System.out.print("번호 선택 : ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1: case 2: case 0: return sel;
			default : System.out.println("잘못 입력하셨습니다 .다시 입력해주세요.");
			}
		}
	}
	
	
	public String updateTitle() {
		System.out.print("수정할 제목 : ");
		return sc.nextLine();
	}
	
	
	public String updateContent() {
		StringBuffer content = new StringBuffer();
		StringBuffer str = new StringBuffer();
		System.out.println("---------- 내용 입력(종료 시 exit 입력) ----------");
		while(true) {
			str.delete(0, str.capacity());
			str.append(sc.nextLine());
			
			if(str.toString().toLowerCase().equals("exit")) break;
			
			content.append(str);
			content.append("\n");
		}
		return content.toString();
	}
	
	public char deleteBoard() {
		
		char check = ' ';
		while(true) {
			System.out.print("정말로 삭제 하시겠습니까?(Y/N) : ");
			check = sc.nextLine().toUpperCase().charAt(0);
			if(check == 'Y' || check == 'N') break;
			else System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
		return check;
	}

	public String randomString(String str) {
		System.out.println("삭제를 원할 시 다음 문자를 똑같이 입력해 주세요.");
		System.out.println("[" +  str + "]");
		System.out.print("입력 : ");
		return sc.nextLine();
	}


	public void commentAll(List<Comment> cList) {
		System.out.printf("%-3s %-15s\t\t%-10s %-3s\n","번호", "댓글 내용", "작성자", "작성일");
		System.out.println("-------------------------------------------------");
		
		for(Comment c : cList) {
		System.out.printf("%-3s %-15s %-10s %-15s\n",
			 c.getcBno() ,c.getContent(), c.getWriter(), c.getCreateDate());
		}
		System.out.println("-------------------------------------------------");
	}


	public int commMenu() {
		while(true) {
		System.out.println("1. 댓글 입력");
		System.out.println("2. 댓글 수정");
		System.out.println("3. 댓글 삭제");
		System.out.println("0. 목록으로");
		System.out.print("메뉴 입력 : ");
		int sel = sc.nextInt();
		sc.nextLine();
		
		switch(sel) {
		case 1: case 2 : case 3: case 0:  return sel;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
		}
	}
}


	public String inputComm() {
		
		
		StringBuffer content = new StringBuffer();
		StringBuffer input = new StringBuffer();
		System.out.println("----- 댓글 내용 입력(종료 시 exit 입력) -----");
		while(true) {
			
			input.delete(0, input.capacity());
			input.append(sc.nextLine());
			
			if(input.toString().equals("exit")) break;
			
			content.append(input);
			content.append("\n");
		}
		
		return content.toString() ; 
		
	}


	public String updateComm() {
		
		StringBuffer content = new StringBuffer();
		StringBuffer input = new StringBuffer();
		System.out.println("----- 댓글 내용 입력(종료 시 exit 입력) -----");
		while(true) {
			
			input.delete(0, input.capacity());
			input.append(sc.nextLine());
			
			if(input.toString().equals("exit")) break;
			
			content.append(input);
			content.append("\n");
		}
		
		return content.toString() ; 
		
		
	}


	public int selectComminput() {
		System.out.print("댓글 번호 입력 : ");
		int no = sc.nextInt();
		sc.nextLine();
		return no;
	}

	
	
}










