package com.kh.chap05_properties.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Run2 {
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		Scanner sc = new Scanner(System.in);
		
		// load(FileInputStream fis)
		// ���Ͽ� �ִ� ������ �ҷ��� Properties ��ü�� ����
		int num = 0;
		
		while(true) {
			System.out.print("�Է� : ");
			num = sc.nextInt();
					
			if(num == 1) {
				try {
					prop.load(new FileInputStream("test.properties"));
					System.out.println(prop);
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("List ���� : " + prop.getProperty("List"));
				System.out.println("Set ���� : " + prop.getProperty("Set"));
				System.out.println("Map ���� : " + prop.getProperty("Map"));
			}
		}
	}
}
