package model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import model.dao.MenuDAO;
import model.vo.Menu;



public class MenuService {
	
	public Map<Integer,Menu> selectSubMenu(int sel) throws Exception{
		
		Connection conn = getConnection();
		MenuDAO menuDAO = new MenuDAO();
		
		return menuDAO.selectSubMenu(conn,sel);
	}

	public int updateSubMenu(String chooseFood) throws Exception {
		Connection conn = getConnection();
		MenuDAO menuDAO = new MenuDAO();
		
		return menuDAO.updateSubMenu(conn,chooseFood);
	}



}