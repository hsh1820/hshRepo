package model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import controller.BoardController;
import model.vo.Board;
import model.vo.Comment;
import model.vo.Count;
import model.vo.Member;
import oracle.net.aso.r;

/**
 * 게시판 프로그램 DAO
 * @author Baek Dong Hyeon
 */
public class BoardDAO {
	
	private Properties prop = null;
	
	
	/**
	 * BoardDAO 객체 생성 시 
	 * query.properties 파일을 동적으로 읽어옴
	 * @throws Exception
	 */
	public BoardDAO() throws Exception{
		prop = new Properties();
		prop.load(new FileReader("query.properties"));
	}
	
	
	/** 로그인용 DAO
	 * @param conn : Connection
	 * @param inputLogin : Member
	 * @return member : Member
	 * @throws Exception
	 */
	public Member login(Connection conn, Member inputLogin) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, inputLogin.getMemberId());
			pstmt.setString(2, inputLogin.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				member = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age, enrollDate);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}
	
	
	/** 게시글 목록 조회용 DAO
	 * @param conn : Connection
	 * @return bList : Board List
	 * @throws Exception
	 */
	public List<Board> selectAll(Connection conn) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		List<Board> bList = null;

		String query = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			bList = new ArrayList<Board>();
			Board board = null;
			
			while(rset.next()) {
				int bNo = rset.getInt("BNO");
				String title = rset.getString("TITLE");
				//String content = rset.getString("CONTENT");
				Date createDate = rset.getDate("CREATE_DATE");
				String writer = rset.getString("WRITER");
				
				board = new Board(bNo, title, createDate, writer);
				
				bList.add(board);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return bList;
	}
	
	
	/** 게시글 조회용 DAO
	 * @param conn : Connection
	 * @param bNo : int
	 * @return board : Board
	 * @throws Exception
	 */
	public Board selectBaord(Connection conn, int bNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String title = rset.getString("TITLE");
				String content = rset.getString("CONTENT");
				Date createDate = rset.getDate("CREATE_DATE");
				String writer = rset.getString("WRITER");
				
				board = new Board(bNo, title, content, createDate, writer);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}	
		return board;
	}


	public int insertBoard(Connection conn, Board board) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, BoardController.loginMember.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public String selectWriter(Connection conn, int bNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String writer = null;
		
		String query = prop.getProperty("selectWriter");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				writer = rset.getString("WRITER");
			}
		}finally {
			close(pstmt);
		}
		
		return writer;
	}


	public int updateBoard(Connection conn, int bNo, String updateQuery, String updateStr) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty(updateQuery);
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, updateStr);
			pstmt.setInt(2, bNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int deleteBoard(Connection conn, int bNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public List<Comment> selectCommAll(Connection conn, int Bbno) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Comment> cList = null;

		String query = prop.getProperty("selectCommAll");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, Bbno);
			
			rset = pstmt.executeQuery();
			
			cList = new ArrayList<Comment>();
			Comment comment = null;
			
			while(rset.next()) {
				int cBno = rset.getInt("C_BNO");
				String content = rset.getString("CONTENT");
				String writer = rset.getString("WRITER");
				Date createDate = rset.getDate("CREATE_DATE");
				
				comment = new Comment(cBno, content, writer, createDate);
				
				cList.add(comment);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}


	public int inputComm(Connection conn, int bNo, String inputComm) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("inputComm");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, bNo);
			pstmt.setString(2, inputComm);
			pstmt.setString(3, BoardController.loginMember.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public String selectMemberId(Connection conn, int sel) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String memberId= null;
		
		String query = prop.getProperty("selectMemberId");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sel);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				memberId = rset.getString("WRITER");				
			}
		}finally {
			close(pstmt);
		}
		
		return memberId;
	}


	public int updateComm(Connection conn, int sel, String updateComm) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateComm");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, updateComm);
			pstmt.setInt(2, sel);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteComm(Connection conn, int sel)throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteComm");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sel);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int countBaord(Connection conn, int bNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String query = prop.getProperty("countSelect");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return count;
	}


	public int updateCount(Connection conn, int bNo, int count) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, count);
			pstmt.setInt(2, bNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;

	}


	public List<Count> CommSelectAll(Connection conn) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		List<Count> cList = null;

		String query = prop.getProperty("CommSelectAll");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			cList = new ArrayList<Count>();
			Count count = null;
			
			while(rset.next()) {
				int cCount = rset.getInt("count");
				
				count = new Count(cCount);
				
				cList.add(count);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return cList;
	}
	
	
}








