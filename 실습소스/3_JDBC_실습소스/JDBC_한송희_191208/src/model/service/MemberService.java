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
	
}