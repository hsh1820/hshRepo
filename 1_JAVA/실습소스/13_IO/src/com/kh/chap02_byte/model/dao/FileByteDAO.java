package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDAO {
	//DAO (date access object)
	// -> DBMS�� �����Ͽ� ���� �����͸� �����ϰų�
	// 	��� ���� ���� �޴µ� ���Ǵ� Ŭ����
	// --> ������ input / output �� ����ϴ� Ŭ����
	
	// ����Ʈ ��� ��Ʈ�� 
	// : 1byte ������ �����͸� �Է�/����ϴ� ��Ʈ��
	
	// FileInputStream : ����Ʈ ��� ���� �Է� ��Ʈ��
	// -> ���α׷� �ܺ� ������ ����Ʈ ������ �о���� ��� ���
	public void fileOpen() {
		
		FileInputStream fis = null;
		// FileInputStream ��ü ������
		// �ٷ� ���ϰ� ���� ������ ��.
		// �ܺο� �ִ� �����͸� �о�� �� �ִ� ���°� ��
		// ���� ������ ���ٸ� FileNotFoundException �߻�
		try {
			fis = new FileInputStream("a_byte.txt");
			// ���� ���α׷��� 
			// �ܺ� �� �ִ� a_byte.txt ������ �����͸� �о��
			// FileInputStream ��ü ����(���Ḹ �Ǿ��ִ� ����)
		
			// InputStream.read()
			// ������ �����͸� 1����Ʈ �о�ͼ� ��ȯ
			// ���� ���̻� �о�� �����Ͱ� ������ -1 ��ȯ
			// �����ʹ����� ����Ʈ ũ��� ������ ����
			// 1byte = 0~255
			
			
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println((char)fis.read());
			// byte �� �о�ͼ� int�� ��ȯ
			// read() �޼ҵ��� ��ȯ���� int�� 
			// ���� ����� ���� �ٸ��� ǥ�õ� 
			// --> char ���·� ����ȯ ���ָ� �ذ��
			
			//while ���� �̿��Ͽ� 
			// read() ��ȯ ���� -1�� ��� ���� �Լ� �о����
			// --> file�� ��� ������ �о�� �� ����

			// read()�� �о�� ���� �ӽ� ������ ���� value ����
			int value = 0;
			
			while((value=fis.read()) != -1) {
				System.out.print((char)value);
			}
			// �ѱ��� ������ ����
			// - �ѱ��� 2byte(�����ڵ�)�� 
			// 2byte�� �� ���� �ؼ��Ǿ�� �ѱ۷� �νĵ� 
			// - ����Ʈ ��� ��Ʈ���� 1����Ʈ ������ ������� �ϱ� ������
			// 	 2byte �ѱ� �����Ϳ� �ջ��� �߻���.
			
		}catch(FileNotFoundException e) {
			System.out.println("������ ������������");
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			// ����� ��Ʈ�� �ڿ� ��ȯ
			try {
				if(fis != null) {
					// fis ��ü�� ���� ��쿡�� nullpointexception �߻�
					fis.close();
					}
				}catch(IOException e) {
					e.printStackTrace();
			}
		}
		
	}
	// ���α׷� --> ����(���)
	public void fileSave() {
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("a_byte2.txt", true);
			// ������ ���� ��ġ ����
			// ������ �������� �ʴ� ��� �ڵ����� ����
			
			// ������ �����ϴ� ��� ���������� ���

			// * ����� �ʰ� �̾�� �ϴ� ���
			// -> FileOutputStream ��ü ���� ��
			// 		�Ű����� �������� true�� �߰�
			
			// FileOutputStream.write()
			// ���α׷����� 1����Ʈ�� �ܺη� ���
			// -> IOExcetpion �߻���ų ���ɼ��� ����
			
			
			fos.write(97);
			// ������ ���� ����ص� 
			// �ش� ��ȣ�� ��ġ�ϴ� �ƽ�Ű�ڵ�(1����Ʈ)ǥ�� ���ڰ� ��µ�
			// �����ڵ�� 2����Ʈ �����̸� �ƽ�Ű�ڵ� Ȯ����
			fos.write('��');
			
			// �ٹٲ� ���� ���
			fos.write('\n');
			
			// Hellow World!! �� ���� ����ϱ�
			// ����Ʈ �迭�� ������� ����
			String str = "Hellow world!";
			
			for(int i=0; i<str.length() ;i++ ) {
				fos.write(str.charAt(i));
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("������ �������� ����");
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null) {
					fos.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
