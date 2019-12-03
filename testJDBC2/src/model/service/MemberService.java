package model.service;

import model.vo.Member;

public class MemberService {
	/* Service 클래스는 데이터에 대한 비즈니스 로직(가공) 수행 및
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
	public int insertMember(Member member) {

		// 1_7. DB 연결을 위한 Connection객체 생성 구문의
		// 		중복되는 코드를 JDBCTemplate 에 작성
		
	}
}
