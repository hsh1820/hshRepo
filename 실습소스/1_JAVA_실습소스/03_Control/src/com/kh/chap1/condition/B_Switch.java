package com.kh.chap1.condition;

import java.util.Scanner;

public class B_Switch {
	
	// switch ���� if - else if  - else �� ����� ���ǹ���.
	// ��, ������ ������ ������ �� ����.
	// input > 10 (X)
	
	/*
	 * switch �� ǥ����
	 * 
	 * switch(���ǽ�) {
	 * case ��1 : �����ڵ�1; break;
	 * case ��2 : �����ڵ�2; break;
	 * case ��3 : �����ڵ�3; break;
	 * ...
	 * default : �����ڵ�;
	 * }
	 * 
	 * switch ���� ���ǽ�
	 * --> if�� ó�� ����� true/false�� �ƴ�
	 * 		���� �񱳰� �Ǵ� ���� �ۼ�
	 *
	 * */
	public void method1() {
		// ������ �Է¹޾�
		// 1�̸� "1�� �Դϴ�."
		// 2�̸� "2�� �Դϴ�."
		// 3�̸� "3�� �Դϴ�."
		// �߸� �Է��� ��� "�߸� �Է��ϼ̽��ϴ�."
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int input = sc.nextInt();
		
		switch(input) {
			case 1: {
				System.out.print(input + "�� �Դϴ�.");
				//break;
			}
			case 2: {
				System.out.print(input + "�� �Դϴ�.");
				break;
			}
			case 3: {
				System.out.print(input + "�� �Դϴ�.");
				break;
			}
			default : System.out.print("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		
		
		
		
		
		
		
		
	}

	public void method2() {
		// switch ���� �̿��� ���� �ο�
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �ۼ��� �ּ���.: ");
		// ������, �Ŵ���, ȸ��
		
		String grade = sc.nextLine();
		
		switch(grade) {
		case "������" : System.out.println("����");
		case "�Ŵ���" : System.out.println("���");
		case "ȸ��" : System.out.println("��ȸ"); break;
		
		default : System.out.println("�߸� �Է���");
		
		}
			
		
		}
		
	public void method3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12�� �� �ϳ��� �Է��� �ּ��� : ");
		int month = sc.nextInt();
		
		String season="";
		
			switch(month) {
			case 3:
			case 4:
			case 5: {
				season = "��";
				break;
				}
			case 6:
			case 7:
			case 8: {
				season = "����";
				break;
				}
			case 9:
			case 10:
			case 11: {
				season = "����";
				break;
				}
			case 12:
			case 1:
			case 2: {
				season = "�ܿ�";
				break;
				}
			default : {
				System.out.print("�ش��ϴ� ������ �����ϴ�.");
			}
			System.out.print(season);
		}		
		
	}
		
	public void method4( ) {
		//1~12������ �Է¹޾�
		// �ش��ϴ� ���� �ϼ��� ����ϼ���.(switch�� ���)
		/*
		 * ex)
		 * �� �Է� : 10
		 * 10���� 31�� �Դϴ�.
		 * 
		 * �� �Է� : 4
		 * 4���� 30�� �Դϴ�.
		 * 
		 * �� �Է� : 15
		 * �߸� �Է��ϼ̽��ϴ�.
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
				
		System.out.print("�� �Է� : ");
		int month = sc.nextInt();
		int day=0;
		
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				day =31;
				System.out.println(month + "���� "+ day + "�� �Դϴ�.");
				break;
			case 2:
				day =28;
				System.out.println(month + "���� "+ day  + "�� �Ǵ� "+ (day+1) + "�� �Դϴ�.");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				day =30;
				System.out.println(month + "���� "+ day + "�� �Դϴ�.");
				break;
			default : {
				System.out.print("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
