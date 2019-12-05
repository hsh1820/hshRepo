package model.service;

// static import 작성
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import model.dao.MemberDAO;
import model.vo.Member;

// 프로젝트 생성시 마다 가져다 쓸수 있음.

public class MemberService {
	/* Service 클래스는 데이터에 대한 비즈니스 로직(가공(데이터)
	 * : 요청에대한 응답을 하기위한 모든 업무 과정들/업무수행에 필요한 모든 것들) 수행 및
	 * DB와의 연결 정보를 가지고 있는 Connection 객체를 생성하고,
	 * 여러 DAO를 호출하여 하나의 요청에대한 
	 * 여러번의 DB 접근/갱신을 진행하며 
	 * 그것을 하나의 트랜잭션으로 묶어 처리하는 클래스.  
	 * */
	
	
	/* Service 클래스에서 메소드 작성하는 방법
	 * 1) Controller 에서 데이터를 전달 받음(매개변수)
	 * 2) Connection 객체 생성
	 * 3) DAO 객체 생성
	 * 4) Connection 객체와 Controller에서 전달 받은 데이터를
	 * 	    알맞은 DAO 메소드로 전달(호출)
	 * 5) DAO 수행 결과를 가지고 필요시 
	 *    데이터 가공 및 트랜잭션 처리 진
	 * */
	
	// 1_6. 새로운 회원 정보 추가용 Service
	// 매개변수로 Controller 로 부터 데이터를 전달 받음
	
	
	/**
	 * 새로운 회원 정보 추가용 Service
	 * @param member : Member
	 * @return result : int
	 * @throws Exception 
	 */
	public int insertMember(Member member) throws Exception{

		// 1_7. DB 연결을 위한 Connection객체 생성 구문의
		// 		중복되는 코드를 JDBCTemplate 에 작성
		
		// 1_8. Connection 객체 생성(얻어오기)
		// Connection conn = JDBCTemplate.getConnection();
		
		// * static import 사용
		//   -> static으로 된 필드 또는 메소드를 한 클래스에서 지속적으로 
		// 	    호출해야되는 경우, 
		//    해당 static 호출에 필요한 클래스 명을 생략할 수 있게 해주는 기능
		Connection conn = getConnection();
	

		// 1_9. DBMS 에 접속하여 데이터를 전송하고 
		// 		결과값을 전달 받을 
		//		MemberDAO 객체 생성 및 클래스 작성
		MemberDAO memberDAO = new MemberDAO();
		// MemberDAO의 기본생성자 내부에 쿼리문을 동적으로 수행할 
		// 기능을 구현한 뒤 발생하는 예외들을 throws 했기 때문에 
		// MemberDAo 객체를 생성한 곳에서 예외처리 해야함
		
		// 1_13. 새로운 회원 정보 삽입을 위한
		// 		 MemberDAO.insertMember(conn, member) 작성
		
		// 1_23. 매개변수로 Connection 객체와
		//		 Controller에서 전달받은 값을 DAO로 전달하고
		//  	 회원 정보 삽입 결과를 반환받아 저장
		int result = memberDAO.insertMember(conn, member);
		
		// 1_24. DB 처리 결과에 따라 트랜잭션 처리
		if(result > 0) { // 삽입 성공 시
			commit(conn);
		}else { // 삽입 실패 시 
			rollback(conn);
		}
		
		// 1_25. DB 처리 결과를 Controller로 반환
		return result;
	}
	
	// 2_2. 전체 회원 정보 조회용 Service
	public List<Member> selectAll() throws Exception{
		
		// 2_3. JDBCTemplate 에서 Connection 객체를 얻어옴.
		Connection conn = getConnection();
		
		// 2_4. MemberDAO 객체 생성
		MemberDAO memberDAO  = new MemberDAO();
		
		// 2_5. Connection객체를 전달받아
		//		모든 회원 정보를 조회하고 반환 할 메소드 
		//		MemberDAO.selectAll(conn) 작성
		
		// 2_16. memberDAO.setlectAll(conn) 호출 후 반환 값 저장
		List<Member> mList = memberDAO.selectAll(conn);
		
		// 2_17. 별도의 트랜잭션 처리가 필요하지 않으므로 
		//		 바로 Controller 로 반환
		return mList;
	}
	
	// 3_8. 입력받은 성별의 회원 정보만 조회용 Service  
	public List<Member> selectGender(char gender) throws Exception{
		
		// 3_9. Connection 객체 얻어오기 + DAO 객체 생성
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		// 3_10. Connection 과 Controller 에서 전달 받은 값을 
		//		 매개변수로 전달 받아 회원 정보를 조회하는 
		//		 MemberDAO.selectGender(conn, gen) 작성
		
		// 3_21. MemberDAO.selectGender(conn,gen) 호출후 반환값 저장
		List<Member> mList = memberDAO.selectGender(conn, gender);
		
		// 3_22. 별도의 트랜잭션 처리 필요 없이 바로 반환
		return mList;
		
	}
	
	public List<Member> selectMemberId(String id) throws Exception{
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		return memberDAO.selectMemberId(conn, id);
	}
	
	public List<Member> selectAddress(String addr) throws Exception{
		Connection conn = getConnection();
		return new MemberDAO().selectAddress(conn, "%"+addr+"%");		
	}
	
	// 4_5. 아이디 존재 여부 확인 Service
	public int checkMember(String memberId) throws Exception{
		
		// 4_6. Connection 얻어오기 + DAO 생성
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		// 4_7. MemberDAO.checkMember(conn, memberid) 메소드 작성
		
		// 4_17. MemberDAO.checkMember(conn, memberId) 호출 후 반환갑 저장
		int check = memberDAO.checkMember(conn, memberId);
		
		// 4_18. 별도의 트랜잭션 처리 없이 반환
		return check;
				
	}
	
	// 4_29. 회원정보 수정용 Service
	public int updateMember(int sel, String memberId, String input) throws Exception{
		
		// 4_30. Connection, DAO 생성
		Connection conn =getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		// 4_31. 선택된 서브메뉴 각각에 대한 DAO 메소드를 만들지 않고
		//		 하나의 DAO로 처리를 하되 
		//		 수행할 SQL구문을 구분해 줄 변수 선언
		String updateQuery = "updateMember"+sel;
		
		// 4_32. MemberDAO.updateMember(
		//				Conn,updateQuery, memberId, input) 작성
		
		// 4_41. MemberDAO.updateMember(
		//				Conn,updateQuery, memberId, input) 호출 후 반환값 저장
		int result = memberDAO.updateMember(conn, updateQuery, memberId, input);
		
		// 4_42. 트랜잭션 처리 
		if(result > 0) commit(conn);
		else rollback(conn) ;
		
		return result;
	}
	public int deleteMember(String memberId) throws Exception{
		
		Connection conn =getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		String deleteMember = "deleteMember";
		
		int result = memberDAO.deleteMember(conn, memberId, deleteMember);
		
		if(result > 0) commit(conn);
		else rollback(conn) ;
		
		return result;
	}
	public String randomString() {
		String  randomString = "";
		int random = 0;
		
		for(int i = 0 ; i<6; ) {
			random = (int)(Math.random() * (('z'+1) - '0')) + '0';
			// random() : 0 이상 1 미만의 소수  
			
			if(random >= 'a' && random <= 'z' || 
					random >= 'A' && random <= 'Z' ||
						random >= '0' && random <= '9'
					) {
				randomString += (char)random;
				i++;
			}
		}
		return  randomString;
	}
	
	// 6_2. Service 에서 자원 반납
	public void exitProgram() {
		close(getConnection());
		// close(conn)아닌 이유 : conn이 자동완선되는 이유는 getConnection()만들때 매개변수 명을 
		// conn으로 해놨기 때문에 자동완성으로 제공되는 것 뿐 
		// 실제 Connection 데이터가 들어있는것은 getConnection() 메소드의 반환 값이기 때문 
		
	}
	
	

}
