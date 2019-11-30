package com.kh.chap1_list.practice.view;

import java.util.Scanner;

import com.kh.chap1_list.practice.controller.MusicController;
import com.kh.chap1_list.practice.model.vo.Music;

public  class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public  void mainMenu() {
		int sel = 0;
		
		do {
			System.out.println(
					"******* ���� �޴� *******\n" + 
					"1. ������ ��ġ�� �� �߰� \n" + 
					"2. ù ��ġ�� �� �߰� \n" + 
					"3. ��ü �� ��� ��� \n" + 
					"4. Ư�� �� �˻� \n" + 
					"5. Ư�� �� ���� \n" + 
					"6. Ư�� �� ���� ���� \n" + 
					"7. ��� �������� ���� \n" + 
					"8. ������ �������� ����\n" + 
					"9. ����"  );
			System.out.print("�޴� ��ȣ ���� : ");
			sel = sc.nextInt();
			
			
			switch(sel) {
			case 1 : addList(); break;				
			case 2 : addAtZero(); break;				
			case 3 : printAll(); break;				
			case 4 : searchMusic();break;				
			case 5 : removeMusic();break;				
			case 6 : setMusic();break;				
			case 7 : ascTitle(); break;				
			case 8 : descSinger();break;				
			case 9 : System.out.println("���α׷� ����");break;				
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");				
			}
			
		}while(sel !=9);
		
	}
	public void addList() {
		//1. ������ ��ġ�� �� �߰�
		sc.nextLine();
		System.out.println("****** ������ ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();		
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		
		
		boolean result = mc.addList(new Music(title, singer));
		if(result = true) {
			System.out.println("�߰� ����");
		}else {
			System.out.println("�߰� ����");
		}
		
	}
	public void addAtZero() { 
		//add(index, e element) 
		sc.nextLine();
		System.out.println("****** ù ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		
		int result = mc.addAtZero(new Music(title, singer));
		
		if(result==1){
			System.out.println("�߰� ����");
		}else if (result==2){
			System.out.println("�߰� ����");
		}
		
		
		// contains(Object o) return t/f 
		
		
	}
	public void printAll() {
		sc.nextLine();
		System.out.println("****** ��ü �� ��� ��� ******");
			
		mc.printAll();
		
		
	}
	public void searchMusic() {
		sc.nextLine();
		System.out.println("****** Ư�� �� �˻� ******");
		System.out.print("�˻��� �� �� : ");
		String title = sc.nextLine();
		
		Music mc2 = mc.searchMusic(title) ;
		if( mc2 == null ) {
			System.out.println(title + "�̶�� ���� �����ϴ�.");
		}else {			
			System.out.println(mc2);
		}
			
		
		
	}
	public void removeMusic() {
		sc.nextLine();
		System.out.println("****** Ư�� �� �˻� ******");
		System.out.print("������ �� �� : ");
		String title = sc.nextLine();
		

			if (  mc.removeMusic(title) != null) {			
				System.out.println("��(��) �����߽��ϴ�.");			
			}
			System.out.println(title+"�̶� ���� �����ϴ�.");
		}
	
	public void setMusic() {
		sc.nextLine();
		System.out.println("****** Ư�� �� ���� ******");
		System.out.print("�˻��� �� �� : ");
		String search = sc.nextLine();
		System.out.print("������ �� �� : ");
		String edit = sc.nextLine();
		System.out.print("������ ���� �� : ");
		String singer = sc.nextLine();
		
		
		
		System.out.println( mc.setMusic(search, new Music(edit, singer))+ " �� ���� ����Ǿ����ϴ�.");
	}
	// ��������
	public void ascTitle() {
		int result = mc.ascTitle();
		if(result == 1) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
		
	}
	
	//���� ����
	public void descSinger() {
		// ����Ʈ ���� �� �������� ����, 1 ����
		if(mc.descSinger() == 1) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
	}
}
