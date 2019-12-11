package model.dao;

import static common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import model.vo.Menu;


public class MenuDAO {
	
	Properties prop = null;
	
	public MenuDAO() throws Exception{
		prop = new Properties();
		prop.load(new FileReader("query.properties"));
		
	}

	public Map<Integer,Menu> selectSubMenu(Connection conn, int sel) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Map<Integer,Menu> menuList = null;
		Menu menu = null;
		
		String query = prop.getProperty("SELECTSUBMENU");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sel);
			
			rset = pstmt.executeQuery();
			
			menuList = new HashMap<Integer,Menu>();
			int i = 1;
			
			while(rset.next()) {
				String cateTitle = rset.getString("CATE_TITLE");
				String menuTitle = rset.getString("MENU_TITLE");
				int menuQuantity = rset.getInt("MENU_QUANTITY");
				int menuPrice = rset.getInt("MENU_PRICE");
				
				menu = new Menu(cateTitle, menuTitle, menuPrice, menuQuantity);
				
				menuList.put((Integer)i, menu);
				i++;
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return menuList;
	}

	public int updateSubMenu(Connection conn, String chooseFood, int quantity) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("UPDATESUBMENU");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, quantity);
			pstmt.setString(2, chooseFood);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			commit(conn);
		}
		return result;
	}
}