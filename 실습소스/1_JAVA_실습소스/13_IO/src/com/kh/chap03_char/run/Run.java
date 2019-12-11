package com.kh.chap03_char.run;

import com.kh.chap01_file.controller.FileController;
import com.kh.chap03_char.model.dao.FileCharDAO;

public class Run {
	public static void main(String[] args) {
//		new FileCharDAO().fileOpen();
		new FileCharDAO().fileSave();
	}
}
