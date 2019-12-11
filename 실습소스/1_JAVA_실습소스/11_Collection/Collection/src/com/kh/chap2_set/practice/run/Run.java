package com.kh.chap2_set.practice.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class Run implements  Comparable<Integer> {
	//	클래스 명 : com.kh.chap2_set.practice.run.Run.java
	//	>> main() 메소드에 기능 구현
	//
	//	1 1~45 사이의 난수 6개를 중복이 되지 않게 저장 후 Iterator를 이용하여 출력 
	
	//	2 저장된 수를 자동 오름차순 정렬되게 처리하는 Set계열 객체에 저장 후 
	//	향상된 for문을 이용하여 출력
	
	public static void main(String[] args) {
			// set 방식
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
	
	// list방식
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


