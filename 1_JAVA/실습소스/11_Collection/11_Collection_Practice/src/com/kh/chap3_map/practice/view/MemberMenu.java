package com.kh.chap3_map.practice.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.kh.chap3_map.practice.controller.MemberController;
import com.kh.chap3_map.practice.model.vo.Member;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========== KH ����Ʈ ==========");
		
		int menuNum = 0;
		while(menuNum != 9) {
			System.out.println("=====***** ���� �޴� *****=====");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. ���� �̸� ȸ�� ã��");
			System.out.println("9. ����");
			
			System.out.println();
			System.out.print("�޴� ��ȣ �Է� : ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: joinMembership(); break;
			case 2: logIn(); memberMenu(); break;
			case 3: sameName(); break;
			case 9: System.out.println("���α׷� ����"); return;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void memberMenu() {
		int menuNum = 0;
		while(true) {
			System.out.println("=====***** ȸ�� �޴� *****=====");
			System.out.println("1. ��й�ȣ �ٲٱ�");
			System.out.println("2. �̸� �ٲٱ�");
			System.out.println("3. �α׾ƿ�");
			
			System.out.println();
			System.out.print("�޴� ��ȣ �Է� : ");
			menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: changePassword(); break;
			case 2: changeName(); break;
			case 3: System.out.println("�α׾ƿ� �Ǿ����ϴ�."); return;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void joinMembership() {
		/*ȸ�������ϱ� ���� ���̵�, ��й�ȣ, �̸��� �ް� ��й�ȣ�� �̸���
		  Member��ü�� ��� id�� ��ü�� MemberController�� joinMembership()�� ����.
		   ���� ����� ���� true�� ������������ ȸ������ �Ϸ��Ͽ����ϴ�.��,
		  false�� ���ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.�� ���*/
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			
			Member m = new Member(password, name);
			if(mc.joinMembership(id, m)) {
				System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�.");
				break;
			} else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}
	
	public void logIn() {
		/*���̵�� ��й�ȣ�� ����ڿ��� �޾� MemberController�� logIn()�޼ҵ�� �Ѱ� ��.
		��ȯ �� ������ ��OOO��, ȯ���մϴ�!�� ��� �� �α��� �� ȭ������(memberMenu()),
		������ ��Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�*/
		
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			
			String name = mc.logIn(id, password);
			if(name != null) {
				System.out.println(name + "��, ȯ���մϴ�!");
				break;
			} else {
				System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void changePassword() {
		/*���̵�� ��й�ȣ, ������ ��й�ȣ�� �޾� MemberController��
		changePassword()�� ����.
		���� ��� ���� true�� ����й�ȣ ���濡 �����߽��ϴ�.��,
		false�� ����й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�*/
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("���� ��й�ȣ : ");
			String oldPw = sc.nextLine();
			System.out.print("���ο� ��й�ȣ : ");
			String newPw = sc.nextLine();
			
			boolean result = mc.changePassword(id, oldPw, newPw);
			if(result) {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void changeName() {
		//���� ���� id�� ���� Member�� �̸��� ���� �Է��� �̸����� ����
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();

			String name = mc.logIn(id, password);
			if(name != null) {
				System.out.println("���� ������ �̸� : " + name);
				System.out.print("������ �̸� : ");
				String newName = sc.nextLine();
				
				mc.changeName(id, newName);
				System.out.println("�̸� ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void sameName() {
		/*�˻��� �̸��� �ް� mc�� sameName()�޼ҵ�� �ѱ�.
		��ȯ ���� ������ entrySet()�� �̿��Ͽ� ���̸�-���̵� �������� ���*/
		
		System.out.print("�˻��� �̸� : ");
		String name = sc.nextLine();
		
		Map<String, String> same = mc.sameName(name);
		Set<Entry<String,String>> set = same.entrySet();
		Iterator<Entry<String,String>> it = set.iterator();
		while(it.hasNext()) {
			Entry<String,String> me = it.next();
			System.out.println(me.getValue() + "-" + me.getKey());
		}
	}
}
