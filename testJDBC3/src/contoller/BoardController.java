package contoller;

import java.util.List;

import model.service.BoardService;
import model.vo.Board;
import model.vo.Member;
import view.BoardView;

/**
 * 게시판 프로그램 Controller
 * @author HanSongHee
 */
public class BoardController {
	
	private BoardService bService = new BoardService();
	private BoardView view = new BoardView();
	
	// 로그인 정보를 유지할 Member 참조 변수 선언(Session 역할)
	public static Member loginMember = null;
	
	/**
	 * 회원 로그인
	 */
	public void login() {
		
		// id, pwd 입력
		Member inputLogin = view.inputLogin();
		
		try {
			//있으면 값있고 , 없으면 null
			loginMember = bService.login(inputLogin);
			 
			 if(loginMember != null) {
				 view.displayLoginSuccess();
			 }else {
				 view.displayLoginFail();
			 }
		}catch(Exception e) {
			view.displayError("로그인 과정 중 오류 발생", e);
		}
	}
	
	public void selectAll() {
		
		try {
			List<Board> bList = bService.selectAll();
			
			if(!bList.isEmpty()) {
				view.selectAll(bList);
			}else {
				view.displaySuccess("조회 결과가 없습니다.");
			}
			
		}catch(Exception e) {
			view.displayError("게시글 목록 조회 과정 중 오류 발생", e);
		}
	}
	public void selectBoard() {
		
		
		try {
			
			int selMenu = view.inputBoard();
			
			Board board = bService.selectBoard(selMenu);
			
			if(board != null) {
				view.selectBoard(board);
			}else {
				view.displaySuccess("조회 결과가 없습니다.");
			}
			
		}catch(Exception e) {
			view.displayError("게시글 조회 과정 중 오류 발생", e);
		}
	}

	public void insertBoard() {
		
		// 글 입력 View 
		// 제목, 글 내용
		Board board = view.insertBoard();
		
		try {
			int result = bService.insertBoard(board);
			
			if(result > 0 ) {
				view.displaySuccess("게시글이 등록되었습니다.");
			}else {
				view.displayFail("게시글 등록이 실패하였습니다.");
			}
			
		}catch(Exception e) {
			view.displayError("게시글 등록 과정 중 오류 발생", e);
		}
		
	}
public void updateBoard() {
		
		// 글 입력 View 
		// 제목, 글 내용
		int sel = view.inputBoard(); // 글번호
		
		try {	

			
			
			int result = 0;
			
			// 로그인한 아이디와  게시글 번호에 해당하는 행의 아이디가져와서 비교 
				
				
				int selMenu = view.inputSubUpdate(); // 제목/ 내용 수정 선택 메뉴 번호 반환
				
				
				String memberId = bService.selectBoard2(sel);
				
				while(true) {
				if (BoardController.loginMember.getMemberId().equals(memberId)) {
					
				
				switch(selMenu) {
				
				case 1 : {
						String inputTitle =  view.inputTitle();
						result = bService.updateTitle(inputTitle,memberId,sel); break;
					}

				case 2 : {
					Board board = view.inputContent();
					result = bService.updateContent(board ,memberId,sel); break;
				}
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
					
					}
				break;
				}		
			
			if(result > 0 ) {
				view.displaySuccess("게시글이 등록되었습니다.");
			}else {
				view.displayFail("게시글 등록이 실패하였습니다.");
			}
			}
		}// try end
		catch(Exception e) {
			view.displayError("게시글 등록 과정 중 오류 발생", e);
		}
		
	}
}
