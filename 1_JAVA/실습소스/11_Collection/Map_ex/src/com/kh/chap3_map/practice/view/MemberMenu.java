package com.kh.chap3_map.practice.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.chap3_map.practice.controller.MemberController;
import com.kh.chap3_map.practice.model.vo.Member;

public class MemberMenu {
	private  Scanner sc = new Scanner(System.in);
	private MemberController mc 	= new MemberController();
	
	public void mainMenu() {
		//		******* ���� �޴� *******
		//		1. ȸ������ // joinMembership() ����
		//		2. �α��� // logIn() ���� �� memberMenu() ����
		//		3. ���� �̸� ȸ�� ã�� // sameName()
		//		9. ���� // �����α׷� ����.�� ��� �� main()���� ����
		//		�޴� ��ȣ ���� : >> �Է� ����
		//		// �޴� ȭ�� �ݺ� ���� ó��
		//		// �� �� �Է� �Ͽ��� ��� "�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���" ��� �� �ݺ�
		while(true) {
		System.out.println("========== KH ����Ʈ ==========");
		System.out.println("=====***** ���� �޴� *****=====\n" + 
				"1. ȸ������\n" + 
				"2. �α���\n" + 
				"3. ���� �̸� ȸ�� ã��\n" +
				"4. ȸ�� �ּ� �������� ����\n"+
				"9. ����");
		System.out.print("�޴� ��ȣ �Է� : ");
		int menu = sc.nextInt()	;
		
		sc.nextLine();
		
			switch(menu) {
			case 1 : joinMembership();break;
			case 2 : logIn();break;
			case 3 : sameName();break;
			case 4 : ascAddress();break;
			case 9 : System.out.println("���α׷� ����.");return;		
			default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");			
			
			}
		}
	}
	public void memberMenu() {
		System.out.println("=====***** ȸ�� �޴� *****=====\n" + 
				"1. ��й�ȣ �ٲٱ�\n" + 
				"2. �̸� �ٲٱ�\n" + 
				"3. �α׾ƿ�");
		System.out.print("�޴� ��ȣ �Է� : ");
		int submenu = sc.nextInt()	;
		sc.nextLine();
		
		while(true) { 
		switch(submenu) {
		case 1 : {
			changePassword();
			break;
		}
		case 2 : {
			changeName();
			break;
		}
		case 3 : {
			System.out.println("�α׾ƿ� �Ǿ����ϴ�");			
			break;
		}
		default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���");		
			}
		break;
		}
		
	}
	public void joinMembership() {
	//		ȸ�������ϱ� ���� ���̵�, ��й�ȣ, �̸��� �ް� ��й�ȣ�� �̸���
	//		Member��ü�� ��� id�� ��ü�� MemberController�� joinMembership()�� ����.
	//		���� ����� ���� true�� ������������ ȸ������ �Ϸ��Ͽ����ϴ�.��,
	//		false�� ���ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.�� ���
		System.out.print("���̵� : " );
		String id = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String pw = sc.nextLine();
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("�ּ� : ");
		String address = sc.nextLine();
		
		Member m = new Member(name, pw, address);
		
		
		if(mc.joinMembership(id,m)) {
			System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�."); 
		}else {
			System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
		}
	}
	public void logIn() {
	//		���̵�� ��й�ȣ�� ����ڿ��� �޾� MemberController�� logIn()�޼ҵ�� �Ѱ� ��.
	//		��ȯ �� ������ ��OOO��, ȯ���մϴ�!�� ��� �� �α��� �� ȭ������(memberMenu()),
	//		������ ��Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�
		while(true) {
		System.out.print("���̵� : " );
		String id = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String pw = sc.nextLine();
		
		String name = mc.logIn(id, pw); 
		
		if (name != null) {
			System.out.println( name + "��, ȯ���մϴ�!");
			memberMenu();
			break;
		}else {
			System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			break;
		}
		}
	}
	public void changePassword() {
		//		���̵�� ��й�ȣ, ������ ��й�ȣ�� �޾� MemberController��
		//		changePassword()�� ����.
		//		���� ��� ���� true�� ����й�ȣ ���濡 �����߽��ϴ�.��,
		//		false�� ����й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.�� ��� �� �ݺ�
		while(true) {
			System.out.print("���̵� : " );
			String id = sc.nextLine();
			System.out.print("���� ��й�ȣ : ");
			String oldPw = sc.nextLine();
			System.out.print("���ο� ��й�ȣ : ");
			String newPw = sc.nextLine();
			
			boolean result = mc.changePassword(id, oldPw, newPw); 
			
			if (result== true) {
				System.out.println( "��й�ȣ ���濡 �����߽��ϴ�.");
				memberMenu();
				break;
			}else {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");				
				break;
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
			System.out.print("���̵� : " );
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String pw = sc.nextLine();
			
			String name = mc.logIn(id, pw); 
			
			if (name != null) {
				System.out.println( "���� ������ �̸� : " + name );
				
				System.out.print( "������ �̸� : " );
				String chName = sc.nextLine();
				mc.changeName(id, chName);
				
				System.out.println( "�̸� ���濡 �����߽��ϴ�." );
				break;
			}else {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");				
				break;
			}
			}
		
	}
	public void sameName() {
	//		�˻��� �̸��� �ް� mc�� sameName()�޼ҵ�� �ѱ�.
	//		��ȯ ���� ������ entrySet()�� �̿��Ͽ� ���̸�-���̵� �������� ���
		System.out.print("�˻��� �̸� : " );
		String name = sc.nextLine();
		Map<String, String> result = mc.sameName(name); // ���� �̸� ��� map���� ��ȯ
		
//			Set<String> keySet = result.keySet(); // Ű�¹���
			
//			Set<Entry<String, String>> entryset = result.entrySet(); // ��Ʈ����
//			Iterator<Entry<String, String>> it = entryset.iterator(); // ��Ʈ������ ���ͷ�����
	//		
	//		while(it.hasNext()) { // ���ͷ����� ���
	//			Entry<String, String> entry = it.next();
	//			System.out.println("[" + entry.getValue()+" - "+entry.getKey()+"]");
	//		}
//		for(String key: keySet ) {  // ���� ���� ���
//			System.out.println("["+ result.get(key)+" - " + key + "]");
//		}
	
	}
	public void ascAddress()	{
		// ȭ�鿡 ȸ���� �ּ� �������� �����Ͽ� �ٷ� �����ֱ�		
		// [ ���̵� - �ּ� ]
		// ���̵� Ű�� ���, �ּҸ� ������. �̸��� ���̵� �������� �����ؼ� ���?
		List<Map.Entry<String, Integer>> result = mc.ascAddress(); // ���̵�� �ּҴ� ������
		
//		Set<String> keySet = result.keySet();
//		Iterator<String> it = result.iterator();
////		
//		while(it.hasNext()) {
//			String str = it.next();
//			System.out.println("["+ str + " - "+ result.get(it.next()) +"]");
//		}
//		
//		
//		
//		Iterator<String> it = result.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next()); // �ּҰ��� �ִ� list�� ����Ű�� iterator
//		}// �ּ� ������ �ǳ� ���̵��� ��������
		
		// entryset���
		
		
		
	}
}
