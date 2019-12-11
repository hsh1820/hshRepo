package com.kh.chap04_assist.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedDAO {
	// Buffered ���� ��Ʈ�� 
	// ����¿� ���õ� �����͸� ���ۿ� ��Ƶξ��ٰ� 
	// �Ѳ����� �Է�/����Ͽ� ���༺���� ��� ��Ŵ
	// --> (����� ȸ�� ���ҷ� ���� �۾� �ӵ� ���)
	

	public void fileSave() {
		// BufferedWriter : ���� ��� ��� ���� ��Ʈ��
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			// BufferedWriter() : Write ������ �ϴ� ��� ��Ʈ���� �Ű������� ���
			//FileWriter("c_buffer.txt") 
			// BufferedWriter ���� ��
			// ���� ũ�⸦ �������� ������ 8192byte�� ũ��� �ʱ�ȭ�ȴ�.
			
			bw.write("�ȳ��ϼ��� \n");
			bw.write("�ݰ����ϴ�.");
			bw.newLine();// ��� �� �ٹٲ� �߰�			
			bw.write("��԰�ͼ� ����. \n");
			bw.write("��԰�ͼ� ����. \n");
			// --> bw.write() �� ������ �ƴ� ���ۿ� ����ϰ� ����
			
			// �۾��� �Ϸ�ǰų� ���۰� ���� á�� ��
			// ���Ϸ� ������ ������ ����ؾ���
			// --> 1) flush()
			//     2) close()--> ���۾ȿ� �ִ� ������� ����ϰ� ��ȯ ���� ��
			// bw.flush();
			// flush() : ������ �����͸� ���Ϸ� ���
			// close() : flush() ���� + �ڿ���ȯ
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyBoardinput() {
		/*	Ű���� �Է� ���� ����
		 * 
		 * 	Ű���� �Է� -> Ű���� �Է� ���� -> �ڹ� ���α׷�     
		 * 	 (����Ʈ)		 (����Ʈ)		  (����Ʈ)
		 * 						  ^ 
		 * 				  ����Ʈ���� ���� ��ȯ ������Ʈ��
		 * */
		
		BufferedReader br = null;
		try {
			br = new BufferedReader( // ���� ��Ʈ�� ���� ���
					new InputStreamReader( // ����Ʈ -> ���� ��ȯ ���
							System.in)); // ����Ʈ ���(Ű����)			
		//���۰����� ����� �ش� ���ۿ��ִ¹��ڸ� �о��	//����Ʈ��� ��Ʈ�������ڷ�  // Ű����� ����� ����Ʈ ��Ʈ��
			
			System.out.print("�Է� : ");
			String str = br.readLine(); 
			// readline() : �ٹٲ� ���ڰ� ������ ������ �о����
			
			System.out.println("�Էµ� �� : " + str);
		}catch(IOException e) {
			e.printStackTrace();
		}
	} 
}
