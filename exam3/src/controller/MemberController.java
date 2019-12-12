package controller;

import java.util.List;

import model.service.MemberService;
import model.vo.Crt;
import model.vo.Member;
import view.MemberView;

public class MemberController {

	private MemberView view = new MemberView();
	private MemberService mService = new MemberService();
	public static Member LoginMember = null;
	
	/**
	 * 회원가입
	 */
	public void insertMember() {
		Member member = view.insertMember();
		
		try {
			int result = mService.insertMember(member);
			
			if(result > 0) {
				view.displaySuccess(result + "계정이추가됨");
			} else {
				view.displayFail("계정추가실패");
			}
		} catch (Exception e) {
			view.displayError("데이터 삽입과정중 오류", e);
			
		}
	}

	/**
	 * 회원로그인
	 */
	public void login() {
		
		Member inputLogin = view.inputLogin();
		
		try {
			
			LoginMember = mService.login(inputLogin);
			
			if(LoginMember != null) {
				view.displaySuccess("로그인 성공");
			} else {
				view.displayFail("로그인 실패");
			}
		} catch (Exception e) {
			view.displayError("로그인중 에러발생", e);
		}
	}

	/**
	 * 계정정보수정
	 */
	public void updateMember() {
		
		String inputPw = view.inputPw();
		
		if(!LoginMember.getMemberPwd().equals(inputPw)) {
			view.displayFail("비밀번호가다릅니다, 넌누구?");
			return;
		}
		Member member = view.updateMember();
		try {
			int result = mService.updateMember(member);
			if(result > 0) {
				view.displaySuccess("정보수정성공!");
			} else {
				view.displayFail("정보수정실패!");
			}
		} catch (Exception e) {
			view.displayError("수정중 에러", e);
		}
		
		
	}

	/**
	 * 계정정보조회
	 */
	public void selectMember() {
		
		String inputPw = view.inputPw();
		
		if(!LoginMember.getMemberPwd().equals(inputPw)) {
			view.displayFail("비밀번호가다릅니다, 넌누구?");
			return;
		}
		try {
			Member member = mService.selectMember();
			if(member != null) {
				view.displaySuccess("계정정보조회성공");
				view.selectMember(member);
			} else {
				view.displayFail("계정정보가없수다");
			}
			
		} catch (Exception e) {
			view.displayError("조회중 에러", e);
		}
		
		
		
	}

	/**
	 * 케릭터 생성
	 */
	public void insertCrt() {
		Crt crt = view.insertCrt();
		
		try {
			int result = mService.insertCrt(crt);
			if(result > 0) {
				view.displaySuccess("케릭터생성성공");
			} else {
				view.displayFail("캐릭터생성실패");
			}
		} catch (Exception e) {
			view.displayError("생성과정중에러", e);
		} 
		
	}

	public void selectAll() {
		
		
		try {
			List<Crt> cList = mService.selectAll();
			
			if(!cList.isEmpty()) {
				view.selectAll(cList);
			} else {
				view.displayFail("조회결과 없음");
			}
		} catch (Exception e) {
			view.displayError("전체케릭터조회중오류", e);
		}
	}

	public void selectCrt() {
		
		try {
			List<Crt> cList = mService.selectCrt();
			
			if(!cList.isEmpty()) {
				view.selectAll(cList);
			} else {
				view.displayFail("조회결과 없음");
			}
		} catch (Exception e) {
			view.displayError("내케릭터조회중오류", e);
		}
		
	}

	public void deleteCrt() {
		
		String delName = view.delName();
		char check = view.delCheck();
		if(check=='N') return;
		try {
			
			int result = mService.deleteCrt(delName);
			if(result>0) {
				view.displaySuccess("삭제완료");
			} else {
				view.displayFail("니꺼 아니걸랑?아님 없거나?");
			}
		} catch (Exception e) {
			view.displayError("삭제중 오류", e);
		}
	}

	public void gameOver() {
		mService.gameOver();
		
	}


	
}
