package controller;


import model.service.MemberService;
import model.vo.Member;
import view.MenuView;

public class MemberController {
	private MenuView view = new MenuView();
	private MemberService mService = new MemberService();
	
	public static Member loginUser = null;

	public void login() {
		Member member = view.inputEmailPassword();
		
		try {
			member = mService.login(member);
			
			if(member != null) {
				loginUser = member;
				view.displayLoginSuccess();
			}else {
				view.displayLoginFail();
			}
			
		}catch(Exception e) {
			view.displayError("로그인 과정 중 오류 발생", e);
		}

	}

	public void joinUs(int sel) {
		Member member = view.joinMemberView();
		
		try {
			String checkEmail = mService.checkEmail(member.getEmail());
			if(checkEmail != null) {
				view.displaySuccess("사용중인 이메일 입니다. 다른 이메일을 입력해주세요.");
				return;
			}
						
			int result = mService.memberUpdate(member, sel);
			
			if(result > 0) {
				view.displaySuccess("회원가입에 성공하였습니다!");
			}else {
				view.displayFail("회원가입에 실패하였습니다.");
			}
			
		}catch(Exception e) {
			view.displayError("회원가입 과정 중 오류 발생", e);
		}
		
	}



}