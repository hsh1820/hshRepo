package com.kh.chap2_Set.part2.run;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetRun {
	public static void main(String[] args) {
	Set<String> tree = new TreeSet<String>();
	tree.add(new String("������"));
	tree.add(new String("������"));
	tree.add(new String("�ƾƾ�"));
	tree.add(new String("������"));
	tree.add(new String("�ٹٹ�"));
	
	// ���� for���� �̿��ؼ� ���
	for(String s : tree) {
		System.out.println(s);
	}
	}
}
