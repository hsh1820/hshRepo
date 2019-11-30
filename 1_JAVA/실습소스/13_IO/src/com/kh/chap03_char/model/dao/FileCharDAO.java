package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDAO {
	// FileReader : ���� ��� ���� �Է½�Ʈ��
	// ���Ͽ� �ִ� ������ ���α׷������� �Է� �޴� ��Ʈ��
	// ���α׷� <------- ����
	
	public void fileOpen() {
		FileReader fr = null;
		// FileReader ��ü�� ������ �� ���ϰ� ���� �����
		// -> ����� ������ ���� ���
		//		FileNotFoundException �߻�
		
		try {
			fr = new FileReader("a_byte.txt");
			
			int value = 0;
			// Reader.read() �� 2����Ʈ ���� ������ �Է��� ��.(�о��)
			// char������ �о��
			// ���̻� �о�ð� ���� �� -1 ��ȯ
			while (( value = fr.read()  ) != -1  ) {
				System.out.print((char)value);
			}
		}catch(FileNotFoundException e) {
			System.out.println("������ �������� ����");
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if( fr != null) {
					fr.close();				
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void fileSave() {
		// FileWriter : ���ڱ�� ������� ��Ʈ��
		// ���α׷� --> ����
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("b_char.txt"/* , true */);
											// �̾�� �ɼ�
			// �Ű� ���� ������ �������� ������ �ڵ����� ���� ����
			
			// Writer.write() : 2����Ʈ ���ڴ����� �ܺη� ���
			// -> IOException �߻� ����
			/*
			 * fw.write('��'); fw.write('��'); fw.write('��');
			 */
			
			// Hellow World! ���
			// �������� ���� : ���ڷ� �� �����͸� ����� ���� 
			fw.write("Hello World!\n");
			fw.write("��հ���?? ");
			fw.write("�׷��ٰ� �ؿ�");
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) {
					fw.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
