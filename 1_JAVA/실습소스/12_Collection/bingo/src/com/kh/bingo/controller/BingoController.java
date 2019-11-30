package com.kh.bingo.controller;

import java.util.HashMap;
import java.util.Map;

public class BingoController {	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public Map<Integer, Integer> bingoboard(int size) {
		
		// size 는  입력받은 크기  // 입력 : 5
		int key = size*size; // 키 갯수 : 25
		int value ; // 25 
//		int flag = 0;
		// for문으로 키값 만들기
		// map은 기본자료형 저장 불가
		for(int i=0;i<key;i++) {
			// 난수 중복제거 필요	
			value = (int)(Math.random()*99+1);// 우선은 최대값 100까지
			// value : 난수 -> int -> integer
			// key: int -> integer
			Integer.toString(i);
				// map put
				map.put(i, ((Integer)value));
		}
		return map;
	}
	public Map<Integer, Integer> bingoX(int num){
		map.keySet().iterator();
		// 입력받은 num 값 == key에 해당하는 map의 value 면
		// 해당 key값의 value로 X 넣기
		
		
		return map;
	}
}
