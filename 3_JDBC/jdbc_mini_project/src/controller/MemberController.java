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

//	public void updateUser() {
//		String checkPwd = view.inputStr("현재 비밀번호 : ");
//		
//		try {
//			if(!checkPwd.equals(loginUser.getPwd())) {
//				view.displayFail("현재비밀번호와 일치하지 않습니다.");
//				return;
//			}
//			
//			String newPwd = view.inputStr("비밀번호 입력 : ");
//			String newCheckPwd = view.inputStr("재입력 : ");
//			
//			if(!newPwd.equals(newCheckPwd)) {
//				view.displayFail("두 비밀번호가 일치하지 않습니다.");
//				return;
//			}
//			
//			int result = uService.updateUser(newPwd);
//			
//			if(result > 0) {
//				view.displaySuccess("회원정보가 수정되었습니다.");
//			}else {
//				view.displayFail("회원정보 수정에 실패하였습니다.");
//			}
//			
//		}catch(Exception e) {
//			view.displayError("회원정보 수정중 오류 발생", e);
//		}
//		
//	}
//
//	public void unsigned() {
//		try {
//			String randStr = uService.randomStr();
//			
//			String checkStr = view.inputStr("다음과 똑같은 문자열을 입력하세요.\n[ " + randStr + " ]\n입력 : ");
//			
//			if(!checkStr.equals(randStr)) {
//				view.displayFail("같지 않은 문자열입니다.");
//				return;
//			}
//			
//			int result = uService.unsigned();
//			
//			if(result > 0) {
//				view.displaySuccess("회원탈퇴 되었습니다.");
//				loginUser = null;
//			}else {
//				view.displayFail("회원탈퇴에 실패하였습니다.");
//			}
//			
//		}catch(Exception e) {
//			view.displayError("회원탈퇴중 오류 발생", e);
//		}
//		
//	}
//
//	public void selectAll() {
//		try {
//			List<User> userList = uService.selectAll();
//			
//			if(!userList.isEmpty()) {
//				view.displayUserList(userList);
//			}else {
//				view.displayFail("조회 결과가 없습니다.");
//			}
//			
//		}catch(Exception e) {
//			view.displayError("책 목록 조회중 오류 발생", e);
//		}
//		
//	}
//
//	public void deleteUser() {
//		String deleteId = view.inputStr("삭제할 아이디 입력 : ");
//		
//		try {
//			char check = uService.checkOut(deleteId);
//			if(check == 'N') {
//				view.displayFail("탈퇴여부가 'Y'가 아니거나 없는 아이디입니다.");
//				return;
//			}
//			
//			int result = uService.deleteUser(deleteId);
//			
//			if(result > 0) {
//				view.displaySuccess(deleteId + "계정을 삭제하였습니다.");
//			}else {
//				view.displayFail("삭제에 실패하였습니다.");
//			}
//			
//		}catch(Exception e) {
//			view.displayError("아이디 삭제중 오류 발생", e);
//		}
//		
//	}

}