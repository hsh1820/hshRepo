package common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
			/* 이전 프로젝트에서 Connection 생성 과정
			 * - JDBC 드라이버 로드
			 * - DB 연결을 위한 정보(url, id, pwd) 직접 작성
			 * 이러한 내용들을 직접 작성함. (정적 코딩)
			 * -- > 추후 DB정보가 변경되는 경우
			 * 		코드 자체를 수정해서 다시 컴파일, 배포해야함.
			 * 		--> 유지보수 불편
			 * 
			 * 이를 해결하기 위해 Properties 파일 사용.
			 * 프로그램 실행 시 동적으로 Properties 파일에서
			 * DB 연결정보를 읽어오도록 코딩. (동적 코딩)
			 * 
			 * -> driver.Properties 파일 작성
			 * 
			 * */
			
			// 외부에서 DB 연결 정보 읽어올 Properties 객체 생성
			try {
				Properties prop = new Properties();
				
				// driver.properties 파일에서 정보를 읽어옴
				prop.load(new FileReader("driver.properties"));
				// -> 파일을 읽어오는 과정에서 IOException 발생 가능성이 있음
				
				// driver.properties에서 읽어들인 정보를 이용해 
				// DB와 연결할 Connection객체를 생성
				
				// jdbc 드라이버 로드
				try {
					Class.forName(prop.getProperty("driver"));
					// classnotfound Exception 발생 가능성 있음
					
					// Connection 객체 생성
					conn = DriverManager.getConnection(
							prop.getProperty("url"),
							prop.getProperty("user"),
							prop.getProperty("password"));
					
					// 명시적 Auto Commit 비활성화
					conn.setAutoCommit(false);
					// 11g xe 버전이 아닌 다른 종류나 버전의 DB에서는 
					// 기본적으로 AutoCommit이 true로 지정되어있는 DB가 있는데
					// 이를 방지하기 위해서 setAutoCommit(false) 구문 작성한 것
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	// DB 연결 관련 자원 반환 메소드 close() 작성
	public static void close(Statement stmt) {
		 // PreparedStatement는 Statement 의 자식
      	 // -> 상속 관계 -> 다형성 적용 -> 매개변수로 부모 타입 사용 가능
		 // --> 즉, 어떤 statement 객체를 사용 하더라도 template에서 한번에 
		 // 자원 처리가능
		
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(ResultSet rset) {
		 // PreparedStatement는 Statement 의 자식
     	 // -> 상속 관계 -> 다형성 적용 -> 매개변수로 부모 타입 사용 가능
		 // --> 즉, 어떤 statement 객체를 사용 하더라도 template에서 한번에 
		 // 자원 처리가능
		
		try {
			if ( rset != null && !rset.isClosed()) {
				rset.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		 // PreparedStatement는 Statement 의 자식
    	 // -> 상속 관계 -> 다형성 적용 -> 매개변수로 부모 타입 사용 가능
		 // --> 즉, 어떤 statement 객체를 사용 하더라도 template에서 한번에 
		 // 자원 처리가능
		
		// 바꾸고싶은 변수명에 Alt + Shift + R
		try {
			if ( conn != null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// 처리 결과에 따른 트랜잭션 처리도 공통적인 업무임
	// --> static으로 선언하여 코드길이 감소와 재사용성의 증가
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
