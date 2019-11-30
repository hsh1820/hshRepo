package com.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	// �ǽ����� 1
	/*
	���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ� 
	������� �迭 �ε����� ���� �� �� ���� ����ϼ���.
	
	ex.
	1 2 3 4 5 6 7 8 9 10 

	 */
	public void practice1() {

		// 1. ���̰� 10�� int�� �迭 ���� �� �Ҵ�
		int[] arr = new int[10];
		
		// 2. 0���� �迭�� ���� �̸���ŭ �ݺ�
		for(int i=0; i<arr.length; i++) { 
			
			// 3. �迭�� �� ��ҿ� i+1 ���� ����
			arr[i] = i+1; 
			System.out.print(arr[i] + " ");
		}
		
	}
	
	// �ǽ����� 2
	/*
	���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ� 
	�������� �迭 �ε����� ���� �� �� ���� ����ϼ���.

	ex.
	10 9 8 7 6 5 4 3 2 1 
	*/

	public void practice2() {
		
		// 1. ���̰� 10�� int�� �迭 ���� �� �Ҵ�
		int[] arr = new int[10];
		
		// 2. 0���� �迭�� ���� �̸���ŭ �ݺ�
		for(int i=0; i<arr.length; i++) {
			
			// 3. �迭 �� ��ҿ� �迭�� ����-i ���� ����
			arr[i] = arr.length - i; 
			System.out.print(arr[i] + " ");
		}
		
	}
	
	// �ǽ����� 3
	
	/*
	����ڿ��� �Է� ���� ���� ������ŭ �迭 ũ�⸦ �Ҵ��ϰ� 
	1���� �Է� ���� ������ �迭�� �ʱ�ȭ�� �� ����ϼ���.

	ex.
	���� ���� : 5
	1 2 3 4 5 
	*/
	public void practice3() {
		// 1. ����ڿ��� ���� �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int size = sc.nextInt();
		
		// 2. �迭�� �Ҵ��� ���� ����ڰ� �Է��� ����(size)��ŭ�� ũ��� �Ҵ�
		int[] arr = new int[size];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
	}
	
	
	// �ǽ����� 4
	/*
	���̰� 5�� String�迭�� �����ϰ� �������, ���֡�, ��������, �������ơ�, �����ܡ��� �ʱ�ȭ �� ��
	�迭 �ε����� Ȱ���ؼ� ���� ����ϼ���.

	ex.
	��
	*/
	public void practice4() {
		// 1. ���̰� 5�� String �迭 ����
		String[] arr = new String[5];
		
		// 2. �� �ε����� �� �ʱ�ȭ
		arr[0] = "���";
		arr[1] = "��";
		arr[2] = "����";
		arr[3] = "������";
		arr[4] = "����";
		
		//String[] arr = {"���", "��", "����", "������", "����"};
		
		// 3. �迭 �ε����� Ȱ���ؼ� �� ���
		System.out.println(arr[1]);
	}
	
	
	// �ǽ����� 5
	/*
	���ڿ��� �Է� �޾� ���� �ϳ��ϳ��� �迭�� �ְ� �˻��� ���ڰ� ���ڿ��� �� �� �� �ִ���
	������ �� ��° �ε����� ��ġ�ϴ��� �ε����� ����ϼ���.

	ex.
	���ڿ� : application
	���� : i
	application�� i�� �����ϴ� ��ġ(�ε���) : 4 8 
	i ���� : 2
	*/
	public void practice5() {
		// 1. ����ڿ��� ���ڿ��� ���� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		
		System.out.println("���� : ");
		char ch = sc.nextLine().charAt(0);
		
		// 2. ����ڰ� �Է��� ���ڿ�(str)�� ���� �ϳ��ϳ��� char�迭�� �ֱ�
		
		// ���� ����ڰ� �Է��� ���ڿ� ���̸�ŭ�� char�迭�� �Ҵ� 
		char[] arr = new char[str.length()];
		
		// �ݺ����� ���� str.charAt(i) ���� arr[i] �� ��� ����
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		
		
		// 3. �˻��� ���ڰ� ���ڿ��� ��� ����ִ����� ��� �ε����� �ִ��� �ľ�
		
		int count = 0; 	// �˻��� ���ڰ� ���ڿ��� ��� ����ִ����� ������ ����
						// ���ڿ����� ������ ���ڰ� �߻��� ������ 1�� ���� ������
		
		
		// �켱 �ݺ����� �����ϱ� ���� ��¹� ���
		System.out.print(str + "�� " + ch + "�� �����ϴ� ��ġ(�ε���) : ");
		
		// �ε������� �����ϱ� ���� �ݺ��� ���
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ch) { // �ش� �ε��� ���� �˻��� ���ڿ� ���� ��� 
				System.out.print(i + " ");	// �ش� �ε��� �̾ ���
				
				count++;	// �׸��� count 1����
			}
		}
		
		System.out.println();	// �ٹٲ�
		
		System.out.println(ch + "���� : " + count);
		
		
		
	}
	
	
	// �ǽ����� 6
	/*
	������ ~ ���ϡ����� �ʱ�ȭ�� ���ڿ� �迭�� ����� 0���� 6���� ���ڸ� �Է� �޾�
	�Է��� ���ڿ� ���� �ε����� �ִ� ������ ����ϰ� 
	������ ���� ���ڸ� �Է� �� ���߸� �Է��ϼ̽��ϴ١��� ����ϼ���.

	ex.
	0 ~ 6 ���� ���� �Է� : 4			0 ~ 6 ���� ���� �Է� : 7
	�ݿ���						�߸� �Է��ϼ̽��ϴ�.
	*/
	public void practice6() {
		
		// 1. "��" ~ "��"���� �ʱ�ȭ�� ���ڿ� �迭 �����
		String[] arr = {"��", "ȭ", "��", "��", "��", "��", "��"};
		
		// 2. ����ڿ��� 0���� 6������ ���� �Է� �ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("0 ~ 6 ���� ���� �Է� : ");
		int num = sc.nextInt();
		
		// 3. num���� 0 ~ 6 ������ �������� Ȯ�� --> �ƴ� ��� "�߸� �Է��ϼ̽��ϴ�." ���
		if(num >= 0 && num <= 6) {
			
			// �ش� ���� ���
			System.out.println(arr[num] + "����");
			
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	// �ǽ����� 7
	/*
	����ڰ� �迭�� ���̸� ���� �Է��Ͽ� �� ����ŭ ������ �迭�� ���� �� �Ҵ��ϰ�
	�迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է��Ͽ� ������ �ε����� ���� �ʱ�ȭ �ϼ���.
	�׸��� �迭 ��ü ���� �����ϰ� �� �ε����� ����� ������ ���� ����ϼ���.

	ex.
	���� : 5
	�迭 0��° �ε����� ���� �� : 4
	�迭 1��° �ε����� ���� �� : -4
	�迭 2��° �ε����� ���� �� : 3
	�迭 3��° �ε����� ���� �� : -3
	�迭 4��° �ε����� ���� �� : 2
	4 -4 3 -3 2 
	�� �� : 2
	*/
	public void practice7() {
		// 1. ����ڿ��� ���� �Է¹ް� �� ����ŭ�� �迭 ���� �� �Ҵ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		// 2. �� �迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է��Ͽ� ������ �ε����� ���� �ʱ�ȭ
		for(int i=0; i<arr.length; i++) {
			System.out.print("�迭 " + i + "��° �ε����� ���� �� : ");
			arr[i] = sc.nextInt();
		}
		
		
		// 3. ��ü �� ���� �� �� �� ���
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		
		System.out.println();
		System.out.println("�� �� : " + sum);
		
		
	}
	
	
	// �ǽ����� 8
	/*
	3�̻��� Ȧ�� �ڿ����� �Է� �޾� �迭�� �߰������� 1���� 1�� �����Ͽ� ������������ ���� �ְ�,
	�߰� ���ĺ��� �������� 1�� �����Ͽ� ������������ ���� �־� ����ϼ���.
	��, �Է��� ������ Ȧ���� �ƴϰų� 3 �̸��� ��� ���ٽ� �Է��ϼ��䡱�� ����ϰ�
	�ٽ� ������ �޵��� �ϼ���. 

	ex.
	���� : 4
	�ٽ� �Է��ϼ���.
	���� : -6
	�ٽ� �Է��ϼ���.
	���� : 5
	1, 2, 3, 2, 1
	*/
	public void practice8() {
		
		// 1. ����ڿ��� 3�̻��� �������� �Է¹���
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("���� : ");
			int num = sc.nextInt();
			
			if(num >= 3 && num % 2 == 1) { // 3�̻��̸鼭 Ȧ���� ��� (��, �� �Է��� ���)
				
				// ����ڰ� �Է��� ���� ũ�� ��ŭ�� �迭 ������
				int[] arr = new int[num];
				
				// ���� �ֱ� ���� ���� --> ���������� ��� 1�� ������Ű�� ���������� ��� 1�� ����
				int count = 0;
				
				// �� �ֱ�
				for(int i=0; i<arr.length; i++) {
					
					if(i <= arr.length / 2) { // �迭�� �߰�������
						count++;
					}else {
						count--;
					}
					
					arr[i] = count;
					
				}
				
				break; // ����� ���� �ϰ� ���� �ݺ��� ����������
				
			}else { // �߸� �Է��� ���
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
	
	
	// �ǽ����� 9
	/*
	����ڰ� �Է��� ���� �迭�� �ִ��� �˻��Ͽ�
	������ ��OOO ġŲ ��� ���ɡ�, ������ ��OOO ġŲ�� ���� �޴��Դϴ١��� ����ϼ���.
	��, ġŲ �޴��� ���ִ� �迭�� ���� ������ ���ϼ���.

	ex.
	ġŲ �̸��� �Է��ϼ��� : ���			ġŲ �̸��� �Է��ϼ��� : �Ҵ�
	���ġŲ ��� ����				�Ҵ�ġŲ�� ���� �޴��Դϴ�.
	*/
	public void practice9() {
		// 1. ġŲ �޴����� ����ִ� String �迭 ����, �Ҵ� ���ÿ� �ʱ�ȭ
		String[] chickens = {"�Ķ��̵�", "���", "�Ĵ�", "ġ��"};
		
		// 2. ����ڿ��� ġŲ �޴� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		String menu = sc.nextLine();
		
		// 3. �ݺ����� ���� �迭�� 0�� �ε������� ������ �ε������� �����Ͽ�
		//    ����ڰ� �Է��� �޴��� ������ �޴��� �ִ���
		boolean flag = false; // ������ �޴��� �ִ��� ������ ������ �޾��ֱ� ���� ���� ���
		
		for(int i=0; i<chickens.length; i++) {
			
			if(chickens[i].equals(menu)) { // ����ڰ� �Է��� �޴��� ������ �޴��� ���
				flag = true; // flag ���� true�� �ٲ��ְ�
				break;       // �ݺ����� ����������. (�������������� true�� �ٲ� �� ���̻� �ݺ����� �� �ʿ䰡 ���⶧���� ȿ�������� ����Ѱ���)
			}
		}
		
		if(flag) { // flag�� true�� ��� ��, ����ڰ� �Է��� �޴��� ������ ���
			System.out.println(menu + "ġŲ ��� ����");
		}else {
			System.out.println(menu + "ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
	
	//�ǽ����� 10
	/*
	�ֹε�Ϲ�ȣ �����ڸ� ���ĺ��� *�� ������ ����ϼ���.
	��, ���� �迭 ���� ���� ���� �迭 ���纻���� �����ϼ���.

	ex.
	�ֹε�Ϲ�ȣ(-����) : 123456-1234567
	123456-1******
	 */
	public void practice10() {
		// 1. ����ڿ��� �ֹε�Ϲ�ȣ ���ڿ� �Է¹ޱ� 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
		String str = sc.nextLine();
		
		// 2. �ݺ����� �̿��Ͽ� char[]�� �Ű� ���
		char[] origin = new char[str.length()];
		
		for(int i=0; i<origin.length; i++) {
			origin[i] = str.charAt(i);
		}
		
		// 3. ���纻 char[]�� �����ڸ� ���ĺ��� *�� ���� ���Բ� ���� ���� �� �ٷ� ���
		char[] copy = new char[origin.length];
		
		for(int i=0; i<copy.length; i++) {
			
			if(i <= 7) { // 7�� �ε��� ���ϱ�����
				copy[i] = origin[i]; // ������ �ֹι�ȣ�� ����
			}else { // �� ���ĺ��ʹ� *�� ������
				copy[i] = '*';
			}
			
			// �ٷ� ���
			System.out.print(copy[i]);
		}
		
		
	}
	
	// �ǽ����� 11
	/*
	10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
	1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ�� �� ����ϼ���.

	ex.
	9 7 6 2 5 10 7 2 9 6 
	*/
	public void practice11() {
		// 1. 10���� ���� ������ �� �ִ� ������ �迭 ���� �� �Ҵ�
		int[] arr = new int[10];
		
		// 2. �� �ε����� 1���� 10 ������ ������ �߻����� �ʱ�ȭ�� �� ���
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			System.out.print(arr[i] + " ");
		}
	}
	
	// �ǽ����� 12
	/*
	10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
	1~10 ������ ������ �߻����� �迭�� �ʱ�ȭ ��
	�迭 ��ü ���� �� �� �߿��� �ִ밪�� �ּҰ��� ����ϼ���.

	ex.
	5 3 2 7 4 8 6 10 9 10 
	�ִ밪 : 10
	�ּҰ� : 2
	*/
	public void practice12() {
		// 1. 10���� ���� ������ �� �ִ� ������ �迭 ���� �� �Ҵ�
		int[] arr = new int[10];
		
		// 2. �� �ε����� 1���� 10 ������ ������ �߻����� �ʱ�ȭ �� ���
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			System.out.print(arr[i] + " ");
		}
		
		System.out.println(); // ����
		
		// 3. �ݺ����� ���� �ִ밪 �ּҰ� �˾Ƴ���
		int max = 1;
		int min = 10; // �ִ밪, �ּҰ��� ����� ���� 
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] > max) { // �迭���� ���� max ���� ū ���
				max = arr[i]; // �ش� ���� max ������ �����
			}
			
			if(arr[i] < min) { // �迭���� ���� min ���� ���� ���
				min = arr[i]; // �ش� ���� min ������ �����
			}
		}
		
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
				
	}
	
	// �ǽ����� 13
	/*
	10���� ���� ������ �� �ִ� ������ �迭�� ���� �� �Ҵ��ϰ�
	1~10 ������ ������ �߻����� �ߺ��� ���� ���� �迭�� �ʱ�ȭ�� �� ����ϼ���.

	ex.
	4 1 3 6 9 5 8 10 7 2 
	*/
	public void practice13() {
		// 1. 10���� ���� ������ �� �ִ� ������ �迭 ���� �� �Ҵ�
		int[] arr = new int[10];
		
		// 2. �� �ε��� ���� 1���� 10 ������ ������ �߻���Ű�µ� �̶� �ߺ��� ������
		for(int i=0; i<arr.length; i++) {
			
			arr[i] = (int)(Math.random() * 10 + 1);
			
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		
		// 3. ���
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// �ǽ����� 14
	/*
	�ζ� ��ȣ �ڵ� ������ ���α׷��� �ۼ��ϴµ� �ߺ� �� ���� ������������ �����Ͽ� ����ϼ���.

	ex.
	3 4 15 17 28 40 
	*/
	public void practice14() {
		// 1. ũ�Ⱑ 6�� ������ �迭 ���� �� �Ҵ�
		int[] lotto = new int[6];
		
		// 2. �迭�� �ߺ������� 1���� 45������ ���� �ʱ�ȭ
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45 + 1);
			
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		// 3. �������� ����
		for(int i=0; i<lotto.length; i++) { // �� ��ü
			for(int j=i+1; j<lotto.length; j++) { // �� ���
				if(lotto[i] > lotto[j]) { // �� ��ü�� �� ��󺸴� ū ��� ���� �ٲ���ߵ�
					
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		// 4. ���
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}
	
	
	// �ǽ����� 15
	/*
	���ڿ��� �Է� �޾� ���ڿ��� � ���ڰ� ������ �迭�� �����ϰ�
	������ ������ �Բ� ����ϼ���.

	ex.
	���ڿ� : application
	���ڿ��� �ִ� ���� : a, p, l, i, c, t, o, n
	���� ���� : 8
	*/
	public void practice15() {
		// 1. ����ڿ��� ���ڿ� �Է¹ޱ� 
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		
		// 2. �ش� ���ڿ��� ���ڵ��� char[]�� ���
		char[] arr = new char[str.length()];
		
		for(int i=0; i<arr.length; i++) {
			
			arr[i] = str.charAt(i);
			
		}
		
		// 3. char�迭���� �ߺ��� ������ ��� ���X, 
		
		int count = 0; // ���� ���� ī��Ʈ
		
		System.out.print("���ڿ��� �ִ� ���� : ");
		
		for(int i=0; i<arr.length; i++) {
			
			boolean flag = true; // �ߺ� üũ�� flag
			
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					flag = false; // �ߺ��̹߻����� ��
					break;
				}
			}
			
			if(flag) { // �ߺ��� �߻����� �ʾ��� ���
				
				if(i == 0) {
					System.out.print(arr[i]);					
				}else {
					System.out.print(", " + arr[i]);					
				}
				
				count++;
			}
			
		}
		
		System.out.println();
		System.out.println("���� ���� : " + count);
		
		
	}
	
	// �ǽ����� 16
	/*
	����ڰ� �Է��� �迭�� ���̸�ŭ�� ���ڿ� �迭�� ���� �� �Ҵ��ϰ�
	�迭�� �ε����� ���� �� ���� ����ڰ� �Է��Ͽ� �ʱ�ȭ �ϼ���.
	��, ����ڿ��� �迭�� ���� �� ������ ����� �� ���� �� �Է��� ����,
	�ø� ���� � �����͸� ���� ������ ��������.
	����ڰ� �� �̻� �Է����� �ʰڴٰ� �ϸ� �迭 ��ü ���� ����ϼ���.
	*/
	public void practice16() {
		
		// 1. ù �迭 ũ�� ����
		Scanner sc= new Scanner(System.in);
		
		System.out.print("�迭�� ũ�⸦ �Է��Ͻÿ� : ");
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[size];
		
		// 2. ù �迭�� ������ ���ڿ� �Է� �ޱ�
		for(int i=0; i<arr.length ; i++) {
			System.out.print((i+1) + "��° ���ڿ� : ");
			arr[i] = sc.nextLine();
		}
		
		// 3. �ݺ��� ���۵Ǵ� �������� ���ѷ����� �ۼ��Ͽ� ���ο� ���� ������ ����� break
		while(true) {
			System.out.print("�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
			char ch = sc.nextLine().charAt(0);
			
			// 4. ���� �� �Է��� ���
			if(ch == 'y' || ch == 'Y') { 
				
				// 5. �� �Է¹��� ���� �Է� �ޱ�
				System.out.print("�� �Է��ϰ� ���� ���� : ");
				int addSize = sc.nextInt(); 
				sc.nextLine();
				
				// 6. ���� ���� �Է� ���� �迭 ���� --> ���� �迭 ũ�� + �߰� �Է� ���� 
				String[] newArr = new String[arr.length + addSize];
				
				// 7. �迭 ���� + ���ο� ���ڿ� �Է� �ޱ�
				for(int i=0; i<newArr.length ; i++) {
					if(i<arr.length) { // �ε����� ũ�Ⱑ ���� �迭���� ���� ��� ���� �迭�� ����
						newArr[i] = arr[i];  
					}else { // �ε����� ũ�Ⱑ ���� �迭���� Ŭ ��� ���ο� ���ڿ� �Է� �ޱ�
						System.out.print((i+1) + "��° ���ڿ� : ");
						newArr[i] = sc.nextLine();
					}
				}
				
				// 8. ���� �迭������ �����ϴ� ���� arr�� ���ο� �迭 ������ �ּ� newArr ����
				arr = newArr;
				
			}else if(ch == 'n' || ch == 'N'){ // 9. ���� �� �Է����� ���� ���
				break; // �ݺ��� ����
			}else { // �߸� �Է��� ���
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
		
		// 10. �迭�� ��� ���
		System.out.println(Arrays.toString(arr));
	}

}
