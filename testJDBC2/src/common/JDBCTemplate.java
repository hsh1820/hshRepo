package common;

import java.sql.Connection;

public class JDBCTemplate {
	/* 기존에는 DB 처리 작업 시 (쿼리문을 하나 보낼때마다 실행하는 것) 마다
	 * 새로운 Connection 객체를 생성하여 DB 연결을 진행함.
	 * 이렇게 하면 한 사용자가 여러 개의 커넥션을 생성하게 됨. 
	 * --> 메모리 낭비 증가, 객체 생성 소멸에 따른 시간 소비
	 * 
	 * 이를 해결하기 위해서 
	 * 프로그램 전체에서 생성할 수 있는 Connection 객체를 한개로 제한
	 * -> 메모리 낭비 및 DB 연결 객체수 오버를 방지
	 * --> 싱글톤(Singletone) 패턴
	 * 
	 * * 싱글톤 패턴이란?
	 * - 프로그램 구동 시 메모리에 객체를 단 하나만 기록되게 하는 
	 * 	  디자인 패턴(설계)
	 * 
	 * - 한 클래스에 모든 필드, 메소드를 static으로 선언하여
	 *   static영역 자체에 해당 클래스 객체를 만드는 형태로 작성
	 *   --> 클래스를 static에 구현하게되면 결국 
	 *   	 하나의 객체로 생성이 되는 것이며, 모든 객체나 메소드에서 접근가능
	 * */
	
	// 한 개의 공용 Connection 객체를 저장할 참조 변수 선언
	// 단, 외부에서 직접 접근할 수 없도록 private 으로 선언
	private static Connection conn = null;
	// 싱글톤 패턴을 적용하기 위해 static 사용
	
	// DB연결을 위한 Connection 객체요청 메소드 작성
	public static Connection getConnection() {
		
		// 프로그램 실행 후 한번도 getConnection() 메소드가 호출되지 
		// 않았을 때
		// -> Connection 객체 생성
		if(conn == null) {
			
		}
		return conn;
	}
	
	
}
