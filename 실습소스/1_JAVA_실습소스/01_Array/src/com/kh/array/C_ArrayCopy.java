package com.kh.array;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class C_ArrayCopy {
	
	Scanner sc = new Scanner(System.in);
	// �迭 ���� 
	// - ���� ���� : �迭�� �ּҸ��� ����
	// - ���� ���� : �����Ϸ��� �迭�� ������ ũ���� 
	// 					���ο� �迭�� ����� ���� ���� ���� ��� �����ϴ� �� 
	
	public void method1() {
		int[]  origin = {1,2,3,4,5};
		
		// ���� ����
		int[] copyArr = origin;
		
		
		System.out.println("���� �� ");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// �ּҰ��� ������ Ȯ��
		System.out.println("origin �� hashCode :  " +  origin.hashCode());
		System.out.println("copyArr �� hashCode :  " +  copyArr.hashCode());
		
		System.out.println();
		System.out.println("���� �� ");
		
		copyArr[0] = 99;// ���� ������ ������ �̿��Ͽ� 0�� �ε��� �� ���� 
		
		// origin(����) �������� ������ �ִ��� Ȯ��
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// �ּҰ��� ������ Ȯ��
		System.out.println("origin �� hashCode :  " +  origin.hashCode());
		System.out.println("copyArr �� hashCode :  " +  copyArr.hashCode());
	}
	
	


	public void method2() {
		
		int[] origin = {1,2,3,4,5};
		
		// ���� ����
		// --> ���� ���縦 �ϱ� ���ؼ��� "�ּ�" ������ ���� ũ���� �迭�� �ʿ���
		int[] copyArr = new int[origin.length];
		
//		System.out.println(copyArr.toString());
		
		for(int i =0; i<origin.length;i++) {
			// ���� �迭�� �����͸� ���� ������ �迭�� ����
			copyArr[i] = origin[i];  
		}
		System.out.println("���� �� ");
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// �ּҰ��� �ٸ��� Ȯ��
		System.out.println("origin �� hashCode :  " +  origin.hashCode());
		System.out.println("copyArr �� hashCode :  " +  copyArr.hashCode());
		
		System.out.println();

		System.out.println("���� �� ");

		copyArr[0] = 99;// ���� ������ ������ �̿��Ͽ� 0�� �ε��� �� ���� 
		
		// origin(����) �������� ������ �ִ��� Ȯ��
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		
		System.out.println();
		// �ּҰ��� ������ Ȯ��
		System.out.println("origin �� hashCode :  " +  origin.hashCode());
		System.out.println("copyArr �� hashCode :  " +  copyArr.hashCode());
		
		
	}
	
	
	public void method3() {
		
		// system Ŭ�������� �����ϴ� arraycopy() �޼ҵ带 ����Ͽ� ���� ���� �ϱ�
		
		int[]	origin = { 9,8,7,6,5};
		
		// ������ �迭 ���� �� �Ҵ�
		int[] copyArr = new int[origin.length];
		
		// system.arraycopy(�����迭��, �����迭�� ���簡 ���۵� �ε���, 
		// ���纻 �迭��, ���纻�� ������������ ���縦 ������ �ε���, �������� �����ؿ� ������ ����); 
		
		System.arraycopy(origin, 0, copyArr, 0, origin.length); 
		
		System.out.println("origin : " + Arrays.toString(origin));
		System.out.println("copyArr : " + Arrays.toString(copyArr));
		

		
			
		
	}
	
	// �迭�� ũ�⸦ �Է¹޾� �ش� ũ�⸸ŭ�� �迭�� �����ϰ�,
	// �迭�� ũ�⸸ŭ ������ �Է¹޾� ������� ����.
	// ���������� ���� ������ �� �߰��� ���� �Է¹����� Ȯ��('y', 'n')
	// 'y' ���� �� ���� ��ų ũ�⸦ �Է¹޾�
	// ���� �迭�� ũ�⸦ ������Ű��
	//	�þ ũ�⸸ŭ �߰��� ���� �Է¹ޱ�.
	//	'n' ���� �� �迭 ����� ��� �� ���.
	
	public void method4() {
		
		
		
//		System.out.println("���� �Է� : ");
		
		
		System.out.print("�迭 ũ�� �Է� : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size]; // ���� �迭 ����
		
		int i = 0; // �ʱ��
		while (true) {
			System.out.println(i + "��° �ε��� �� : ");
			arr[i] = sc.nextInt();
			sc.nextLine(); // ���ۿ� �����ִ� �ٹٲ� ���� ����
			
				if (i == arr.length-1) {
					System.out.print("�߰��� ���� �Է��Ͻðڽ��ϱ�? (y/n) : ");
					char yn = sc.next().charAt(0);
					
					if(yn == 'n') {
						break;
					}else { // y �� �Էµ� ���
						System.out.println("������ų �迭�� ũ�� : ");
						int addSize = sc.nextInt();
						
						// �迭 ũ�� ����
						// --> ũ�Ⱑ ������ ���ο� �迭�� �����
						// 		���� �迭�� �����͸� ���� ���� ��
						// 		���� �迭 ������ ������
						// 		���ο� �迭�� �����ϵ��� �ּҰ��� ����
						
						int[] newArr = new int[arr.length+addSize];
						// ���� �迭 ũ�� + �߰� ũ�� ��ŭ�� ���ο� �迭 ���� ����
						System.arraycopy(arr, 0, newArr, 0, arr.length);
					
						arr = newArr; // arr�� �迭 ��, newArr�� ���������� ������� =GC
						
					}
					
				}
			
			i++; // ������
			
		}
		System.out.println(Arrays.toString(arr));
		
		
		
//		System.out.print("�迭 ũ�� �Է� : ");
//		int input = sc.nextInt();
//		
//		for(int i =0 ; i<input;i++) {
//			int[] arr = new int[input]; // origin
			
	//	}
	}
	
	
	
	
}
