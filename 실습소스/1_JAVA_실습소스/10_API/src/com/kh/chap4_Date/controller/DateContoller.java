package com.kh.chap4_Date.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateContoller {
	public void method1() {
		
		// 현재 날짜, 시간 출력
		// -> Date() 기본생성자를 이용하여 객체를 생성
		
		// Date() 기본 생성자 : 
		// 객체가 생성된 가장 가까운 밀리 초 단위로 초기화 
		// 1ms = 1/1000s
		
		
		// (우리나라 한정)
		// java는 1970년 1월 1일 오전 9시 0분 0초를 기준으로
		// 시간을 ms 단위로 계산
		Date today = new Date();
		System.out.println("현재 시간 : " + today);
		
		// 기준시간 출력
		Date standard = new Date(0L);
		System.out.println("기준 시간 : "+ standard);
		
		// 날짜 출력 형태 지정
		SimpleDateFormat fmt = new SimpleDateFormat("G yyyy년 MM월 dd일 E요일 hh시 mm분 ss초");
		// 서기 2019년 11월 6일 수요일 3시 36분 50초
		
		String str = fmt.format(today);
		
		System.out.println(str);
		
		
		
	}
}
