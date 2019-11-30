package com.kh.chap3_map.practice.view;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.chap3_map.controller.MemberController;
import com.kh.chap3_map.model.vo.Member;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	//	����ڰ� ���� ���� �޴��� ����
	//	�� �� ����. ���� ������ �ݺ� ��
	//	��. �� �޴��� ���� �� �ش� �޼�
	//	��� �̵�
	public void mainMenu() {
		while(true) {
		System.out.println("========== KH ����Ʈ ==========");
		System.out.println("=====***** ���� �޴� *****=====\n" + 
				"1. ȸ������\n" + 
				"2. �α���\n" + 
				"3. ���� �̸� ȸ�� ã��\n" + 
				"9. ����\n");
		System.out.print("�޴� ��ȣ �Է� : ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		// �޴� ȭ�� �ݺ� ���� ó��
		// �� �� �Է� �Ͽ��� ��� "�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���" ��� �� �ݺ�
		
			switch(menu) {
			case 1 : joinMembership();break;
			case 2 : logIn(); memberMenu(); break;
			case 3 : sameName();break;
			case 9 : System.out.print("���α׷� ����.");return;
			default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");continue;
			}
		}
	}
	public void memberMenu() {
		while(true) {
		System.out.println("=====***** ȸ�� �޴� *****=====\n" + 
				"1. ��й�ȣ �ٲٱ�\n" + 
				"2. �̸� �ٲٱ�\n" + 
				"3. �α׾ƿ�\n");
		
		System.out.print("�޴� ��ȣ �Է� : ");
		int submenu = sc.nextInt();
		sc.nextLine();
		
		switch(submenu) {
		case 1 : changePassword();break;
		case 2 : changeName();break;
		case 3 : System.out.println("�α׾ƿ� �Ǿ����ϴ�.");mainMenu();return;
		default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");continue;
			}
		}
	}
	public void joinMembership() {
	//		ȸ�������ϱ� ���� ���̵�, ��й�ȣ, �̸��� �ް� ��й�ȣ�� �̸���
	//		Member��ü�� ��� id�� ��ü�� MemberController�� joinMembership()�� ����.
	//		���� ����� ���� true�� ������������ ȸ������ �Ϸ��Ͽ����ϴ�.��,
	//		false�� ���ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.�� ���
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			
			Member m = new Member(password, name);
			
			boolean result = mc.joinMembership(id, m);
			
			if( result == true) {
				System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�.");return;
			}System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");continue;
		}
	}
	public void logIn() {
	//		���̵�� ��й�ȣ�� ����ڿ��� �޾� MemberController�� logIn()�޼ҵ�� �Ѱ� ��.
	//		��ȯ �� ������ ��OOO��, ȯ���մϴ�!�� ��� �� �α��� �� ȭ������(memberMenu()),
	//		������ ��Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			
			String result = mc.login(id, password);
			
			if(result != null) {
				System.out.println(result +"��, ȯ���մϴ�!");
				memberMenu();return;
			}System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ �Դϴ�. �ٽ� �Է����ּ���.");continue;
		}
	}
	public void changePassword() {
	//		���̵�� ��й�ȣ, ������ ��й�ȣ�� �޾� MemberController��
	//		changePassword()�� ����.
	//		���� ��� ���� true�� ����й�ȣ ���濡 �����߽��ϴ�.��,
	//		false�� ����й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("���� ��й�ȣ : ");
			String oldPw = sc.nextLine();
			System.out.print("���ο� ��й�ȣ : ");
			String newPw = sc.nextLine();
			
			boolean result = mc.changePassword(id, oldPw, newPw);
			
			if(result == true) {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");break;
			}else{
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");continue;
			}
		}
	}
	public void changeName() {
	//		���̵�� ��й�ȣ�� �޾� MemberController�� logIn()���� �Ѱ�
	//		���� ����Ǿ� �ִ� �̸��� �ް�
	//		����ڿ��� ���� ����Ǿ� �ִ� �̸��� ����Ͽ� ������.
	//		������ �̸��� �޾� MemberController�� chageName()�� id�� �Բ� �ѱ��
	//		���̸� ���濡 �����Ͽ����ϴ�.�� ���
	//		���� logIn()�κ��� ����Ǿ� �ִ� �̸��� ���� �� �ߴٸ�
	//		���̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ��䡱 ��� �� �ݺ�
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			
			String name = mc.login(id, password);
			if(name != null) {
				System.out.println("���� ������ �̸� : "+ name );
				
				System.out.print("������ �̸�  : ");
				String newName = sc.nextLine();
				
				mc.changeName(id, newName);
				break;
			}else {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
		}

	}
	public void sameName() {
	//		�˻��� �̸��� �ް� mc�� sameName()�޼ҵ�� �ѱ�.
	//		��ȯ ���� ������ entrySet()�� �̿��Ͽ� ���̸�-���̵� �������� ���
		
		System.out.print("�˻��� �̸� : ");
		String name = sc.nextLine();
		
		
		
		for(Map.Entry<String, String> entry : mc.sameName(name).entrySet()) {
			System.out.println("["+entry.getValue()+" - "+entry.getKey()+"]");
		}

	}
}
