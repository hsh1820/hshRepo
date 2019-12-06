package model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import model.dao.BoardDAO;
import model.vo.Board;
import model.vo.Comment;
import model.vo.Member;

/**
 * 게시판 프로그램 Service
 * @author Baek Dong Hyeon
 */
public class BoardService {

	/** 로그인용 Service
	 * @param inputLogin : Member
	 * @return member : Member
	 * @throws Exception
	 */
	public Member login(Member inputLogin) throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.login(conn, inputLogin);
	}
	
	
	/** 게시글 목록 조회용 Service
	 * @return bList : Board List
	 * @throws Exception
	 */
	public List<Board> selectAll() throws Exception{
		
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.selectAll(conn);
	}
	
	
	/** 게시글 조회용 Service
	 * @param bNo : int
	 * @return board Board
	 * @throws Exception
	 */
	public Board selectBoard(int bNo) throws Exception{
		Connection conn = getConnection();
		BoardDAO boarDAO = new BoardDAO();
		
		return boarDAO.selectBaord(conn, bNo);
	}


	public int insertBoard(Board board) throws Exception{
		
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.insertBoard(conn, board);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}


	public String selectWriter(int bNo) throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.selectWriter(conn, bNo);
		
	}


	public int updateBoard(int bNo, int sel, String updateStr) throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		String updateQuery = "update";
		switch(sel) {
		case 1 : updateQuery += "Title"; 
				 break;
		case 2 : updateQuery += "Content"; 
				 break;
		}
		
		int result = boardDAO.updateBoard(conn, bNo, updateQuery, updateStr);
		
		if(result > 0) commit(conn);
		else		rollback(conn);
		
		return result;
	}

	
	public int deleteBoard(int bNo) throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.deleteBoard(conn, bNo);

		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}

	
	public void exitProgram(){
		close(getConnection());
	}
	
	
	public String randomString() {
		String str = "";
		int random = 0;
		for(int i=0 ; i<6 ; ) {
			random = (int)(Math.random() * (('z'+1) - '0') ) + '0';
			
			if(random >= '0' && random <= '9' || 
				random >='A' && random <= 'Z' ||
				random >='a' && random <= 'z') {
				
				str += (char)random;
				i++;
			}
		}
		return str;
	}


	public List<Comment> selectCommAll(int Bbno) throws Exception {

		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.selectCommAll(conn, Bbno);
	}


	public int inputComm(int bNo, String inputComm) throws Exception {

		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.inputComm(conn, bNo, inputComm);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}


	public String selectMemberId(int sel) throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		String memberId = boardDAO.selectMemberId(conn, sel); 
		return  memberId;
	}


	public int updateComm(int sel, String updateComm) throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.updateComm(conn, sel, updateComm);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}


	public int deleteComm(int sel) throws Exception	{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.deleteComm(conn, sel);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}
	
	
	
	
}









