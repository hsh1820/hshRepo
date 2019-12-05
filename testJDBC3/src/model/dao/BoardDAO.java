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

import contoller.BoardController;
import model.vo.Board;
import model.vo.Member;

/** 게시판 프로그램 DAO
 * @author Hansonghee
 */
public class BoardDAO {

	private Properties prop = null;
	
	/** BoardDAO 객체 생성 시 query.properties 파일을
	 * 동적으로 읽어옴
	 * @throws Exception : IOException
	 */
	public BoardDAO() throws Exception {
		prop = new Properties();
		prop.load(new FileReader("query.properties"));
		//FileNotFoundException
	}
	
	/** 로그인용 DAO
	 * @param conn : Connection
	 * @param inputLogin : Member
	 * @return member : Member
	 * @throws Exception : SQLException
	 * @see query.properties 
	 */
	public Member login(Connection conn, Member inputLogin)throws Exception{
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
				String memberId = rset.getString("member_id");
				String memberPwd = rset.getString("member_pwd");
				String memberName = rset.getString("member_name");
				char gender = rset.getString("gender").charAt(0);
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				int age = rset.getInt("age");
				Date enrollDate = rset.getDate("enroll_date");
				
				member = new Member(memberId, memberPwd, memberName, gender, email, phone, address, age, enrollDate);
				
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

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
				int bno = rset.getInt("bno");
				String title = rset.getString("title");
				Date createDate = rset.getDate("create_date");
				String writer = rset.getString("writer");
				
				board = new Board(bno, title, createDate, writer);
				
				bList.add(board);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return bList;
	}

	public Board selectBoard(Connection conn, int selMenu) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null; 
		
		String query = prop.getProperty("selectBoard"); 
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, selMenu);

			rset = pstmt.executeQuery();
			
			
			
			while(rset.next()) {
				int bno = rset.getInt("bno");
				String title = rset.getString("title");
				String writer = rset.getString("writer");
				Date createDate = rset.getDate("create_date");
				String content = rset.getString("content");
				
				board = new Board(bno, title, createDate, writer, content);
				
			}
		}finally {
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

	public String selectBoard2(Connection conn, int sel) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectBoard"); 
		String memberId = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sel);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				memberId = rset.getString("writer");
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return memberId;
	}

	public int updateTitle(Connection conn,String inputTitle, String memberId, int sel) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateTitle");
				
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, inputTitle);
			pstmt.setString(2, memberId);
			pstmt.setInt(3, sel);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateContent(Connection conn, Board board, String memberId , int sel) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateContent");
				
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, board.getContent());
			pstmt.setString(2, memberId);
			pstmt.setInt(3, sel);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	

}
