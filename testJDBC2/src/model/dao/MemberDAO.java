package model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import model.vo.Member;

public class MemberDAO {
	// 1_10. MemberDAO 기본 생성자 코드 작성
	
	/*
	 * DAO 클래스는 SQL구문 실행 후 결과 반환받는 클래스.
	 * 이전 프로젝트에서는 SQL구문을 DAO에 직접 작성.(정적 코딩)
	 * 
	 * 유지보수성의 증가를 위해서 
	 * SQL구문을 별도의 .properties 파일에 작성하여
	 * DAO객체가 생성 되어질 때 마다 
	 * SQL구문을 동적으로 읽어들이는 코드로 작성 (동적 코딩) 
	 *  
	 *  
	 * */
	
	// 1_11. 기본생성자 작성 전에 먼저 SQL 구문이 작성될
	//		 query.properties 생성 후
	//		 Properties 객체 선언
	private Properties prop = null;
	
	// 1_12. 기본 생성자 내부에 
	//		 query.properties 파일을 동적으로 읽어들일 구문 작성
	public MemberDAO() throws Exception {
		// 발생하는 예외를 Controller로 전달하여 예외처리 할 수 있도록
		// throws Exception 작성
		
		prop = new Properties();
		
		prop.load(new FileReader("query.properties"));
		
	}
	
	// 1_14. 새로운 회원 정보 추가 DAO
	// Service에서 생성한 Connection 객체를 전달 받을 예정
	public int insertMember(Connection conn, Member member) throws Exception{
		
		// SQL 수행, DB 자원 반환

		// 1_15. SQL을 DB에 전달하고 결과를 반환 받을 PreparedStatement 객체 선언
		//		 PreparedStatement 변수 선언
		// 		 + DB 처리 결과 저장할 result 변수 선언
		PreparedStatement pstmt = null;
		int result = 0;
		
		// 1_16. query.properties 파일에 insertmember 작성
		
		// 1_17. query.properties 에서 SQL 구문 얻어오기
		String query = prop.getProperty("insertMember");
		
		// 1_18. 전달 받은 Connection 과 query를 DB로 전달할 준비
		try {
			pstmt = conn.prepareStatement(query);
			
			// 1_19. 각 위치홀더에 알맞은 값 대입
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			
			// PreparedStatement.getChar() 메소드 존재하지 않음
			// DB에는 문자형 데이터 타입이 없고 문자열 데이터 타입만 있기 때문
			// -> Java의 char 자료형을 DB에 전달할 경우
			//	  String으로 변환하여 전달할 것
			pstmt.setString(4, member.getGender() + "" );			
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setInt(8, member.getAge());
		
			// 1_20. SQL구문 실행 후 결과를 반환 받아 저장
			result = pstmt.executeUpdate();
			
			
		}finally {
			// 1_21. SQL 수행에 사용된 자원 반환
			// --> JDBCTemplate 에서 자원 반환 메소드 작성
			close(pstmt);			
		}
		
		// 1_22. insert 결과 반환
		return result;
	}
	
	
}
