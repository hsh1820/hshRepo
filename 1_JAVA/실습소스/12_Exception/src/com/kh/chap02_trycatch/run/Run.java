package com.kh.chap02_trycatch.run;

import com.kh.chap02_trycatch.controller.TryCatchController;
import com.kh.chap04_UserException.conrtroller.UserExceptionController;

public class Run {
	public static void main(String[] args) {
//		new TryCatchController().method1();
//		new TryCatchController().method2();
//		new TryCatchController().method3();
		new UserExceptionController().method();
	}
}
