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


}