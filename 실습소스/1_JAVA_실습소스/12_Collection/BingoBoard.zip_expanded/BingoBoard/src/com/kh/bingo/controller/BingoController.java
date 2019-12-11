package com.kh.bingo.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BingoController {
	
	private Map<String, String> bingoBoard;
	private int bingoSize;
	public static int goal; 
	
	
	// ������ ũ�� ���� ��  �¸� ��ǥ ����
	public void setBingo(int bingoSize, int goal) {
		
		// ���ο� �������� ������ LinkedHashMap ��ü ����
		// * LinkedHashMap : �߰��Ǵ� ������ �����ϴ� Map
		bingoBoard = new LinkedHashMap<String, String>();
		
		// �Ű������� �������� ũ��
		this.bingoSize = bingoSize;
		this.goal = goal;
		
		// ������ ���� �޼ҵ� ȣ��
		createBingo();
	}
	
	public Map<String, String> getBingo(){
		// ������ ���� ����
		return bingoBoard;
	}
	
	// ������ ����
	public void createBingo() {
		int random = 0;
		for(int i=0 ; i<bingoSize * bingoSize; ) {
			
			random = (int)(Math.random() * (bingoSize * bingoSize) + 1);
			if(bingoBoard.put(""+ random, ""+ random) == null){
				i++;
			}
		}
	}
	
	// �����ǿ� �Էµ� ���� üũ
	// ������ ���� ���� ��ȯ
	public int checkBingo(String input) {
		
		// �Էµ� ���� �����ǿ� ���� ��� "X"�� ����
		if(bingoBoard.containsKey(input)) {
			bingoBoard.replace(input, "X");
		}
		
		// Map�� ����� value ���鸸�� ArrayList��ü�� ��ȯ
		List<String> list = new ArrayList<String>(bingoBoard.values());
		
		boolean rowCheck = true; // ���� ���� ���� �Ǵ�
		boolean colCheck = true; // ���� ���� ���� �Ǵ�
		int bingoCount = 0;
		
		boolean diaCheck1 = true; //�»� ����(\) �밢�� ���� ���� �Ǵ�
		boolean diaCheck2 = true; //��� ����(/) �밢�� ���� ���� �Ǵ�
		
		for(int i=0 ; i<bingoSize; i++) {
			// ���� ���� üũ
			rowCheck = true;
			for(int j=i*bingoSize; j<(i+1)*bingoSize ; j++) {
				if(!list.get(j).equals("X")) {
					rowCheck = false;
					break;
				}
			}
			if(rowCheck) bingoCount++;

			
			
			// ���� ���� üũ
			colCheck = true;
			for(int k=i; k<list.size() ; k+=bingoSize) {
				if(!list.get(k).equals("X")) {
					colCheck = false;
					break;
				}
			}
			if(colCheck) bingoCount++;
						
			
			// �»� ����(\) �밢�� ���� üũ
			if(!list.get(i + (bingoSize * i) ).equals("X")) {
				diaCheck1 = false;
			}
			
			// ��� ����(/) �밢�� ���� üũ
			if(!list.get(bingoSize * i + (bingoSize - 1 - i)).equals("X")) {
				diaCheck2 = false;
			}
		}
		
		if(diaCheck1) bingoCount++;
		if(diaCheck2) bingoCount++;
		
		return bingoCount;
	}
}
