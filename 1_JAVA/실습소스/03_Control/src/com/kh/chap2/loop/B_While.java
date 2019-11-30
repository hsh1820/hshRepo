package com.kh.chap2.loop;

import java.util.Scanner;

public class B_While {
	Scanner sc = new Scanner(System.in);
	
	// 1. �ܵ� while��
	public void method1() {
		int i = 1; // �ʱ��
		
		while(i <= 10) { // ���ǽ�
			// while���� ���ǽ��� true�� ��� �ݺ��� ������
			System.out.println(i+" ���");
			
			i++; // ������
		}//System.out.println();
		
		// for��
		for(int j = 1; j<=10;j++) {
			System.out.println(j+" ���");
		}
	}
	
	public void method2() {
		// 10 ~ 1 ���� ���� ���
		int i = 10;
		
		while(i>0) { // i>=1
			System.out.println(i + " ���");
			i--;
		}
		
		for(int j =10 ; j>0 ; j-- )
			System.out.println(j + " ���");
		
		
		
	}

	public void method3() {
		// ���� 0�� �Էµ� �� ����
		// �Է¹��� ��� ���� ���Ͽ� ��� ���
		
		int input = -1; // �Է¹��� ������ ������ ����
		int sum = 0; // ������ ���� ������ ����
		
		while(input != 0) {
			
			System.out.print("�Է� : ");
			input = sc.nextInt();
			sum += input;
		}
		System.out.println("���� : " + sum);
	}
	
	public void method4() {
		// ���� 0�� �Էµ� �� ����
		// �Է¹��� ��� ���� ���Ͽ� ��� ���

		int input = 0; // �Է¹��� ������ ������ ����
		int sum = 0; // ������ ���� ������ ����
		boolean check = true; // �ݺ����� �ݺ� ���θ� ������ ���� ����
		
		while(check) { /* ���ǽ��� ��� ����� true/false */
			System.out.print("�Է� : ");
			input = sc.nextInt();
			
			if(input == 0) { // �Է°��� 0�̸�
				check = false;
				// �ݺ��� ���Ḧ ���� check ���� false�� ����
				
			}else {
				sum += input;
			}
		}
		System.out.println("���� : " + sum);
	}
	
	
	// ��ø while ��
	// ���ǻ���!
	// - while�� �ϳ������ε� ���ѷ����� ���ɼ��� �ٺ���
	// - while���� ��ø�ؼ� ����ϴ� ���
	//   ���ѷ����� ���輺�� �þ
	// --> while���� �������� ���� ���� ���������� Ȯ���� ��Ÿ�� �� �ִ� ��쿡�� ���
	
	public void method5() {
		
		// method3() do ~ while �������� ����
		
		int input = -1;
		int sum = 0;
		
		do {
			System.out.print("�Է� : ");
			input = sc.nextInt();
			sum += input;
			
		}while(input != 0);
		// do ~ while ���� while�� ������ ������ �����ݷ� (;) 
		// �ݵ�� �߰� 
		
		System.out.println("���� : " + sum);
	}
	
	
	public void method6() {
		// Ű����� �Է��� ���ڿ��� ��� �� �������� ����� ���
		// ��, exit �Է� �� ����.
		
		String str =""; // �Է�
		// �������� �ֵ� �������� �����ʹ� ����
		//		String str =null; // ������ ����ִ�. == �����ϴ� ���� ����. 
		//		String str;    	  // str ������ �� ������. 
		
		String sen = ""; // �Է¹��� ���ڿ� �������� ��ġ�� ����

		do {
			System.out.print("���ڿ� �Է� : ");
			str = sc.nextLine();
			if (!str.equals("exit")) {
				sen += (str+" ");
			}
			
		}while(!str.equals("exit")); // exit
		
		System.out.println(sen);
	}
	
	public void method7() {
		// do ~ while �� �̿��Ͽ� �޴�ȭ�� �����ϱ�
		int input = 0;
		
		do {
				System.out.println("1. �޼ҵ� 1 ����");
				System.out.println("2. �޼ҵ� 2 ����");
				System.out.println("3. �޼ҵ� 3 ����");
				System.out.println("4. �޼ҵ� 4 ����");
				System.out.println("5. �޼ҵ� 5 ����");
				System.out.println("6. �޼ҵ� 6 ����");
				System.out.println("0. ����");
				System.out.print("�޴� ���� ==> ");
				input = sc.nextInt();
				
				switch(input) {
				case 1 : method1(); break;
				case 2 : method2(); break;
				case 3 : method3(); break;
				case 4 : method4(); break;
				case 5 : method5(); break;
				case 6 : method6(); break;
				case 0 : System.out.println("���α׷��� �����մϴ�."); break;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
				
		} while(input!=0);
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
