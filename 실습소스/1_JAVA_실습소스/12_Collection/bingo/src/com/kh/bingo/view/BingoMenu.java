package com.kh.bingo.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.kh.bingo.controller.BingoController;

public class BingoMenu {
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("========== 빙고 게임 ==========");
		System.out.println("1. 게임 시작");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		switch(menu) {
			case 1 : startBingo(); break;
			case 0 : return;
		}
	}
	
	public void startBingo() {
		//빙고 크기 입력 ( ex. 5X5 빙고 --> 5) : 5
		System.out.print("빙고 크기 입력  ( ex. 5X5 빙고 --> 5) : ");
		int size = sc.nextInt();
		System.out.print("승리 목표 (빙고 개수) : ");
		int goal = sc.nextInt();
		sc.nextLine();
		
//		  18  17  15   6   8
//		  25  22  23  16  11
//		   7   5   1  10  19
//		  14  21   9   3   4
//		  24  20  13  12   2
//        출력
		BingoController bc = new BingoController();
		// size크기의 빙고판 map 으로 가져오기
		Map<Integer, Integer> board = new HashMap<Integer, Integer>();
		board.putAll(bc.bingoboard(size));
		
		
		// keyset, for{} / iterator로 가져오기
		 
		// map,set 안에 iterator 가 있는거
		// iterator 써야함		// 출력 라인 수정필요
		Iterator<Integer> it = board.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			if((key.intValue()%size ==0 )) {				
				System.out.println();						
			}
			System.out.printf("%3d",board.get(key));
		}
		// 빙고수 count 
		int bingo = 0;
		System.out.println();
		System.out.print("\n현재 빙고 수 : "+ bingo);  
		
		System.out.println();
		System.out.print("\n숫자를 입력하세요 : ");
		int num = sc.nextInt();		
		sc.nextLine();
		// X 를 치는 구문
		// KEYSET이랑 MAP 안에 있는 값 같으면 값 덮어쓰기 
		bc.bingoX(num).keySet().iterator();
		
		//x있는 판 출력 
		
	}
}
