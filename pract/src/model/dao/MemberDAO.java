package model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static common.JDBCTemplate.*;
import model.vo.Member;

public class MemberDAO {
	
	public int insertMember(Connection conn, Member member) throws Exception{
		int result = 0;
		
		PreparedStatement pstmt = null;

		Properties prop = null;
		
		prop.load(new FileReader("query.properties"));
		
		String query = prop.getProperty("query");
		
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberName());

		pstmt.setString(4, member.getGender() + "");
		pstmt.setString(5, member.getEmail());
		pstmt.setString(6, member.getPhone());
		pstmt.setString(7, member.getAddress());
		pstmt.setInt(8, member.getAge());
		
		
		result = pstmt.executeUpdate();
		 
		if (result > 0	) {
			close(pstmt);
			close(conn);			
		}
		
		return result;
	}
}
