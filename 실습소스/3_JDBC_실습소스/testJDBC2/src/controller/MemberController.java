package controller;

import java.util.List;

import model.service.MemberService;
import model.vo.Member;
import view.MemberView;

public class MemberController {
	// 중간에서 요청을 받고 반환해주는 것에 대한 방향을 정해주는 역할

	// 동작 중 필요한 서브메뉴, 결과를 반환할 뷰를 호출하기 위한
	// MemberView 객체 선언
	private MemberView view = new MemberView();

	// 1_4. 동작
	private MemberService mService = new MemberService();

	// 1. 새로운 회원 정보 추가
	// 입력받은 회원 정보를 DB로 전달한 후 결과에 따라
	// 알맞은 View에 연결처리하는 메소드

	/**
	 * 새로운 회원 정보 추가 Controller
	 * 
	 */
	public void insertMember() {

		// 1_1. 새로운 회원 정보를 입력받기 위한 서브메뉴
		// MemberView.insertMember() 작성

		// 1_3. 입력받은 회원 정보를 Member타입 변수에 저장
		Member member = view.insertMember();

		// 1_4. MemberService 객체를 필드에 생성
		// Controller 와 DAO 에서 사용

		// 1_5. 회원 정보에대한 비즈니스 로직을 수행한 후
		// DAO 에 전달하고
		// DAO 로 부터 전달받은 값에 따라
		// 트랜잭션 처리를 할
		// MemberService.insertMember(member) 작성

		// 1_26. MemberService.insertMember()를
		// 호출하여 반환값을 저장
		// -> throws Exception 예외처리 할 수 있도록
		// try-catch 구문으로 작성
		try {
			int result = mService.insertMember(member);

			// 1_27. DB 삽입 결과에 따른 View 연결 처리
			if (result > 0) { // 삽입 성공
				// 1_28. DML 구문 처리 성공 시 메세지를 출력할
				// MemberView.displaySuccess() 작성

				// 1_30. 삽입 성공 메세지 출력
				view.displaySuccess(result + "개의 행이 추가되었습니다.");

			} else { // 삽입 실패
				// 1_31. 실패 메세지 출력용 View
				// MemberView.displayFail() 작성

				// 1_33. 삽입 실패 메세지 출력
				view.displayFail("데이터 삽입 실패");
			}

		} catch (Exception e) {
			// 1_34. 예외 메세지 출력용 View
			// MemberView.displayError(msg, e) 작성

			// 1_36. 예외 메세지 출력
			view.displayError("데이터 삽입 과정 중 오류 발생", e);

		}
		// 1_37. 메인 메뉴 case 1에
		// mController.insertMember() 호출 구문 작성
	}

	// 2. 모든 회원 정보 조회
	public void selectAll() {

		// 2_1. MemberService.selectAll() 메소드 작성

		// 2_18. MemberService.selectAll() 메소드 호출하여 반환값 저장
		try {
			List<Member> mList = mService.selectAll();

			// 2_19. 조회 결과에 따라 보여줄 View 연결 처리
			if (!mList.isEmpty()) { // 조회 결과가 있을 경우
				// memberDAO 에서 쿼리문 실행 후
				// list를 생성 했기 때문에
				// 쿼리 문 실행 중 Exception 발생하면
				// memberSerivce 클래스에서 MemberDAO.selectAll() 이
				// null 값이 되기때문에 조건문에 mList.isEmpty()사용

				// 2_20. 모든 회원 정보를 출력할 View
				// MemberView.displayMember(mList) 메소드 작성

				// 2_22. 회원 정보 출력용 View 호출
				view.displayMember(mList);

			} else { // 조회 결과 행의 개수가 0개인 (mList가 비어있는) 경우

				// 2_23. view.displaySuccess() 호출
				view.displaySuccess("조회 결과가 없습니다.");
			}

		} catch (Exception e) {
			// 2_24. MemberView.displayError(msg) 호출
			view.displayError("데이터 조회 과정 중 오류 발생", e);
		}

		// 2_25. MemberView.mainMenu() case 에서
		// MemberController.selectAll() 호출

	}

	// 화면 : [화면1] 3 특정 회원 정보 조회 -> [화면2] 1. 조건
	// [화면3] 2. 조건
	// [화면4] 3. 조건

	// 3. 특정 조건 회원 조회 - 경우 : 1명, 0명, 여러명
	public void selectmember() {

		// 3_1. 조회 결과를 저장할 임시 List 참조 변수 선언
		List<Member> mList = null;

		// 3_2. 검색 조건을 입력받기 위한 서브메뉴 View
		// MemberView.selectCondition() 메소드 작성

		// 3_4. 검색 조건을 입력 받아 저장
		int sel = view.selectCondition();

		// 3_5. 검색 조건에 따라 알맞은 Service를 호출 할 수 있도록
		// switch문 작성
		try { // Controller에서 Exception 처리

			// 3_6. 각 조건에 맞는 값을 입력 받을 View 작성
			// MemberView.inputGender()
			// MemberView.inputMemberId()
			// MemberView.inputAddress()
			switch (sel) { // 1메소드에서 다양한 Service 호출가능
			case 1:
				// 3_7. 입력받은 성별과 Connection 객체를 전달하는
				// MemberService.selectGender(gender) 메소드 작성

				// 3_23. 1번 선택 시 성별을 입력받고, 조회결과를 반환 받아 저장
				mList = mService.selectGender(view.inputGender());
				break;
			case 2:
				mList = mService.selectMemberId(view.inputMemberId());
				break;
			case 3:
				mList = mService.selectAddress(view.inputAddress());
				break;
			case 0:
				// break; 경우 : java.lang.NullPointerException발생
				// --> break 경우 switch밖 아래 코드들이 실행됨
				return;
			}

			// 3_24. 조회 결과에 따라 View 연결 처리
			if (!mList.isEmpty()) { // 조회 결과가 있을 경우

				// 3_25. 2번 기능에서 만들어 둔
				// 회원 정보 출력용 View 호출
				view.displayMember(mList);

			} else { // 조회 결과가 없을 경우
				// 3_26. MemberView.displaySuccess(msg) 호출
				view.displaySuccess("조회 결과가 없습니다.");
			}

		} catch (Exception e) {
			// 3_27. MemberView.displayError(msg,e)호출
			view.displayError("데이터 조회 과정 중 오류 발생 ", e);
		}
		// 3_28. MemberView.mainMenu() 의
		// case 3: 에서 MemberController.selectMember() 호출
	}

	// 4. 회원 정보 수정
	public void updateMember() {

		// 4_1. 정보를 수정할 회원 선택
		// PK로 설정된 memberId를 이용해 회원 선택
		// MemberView.selectMemberId() 작성

		// 4_3. 입력받은 아이디를 저장
		String memberId = view.selectMemberId();

		// 4_4. 입력받은 아이디와 일치하는 회원이 있는지
		// 존재 여부를 확인하는 메소드
		// MemberService.checkmember(memberId) 작성

		// 4_19. MemberService.checkmember(memberId) 호출 후 반환값 저장
		try {
			int check = mService.checkMember(memberId);

			// 4_20. 회원 존재 여부에 따라 처리방법 지정
			if (check < 1) { // 조회결과가 없는 경우
				view.displayFail("존재하지 않는 아이디 입니다.");

			} else { // 조회 결과가 있는 경우

				// 4_21. 수정 내용을 선택할 서브메뉴 작성
				// MemberView.updateMember() 작성

				// 4_23. MemberView.updateMember() 호출 후 반환 값 저장
				int sel = view.updateMember();

				// 4_24. 선택된 서브메뉴가 0번일 경우 메인 메뉴로 돌아가기
				if (sel == 0)
					return;

				// 4_25. 수정할 값을 입력받을 View
				// MemberView.inputUpdate() 작성

				// 4_27. MemberView.inputUpdate() 호출 후 반환값 저장
				String input = view.inputUpdate();

				// 4_28. 입력받은 값들과 Connection 객체를 전달하는
				// MemberService.updateMember(sel,memberId, input) 작성

				// 4_44. MemberService.updateMember(sel,memberId, input)
				// 호출 후 반환 값 저장
				int result = mService.updateMember(sel, memberId, input);

				// 4_45. 수정 결과에 따라 View 연결 처리
				if (result > 0) {
					view.displaySuccess(result + "개의 행이 수정되었습니다.");
				} else {
					view.displayFail("데이터 수정 실패");
				}

			}
		} catch (Exception e) {
			view.displayError("데이터 수정 과정 중 오류 발생 ", e);
		}
	}

	public void deleteMember() {
		
		String memberId = view.selectMemberId();
		try {
			while(true) {
			String random = mService.randomString();
			
			if(random.equals(view.inputRandom(random))) { // 입력된 보안문자
				
			
			////------------------------------------------------
			int check = mService.checkMember(memberId);
			if (check < 1) {
				view.displayFail("존재하지 않는 아이디 입니다.");
			} else {
				char yn = view.deleteMember();
				if (yn == 'N')
					return;
				else {
					int result = mService.deleteMember(memberId);

					if (result > 0) {
						view.displaySuccess(result + "개의 행이 수정되었습니다.");
					} else {
						view.displayFail("데이터 수정 실패");
					}
				} 
			} 
			break;
		}else System.out.println("보안문자를 다시 입력 해주세요.");
			}
		} catch (Exception e) {
			view.displayError("데이터 수정 과정 중 오류 발생 ", e);
		}
		
	}

	// 6. 프로그램 종료
	public void exitProgram() {
		mService.exitProgram();
	}
	
	
}
