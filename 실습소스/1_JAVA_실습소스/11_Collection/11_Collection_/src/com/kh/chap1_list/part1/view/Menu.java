package com.kh.chap1_list.part1.view;

import java.util.Scanner;

import com.kh.chap1_list.part1.controller.StudentController;
import com.kh.chap1_list.part1.model.vo.Student;

// MVC model 2 ���� view�� �ǹ� :
/*	-> �����(Ŭ���̾�Ʈ)�� ���� ��û�� �ް� ������ �����ִ� 
 * 	���������� ����ڿ� �����ϴ� �κ� 
 * */
// CharacterUI == TerminalUI == CommandLI

public class Menu {
	private Scanner sc = new Scanner(System.in);
//	private ObjectArrayController Con = new ObjectArrayController();
	private StudentController Con = new StudentController();
	
	public void display() {
		int sel = 0; // �Է¹��� �޴� ��ȣ�� ������ ���� ����
		
		do {
			System.out.println("=== �л� ���� ���α׷� ===");
			System.out.println("1. �л� �߰�");
			System.out.println("2. ��ü ��ȸ");
			System.out.println("3. �л� ����");
			System.out.println("0. ���α׷� ����");			
			System.out.print("�޴� ���� --> ");
			sel = sc.nextInt();
			sc.nextLine(); // ���ۿ� ���� �ִ� �ٹٲ� ���� ����
			
			switch(sel) {
			case 1 : {
				insertStudent();
				break;
			}
			case 2 : {
				printStudent();
				break;
			}
			case 3 : {
				removeStudent();
				break;
			}
			case 0 : {
				System.out.println("���α׷� ���� ");
				break;
			}
			default : {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
			}
			
		}while(sel != 0);
		
	}
	private void insertStudent()	{
		System.out.println("[�л� �߰�]");
		System.out.print(" �̸� : ");
		String name = sc.nextLine();
		System.out.print("���� : ");
		int score = sc.nextInt();
		sc.nextLine();
		
		// �л� ��ü�� �������ڸ��� �ش� ��ü�� �ּҸ�
		// ObjectArrayController �� insertArray()�� ����
		Con.insertStudent(new Student(name,score));
		
	}
	
	private void printStudent()	{
		System.out.println("[��ü �л� ���� ���]");
		Con.printStudent();
	}
	
	// �л� ���� �޼ҵ� 
	// �Է¹��� �ε����� �ش��ϴ� �л� ��ü�� ����
	private void removeStudent()	{
		System.out.println("[�л�����]");
		System.out.print("�ε��� �Է� : ");
		int index = sc.nextInt();
		sc.nextLine();
		Con.removeStudent(index);
	}
	
	
}
