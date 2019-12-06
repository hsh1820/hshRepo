package controller;

import java.util.List;

import model.service.BoardService;
import model.service.MemberService;
import model.vo.Board;
import model.vo.Comment;
import model.vo.Count;
import model.vo.Member;
import view.BoardView;
import view.MemberView;


public class BoardController {
	private BoardService bService = new BoardService();
	private MemberService mService = new MemberService();
	
	private MemberView mView = new MemberView();
	private BoardView view = new BoardView();
	
	public static Member loginMember = null;
	public static Count count = null;
	
	public void login() {
		
		// id, pwd 입력
		Member inputLogin = view.inputLogin();
		
		try {
			loginMember = bService.login(inputLogin);
			
			if(loginMember != null) 
			{
				if(BoardController.loginMember.getMemberId().equals("user01")) {
					view.displayLoginSuccess();
					
				}else {
					view.displayMemberLoginSuccess();
				}
			}else {
				view.displayLoginFail();
			}
		}catch(Exception e) {
			view.displayError("로그인 과정 중 오류 발생", e);
		}
	}
	
	
	/**
	 * 게시글 목록 조회
	 */
	public void selectAll() {
		
		try {
			List<Board> bList = bService.selectAll();
			List<Count> cList = bService.CommSelectAll();
			if(!bList.isEmpty()) {
				view.selectAll(bList,cList);
			}else {
				view.displaySuccess("조회 결과가 없습니다.");
			}
		}catch (Exception e) {
			view.displayError("게시글 목록 조회 과정 중 오류 발생", e);
		}
	}
	
	public void selectBoard() {
		
		// 글 번호 입력 View
		int bNo = view.inputBNo();
		Count count = new Count();
		while(true) {
		try {
			Board board = bService.selectBoard(bNo);
			
			if(board != null) {
				
				count.setCount(bService.countBoard(bNo)); 
				bService.updateCount(bNo,count.getCount());
				
					
				view.selectBoard(board,count.getCount());
				
				List<Comment> cList = bService.selectCommAll(bNo);
				
				if(!cList.isEmpty()) {
					view.commentAll(cList);
					int commMenu = view.commMenu();
					

					
					switch(commMenu) {
					case 1: {
						String inputComm = view.inputComm();
						int result = bService.inputComm(bNo,inputComm);
						if(result > 0) {
							view.displaySuccess("댓글이 등록되었습니다.");
							break;
						}else {
							view.displayFail("댓글 등록에 실패하였습니다.");
							break;
						}
						
					}
					case 2: {
						view.selectBoard(board,count.getCount());
						view.commentAll(cList);
						
						int sel = view.selectComminput();
						
						String memberId = bService.selectMemberId(sel);
								
						
						if(BoardController.loginMember.getMemberId().equals(memberId)||
								BoardController.loginMember.getMemberId().equals("user01")) {
							
							
							String updateComm = view.updateComm();
							
							int result = bService.updateComm(sel,updateComm);
							
							if(result > 0) {
								view.displaySuccess("댓글이 수정되었습니다.");
								break;
							}else {
								view.displayFail("댓글 수정에 실패하였습니다.");
								break;
							}
						}else {
							view.displaySuccess("자신이 작성한 댓글만 수정할 수 있습니다.");
						}
					}
					case 3: {
						view.selectBoard(board,count.getCount());
						view.commentAll(cList);
						
						int sel = view.selectComminput();
						
						String memberId = bService.selectMemberId(sel);
								
						if(BoardController.loginMember.getMemberId().equals(memberId)||
								BoardController.loginMember.getMemberId().equals("user01")) {
							int result = bService.deleteComm(sel);
														
							if(result > 0) {
								view.displaySuccess("댓글이 수정되었습니다.");
								break;
							}else {
								view.displayFail("댓글 수정에 실패하였습니다.");
								break;
							}
						}else {
							view.displaySuccess("자신이 작성한 댓글만 수정할 수 있습니다.");
							break;
						}
						
					}
					
					case 0: return; 
						
					}
					
				}else {
					view.displaySuccess("댓글이 존재하지 않습니다.");
				}
				
				break;
					
			}else {
				view.displayFail("해당 글이 존재하지 않습니다.");
				}
				
		
		} catch (Exception e) {
			view.displayError("게시글 목록 조회 과정 중 오류 발생", e);
		}
	}
}
	
	
	public void insertBoard() {
		
		// 글 입력 View
		Board board = view.insertBoard();
		
		try {
			int result = bService.insertBoard(board);
			
			if(result > 0) {
				view.displaySuccess("게시글이 등록되었습니다.");
			}else {
				view.displayFail("게시글 등록이 실패하였습니다.");
			}
		}catch (Exception e) {
			view.displayError("게시글 등록 과정 중 오류 발생", e);
		}
		
		
	}


	public void updateBoard() {
		// 글 번호 입력 View
		int bNo = view.inputBNo();
		
		try {
			if(loginMember.getMemberId()
					.equals(bService.selectWriter(bNo)) ||
					loginMember.getMemberId()
					.equals("user01")){
				
				int sel = view.updateMenu();
				
				String updateStr = null;
				switch(sel) {
				case 1 : updateStr = view.updateTitle();
						 break;
				case 2 : updateStr = view.updateContent();
						 break;
				case 0 : return;
				}
				
				int result = bService.updateBoard(bNo, sel, updateStr);
				
				if(result > 0) {
					view.displaySuccess("게시글이 수정 되었습니다.");
				}else {
					view.displayFail("게시글 수정이 실패하였습니다.");
				}
				
			}else {
				view.displayFail("해당 글을 수정할 수 없습니다.");
			}
		}catch (Exception e) {
			view.displayError("게시글 수정 과정 중 오류 발생", e);
		}
	}
	
	
	public void deleteBoard() {
		
		int bNo = view.inputBNo(); 
		
		try {
			if(loginMember.getMemberId()
					.equals(bService.selectWriter(bNo))||
					loginMember.getMemberId()
					.equals("user01")) {
				
				if(view.deleteBoard() == 'Y') {
					
					// 자동 삭제 방지용 인증 문자 생성 Service 호출
					String str = bService.randomString();
					
					if(!str.equals(view.randomString(str))) {
						view.displayFail("문자열이 일치하지 않습니다");
					}else {
					
						int result = bService.deleteBoard(bNo);
						
						if(result > 0) {
							view.displaySuccess("게시글이 삭제되었습니다.");
						}else {
							view.displayFail("게시글 삭제가 실패하였습니다.");
						}
					}
				}
			}
		}catch (Exception e) {
			view.displayError("게시글 목록 조회 과정 중 오류 발생", e);
		}
	}


	public void join() {
				Member member = mView.insertMember();
				
			
					try {
						int result = mService.insertMember(member);
						if (result > 0) { 
							view.displaySuccess("회원가입이 완료되었습니다.");

						} else {
							view.displayFail("회원가입 실패");
						}

					} catch (Exception e) {
						view.displayError("데이터 삽입 과정 중 오류 발생", e);

					}
				
		
				}
	
	public void adminmainMenu() {
		mView.adminmainMenu();
	}


	public void myInfoEdit() {
		mView.mainMenu();
		
	}
}








