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

import javax.naming.PartialResultException;
import javax.naming.spi.DirStateFactory.Result;

import controller.MemberController;
import model.vo.Crt;
import model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	public MemberDAO() throws Exception {
		prop = new Properties();
		prop.load(new FileReader("query.properties"));
	}
	
	public int insertMember(Connection conn, Member member) 
			throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender()+"");
			pstmt.setString(5, member.getEmail());
			pstmt.setInt(6, member.getAge());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Member login(Connection conn, Member inputLogin) 
			throws Exception{
		
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
				int age = rset.getInt("AGE");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				member = new Member(memberId, memberPwd, memberName, gender, email, age, enrollDate);
			}
		} finally {
			close(pstmt);
			close(rset);
			
		}
		return member;
	}

	public int updateMember(Connection conn, Member member)
			throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = prop.getProperty("updateMember");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getGender()+"");
			pstmt.setString(3, member.getEmail());
			pstmt.setInt(4, member.getAge());
			pstmt.setString(5, MemberController.LoginMember.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = prop.getProperty("selectMember");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, MemberController.LoginMember.getMemberId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				int age = rset.getInt("AGE");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				member = new Member(memberId, memberName, gender, email, age, enrollDate);
				
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int insertCrt(Connection conn, Crt crt) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCrt");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, crt.getCrtName());
			pstmt.setString(2, crt.getCrtClass());
			pstmt.setString(3, MemberController.LoginMember.getMemberId());
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
		}
		return result;
	}

	public List<Crt> selectAll(Connection conn)	throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		List<Crt> cList = null;
		
		String query = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			cList = new ArrayList<Crt>();
			Crt crt = null;
			
			while(rset.next()) {
				String crtName = rset.getString("CRT_NAME");
				String crtClass = rset.getString("CRT_CLASS");
				int crtLevel = rset.getInt("CRT_LEVEL");
				String crtOwner = rset.getString("CRT_OWNER");
				
				crt = new Crt(crtName, crtClass, crtLevel, crtOwner);
				
				cList.add(crt);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return cList;
	}

	public List<Crt> selectCrt(Connection conn) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Crt> cList = null;
		
		String query = prop.getProperty("selectCrt");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, MemberController.LoginMember.getMemberId());
			rset = pstmt.executeQuery();
			cList = new ArrayList<Crt>();
			Crt crt = null;
			
			while(rset.next()) {
				String crtName = rset.getString("CRT_NAME");
				String crtClass = rset.getString("CRT_CLASS");
				int crtLevel = rset.getInt("CRT_LEVEL");
				String crtOwner = rset.getString("CRT_OWNER");
				
				crt = new Crt(crtName, crtClass, crtLevel, crtOwner);
				
				cList.add(crt);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return cList;
	}

	public int deleteCrt(Connection conn, String delName)
			throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteCrt");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, delName);
			pstmt.setString(2, MemberController.LoginMember.getMemberId());
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
