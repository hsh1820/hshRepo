package model.service;
import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import model.dao.MemberDAO;
import model.vo.Crt;
import model.vo.Member;

public class MemberService {

	public int insertMember(Member member) throws Exception {

		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.insertMember(conn, member);


		if(result > 0) {
			commit(conn);
		} else { // 삽입 실패 시
			rollback(conn);
		}

		return result;
	}
	
	public Member login(Member inputLogin) throws Exception{
		
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		return memberDAO.login(conn, inputLogin);
	}

	public int updateMember(Member member) throws Exception{
		
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.updateMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public Member selectMember() throws Exception{
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		return memberDAO.selectMember(conn);
	}
	
	public int insertCrt(Crt crt) throws Exception{
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		
		int result = memberDAO.insertCrt(conn, crt);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public List<Crt> selectAll() throws Exception {
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		return memberDAO.selectAll(conn);
	}

	public List<Crt> selectCrt() throws Exception{
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		return memberDAO.selectCrt(conn);
	}

	public int deleteCrt(String delName) throws Exception{
		Connection conn = getConnection();
		MemberDAO memberDAO = new MemberDAO();
		int result = memberDAO.deleteCrt(conn, delName);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public void gameOver() {
		// TODO Auto-generated method stub
		close(getConnection());
	}
}
