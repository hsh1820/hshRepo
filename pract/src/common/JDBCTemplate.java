package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;


public class JDBCTemplate {
	
	
	public static Connection getConnection () throws Exception{
		Connection conn =null;
		Properties prop = new Properties();
		
		prop.load(new FileReader("driver.properties"));
		
		
		String url = prop.getProperty("url");
		String id = prop.getProperty("id");
		String password = prop.getProperty("password");
		
		Class.forName(prop.getProperty("driver"));
		
		conn = DriverManager.getConnection(url,id,password);
		
		return conn; 
	}
	
	public static void close(Connection conn) throws Exception {
		if(conn != null & !conn.isClosed()) {
			conn.close();
		}
	}
	
	public static void close(Statement stmt) throws Exception {
		if(stmt != null & !stmt.isClosed()) {
			stmt.close();
		}
	}
	public static void commit(Connection conn) throws Exception{
		if(conn != null && !conn.isClosed()) {
			conn.commit();
		}
	}
	
	public static void rollback(Connection conn) throws Exception{
		if(conn != null && !conn.isClosed()) {
			conn.rollback();
		}
	}
}
