package model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import model.dao.MemberDAO;
import model.vo.Member;

public class MemberService {
    // MEMBER select 사용 
	public Member login(Member member) throws Exception{
		Connection conn = getConnection();
		MemberDAO MemberDAO = new MemberDAO();
		
		return MemberDAO.login(conn, member);
	}
	
	public String checkEmail(String email) throws Exception{
		Connection conn = getConnection();
		MemberDAO MemberDAO = new MemberDAO();
		
		return MemberDAO.checkEmail(conn, email);
	}
	 // MEMBER select 사용 end 
	
	// MEMBER DML 사용 
	public int memberUpdate(Member member, int sel) throws Exception{
		Connection conn = getConnection();
		MemberDAO MemberDAO = new MemberDAO();
		
		String updateQuery = "MEMBER";
		int result = 0;
		
		switch(sel) {
		case 2 : {
			updateQuery += "INSERT";
			result = MemberDAO.memberUpdate(conn, member, updateQuery);
		}
		// 아래에 MEMBER 테이블에 대한 DML 추가 예정
		
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}	
	// MEMBER DML 사용 end
	
	
//	public int updateUser(String newPwd) throws Exception{
//		Connection conn = getConnection();
//		UserDAO userDAO = new UserDAO();
//		
//		int result = userDAO.updateUser(conn, newPwd);
//		
//		if(result > 0) commit(conn);
//		else rollback(conn);
//		
//		return result;
//	}
//
//	public String randomStr() throws Exception{
//		String str = "";
//		int random = 0;
//		
//		for(int i=0; i<6; ) {
//			random = (int)(Math.random() * ('z' - '0') + '0' + 1);
//			
//			if(random >= '0' && random <='9' ||
//					random >= 'A' && random <= 'Z' ||
//					random >= 'a' && random <= 'z') {
//				
//				str += (char)random;
//				i++;
//			}
//		}
//		
//		return str;
//	}
//
//	public int unsigned() throws Exception{
//		Connection conn = getConnection();
//		UserDAO userDAO = new UserDAO();
//		
//		int result = userDAO.unsigned(conn);
//		
//		if(result > 0) commit(conn);
//		else rollback(conn);
//		
//		return result;
//	}
//
//	public List<User> selectAll() throws Exception{
//		Connection conn = getConnection();
//		UserDAO userDAO = new UserDAO();
//		
//		return userDAO.selectAll(conn);
//	}
//
//	public char checkOut(String deleteId) throws Exception{
//		Connection conn = getConnection();
//		UserDAO userDAO = new UserDAO();
//		
//		char check = userDAO.checkOut(conn, deleteId);
//		
//		return check;
//	}
//
//	public int deleteUser(String deleteId) throws Exception{
//		Connection conn = getConnection();
//		UserDAO userDAO = new UserDAO();
//		
//		int result = userDAO.deleteUser(conn, deleteId);
//		
//		if(result > 0) commit(conn);
//		else rollback(conn);
//		
//		return result;
//	}
//	
}