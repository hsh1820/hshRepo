package com.kh.chap2_set.practice.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class Run implements  Comparable<Integer> {
	//	Ŭ���� �� : com.kh.chap2_set.practice.run.Run.java
	//	>> main() �޼ҵ忡 ��� ����
	//
	//	1 1~45 ������ ���� 6���� �ߺ��� ���� �ʰ� ���� �� Iterator�� �̿��Ͽ� ��� 
	
	//	2 ����� ���� �ڵ� �������� ���ĵǰ� ó���ϴ� Set�迭 ��ü�� ���� �� 
	//	���� for���� �̿��Ͽ� ���
	
	public static void main(String[] args) {
			// set ���
//		Set<Integer> list = new HashSet<Integer>(); 
//				
//		
//		while(true) {
//			int num = (int)(Math.random()*45+1);
//				list.add(new Integer(num));
//				if(list.size() == 6) {
//					break;
//				}
//		}
		
		/*	List<Integer> copy = new ArrayList<Integer>(list);
		Collections.sort(copy);
		
		
		for(Integer s : copy) {
			System.out.print(s + "  ");
		}
	
	}*/
	
	// list���
	List<Integer> list = new ArrayList<Integer>();
	while(true) {
		int num = (int)(Math.random()*45+1);
			list.add(new Integer(num));
			if(list.size() == 6) {
				break;
			}
	}
	
	Collections.sort(list);
	
	
	for(Integer s : list) {
		System.out.print(s + "  ");
	}
	
	
	//treeset
//	Set<Integer> tree = new TreeSet<Integer>();
//	
//	while(true) {
//		int num = (int)(Math.random()*45+1);
//		tree.add(new Integer(num));
//			if(list.size() == 6) {
//				break;
//			}
//	}
//	for(Integer s : tree) {
//		System.out.print(s + "  ");
//	}
		
		
		
}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}

}


