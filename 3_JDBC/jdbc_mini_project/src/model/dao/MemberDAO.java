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

import model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() throws Exception{
		prop = new Properties();
		prop.load(new FileReader("query.properties"));
	}

	public Member login(Connection conn, Member member) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginMember = null;
		
		String query = prop.getProperty("LOGIN");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String email = rset.getString("EMAIL");
				String password = rset.getString("PASSWORD");
				String name = rset.getString("NAME");
				
				
				loginMember = new Member(email, password, name);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return loginMember;
	}

	public String checkEmail(Connection conn, String email) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String checkId = null;
		
		String query = prop.getProperty("CHECKEMAIL");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				checkId = rset.getString(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return checkId;
	}
	
	public int memberUpdate(Connection conn, Member member, String updateQuery) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty(updateQuery);
		System.out.println(updateQuery);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getKhYN()+"");
			
			result = pstmt.executeUpdate();
			
		}finally{
			close(pstmt);
		}
		
		return result;
	}

//
//	public int updateMember(Connection conn, String newPwd) throws Exception{
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		String query = prop.getProperty("updateMember");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, newPwd);
//			pstmt.setString(2, MemberController.loginMember.getId());
//			
//			result = pstmt.executeUpdate();
//			
//		}finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//
//	public int unsigned(Connection conn) throws Exception{
//		PreparedStatement pstmt = null;
//		int result = 0;
//		String query = prop.getProperty("unsigned");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, MemberController.loginMember.getId());
//			
//			result = pstmt.executeUpdate();
//			
//		}finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//
//	public List<Member> selectAll(Connection conn) throws Exception{
//		Statement stmt = null;
//		ResultSet rset = null;
//		List<Member> MemberList = null;
//		
//		
//		String query = prop.getProperty("selectAllMember");
//		
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//			
//			MemberList = new ArrayList<Member>();
//			Member Member = null;
//			
//			while(rset.next()) {
//				String id = rset.getString("ID");
//				String pwd = rset.getString("PWD");
//				String name = rset.getString("NAME");
//				Date enrollDate = rset.getDate("ENROLL_DATE");
//				String rent = rset.getString("RENT");
//				char checkOut = rset.getString("CHECK_OUT").charAt(0);
//				
//				Member = new Member(id, pwd, name, enrollDate, rent, checkOut);
//				
//				MemberList.add(Member);
//			}
//			
//		}finally {
//			close(rset);
//			close(stmt);
//		}
//		
//		return MemberList;
//	}
//
//	public char checkOut(Connection conn, String deleteId) throws Exception{
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		char check = 0;
//		
//		String query = prop.getProperty("checkOut");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, deleteId);
//			
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				check = rset.getString(1).charAt(0);
//			}
//			
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return check;
//	}
//
//	public int deleteMember(Connection conn, String deleteId) throws Exception{
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		String query = prop.getProperty("deleteMember");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, deleteId);
//			
//			result = pstmt.executeUpdate();
//			
//		}finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

}