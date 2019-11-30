package com.kh.dimension;

public class DimensionalArray {
	
		// 2���� �迭 : 1���� �迭 �������� �ϳ��� ���� ����ϴ� ��
	
	public void method1() {
		// 2���� �迭�� ���� �� �Ҵ�
		
		// 2���� ����
		int [][] arr1;
		int arr2[][];
		int [] arr3[];
		// [] == �迭 1������ �ǹ�
		
		// �Ҵ� = new
		// 2���� �迭 �Ҵ�
		arr1 = new int [3][5];
		// Heap ������ int �� 2���� �迭 3�� 5�� �Ҵ�
		
		// ���� ����(���� �ΰ�?) Ȯ��
		System.out.println("���� ���� : "+ arr1.length);
		
		// ���� ����(�� ĭ �ΰ�?) Ȯ��
		System.out.println("���� ���� : "+ arr1[0].length);
		
		//3�� 5���� int �� 2���� �迭�� ��� ĭ��
		// ���� 1 ä���
		// 2���� �迭 �ʱ�ȭ
		for(int i=0;i<arr1.length ;i++) { // ���� ���� ��ŭ �ݺ�
			for(int j =0;j<arr1[i].length;j++) { // ���� ���� ��ŭ �ݺ�
				arr1[i][j]=1;
//				System.out.println(arr1[i][j]);
			}
		}
		// 2���� �迭 ����
		// 2���� �迭�� �� ��ҿ� ����� �� ����ϱ�
		for(int i=0;i<arr1.length ;i++) { // ���� ���� ��ŭ �ݺ�
			for(int j =0;j<arr1[i].length;j++) { // ���� ���� ��ŭ �ݺ�
				System.out.print(arr1[i][j] +" ");
			}System.out.println();			
		}
		
	}
	public void method2() {
		// 2���� �迭 ����� ���ÿ� �ʱ�ȭ
		
		int[][] arr = {   {0, 1, 2, 3} , 
						  {4, 5, 6, 7}, 
						  {8 , 9, 10, 11}    };
		
		// �ʱ�ȭ�� 2���� �迭 �� ��� ���
		
		for(int i =0; i<arr.length;i++) {
			for(int j =0; j<arr[i].length;j++) {
				//arr[0][0] = 0
				System.out.print("arr [ " + i +" ] " + " [ "+j+" ]  = " + arr[i][j] +" " );
			}System.out.println();
		}
		
		
	}
	
	public void method3() {
		
		// 4�� 4�� ¥�� int �� 2���� �迭 ���� �� �Ҵ��ϰ�
		// �� ��ҿ� 1~16������ ���� ������� �����ϰ� ���
		
		int[][] arr = new int[4][4];
		int count = 1;
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr[i].length;j++) {				
				
				arr[i][j] = count ++; 
				// arr �� ��ҿ� ���� count �� ���� �� count 1 ����  
			
				// arr[i][j] ��° ��� ���
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(); // �ٹٲ�
		}
	}
	
	public void method4() {
		// ���� ������ ������ ������,
		// �� �࿡ ���� ���� ������ �������� ���� 2���� �迭
		// ���� �迭 ���� �� �Ҵ�
		int[][] arr = new int[4][];
		
		arr[0] = new int[3];  // �������� new �� ���� 
		arr[1] = new int[4];
		arr[2] = new int[5];
		arr[3] = new int[2];
		
		// �迭�� ����ҿ� ��¥ 0 (int �⺻��)�� ����ִ��� Ȯ��
		for(int i=0; i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) { // ������
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
		System.out.println();
		
		int value = 1;
		for(int i=0; i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) { // ������
				arr[i][j] = value++;
				
				System.out.print(arr[i][j]+" ");
				
			}System.out.println();
		}
	}
	
}
