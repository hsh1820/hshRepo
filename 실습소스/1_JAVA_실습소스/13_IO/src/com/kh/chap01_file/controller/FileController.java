package com.kh.chap01_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method1() {
		try {
			// 1. ���� ������Ʈ�� test.txt ���� �����ϱ�
			File f1 = new File("test.txt");
			// --> f1 : �������� ���� ���������� �����Ѵٰ� ������ ����
			// test.txt�� �޸𸮿� �������� ������ ����
			// ������ ��θ� �������� ������ ������Ʈ ���� �ֻ�ܿ� ���� ����
			
			f1.createNewFile();// �ش� �޼ҵ尡 ����Ǿ� ���� ������
			// checked exception�� IOException �߻�
			// try-catch �� �ʿ�
			
			// 2. ������ �����ϴ� ������ ������ ����
			File f2 = new File("C:\\dev\\test.txt");
			// \ --> 1���� ���� �̽����������ڷ� �ν���
			
			f2.createNewFile();
			
			//3. ������ ���� ������ ���� ���� -- ������ ��θ� ã�� �� �����ϴ�. ���� �߻�
//			File f3 = new File("c:\\dev\\temp\\test.txt");
			
//			f3.createNewFile();
			// -> ���� ��ο��� ���� ���� �Ұ���(IOException �߻�)
			
			// ���� ����
			File f3 = new File("c:\\dev\\temp\\t1");
			f3.mkdir(); // ���� ���� �޼ҵ�
			// mkdir() : �������� ���� �Ұ� .
			// �������� ���� ������ mkdirs()
			
			File f4 = new File("c:\\dev\\temp\\test.txt");
			f4.createNewFile();
			
			File f5 = new File("c:\\dev\\temp2\\test"); 
			f5.mkdirs();// ���������� �����ǰ� txt������ ���� �ȵ�			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void method2() {
		// c:\\dev\\temp3 ������ �ִ��� �˻� �� ������ �����ϰ�
		// temp3 ������ person.txt �� ����
		// ==> ���� ���� �� �޼��� ���
			File folder = new File("c:\\dev\\temp3");
			if(!folder.exists()) { // temp3 ������ �������� �ʴ´ٸ�
				folder.mkdir();// ���� ����
				// mkdir(), mkdirs() : � �ü������ ��� �����ϴ� ��ɾ��̱⶧���� 
				// Exception ó�� �ʿ� ����
				System.out.println(folder.getName()+ " ������ ���� �Ͽ����ϴ�.");
		}
			try {
				File file = new File("c:\\dev\\temp3\\person.txt");
				if(file.createNewFile()) { // person.txt ���� ���� ��
					System.out.println(file.getName() + " ������ �����Ͽ����ϴ�.");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
