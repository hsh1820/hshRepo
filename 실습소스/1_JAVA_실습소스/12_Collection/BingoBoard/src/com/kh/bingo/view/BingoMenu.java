package com.kh.bingo.view;

import java.util.Map;
import java.util.Scanner;

import com.kh.bingo.controller.BingoController;

public class BingoMenu {
	private Scanner sc = new Scanner(System.in);
	private BingoController bc = new BingoController();
	
	public void mainMenu() {
		int sel= 0;
		do {
			System.out.println("========== ���� ���� ==========");
			System.out.println("1. ���� ����");
			System.out.println("0. ����");
			
			System.out.print("�޴� ���� : ");
			sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
			case 1 : initGame(); break;
			case 2 : System.out.println("���� ����"); break;
			default : System.out.println("�ٽ� �Է��� �ּ���.");
			}
			
			System.out.println();
		}while(sel != 0);
	}

	// ���� ���� �� ���� �޼ҵ�
	private void initGame() {
		
		// ���� ũ�� �Է�
		System.out.print("���� ũ�� �Է� ( ex. 5X5 ���� --> 5) : ");
		int bingoSize = sc.nextInt();
		
		// ���� �¸� ��ǥ �Է�
		System.out.print("�¸� ��ǥ (���� ����) : ");
		int goal = sc.nextInt();
		sc.nextLine();
		
		// ������ ���� 
		bc.setBingo(bingoSize, goal);
		
		// ������ ���
		printBingo(bc.getBingo());
		
		
		// ���� ���� �޼ҵ� ���
		startGame();
	}
	
	// ������ ��� �޼ҵ�
	private void printBingo(Map<String,String> bingoBoard) {
		
		int i=1;
		System.out.println();
		for(String s : bingoBoard.keySet()) {
			
			System.out.printf("%4s",bingoBoard.get(s));
			if(i % Math.sqrt(bingoBoard.size()) == 0){
				System.out.println();
			}
			i++;
		}
	}
	
	
	// ���� ���� �޼ҵ�
	private void startGame() {
		String input = null;
		
		while(true) {
			System.out.println();
			System.out.print("���ڸ� �Է��ϼ��� : ");
			input = sc.nextLine();
			
			// �Է� ���� ���� �ش� �ϴ� �κ��� "X"�� �����ϰ� ���� ���� ��ȯ �ޱ�
			int bingoCount = bc.checkBingo(input);
			for(int i=0; i<10 ; i++) System.out.println();
			printBingo(bc.getBingo());
			
			// ���� ���� ���
			System.out.println();
			System.out.println("���� ���� �� : " + bingoCount);
			
			// ���� ������ �¸� ��ǥ�� ���� ������ "Bingo!!" ������ ���� �������� �̵�
			if(bingoCount == BingoController.goal) {
				System.out.println("Bingo!!");
				break;
			}
		}
	}
}	
