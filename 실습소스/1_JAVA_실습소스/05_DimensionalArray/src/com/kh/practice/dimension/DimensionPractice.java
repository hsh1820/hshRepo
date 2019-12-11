package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {
	//	2���� �迭
	//	�ǽ� ����
	//	�� ���� �ȳ�
	//	��� ���� Ŭ���� : com.kh.practice.dimension.DimensionPractice
	//	��� ���� Ŭ���� : com.kh.practice.run.Run
	//	�� �ǽ� ��� Ŭ������ ���� �޼ҵ带 �־� �ǽ� ����
	//	�� �ǽ�����1
	//	�޼ҵ� �� : public void practice1(){}
	//	3�� 3��¥�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
	//	�ε��� 0�� 0������ 2�� 2������ ���ʴ�� �����Ͽ� ��(0, 0)���� ���� �������� ���� �� ����ϼ���.
	//	ex.
	//	(0, 0)(0, 1)(0, 2)
	//	(1, 0)(1, 1)(1, 2)
	//	(2, 0)(2, 1)(2, 2)
	public void practice1() {
		String[][] arr = new String[3][3];
		
		arr[0][0] = "(0,0)";
		arr[0][1] = "(0,1)";
		arr[0][2] = "(0,2)";
		System.out.println(arr[0][0]+arr[0][1]+arr[0][2]);
		arr[1][0] = "(1,0)";
		arr[1][1] = "(1,1)";
		arr[1][2] = "(1,2)";
		System.out.println(arr[1][0]+arr[1][1]+arr[1][2]);
		arr[2][0] = "(2,0)";
		arr[2][1] = "(2,1)";
		arr[2][2] = "(2,2)";
		System.out.println(arr[2][0]+arr[2][1]+arr[2][2]);
	}
	
	
	
	
	
	
	
	//	�� �ǽ�����2
	//	�޼ҵ� �� : public void practice2(){}
	//	4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
	//	1) 1 ~ 16���� ���� ���ʴ�� �����ϼ���.
	//	2) ����� ������ ���ʴ�� ����ϼ���.
	//	ex.
	//	1 2 3 4
	//	5 6 7 8
	//	9 10 11 12
	//	13 14 15 16 
	
	public void practice2()	{
		
		int count=1;
		
		int [][] arr = new int[4][4];
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0; j<arr[i].length;j++) {
				arr[i][j] = count;
				count++;
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		
	}
	
	
	
	
	
	
	//	�� �ǽ�����3
	//	�޼ҵ� �� : public void practice3(){}
	//	4�� 4��¥�� ������ �迭�� ���� �� �Ҵ��ϰ�
	//	1) 16 ~ 1�� ���� ���� �Ųٷ� �����ϼ���.
	//	2) ����� ������ ���ʴ�� ����ϼ���.
	//	ex.
	//	16 15 14 13
	//	12 11 10 9
	//	8 7 6 5
	//	4 3 2 1 
	public void practice3(){
		int[][] arr = new int[4][4];
		int count = 16;
		
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0 ; j<arr[i].length;j++) {
				arr[i][j] = count;
				count--;
				System.out.print(arr[i][j]+ " ");
			}System.out.println();
		}
	}
	
	
	//	�� �ǽ�����4
	//	�޼ҵ� �� : public void practice4(){}
	//	4�� 4�� 2���� �迭�� �����Ͽ� 0�� 0������ 2�� 2�������� 1~10������ ������ ���� �� ���� ��
	//	�Ʒ��� ����ó�� ó���ϼ���.
	//	ex.
	//	2 4 3 9
	//	10 2 2 14
	//	7 3 8 18
	//	19 9 13 62
	//	0�� 1�� 2�� 3��
	//	0�� �� �� �� 0�� ������ ��
	//	1�� �� �� �� 1�� ������ ��
	//	2�� �� �� �� 2�� ������ ��
	//	3�� 0�� ������ �� 1�� ������ �� 2�� ������ �� ���� ���� ��
	public void practice4(){
		int[][] arr = new int[4][4];
		int vhap=0;
		int hhap=0;
		int total=0;
	
		
		for(int i =0; i<=arr.length/2;i++) {
			for(int j=0; j<=arr[i].length/2;j++) {
				arr[i][j]= (int)(Math.random()*10 +1);
				vhap += arr[i][j];
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.printf("%3d\n",vhap);
			total += vhap;
			vhap=0;
		}
		for(int i =0; i<=arr.length/2;i++) {
			for(int j=0; j<=arr[i].length/2;j++) {
				hhap += arr[j][i];
			}
			System.out.printf("%3d", hhap);
			total += hhap;
			hhap =0;
		}
		System.out.printf("%3d", total);
		
	}
	
	
	
	//	�� �ǽ�����5
	//	�޼ҵ� �� : public void practice5(){}
	//	2���� �迭�� ��� ���� ũ�⸦ ����ڿ��� ���� �Է¹޵�, 1~10���� ���ڰ� �ƴϸ�
	//	���ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.�� ��� �� �ٽ� ������ �ް� �ϼ���.
	//	ũ�Ⱑ ������ ������ �迭 �ȿ��� ���� �빮�ڰ� �������� ���� �� �� ����ϼ���.
	//	(char���� ���ڸ� ���ؼ� ���ڸ� ǥ���� �� �ְ� 65�� A�� ��Ÿ��, ���ĺ��� �� 26����)
	//	ex.
	//	�� ũ�� : 5
	//	�� ũ�� : 4
	//	T P M B
	//	U I H S
	//	Q M B H
	//	H B I X
	//	G F X I 
	public void practice5(){
		Scanner sc = new Scanner(System.in);
		int row = 0;
		int col = 0;
		
		while(true) {
			System.out.print("�� ũ�� : ");
			row = sc.nextInt();
			System.out.print("�� ũ�� : ");
			col = sc.nextInt();
			
			if(!(row > 0 && row <11 && col >0 && col <11)) {
				System.out.println("�ݵ�� 1~10 ������ ������ �Է��ؾ� �մϴ�.");
				continue;
			}else {
				break;
			}
		}//while end
		
		char[][] arr = new char[row][col];
		for(int i =0 ;i<arr.length;i++) {
			for(int j =0; j<arr[i].length;j++) {
				arr[i][j]= (char)(Math.random()*10 + 65);
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		
	}
	
	
	
	
	//	�� �ǽ�����6
	//	�޼ҵ� �� : public void practice6(){}
	//	String[][] strArr = new String[][] {{"��", "��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��",
	//	"��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��", "��", "! ", "��", "!! "}};
	//	���� �ʱ�ȭ�Ǿ� �ִ� �迭�� ������ �Ʒ��� ��[�׸�] �ǽ�����4 �帧���� ���� ������� ����ϼ���.
	//	��, print()�� ����ϰ� �� ���̿� ����(�� ��)�� �����ϵ��� ����ϼ���.
	//	1 4 7
	//	2 5 8
	//	3 6 9
	//	���� �帧 �ǽ�����6 �帧
	
	public void practice6(){
		String[][] strArr = new String[][] {{"��", "��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��",
				"��", "��", "��", "��"}, {"��", "��", "��", "��", "��"}, {"��", "��", "! ", "��", "!! "}};
		for(int i =0;i<strArr.length;i++) {
			for(int j =0; j<strArr[i].length;j++)	{
				System.out.print(strArr[j][i] + " ");
			}System.out.println();
		}
	}
	
	
	//	�� �ǽ�����7
	//	�޼ҵ� �� : public void practice7(){}
	//	����ڿ��� ���� ũ�⸦ �Է� �ް� �� ����ŭ�� �ݺ��� ���� ���� ũ�⵵ �޾�
	//	������ ���� �迭�� ���� �� �Ҵ��ϼ���.
	//	�׸��� �� �ε����� ��a������ �� �ε����� ������ŭ �ϳ��� �÷� �����ϰ� ����ϼ���.
	//	ex.
	//	���� ũ�� : 4
	//	0���� ũ�� : 2
	//	1���� ũ�� : 6
	//	2���� ũ�� : 3
	//	3���� ũ�� : 5
	//	a b
	//	c d e f g h
	//	i j k
	//	l m n o p 
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ũ�� : ");
		int row = sc.nextInt();
		int col = 0;
		char alpha = 'a';
		
		char[][] arr = new char[row][];
		for(int i = 0 ;i<row;i++) {
			System.out.print(i+ "���� ũ�� : ");
			col = sc.nextInt();			
			arr[i] = new char[col];
		}
		for(int i = 0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] = alpha;
				alpha++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
}
