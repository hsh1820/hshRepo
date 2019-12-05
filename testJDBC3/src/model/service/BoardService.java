package model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import model.dao.BoardDAO;
import model.vo.Board;
import model.vo.Member;

/**
 * 게시판 프로그램 Service
 * @author Hansonghee
 */
public class BoardService {
	
	/** 로그인용 Service
	 * @param inputLogin : Member
	 * @return member : Member
	 * @throws Exception : SQLException, IOException
	 * @see Connection시 발생하는 Exception은 JDBCTemplate에서 처리함.
	 */
	public Member login(Member inputLogin) throws Exception{
		
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.login(conn, inputLogin);
	}
	
	/** 게시글 목록 조회용 Service
	 * @return bList : List<Board>
	 * @throws Exception : SQlExcetpion, IOException
	 */
	public List<Board> selectAll() throws Exception{
		
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.selectAll(conn);
		
	}
	
	public Board selectBoard(int selMenu) throws Exception{
		
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		return boardDAO.selectBoard(conn, selMenu);
		
	}
	
public String selectBoard2(int sel) throws Exception{
		
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		String memberId = boardDAO.selectBoard2(conn, sel);
		return memberId;
		
	}

	public int insertBoard(Board board) throws Exception {
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.insertBoard(conn, board);
		
		if (result > 0)	commit(conn);
		else 			rollback(conn);
		
		return result ;
	}

	public int updateTitle(String inputTitle,String memberId, int sel)  throws Exception{
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.updateTitle(conn, inputTitle, memberId, sel);
		
		if (result > 0)	commit(conn);
		else 			rollback(conn);
		return result ;
	}

	public int updateContent(Board board, String memberId , int sel)  throws Exception {
		Connection conn = getConnection();
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.updateContent(conn, board, memberId, sel);
		
		if (result > 0)	commit(conn);
		else 			rollback(conn);
		return result ;
	}

}
