package com.kh.bingo.controller;

import java.util.HashMap;
import java.util.Map;

public class BingoController {	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public Map<Integer, Integer> bingoboard(int size) {
		
		// size ��  �Է¹��� ũ��  // �Է� : 5
		int key = size*size; // Ű ���� : 25
		int value ; // 25 
//		int flag = 0;
		// for������ Ű�� �����
		// map�� �⺻�ڷ��� ���� �Ұ�
		for(int i=0;i<key;i++) {
			// ���� �ߺ����� �ʿ�	
			value = (int)(Math.random()*99+1);// �켱�� �ִ밪 100����
			// value : ���� -> int -> integer
			// key: int -> integer
			Integer.toString(i);
				// map put
				map.put(i, ((Integer)value));
		}
		return map;
	}
	public Map<Integer, Integer> bingoX(int num){
		map.keySet().iterator();
		// �Է¹��� num �� == key�� �ش��ϴ� map�� value ��
		// �ش� key���� value�� X �ֱ�
		
		
		return map;
	}
}
