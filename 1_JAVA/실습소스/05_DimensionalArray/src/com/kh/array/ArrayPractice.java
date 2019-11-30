package com.kh.array;

import java.util.Scanner;

public class ArrayPractice {
	Scanner sc =new Scanner(System.in);

	
	public void practice5()	{
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);
		
		// 
		// 2. ����ڰ� �Է��� ���ڿ�����
		// ���� �ϳ��ϳ��� char �迭�� ����
		
		// 2-1 ���ڿ��� ���̸�ŭ�� char �迭 ���� �� �Ҵ� 
		char[] arr = new char[str.length()]; // .length ����� �θ��� ��
		
		// 2-2 �ݺ����� ���� str.charAt(i) ���� arr[i]�� ����
		for(int i = 0; i<arr.length;i++) { // .length �迭�� �ʵ尪 �������� ��  
			arr[i] = str.charAt(i);
		}
		//  3. �˻��� ���ڰ� �迭���� ��� ����ִ��� �˻�
				// + �˻��� �ε��� ���
		int count =0;

		// �ݺ��� ���� �� ���� ���
		System.out.print(str + "�� "+ ch + "�� �����ϴ� ��ġ(�ε���) : ");
		
		// �ݺ����� �̿��Ͽ� �迭�� �� ��ҿ� ����
		for (int i =0 ; i<arr.length;i++) {
			if(arr[i] == ch) { // �ش� �ε����� ��Ұ� �˻��� ���ڿ� ���� ���
				System.out.print( i + " " ); // ���� �ε��� ���
				count++;
			}
		}
		System.out.println(); // �ٹٲ�
		
		// ��� ���
		System.out.println(ch + "���� : " + count);
	}
	
	public void practice8()	{
		
		while(true) {
			System.out.print("���� : ");
			int num = sc.nextInt();
			
			// �Է¹��� ���� 3�̻��̸鼭 Ȧ���� ���
			if(num > 3 && num %2==1) {
				// �Է¹��� ũ�⸸ŭ�� int�� �迭 ���� �� �Ҵ�
				int[] arr = new int[num];

				// �迭 ��ҿ� ������ ���� ���� ���� ����
				int value = 0;
				// �迭�� �߰������� value++;
				// �迭 �߰����� ���ʹ� value--;
				for(int i =0; i < arr.length;i++) {
					// �迭�� �߰�����
					if (i <= arr.length/2) {
					value ++;
				}else {
					value--;
					} 
					arr[i] = value;
					System.out.print(arr[i] + " ");
				}//for end
				break;
				
			}else {
				System.out.println("�ٽ� �Է��ϼ���"); 
				}
		}	
	}
	public void practice15() {
		
		// 1. ����ڿ��� ���ڿ� �Է¹ޱ�		
		System.out.print("���ڿ� : ");
		String str = sc.nextLine(); // nextLine().charat(i) => ���ڿ� �� i ��° ���ڸ� �޴´�
		
		// �Է¹��� ���ڿ��� char[] �� ����
		
		char[] arr = new char[str.length()];
		
		for(int i =0; i<arr.length;i++) {
			arr[i] = str.charAt(i);			
		}
		System.out.print("���ڿ��� �ִ� ���� : ");

		// 3. �ݺ����� �̿��Ͽ� char �迭���� �ߺ����� �����ϴ� ��� ��� X
		 int count = 0;
		 
		// �� ���� ����
		for(int i =0;i<arr.length;i++) {
			boolean flag = true;
			// �ߺ� üũ�� ����
			
			for(int j = 0; j<i;j++) { // i ���� ���� �� ��� ����
				if(arr[i] == arr[j]) { // ���ذ� �񱳴���� ���� ��� �ߺ��߻�
					flag = false;
					break;
					
				}
			}
			// �ߺ��� �߻����� ���� ��� ��� �� count ����
			if (flag) {
				if(i ==0 ) { //���ڿ� ù��°���
					System.out.print(arr[i]);   // a 
				}else {
					System.out.print(", "+arr[i]); // + b
				}
				count++;
			}
			
		}
		System.out.println();
		System.out.println("���� ���� : " + count );
}
	
	
	
}
// 