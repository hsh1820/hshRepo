package com.kh.chap02_trycatch.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchController {
	/*	try ~ catch ���� : 
	 * Exception �� �߻��� ������ ���� ó���ϴ� ����ó�� ���
	 * 
	 *  - try : ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 
	 *  		try��� {} ���� �ְ� �õ�
	 *  
	 *  - catch : try ��� ������ �߻��ϴ� (��������) Exception�� 
	 *  		��Ƴ��� ó���ϴ� ����� ���.
	 *  
	 *  - finally : try~catch ���� �� 
	 *  			���������� �ݵ�� �����ؾ� �ϴ� �ڵ带 �ۼ�
	 *  
	 *  	
	 * */
	
	public void method1() {
		// Scanner �� �̿��Ͽ� �Էµ� �� �� ������
		Scanner sc = new Scanner (System.in);
		try {
			System.out.println("�Էµ� �� �� ������");
			System.out.print("�Է� 1 : ");
			int num1 = sc.nextInt();
			System.out.print("�Է� 2 : ");
			int num2 = sc.nextInt();			
			
			System.out.println("num1 / num2 = " + num1/num2);
			
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");					
		}catch(InputMismatchException e) {
			// catch ������ ������ �ۼ� ������
			// ��, ������ �ۼ��� ��� ���踦 ����ؾ� ��
			System.out.println("�� �� �Է��ϼ̽��ϴ�. ������ �Է����ּ���");
		
		}catch(Exception e) { // �������� �̿��� Exception catch 
			System.out.println("���ܻ�Ȳ �߻�");
			// catch ������ ���� �� �ۼ� �� ���
			// ��� ���迡�� ���� �ڽĿ� ��ġ�ϴ� Exception�� ���� �ۼ� �� ��.
			// -> try ��Ͽ��� Exception �� �߻��ϸ� 
			// 		catch ������ ���� ���κ� ���� Exception ��ġ ���θ� �˻��ϴµ�
			// 		�θ�Ÿ���� Exception�� ���κп� �ڸ� ��� �Ǹ� 
			// 		�ش� Ÿ���� �ڽ� Exception ���� ��� �����ϰ� ��.
			System.out.println(e);
		}
	}
	public void method2() {
		System.out.println("BufferedReader �� �̿��Ͽ� �� �� ������");
		
		BufferedReader br = null;
		
		try { // IO ���� ��ü ������ �ݵ�� ������ ������ Exception�� Ȯ���ؾ� ��
			br = new BufferedReader(new InputStreamReader(System.in));
			// int, double .. ���� ������ String �� �Է� ���� �� ����
			// �Է¹��� ���ڸ� ���ۿ� �����صξ��ٰ� \n�������� ���ڵ��� ���ڿ��� �ѹ��� ��ȯ
			System.out.print("�Է� 1 : ");
			int num1 = Integer.parseInt(br.readLine());
			
			if(num1 == 1) return; 
			
			System.out.print("�Է� 2 : ");
			int num2 = Integer.parseInt(br.readLine());
			
			System.out.println("num1 / num2 = " + num1/num2);
			
		}catch (IOException e){
			System.out.println("�Է� �� ���� �߻�");
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		}catch(NumberFormatException e){
			System.out.println("������ �Է��� �ּ���.");
		}catch(Exception e) {
			System.out.println("���� ��Ȳ �߻�");
		}finally {
			// Exception �߻� ���ο� ���� ����
			// �ݵ�� ó���ؾ� �ϴ� ������ ����ϴ� �κ�
			 
			 // �ڿ� �ݳ�, ��ȯ �� ���
			 // ��� �Ϸ�� ���� ��ȯ
			 try {
				 System.out.println("BufferedReader ��ȯ");
				 br.close(); // ���� ��ȯ 
				 // IOException �߻� �����Ͽ� try-catch
				 
				 System.out.println("���α׷� ����");
				 
			 }catch(IOException e) {
				 System.out.println("��ȯ �� ���� �߻�");
			 }
		}
			
	}
	
	public void method3() {
		// try ~ with ~ resource
		// try ���� ���� �� �Ű������� try ���ο��� ����� �ڿ���
		// �̸� �Բ� �����Ͽ� 
		// try ���� ���� �� �ڵ����� ��ȯ�ϰ� �ϴ� ����ó�� ���
		
			System.out.println("BufferedReader �� �̿��Ͽ� �� �� ������");
			
			
			try (BufferedReader br 
					= new BufferedReader(
							new InputStreamReader(System.in))){				
				
				
				
				System.out.print("�Է� 1 : ");
				int num1 = Integer.parseInt(br.readLine());
				
				if(num1 == 1) return; 
				
				System.out.print("�Է� 2 : ");
				int num2 = Integer.parseInt(br.readLine());
				
				System.out.println("num1 / num2 = " + num1/num2);
				
			}catch (IOException e){
				System.out.println("�Է� �� ���� �߻�");
			}catch(ArithmeticException e) {
				System.out.println("0���� ���� �� �����ϴ�.");
			}catch(NumberFormatException e){
				System.out.println("������ �Է��� �ּ���.");
			}catch(Exception e) {
				System.out.println("���� ��Ȳ �߻�");
			}finally {
				// Exception �߻� ���ο� ���� ����
				// �ݵ�� ó���ؾ� �ϴ� ������ ����ϴ� �κ�
				 
					 System.out.println("���α׷� ����");					 
			}
	}
}
