package controller;

import model.service.MemberService;
import model.vo.Member;
import view.MemberView;

public class MemberController {
	// 중간에서 요청을 받고 반환해주는 것에 대한 방향을 정해주는 역할

	// 동작 중 필요한 서브메뉴, 결과를 반환할 뷰를 호출하기 위한
	// MemberView 객체 선언
	private MemberView view = new MemberView();
	
	// 1_4. 동작
	private MemberService mService  = new MemberService(); 
	
	// 1. 새로운 회원 정보 추가
	// 입력받은 회원 정보를 DB로 전달한 후 결과에 따라
	// 알맞은 View에 연결처리하는 메소드
	public void insertMember() {
		
		// 1_1. 새로운 회원 정보를 입력받기 위한 서브메뉴
		// MemberView.insertMember() 작성
		
		// 1_3. 입력받은 회원 정보를 Member타입 변수에 저장
		Member member = view.insertMember();
		
		// 1_4. MemberService 객체를 필드에 생성
		// Controller 와 DAO 에서 사용
		
		// 1_5. 회원 정보에대한 비즈니스 로직을 수행한 후
		// 		DAO 에 전달하고 
		//		DAO 로 부터 전달받은 값에 따라 
		//		트랜잭션 처리를 할 
		// 		MemberService.insertMember(member) 작성
		
		
		
	}
	
}
