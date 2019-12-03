package controller;

import model.vo.Member;
import service.MemberService;
import view.MemberView;

public class MemberController {
	
	private MemberView view = new MemberView();
	private MemberService mService = new MemberService();
	
	public void insertMember() {
	
		Member member = view.insertMember();
		
		try {
			int result = mService.insertMember(member);
			
			if(result > 0 ) {
				view.displaySuccess(result + "개의 행이 삽입되었습니다.");
			}else {
				view.displayFail("회원 정보 삽입 중 실패 발생");
			}
		} catch(Exception e) {
			view.displayError("회원 정보 삽입 중 예외발생 : ");
			e.printStackTrace();
		}
	}
	

}
