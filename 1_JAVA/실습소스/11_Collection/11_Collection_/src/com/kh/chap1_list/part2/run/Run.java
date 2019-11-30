package com.kh.chap1_list.part2.run;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import com.kh.chap1_list.part2.model.vo.Food;

public class Run {
	public static void main(String[] args) {
		
		// Food ���� ������ �� �ִ� List ��ü ����
		
		List<Food> list = new ArrayList<Food>()	; //���� ����������� ���� ȣȯ �Ұ�
//		// List �ڽĵ� == ��üȭ
//		ArrayList<Food> aList = new ArrayList<Food>();
//		LinkedList<Food> lList = new LinkedList<Food>();
//		
//		list = lList;
//		list = aList;
		
		// 1. add(E e) : ����Ʈ�� ���� �ν��Ͻ� �����͸� �߰��ϴ� �޼ҵ�
		list.add(new Food("������", 15000));
		list.add(new Food("�ұ���", 9000));
		list.add(new Food("�ø�", 13000));
		
		System.out.println(list);
		
		//2. add(int index, E e)
		// �ε����� �����Ͽ� �ش� �ε����� �ν��Ͻ��� �߰��ϴ� �޼ҵ�
		list.add(1, new Food("���", 3000));
		
		System.out.println(list);
	
		// 3. set(int index, E e)
		// �ش� �ε����� ���� ���ο� �ν��Ͻ��� ����
		list.set(0, new Food("������",12000));
		System.out.println(list);
		
		// 4. size() : ����Ʈ ���� �ִ� ��ü�� ���� ��ȯ
		System.out.println("size() : "+list.size());
		
		// 5. get(int index)
		// �ش� �ε����� ����� �ν��Ͻ� ��ȯ
		System.out.println(list.get(2));
		
		// 6. remove(int index);
		// �ش� �ε����� ����� �ν��Ͻ� ���� ��
		// �� ������ �ڿ��� ��ܿͼ� �Ų�
		list.remove(3);
		System.out.println(list);
		
		// 7. sublist(int index1, int index2);
		// ����Ʈ�� index1 ~ index2 ���̸� �����Ͽ� 
		// ������ ����Ʈ ����
		List<Food> sub = list.subList(0, 2);
		System.out.println(sub);
		System.out.println(list);
		
		// 8. clear() : ����Ʈ �� ���� ���� ����
		list.clear();
		System.out.println(list);
		
		
		// 9. isEmpty() : ����Ʈ�� ����ִ��� Ȯ��
		System.out.println(list.isEmpty());
		
		// 10. 
		
		
	}
	
}
