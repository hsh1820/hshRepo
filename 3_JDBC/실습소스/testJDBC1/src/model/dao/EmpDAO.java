package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.EMP;

public class EmpDAO {
	// 1_3. 사원 정보 전체 조회
	public ArrayList<EMP> selectAll(){
		
		// JDBC 객체 선언(java.sql)
		Connection conn = null;
		// - DB의 연결 정보를 담은 객체
		// - JDBC 드라이버 DB 사이를 연결해주는 일종으 ㅣ통로
		// - 직접 객체 생성 불가(interface 이기 때문에) 
		//-> DriverManager.getConnection() 이용하여 생성
		
		Statement stmt = null;
		// - connection 객체를 이용해서 DB에 SQL문을 전달하고
		// 	 전달한 SQL문의 실행 결과를 반환 받는 역할
		// - Connection.createStatement() 이용해서 객체 생성
		
		// --> JDBC Driver 안에는 대부분이 interface 이기 때문에 
		// 객체를 만들어주는 메소드가 있음
		
		ResultSet rset = null;
		// - SELECT 문을 사용한 SQL 성공 시 반환되는 값을 저장할 객체
		// - SELECT의 결과로 생성된 테이블을 담고 있으며
		//   커서(CURSOR)라는 테이블의 한 행씩 접근하는 DB객체를 이용하여
		// 	 특정 행에 대한 참조를 조작함.
		
		ArrayList<EMP> empList = null;
		// DB에서 조회한 결과를 저장할 ArrayList
		
		
		// 1_4. 해당 DB에 대한 라이브러리(JDBC 드라이버) 등록 작업
		// -> JDBC 드라이버의 클래스를 메모리에 로드(드라이버 클래스를 사용하기 위해 메모리상으로 올려주는 과정)
		// Class.forName("클래스명")를 이용하여 메모리에 로드
		// --> ClassNotfoundException 발생할 가능성이 있음
		// 		--> 예외처리 필요(try-catch)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver 를 메모리에 로드 
			// --> JDBC 드라이버 
			// --> DriverManager 객체 사용가능
			// ojdbc6 라이브러리 포함되어 있음 
			
			// 1_5. DBMS 연결 작업
			/*	
			 * 연결 정보를 담을 Connection
			 * 연결 처리를 위한 DriverManager
			 * 
			 * - jdbc:oracle:thin -> JDBC 드라이버 thin 타입이라는 의미
			 * - @127.0.0.1 -> 접속하려는 오라클이 설치된 컴퓨터의 IP를 입력하는 부분
			 * 				-> 127.0.0.1 은 자신의 컴퓨터 IP
			 * 					(@localhost로 대체 가능)
			 * - 1521 : 오라클 Listener 포트 번호
			 * - xe : 접속할 오라클 DB 명(Express -> xe)
			 * - SCOTT : DB 접속 계정
			 * - TIGER : 접속 비밀번호
			 * 
			 * */
			
			conn = DriverManager.
					getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "TIGER");
			
			// 1_6. DB 접속 성공 확인
			// 		접속 성공 시 conn을 출력하면 DB 정보가 출력됨.
			// 		접속 실패 시 null, SQLException 발생 가능성이 있음
			//System.out.println(conn);
			
			// 1_8. DB에 SQL문을 전달하고, 실행시킨 후 
			// 		그 결과를 반환 받아올 Statement 객체 생성
			stmt = conn.createStatement();
			
			String query = "select * from EMP";
			
			// 1_9. SQL문을 Statement 객체를 이용하여 
			//		DB에 전달 및 실행 시킨 후
			// 		반환된 결과를 ResultSet rset에 저장
			
			rset = stmt.executeQuery(query);
			// single resultset
			// executeQuery()
			// - DB로 Select문을 전달하여 실행하고 ,결과를 반환 받음
			// executeUpdate() : DML 문 사용시 사용
			// -> DML(INSERT, UPDATE, DELETE) 전달 및 실행 및 결과 반환 받음
			// -> 성공한 행의 개수 반환
			
			// 1_10. rset에 있는 결과(테이블로 담겨있음)를 ArrayList에 담아주기
			empList = new ArrayList<EMP>(); // 결과를 저장할 ArrayList 생성
			EMP emp = null; // 조회 결과의 한 행(row) 값을 저장할 임시 변수 선언
			
			while(rset.next()) {
				// ResultSet.next() 
				// 반환 받은 조회 결과(테이블)에
				// 커서(cursor)를 이용하여 한 행 씩 접근
				// 이 때, 행이 존재하면 true, 없으면 false 반환
				
				// get[Type]("컬럼명") : 해당 컬럼의 값을 가져오는 동작
				// [Type] 은 가져올 값의 자료형을 의미
				
				int empNo = rset.getInt("EMPNO");
				String eName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				
				// 조회 결과를 매개변수로 하여 EMP 객체 생성
				
				emp = new EMP(empNo, eName, job, mgr, hireDate, sal, comm, deptNo);
				
				// 생성된 EMP 객체를 empList에 추가
				empList.add(emp);
				
			}
			
			//System.out.println(empList);
			
			// 조회 결과를 모두 empList에 저장했다면
			// DB 연결에 사용되었던 모든 객체 반환  
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// 1_11. DB 연결 끊기
			// DB 연결에 사용된 객체는 사용 후 반드시 반환할 것 
			try {
				// 반환 순서 : 마지막에 생성된 DB 관련 객체부터 반환
				rset.close();
				stmt.close();
				conn.close();
				//drivermanager객체는 연결에 대한 관리를 하는 역할이지
				// DB연결자체와 관련이 없음
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		// 1_12. 조회된 사원 정보가 담긴 empList를 반환
		return empList;
	}
	// 2_6. 매개 변수로 전달된 사번으로 직원 정보 조회
	public EMP selectEmp(int empNo) {
		
		// 2_7. JDBC 관련 객체 선언
		
		Connection conn = null ; // DB 연결 정보 (일종의 연결 통로)
		Statement stmt = null; // SQL문 DB로 전달 및 결과 반환
		ResultSet rset = null; // DB 조회 결과 저장
		
		EMP emp = null; // 조회 결과 임시 저장 변수
		
		// 2_8. JDBC 드라이버 등록 작업 : 메모리에 로드
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			
			// 2_9. Statement를 이용하여 정보 조회
			
			// 해당 사번의 사원 정보를 조회하는 쿼리문 작성
			String query = "select * from EMP where empno = "+ empNo ;
			
			stmt = conn.createStatement(); // statement 생성
			
			rset = stmt.executeQuery(query); // DB 조회 결과 저장
						
			// 2_10. 조회된 결과를 EMP 객체에 저장
			if(rset.next()) {
				// 조회 결과가 한 행 이므로 if 문을 이용하여 next()를 1회만 진행
				
				// empNo 매개변수 재활용
				String eName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				
				emp = new EMP(empNo, eName, job, mgr, hireDate, sal, comm, deptNo);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 2_11. DB 연결 자원 반환
			try {
				rset.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		// 2_12. 조회 정보를 저장한 emp 반환
		return emp;
	}
}
