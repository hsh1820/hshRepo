package com.kh.chap2_Set.part2.run;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetRun {
	public static void main(String[] args) {
	Set<String> tree = new TreeSet<String>();
	tree.add(new String("하하하"));
	tree.add(new String("나나나"));
	tree.add(new String("아아아"));
	tree.add(new String("가가가"));
	tree.add(new String("바바바"));
	
	// 향상된 for문을 이용해서 출력
	for(String s : tree) {
		System.out.println(s);
	}
	}
}
