package service;


import static common.JDBCTemplate.*;

import java.sql.Connection;

import model.dao.MemberDAO;
import model.vo.Member;

public class MemberService {
	public int insertMember(Member member) throws Exception {
		Connection conn = null;
		
		int result = 0;
		
		conn = getConnection();
		
		MemberDAO mDAO = new MemberDAO();
		result = mDAO.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
}
