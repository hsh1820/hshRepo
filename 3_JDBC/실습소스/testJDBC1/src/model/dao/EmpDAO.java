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
	// 1_3. ��� ���� ��ü ��ȸ
	public ArrayList<EMP> selectAll(){
		
		// JDBC ��ü ����(java.sql)
		Connection conn = null;
		// - DB�� ���� ������ ���� ��ü
		// - JDBC ����̹� DB ���̸� �������ִ� ������ �����
		// - ���� ��ü ���� �Ұ�(interface �̱� ������) 
		//-> DriverManager.getConnection() �̿��Ͽ� ����
		
		Statement stmt = null;
		// - connection ��ü�� �̿��ؼ� DB�� SQL���� �����ϰ�
		// 	 ������ SQL���� ���� ����� ��ȯ �޴� ����
		// - Connection.createStatement() �̿��ؼ� ��ü ����
		
		// --> JDBC Driver �ȿ��� ��κ��� interface �̱� ������ 
		// ��ü�� ������ִ� �޼ҵ尡 ����
		
		ResultSet rset = null;
		// - SELECT ���� ����� SQL ���� �� ��ȯ�Ǵ� ���� ������ ��ü
		// - SELECT�� ����� ������ ���̺��� ��� ������
		//   Ŀ��(CURSOR)��� ���̺��� �� �྿ �����ϴ� DB��ü�� �̿��Ͽ�
		// 	 Ư�� �࿡ ���� ������ ������.
		
		ArrayList<EMP> empList = null;
		// DB���� ��ȸ�� ����� ������ ArrayList
		
		
		// 1_4. �ش� DB�� ���� ���̺귯��(JDBC ����̹�) ��� �۾�
		// -> JDBC ����̹��� Ŭ������ �޸𸮿� �ε�(����̹� Ŭ������ ����ϱ� ���� �޸𸮻����� �÷��ִ� ����)
		// Class.forName("Ŭ������")�� �̿��Ͽ� �޸𸮿� �ε�
		// --> ClassNotfoundException �߻��� ���ɼ��� ����
		// 		--> ����ó�� �ʿ�(try-catch)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// OracleDriver �� �޸𸮿� �ε� 
			// --> JDBC ����̹� 
			// --> DriverManager ��ü ��밡��
			// ojdbc6 ���̺귯�� ���ԵǾ� ���� 
			
			// 1_5. DBMS ���� �۾�
			/*	
			 * ���� ������ ���� Connection
			 * ���� ó���� ���� DriverManager
			 * 
			 * - jdbc:oracle:thin -> JDBC ����̹� thin Ÿ���̶�� �ǹ�
			 * - @127.0.0.1 -> �����Ϸ��� ����Ŭ�� ��ġ�� ��ǻ���� IP�� �Է��ϴ� �κ�
			 * 				-> 127.0.0.1 �� �ڽ��� ��ǻ�� IP
			 * 					(@localhost�� ��ü ����)
			 * - 1521 : ����Ŭ Listener ��Ʈ ��ȣ
			 * - xe : ������ ����Ŭ DB ��(Express -> xe)
			 * - SCOTT : DB ���� ����
			 * - TIGER : ���� ��й�ȣ
			 * 
			 * */
			
			conn = DriverManager.
					getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "TIGER");
			
			// 1_6. DB ���� ���� Ȯ��
			// 		���� ���� �� conn�� ����ϸ� DB ������ ��µ�.
			// 		���� ���� �� null, SQLException �߻� ���ɼ��� ����
			//System.out.println(conn);
			
			// 1_8. DB�� SQL���� �����ϰ�, �����Ų �� 
			// 		�� ����� ��ȯ �޾ƿ� Statement ��ü ����
			stmt = conn.createStatement();
			
			String query = "select * from EMP";
			
			// 1_9. SQL���� Statement ��ü�� �̿��Ͽ� 
			//		DB�� ���� �� ���� ��Ų ��
			// 		��ȯ�� ����� ResultSet rset�� ����
			
			rset = stmt.executeQuery(query);
			// single resultset
			// executeQuery()
			// - DB�� Select���� �����Ͽ� �����ϰ� ,����� ��ȯ ����
			// executeUpdate() : DML �� ���� ���
			// -> DML(INSERT, UPDATE, DELETE) ���� �� ���� �� ��� ��ȯ ����
			// -> ������ ���� ���� ��ȯ
			
			// 1_10. rset�� �ִ� ���(���̺�� �������)�� ArrayList�� ����ֱ�
			empList = new ArrayList<EMP>(); // ����� ������ ArrayList ����
			EMP emp = null; // ��ȸ ����� �� ��(row) ���� ������ �ӽ� ���� ����
			
			while(rset.next()) {
				// ResultSet.next() 
				// ��ȯ ���� ��ȸ ���(���̺�)��
				// Ŀ��(cursor)�� �̿��Ͽ� �� �� �� ����
				// �� ��, ���� �����ϸ� true, ������ false ��ȯ
				
				// get[Type]("�÷���") : �ش� �÷��� ���� �������� ����
				// [Type] �� ������ ���� �ڷ����� �ǹ�
				
				int empNo = rset.getInt("EMPNO");
				String eName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				
				// ��ȸ ����� �Ű������� �Ͽ� EMP ��ü ����
				
				emp = new EMP(empNo, eName, job, mgr, hireDate, sal, comm, deptNo);
				
				// ������ EMP ��ü�� empList�� �߰�
				empList.add(emp);
				
			}
			
			//System.out.println(empList);
			
			// ��ȸ ����� ��� empList�� �����ߴٸ�
			// DB ���ῡ ���Ǿ��� ��� ��ü ��ȯ  
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// 1_11. DB ���� ����
			// DB ���ῡ ���� ��ü�� ��� �� �ݵ�� ��ȯ�� �� 
			try {
				// ��ȯ ���� : �������� ������ DB ���� ��ü���� ��ȯ
				rset.close();
				stmt.close();
				conn.close();
				//drivermanager��ü�� ���ῡ ���� ������ �ϴ� ��������
				// DB������ü�� ������ ����
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		// 1_12. ��ȸ�� ��� ������ ��� empList�� ��ȯ
		return empList;
	}
	// 2_6. �Ű� ������ ���޵� ������� ���� ���� ��ȸ
	public EMP selectEmp(int empNo) {
		
		// 2_7. JDBC ���� ��ü ����
		
		Connection conn = null ; // DB ���� ���� (������ ���� ���)
		Statement stmt = null; // SQL�� DB�� ���� �� ��� ��ȯ
		ResultSet rset = null; // DB ��ȸ ��� ����
		
		EMP emp = null; // ��ȸ ��� �ӽ� ���� ����
		
		// 2_8. JDBC ����̹� ��� �۾� : �޸𸮿� �ε�
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			
			// 2_9. Statement�� �̿��Ͽ� ���� ��ȸ
			
			// �ش� ����� ��� ������ ��ȸ�ϴ� ������ �ۼ�
			String query = "select * from EMP where empno = "+ empNo ;
			
			stmt = conn.createStatement(); // statement ����
			
			rset = stmt.executeQuery(query); // DB ��ȸ ��� ����
						
			// 2_10. ��ȸ�� ����� EMP ��ü�� ����
			if(rset.next()) {
				// ��ȸ ����� �� �� �̹Ƿ� if ���� �̿��Ͽ� next()�� 1ȸ�� ����
				
				// empNo �Ű����� ��Ȱ��
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
			// 2_11. DB ���� �ڿ� ��ȯ
			try {
				rset.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		// 2_12. ��ȸ ������ ������ emp ��ȯ
		return emp;
	}
}
