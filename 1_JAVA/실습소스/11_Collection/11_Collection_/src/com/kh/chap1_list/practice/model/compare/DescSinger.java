package com.kh.chap1_list.practice.model.compare;

import java.util.Comparator;

import com.kh.chap1_list.practice.model.vo.Music;

// Ŭ���ϰ� f2 �� = rename
public class DescSinger implements Comparator<Music>{
	// Music�� ���ǵ� ������ �������� �̿��� 
		// ������ ���Ͽ� ������ Ŭ����
		// Comparator ���
		
	@Override
	public int compare(Music o1, Music o2) {   
		//2���� ���߿� ������� ū�� ������ ��
		// ���� : ù��° �Ű������� ������ ��
		// ==> o1�� �������� o1�� o2���� ū�� ������ ��
		
		// ������ �������� ���ĸ����
		return -o1.getSinger().compareTo(o2.getSinger()); 
		// ������ ���������� -�� ���ؼ� ��ȣ���� ���� == ��������
		
	}
	
}
