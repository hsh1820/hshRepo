package com.kh.chap1_poly.practice.view;

import java.util.Scanner;

import com.kh.chap1_poly.practice.controller.LibraryController;
import com.kh.chap1_poly.practice.model.vo.Book;
import com.kh.chap1_poly.practice.model.vo.Member;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		//public void mainMenu() {
//		// �̸�, ����, ������ Ű����� �Է� ���� �� Member ��ü ����
//		// LibraryController�� insertMember() �޼ҵ忡 ����
//		==== �޴� ==== // ���� �ݺ� ����
//		1. ���������� // LibraryController�� myInfo() ȣ���Ͽ� ���
//		2. ���� ��ü ��ȸ // LibraryMenu�� selectAll() ȣ��
//		3. ���� �˻� // LibraryMenu�� searchBook() ȣ��
//		4. ���� �뿩�ϱ� // LibraryMenu�� rentBook() ȣ��
//		9. ���α׷� �����ϱ�
//		�޴� ��ȣ :
//		}
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���� : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("����  : ");
		char gender = sc.next().charAt(0);
		
		Member mem = new Member(name, age, gender);
		lc.insertMember(mem);
		
		while(true) {
		System.out.println("==== �޴� ====");
		System.out.println("1. ����������");
		System.out.println("2. ���� ��ü ��ȸ");
		System.out.println("3. ���� �˻�");
		System.out.println("4. ���� �뿩�ϱ�");
		System.out.println("9. ���α׷� �����ϱ�");
		System.out.print("�޴� ��ȣ : ");
		
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1 : {
				
				System.out.println(lc.myInfo().toString());
				break;
			}
			case 2: {
				selectAll();
				break;
			}
			case 3:{
				searchBook();
				break;
				
			}
			case 4: {
				// �뿩������ ������� ���
				rentBook();
				break;
			}
			case 9 : {
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
				
		}
	}
}
	public void selectAll() {
		
		Book[] bList = lc.selectAll();
		
		for(int i=0;i<bList.length;i++) {
			System.out.println(i+"�� ���� : "+ bList[i]);
//			ex ) 0������ : �������� ���� / ������ / tvN / true
		}
	}
	public void searchBook() {
		sc.nextLine();
		System.out.print( "�˻��� Ű���� : ");
		String keyword = sc.nextLine();
		
		
		Book[] searchList =  lc.searchBook(keyword);
		
		for(int i = 0;i<searchList.length;i++) {
			if(searchList[i] != null)
			System.out.println(searchList[i]);
		}
		
	}
	public void rentBook() {
		for(int i=0;i<lc.selectAll().length;i++) {
			System.out.println(i+"�� ���� : "+ lc.selectAll()[i]);
		}
		
		System.out.print("�뿩�� ���� ��ȣ ���� : ");
		int index = sc.nextInt();
		int result = lc.rentBook(index);
		
		if(index == 0) {
			System.out.println("���������� �뿩�Ǿ����ϴ�.");
		}else if(index == 1) {
			System.out.println("���� �������� �뿩 �Ұ����Դϴ�.");
		}else if(index == 2) {
			System.out.println("���������� �뿩�Ǿ����ϴ�. �丮�п� ������ �߱޵Ǿ����� �������������� Ȯ���ϼ���.");
		}
		
	}
	
}
