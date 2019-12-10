package com.kh.chap2_set.practice.run;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Run {
	public static void main(String[] args) {
		
		// 1. 1 ~ 45 ������ ���� 6���� �ߺ��� ���� �ʰ� ���� �� 
		// Iterator�� �̿��Ͽ� ���  
		Set<Integer> lotto = new HashSet<Integer>();
		
		int ran = 0;
		for(int i=0 ; i<6 ; ) {
			ran = (int)(Math.random()*45) + 1;
			if(lotto.add(ran)) {
				i++;
			}
		}
		
		Iterator<Integer> it = lotto.iterator();
		System.out.println("��÷�� �ζ� ��ȣ");
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		// 2. ����� ���� �ڵ� �������� ���ĵǰ� ó���ϴ� 
		// Set �迭 ��ü�� ���� �� 
		// ���� for���� �̿��Ͽ� ���
		Set<Integer> tree = new TreeSet<Integer>(lotto);
		
		System.out.println("���ĵ� �ζ� ��ȣ");
		for(int i : tree) {
			System.out.print(i + " ");
		}
		
	}
}
