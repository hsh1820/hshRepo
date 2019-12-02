package controller;

import java.sql.Connection;
import java.util.ArrayList;

import model.dao.EmpDAO;
import model.vo.EMP;
import view.EmpView;

public class EmpController {
	// View에서 전달받은 데이터를 가공처리(데이터 변환, 디코딩) 진행 후
	// DAO로 전달하는 역할
	
	// DAO로 부터 전달받은 결과에 따라 View(출력화면)을 결정하여
	// 인코딩 후 알맞은 View로 전달.
	
	// DB 처리 결과에 따른 View 출력을 위한 EmpView 객체 생성
	private EmpView view = new EmpView();
	// 서브메뉴, 성공, 실패(오류) 화면을 출력하는 역할.
	
	// 1. 전체 사원 정보 조회
	public void selectAll() {
		
		// 1_1. View의 요청을 DB에 전달하고 결과를 반환 받을
		//      EmpDAO 객체 생성
		EmpDAO empDAO = new EmpDAO();
		
		// 1_2. DBMS 접속 및 전체 사원 정보를 조회하고
		//	     그 결과를 반환할 메소드인
		//     EmpDAO.selectAll() 메소드 작성
		
		// 1_7. DB 접속 확인을 위하여 EmpDAO.selectAll() 메소드 호출
		ArrayList<EMP> empList = empDAO.selectAll();
		// + 메인메뉴 case 1에 controller.selectAll() 호출 작성
		
		
		// 1_13. 조회 결과에 따라 보여줄 View 지정
		// 1) 반환된 empList에 저장된 데이터가 있을 경우
		//    -> 조회 결과를 모두 출력하는 View 메소드 호출
		
		// 2) empList가 비어있거나 조회 실패한 경우
		//    -> 조회 결과가 없다는 메세지를 출력할 View 메소드 호출
		
		if( empList != null && !empList.isEmpty() ) {
			// 1_14. 전체 조회 결과를 출력할 View 작성하기
			//  -> EmpView.selectAll() 메소드 작성
			
			// 1_16. 전체 사원 정보를 출력하는 View 호출
			view.selectAll(empList);
		} else {
			// 조회 결과가 없는 경우
			
			// 1_17. 조회 뿐만 아니라 DB처리 작업이 결과 값이 없거나
			// 예외가 발생하는 경우
			// 문제 내용을 출력해줄 별도의 View 작성
			// -> EmpView.displayError() 메소드 작성
			
			// 1_19. 조회 결과가 없을 경우 메세지를 출력하는 View 호출
			view.displayError("조회 결과가 없습니다.");
		}
		
	}
	
	
	// 2. 사번으로 사원 정보 조회
	public void selectEmp() {
		
		// 2_1. EmpDAO 객체 생성
		EmpDAO empDAO = new EmpDAO();
		
		// 2_2. 사번을 입력받는 View 생성
		// --> EmpView.selectEmpNo() 메소드 작성
		
		// 2_4. 사번 입력 View를 호출하여 조회할 사번을 입력받고
		//      그 값을 반환받아 저장.
		int empNo = view.selectEmpNo();
		
		// 2_5. 입력된 사번을 매개변수로 전달하여 
		//      해당 사번을 가진 사원의 정보를 조회하는
		//      EmpDAO.selectEmp(empNo) 작성
		
		// 2_13. DB에서 조회된 사원 정보를 저장
		EMP emp = empDAO.selectEmp(empNo);
		
		// 2_14. 조회 결과 유무에 따라서 View 연결 지정
		if(emp != null) { // 조회 결과가 있을 경우
			// 2_15. 사원 한 명의 정보를 출력하는 View
			// EmpView.selectEmp() 작성
			
			// 2_17. EmpView.selectEmp() 호출
			view.selectEmp(emp);
			// 메인 메뉴 case 2에서 EmpController.selectEmp();
		
		}else { // 조회 결과가 없을 경우
			// 2_18. displayError() 메소드에
			// "해당 사번의 검색 결과가 없습니다." 메세지 전달하여 출력
			view.displayError("해당 사번의 검색 결과가 없습니다.");
		}
		
	}


	
	
	
	
	
	// 6. 일정 범위 내 급여를 받는 사원 정보 조회
	public void salRange() {
		
		EmpDAO empDAO = new EmpDAO();
		
		int[] range = view.inputRange();
		
		ArrayList<EMP> empList = empDAO.salRange(range);
		
		if(!empList.isEmpty()) { 
			view.selectAll(empList);
		} else { 
			view.displayError("조회 결과가 없습니다.");
		}	
	}
	
	
	// 3. 새로운 사원 정보 추가
	public void insertEmp() {
		
		// 3_1. EmpDAO 객체 생성
		EmpDAO empDao = new EmpDAO();
		
		// 3_2. 사원 정보를 입력받을 수 있는 View 작성
		// -> EmpView.insertEmp() 메소드 작성
		
		// 3_4. 사원 정보 입력 View를 호출하고 반환값 저장
		EMP emp = view.insertEmp(); // 주소에대한 얕은 복사
		
		// 3_5. 입력받은 사원 정보를 DB에 삽입하기 위한 
		// EmpDAO.insertEmp(emp) 메소드 작성
		
		// 3_15. 사원 정보 삽입 후 결과를 반환
		int result = empDao.insertEmp(emp);
		
		// 3_16. 삽입 결과에 따른 View 연결 처리
		if(result > 0) { // 삽입 성공 시 
			// 3_17. DML 성공 시 메세지를 출력할 View 작성
			// -> EmpView.displaySuccess() 메소드 작성
			
			// 3_19. 성공 메세지 출력을 위한 View 호출
			view.displaySuccess(result + "개의 행이 삽입되었습니다.");
		}else { // 삽입 실패시 
			view.displayError("데이터 삽입과정 중 오류 발생");
		}
		
		
	}
	
	// 4. 사번으로 사원 정보 수정
	public void updateEmp() {
		// controller에 메소드 생성되면 DB필요시 empDAO 객체 생성
		// 4_1. EmpDAO 객체 생성
		EmpDAO empDAO = new EmpDAO();
		
		// 4_2. 사번을 입력받는 View 호출
		int empNo = view.selectEmpNo();
		
		// 4_3. 사원 정보 수정 내용을 입력할 View 작성
		// -> EmpView.updateEmp() 메소드 작성
		
		// 4_5. 사원 정보 수정 내용 입력 View 호출 후
		// 		반환 받은 내용 저장
		EMP emp = view.updateEmp();
		
		// 4_6. 입력받은 사번을 emp 객체에 저장
		emp.setEmpNo(empNo);
		
		// 4_7. 입력받은 사번과 일치하는 사원의 정보를
		// 		DB에서 찾아 수정한 후 결과를 반환하는 메소드
		// 		EmpDAO.updateEmp(emp) 메소드 작성
		
		// 4_18. DB 수정 결과를 반환 받아 저장
		int result = empDAO.updateEmp(emp);
		
		// 4_19. 수정 결과에 따른 View 연결 처리
		if(result > 0) {
			view.displaySuccess(result + "개의 행이 수정되었습니다.");
			
		}else {
			view.displayError("데이터 수정 과정 중 오류 발생");
		}
	}
	
	// 5. 사번으로 사원정보 삭제
	public void deleteEmp() {
		// 5_1. EmpDAO 객체 생성
		EmpDAO empDAO = new EmpDAO ();
		
		// 5_2. 사번 입력 View 호출
		int empNo = view.selectEmpNo();
		
		// 5_3. 사원 정보를 정말로 삭제할 것인지 확인하는
		//		EmpView.deleteEmp() 메소드 작성
		
		// 5_4. 입력받은 check 저장
		char check = Character.toUpperCase(view.deleteEmp()) ;
		// 전달받은 값을 대문자로 변경
		
		// 5_6. check 값에 따라서 DAO 또는 메인메뉴로 갈지 처리
		if(check == 'Y') {

			// 5_7. 입력받은 사번과 일치하는 사원 정보를 
			// 		DB에서 삭제하는
			//		EmpDAO.deleteEmp(empNo) 메소드 작성
			
			// 5_18. DB 삭제 결과를 저장
			int result = empDAO.deleteEmp(empNo);
			
			// 5_19. 삭제 결과에 따른 View 연결 처리
			if (result > 0 ) {
				view.displaySuccess(result + "개 행이 삭제되었습니다.");
			}else {
				view.displayError("데이터 삭제 과정 중 오류 발생");
			}
			
		}else if(check == 'N') {
			view.displaySuccess("사원 정보 삭제 취소");
			
		}else {
			view.displayError("잘못 입력하셨습니다. 다시 삭제를 실행해 주세요.");
			
		}
		
		
	}

	
	
	
	
}
